package changes;

import java.util.ArrayList;

public final class AnnualChanges {
    private Integer numberOfYears;
    private ArrayList<Class<ChangesList>> annualChanges;

    public ArrayList<Class<ChangesList>> getAnnualChanges() {
        return annualChanges;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public void setAnnualChanges(final ArrayList<Class<ChangesList>> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Constructor
     * @param numberOfYears numberOfYears
     * @param annualChanges annualChanges
     */
    public AnnualChanges(final int numberOfYears,
                         final ArrayList<Class<ChangesList>> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.annualChanges = annualChanges;
    }

}
