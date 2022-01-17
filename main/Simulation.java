package main;

import common.Constants;
import entities.children.ChildBase;
import entities.gift.Gift;
import enums.CityStrategyEnum;
import factories.ChildrenFactory;
import factories.ElfFactory;
import fileio.input.AnnualChangesInputData;
import fileio.input.ChildrenInputData;
import fileio.input.GiftInputData;
import fileio.input.InputData;
import fileio.output.ChildList;
import lombok.Getter;
import lombok.Setter;
import santa.Santa;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Getter
@Setter
public final class Simulation {
    private InputData inputData;
    private ChildrenFactory factory;
    private ElfFactory elfFactory;
    private List<ChildList> listOfSimulations = new ArrayList<>();
    private List<Gift> giftList;
    private List<AnnualChangesInputData> annualChanges;
    private List<ChildBase> childrenList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param inputData input data
     */
    public Simulation(final InputData inputData) {
        this.inputData = inputData;
        factory = ChildrenFactory.getInstance();
        elfFactory = ElfFactory.getInstance();
        getChildrenList();
        List<GiftInputData> giftInput = inputData.getInitialData().getSantaGiftsList();
        giftList = new ArrayList<>();
        for (var gift : giftInput) {
            Gift currentGift = new Gift(gift);
            giftList.add(currentGift);
        }
        annualChanges = inputData.getAnnualChanges();
    }

    /**
     * Method to retrieve simulation output
     *
     * @return List of Children
     */
    public List<ChildList> getListOfSimulations() {
        return listOfSimulations;
    }

    /**
     * Method to generate children from input
     *
     * @return children list
     */
    public List<ChildBase> getChildrenList() {
        List<ChildrenInputData> childInput = inputData.getInitialData().getChildren();
        for (ChildrenInputData child : childInput) {
            childrenList.add(factory.createChildren(child));
        }
        return childrenList;
    }

    /**
     * First Round simulation
     *
     * @return Child list
     */
    public List<ChildBase> firstRound() {
        /**
         * Removing young adults
         */
        childrenList.removeIf(child -> child.getAge() > Constants.EIGHTEEN);
        Santa.calculateScore(childrenList, inputData.getSantaBudget());
        sortChildrenOnStrategy(CityStrategyEnum.ID.getValue());
        Santa.givePresents(childrenList, giftList);
        childrenList.sort(Comparator.comparing(ChildBase::getId));
        return childrenList;
    }

    private void sortChildrenOnStrategy(final String strategyEnum) {
        if (strategyEnum.equals(CityStrategyEnum.ID.getValue())) {
            childrenList.sort(Comparator.comparing(ChildBase::getId));
        } else if (strategyEnum.equals(CityStrategyEnum.NICE_SCORE.getValue())) {
            childrenList.sort(Comparator.comparing(ChildBase::getAverageScore).reversed());
        } else if (strategyEnum.equals(CityStrategyEnum.NICE_SCORE_CITY.getValue())) {
//            childrenList.sort(Comparator.comparing(Child::getNiceScoreCity).reversed());
            Collections.sort(childrenList, new Comparator<ChildBase>() {
                @Override
                public int compare(final ChildBase lhs, final ChildBase rhs) {
                    if (lhs.getNiceScoreCity() > rhs.getNiceScoreCity()) {
                        return -1;
                    } else if (lhs.getNiceScoreCity() < rhs.getNiceScoreCity()) {
                        return 1;
                    } else if (lhs.getNiceScoreCity().equals(rhs.getNiceScoreCity())) {
                        return lhs.getCity().compareToIgnoreCase(rhs.getCity());
                    }
                    return 0;
                }
            });
        }
    }

    /**
     * Method to simulate next set of rounds
     *
     * @param annualChangesInput Annual Changes
     * @return Children List
     */
    public List<ChildBase> round(final AnnualChangesInputData annualChangesInput) {
        List<ChildrenInputData> newChildren = annualChangesInput.getNewChildren();
        List<GiftInputData> newGifts = annualChangesInput.getNewGifts();
        prepareChildrenForNextRound();
        addNewChildren(newChildren);
        addNewGifts(newGifts);
        handleChildUpdates(annualChangesInput);

        Santa.calculateScore(childrenList, annualChangesInput.getNewSantaBudget());
        sortChildrenOnStrategy(annualChangesInput.getStrategy());
        Santa.givePresents(childrenList, giftList);

        childrenList.sort(Comparator.comparing(ChildBase::getId));
        return childrenList;
    }

    private void handleChildUpdates(final AnnualChangesInputData annualChangesInputData) {
        for (var childUpdate : annualChangesInputData.getChildrenUpdates()) {
            childrenList.stream().filter(a ->
                    a.getId().equals(childUpdate.getId())).findFirst().
                    ifPresent(existingChild -> {
                        if (childUpdate.getNiceScore() != null) {
                            existingChild.setNiceScore(childUpdate.getNiceScore());
                            existingChild.getNiceScoreHistory().add(childUpdate.getNiceScore());
                        }
                        ArrayList<String> newGiftsPref = childUpdate.getGiftsPreferences();
                        // If the child has new gifts preferences
                        if (newGiftsPref.size() > 0) {
                            newGiftsPref.addAll(existingChild.getGiftsPreferences());
                            newGiftsPref = (ArrayList<String>) newGiftsPref.stream()
                                    .distinct().collect(Collectors.toList());
                            existingChild.setGiftsPreferences(newGiftsPref);
                        }
                        if (childUpdate.getElf() != null) {
                            existingChild.setElf(elfFactory.createElf(childUpdate.getElf()));
                        }
                    });
        }
    }

    private void addNewGifts(final List<GiftInputData> newGifts) {
        if (newGifts != null) {
            for (var gift : newGifts) {
                Gift currentGift = new Gift(gift);
                giftList.add(currentGift);
            }
        }
    }

    private void addNewChildren(final List<ChildrenInputData> newChildren) {
        /**
         * Adding the new children in the list
         */
        for (ChildrenInputData newChild : newChildren) {
            childrenList.add(factory.createChildren(newChild));
        }
        /**
         * Removing young adults
         */
        childrenList.removeIf(child -> child.getAge() > Constants.EIGHTEEN);
    }

    private void prepareChildrenForNextRound() {
        /**
         * For each child the age will be modified by 1
         */
        childrenList.forEach(child -> child.setAge(child.getAge() + 1));
        childrenList.forEach(children -> children.setReceivedGifts(new ArrayList<>()));
    }

    /**
     * Trigger Simulation
     */
    public void allRounds() {
        firstRound();
        listOfSimulations.add(new ChildList(childrenList));
        for (int i = 0; i < inputData.getNumberOfYears(); i++) {
            AnnualChangesInputData annualChange = inputData.getAnnualChanges().get(i);
            round(annualChange);
            listOfSimulations.add(new ChildList(childrenList));
        }
    }
}
