package entities.children;

import common.Constants;
import elf.Elf;
import entities.gift.Gift;
import enums.ChildType;

import java.util.ArrayList;

public final class ChildBase {

    private Integer id;
    private String lastName;
    private String firstName;
    private String city;
    private Integer age;
    private ArrayList<String> giftsPreferences;
    private Double niceScore;
    private ChildType childType;
    private ArrayList<Double> niceScoreHistory;
    private Double niceScoreBonus;
    private Elf elf;
    private Double averageScore;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;
    private Double niceScoreCity;


    public ChildBase(final Builder childBuilder) {
        this.id = childBuilder.id;
        this.age = childBuilder.age;
        this.firstName = childBuilder.firstName;
        this.lastName = childBuilder.lastName;
        this.giftsPreferences = childBuilder.giftsPreferences;
        this.city = childBuilder.city;
        this.niceScore = childBuilder.niceScore;
        this.niceScoreBonus = childBuilder.niceScoreBonus;
        this.elf = childBuilder.elf;
        this.averageScore = childBuilder.averageScore;
        this.receivedGifts = childBuilder.receivedGifts;
        this.assignedBudget = childBuilder.assignedBudget;
        this.niceScoreCity = childBuilder.niceScoreCity;
    }

    public static class Builder {
        private Integer id;
        private String lastName;
        private String firstName;
        private String city;
        private Integer age;
        private ArrayList<String> giftsPreferences;
        private Double niceScore;
        private Double niceScoreBonus;
        private Elf elf;
        private Double averageScore;
        private Double assignedBudget;
        private ArrayList<Gift> receivedGifts;
        private Double niceScoreCity;

        public Builder(final Integer id, final String lastName, final String firstName,
                       final String city, final Integer age,
                       final ArrayList<String> giftsPreferences, final Double niceScore,
                       final Double niceScoreBonus, final Elf elf) {
            this.id = id;
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
            this.giftsPreferences = giftsPreferences;
            this.city = city;
            this.niceScore = niceScore;
            this.niceScoreBonus = niceScoreBonus;
            this.elf = elf;
        }

        public Builder() {

        }
        /**
         * @param id is the child's id
         * @return
         */
        public final Builder id(final Integer id) {
            this.id = id;
            return this;
        }
        /**
         *
         * @param age is the child's age
         * @return
         */
        public final Builder age(final Integer age) {
            this.age = age;
            return this;
        }
        /**
         *
         * @param firstName is the child's firstName
         * @return
         */
        public final Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }
        /**
         *
         * @param lastName is the child's lastName
         * @return
         */
        public final Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }
        /**
         *
         * @param city is the child's city
         * @return
         */
        public final Builder city(final String city) {
            this.city = city;
            return this;
        }
        /**
         *
         * @param giftsPreferences is the child's preferences
         *                         for gifts
         * @return
         */
        public final Builder giftsPreferences(final ArrayList<String> giftsPreferences) {
            this.giftsPreferences = giftsPreferences;
            return this;
        }
        /**
         *
         * @param niceScoreBonus is the child's bonus score
         *                       if they have one
         * @return
         */
        public final Builder niceScoreBonus(final Double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }
        /**
         *
         * @param averageScore is the child's average nice score
         * @return
         */
        public final Builder averageScore(final Double averageScore) {
            this.averageScore = averageScore;
            return this;
        }
        /**
         *
         * @param niceScore is the child's nice score
         * @return
         */
        public final Builder niceScore(final Double niceScore) {
            this.niceScore = niceScore;
            return this;
        }
        /**
         *
         * @param elf is the child's elf type
         * @return
         */
        public final Builder elf(final Elf elf) {
            this.elf = elf;
            return this;
        }
        /**
         *
         * @param assignedBudget is the child's assignedBudget
         * @return
         */
        public final Builder assignedBudget(final Double assignedBudget) {
            this.assignedBudget = assignedBudget;
            return this;
        }
        /**
         *
         * @param receivedGifts is the child's list of gifts
         *                      that they received
         * @return
         */
        public final Builder receivedGifts(final ArrayList<Gift> receivedGifts) {
            this.receivedGifts = receivedGifts;
            return this;
        }
        /**
         *
         * @param niceScoreCity is the child's niceScore for
         *                      their city
         * @return
         */
        public final Builder niceScoreCity(final Double niceScoreCity) {
            this.niceScoreCity = niceScoreCity;
            return this;
        }

        /**
         *
         * @return a new ChildBase object
         */
        public ChildBase build() {
            return new ChildBase(this);
        }

    }
    public ChildBase() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getNiceScoreCity() {
        return niceScoreCity;
    }

    public void setNiceScoreCity(final Double niceScoreCity) {
        this.niceScoreCity = niceScoreCity;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public Elf getElf() {
        return elf;
    }

    public void setElf(final Elf elf) {
        this.elf = elf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public ChildType getChildType() {
        return childType;
    }

    public void setChildType(final ChildType childType) {
        this.childType = childType;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Method to initialize ChildType & NiceScoreHistory
     */
    public void initialize() {
        if (age < Constants.FIVE) {
            setChildType(ChildType.Baby);
        } else if (age < Constants.TWELVE) {
            setChildType(ChildType.Kid);
        } else if (age <= Constants.EIGHTEEN) {
            setChildType(ChildType.Teen);
        } else {
            setChildType(ChildType.YoungAdult);
        }
        if (niceScoreHistory == null) {
            niceScoreHistory = new ArrayList<>();
        }
        niceScoreHistory.add(niceScore);
    }

}
