package fileio.output;

import entities.children.ChildBase;
import entities.gift.Gift;

import java.util.ArrayList;

public final class ChildrenOutputData {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String city;
    private ArrayList<String> giftsPreferences;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private ArrayList<GiftOutputData> receivedGifts = new ArrayList<>();

    public ArrayList<GiftOutputData> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<GiftOutputData> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
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

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public ChildrenOutputData(final ChildBase child) {
        setAge(child.getAge());
        setId(child.getId());
        setCity(child.getCity());
        setFirstName(child.getFirstName());
        setLastName(child.getLastName());
        setAssignedBudget(child.getAssignedBudget());
        setAverageScore(child.getAverageScore());
        setGiftsPreferences(child.getGiftsPreferences());
        for (Double d : child.getNiceScoreHistory()) {
            niceScoreHistory.add(d);
        }
        for (Gift gift : child.getReceivedGifts()) {
            receivedGifts.add(new GiftOutputData(gift));
        }
    }
}
