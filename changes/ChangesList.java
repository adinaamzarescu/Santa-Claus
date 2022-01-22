package changes;

import java.util.ArrayList;


public final class ChangesList {
    private Double newSantaBudget;

    private ArrayList<String> newGifts;
    private ArrayList<String> newChildren;
    private ArrayList<String> childrenUpdates;

    public void setNewGifts(final ArrayList<String> newGifts) {
        this.newGifts = newGifts;
    }

    public void setNewChildren(final ArrayList<String> newChildren) {
        this.newChildren = newChildren;
    }

    public void setChildrenUpdates(final ArrayList<String> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public ArrayList<String> getNewGifts() {
        return newGifts;
    }

    public ArrayList<String> getNewChildren() {
        return newChildren;
    }

    public ArrayList<String> getChildrenUpdates() {
        return childrenUpdates;
    }
}
