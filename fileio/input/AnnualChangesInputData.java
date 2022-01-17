package fileio.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class AnnualChangesInputData {
    private Double newSantaBudget;
    private List<GiftInputData> newGifts;
    private List<ChildrenInputData> newChildren;
    private List<ChildrenInputData> childrenUpdates;
    private String strategy;
}
