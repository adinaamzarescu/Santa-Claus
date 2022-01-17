package fileio.output;

import entities.children.ChildBase;

import java.util.ArrayList;
import java.util.List;

public class ChildList {
    private List<ChildrenOutputData> children = new ArrayList<>();

    /**
     * Constructor
     * @param childrenList child list
     */
    public ChildList(final List<ChildBase> childrenList) {
        for (var child : childrenList) {
            children.add(new ChildrenOutputData(child));
        }
    }

    /**
     * Method to return children object
     * @return children object
     */
    public List<ChildrenOutputData> getChildren() {
        return children;
    }
}
