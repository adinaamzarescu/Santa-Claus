package santa;

import common.Constants;
import entities.children.ChildBase;
import entities.gift.Gift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public final class Santa {

    private Santa() {
    }

    /**
     * Method to calculate scores & budget per child
     *
     * @param childrenList children list
     * @param budget       budget
     */
    public static void calculateScore(final List<ChildBase> childrenList, final double budget) {
        double sumAverage = 0.0;
        Map<String, List<Double>> niceCityScoreMap = new HashMap<>();
        for (var child : childrenList) {
            double averageScore = 0.0;
            if (child.getAge() < Constants.FIVE) {
                averageScore = Constants.BABY_GRADE;
            } else if (child.getAge() < Constants.TWELVE) {
                for (double score : child.getNiceScoreHistory()) {
                    averageScore += score;
                }
                averageScore /= child.getNiceScoreHistory().size();
            } else if (child.getAge() <= Constants.EIGHTEEN) {
                int j = 0;
                for (int i = 0; i < child.getNiceScoreHistory().size(); i++) {
                    averageScore += child.getNiceScoreHistory().get(i) * (i + 1);
                    j = j + (i + 1);
                }
                averageScore /= j;
            }
            if (child.getNiceScoreBonus() != null) {
                averageScore += averageScore * child.getNiceScoreBonus() / Constants.HUNDRED;
                if (averageScore > Constants.TEN) {
                    averageScore = Constants.TEN;
                }
            }
            child.setAverageScore(averageScore);
            sumAverage += averageScore;
            calculateNiceScoreCity(niceCityScoreMap, child);
        }

        double newBudgetUnit = budget / sumAverage;
        for (var child : childrenList) {
            child.setAssignedBudget(newBudgetUnit * child.getAverageScore());
            List<Double> cityScores = niceCityScoreMap.get(child.getCity());
            Double sumCityScores = 0.0;
            for (Double d : cityScores) {
                sumCityScores += d;
            }
            Double cityScoreAverage = sumCityScores / cityScores.size();
            child.setNiceScoreCity(cityScoreAverage);
        }
        applyElfChanges(childrenList);
    }

    private static void calculateNiceScoreCity(final Map<String,
            List<Double>> niceCityScoreMap, final ChildBase child) {
        if (niceCityScoreMap.containsKey(child.getCity())) {
            niceCityScoreMap.get(child.getCity()).add(child.getAverageScore());
        } else {
            List<Double> values = new ArrayList<>();
            values.add(child.getAverageScore());
            niceCityScoreMap.put(child.getCity(), values);
        }
    }

    private static void applyElfChanges(final List<ChildBase> childrenList) {
        for (var child : childrenList) {
            child.getElf().modifyBudget(child);
        }
    }

    /**
     * Method to distribute presents
     *
     * @param childrenList children list
     * @param giftList     gift list
     */
    public static void givePresents(final List<ChildBase> childrenList,
                                    final List<Gift> giftList) {
        for (var child : childrenList) {
            Map<String, Integer> preferences = new HashMap<>();
            double budget = child.getAssignedBudget();
            for (var pref : child.getGiftsPreferences()) {
                for (var gift : giftList) {
                    if (pref.equals(gift.getCategory())) {
                        preferences.putIfAbsent(gift.getCategory(), 0);
                        if (preferences.containsKey(gift.getCategory())
                                && preferences.get(gift.getCategory()) == 0
                                && gift.getQuantity() > 0) {
                            if (budget - gift.getPrice() > 0.0) {
                                child.getReceivedGifts().add(gift);
                                preferences.put(gift.getCategory(), 1);
                                budget -= gift.getPrice();
                                gift.setQuantity(gift.getQuantity() - 1);
                            }
                        } else if (preferences.containsKey(gift.getCategory())
                                && preferences.get(gift.getCategory()) == 1) {
                            for (var gift2 : child.getReceivedGifts()) {
                                if (gift.getCategory().equals(gift2.getCategory())
                                        && gift.getQuantity() > 0) {
                                    if (gift2.getPrice() > gift.getPrice()) {
                                        child.getReceivedGifts().set(
                                                child.getReceivedGifts().indexOf(gift2), gift
                                        );
                                        gift2.setQuantity(gift2.getQuantity() + 1);
                                        gift.setQuantity(gift.getQuantity() - 1);
                                        budget += (gift2.getPrice() - gift.getPrice());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        applyElfChanges(childrenList, giftList);

    }

    /**
     * Method to Apply Elf changes
     *
     * @param childrenList children list
     * @param giftList     gift list
     */
    private static void applyElfChanges(final List<ChildBase> childrenList,
                                        final List<Gift> giftList) {
        for (ChildBase child : childrenList) {
            child.getElf().modifyGifts(child, giftList);
        }
    }
}
