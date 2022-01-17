package changes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ChangesList {
    private Double newSantaBudget;
    private ArrayList<String> newGifts;
    private ArrayList<String> newChildren;
    private ArrayList<String> childrenUpdates;
}
