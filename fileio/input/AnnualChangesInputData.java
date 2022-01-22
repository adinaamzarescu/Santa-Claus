package fileio.input;

import java.util.List;


public final class AnnualChangesInputData {
    private Double newSantaBudget;
    private List<GiftInputData> newGifts;
    private List<ChildrenInputData> newChildren;
    private List<ChildrenInputData> childrenUpdates;
    private String strategy;

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<GiftInputData> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final List<GiftInputData> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildrenInputData> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final List<ChildrenInputData> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildrenInputData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final List<ChildrenInputData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
