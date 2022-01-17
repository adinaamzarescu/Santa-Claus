package fileio.input;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public final class ChildrenInputData {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String city;
    private Double niceScore;
    private Double niceScoreBonus;
    private String elf;
    private ArrayList<String> giftsPreferences;
}
