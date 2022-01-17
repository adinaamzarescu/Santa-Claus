package entities.children;

import common.Constants;
import elf.Elf;
import entities.gift.Gift;
import enums.ChildType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
@Setter
/**
 * Class used for a child
 */
public class ChildBase {

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
