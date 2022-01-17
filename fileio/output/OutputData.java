package fileio.output;

import java.util.ArrayList;
import java.util.List;

public final class OutputData {
    private final List<ChildList> annualChildren = new ArrayList<>();

    /**
     * Constructor
     * @param children children object
     */
    public OutputData(final List<ChildList> children) {
        for (ChildList childList : children) {
            annualChildren.add(childList);
        }
    }

    /**
     * Method to return annual children object
     * @return annual children object
     */
    public List<ChildList> getAnnualChildren() {
        return annualChildren;
    }
}
