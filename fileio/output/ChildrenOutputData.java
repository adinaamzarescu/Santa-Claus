package fileio.output;

import entities.children.ChildBase;
import entities.gift.Gift;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
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
