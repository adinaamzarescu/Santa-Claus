package fileio.input;

import enums.Cities;
import java.util.List;

public final class InitialInputData {

    private List<ChildrenInputData> children;
    private List<GiftInputData> santaGiftsList;
    private List<Enum<Cities>> cities;

    public List<GiftInputData> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final List<GiftInputData> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public List<Enum<Cities>> getCities() {
        return cities;
    }

    public void setCities(final List<Enum<Cities>> cities) {
        this.cities = cities;
    }

    public List<ChildrenInputData> getChildren() {
        return children;
    }

    public void setChildren(final List<ChildrenInputData> children) {
        this.children = children;
    }
}
