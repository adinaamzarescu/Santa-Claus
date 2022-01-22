package fileio.input;

import java.util.List;

public final class InputData {
    private Integer numberOfYears;
    private Double santaBudget;
    private List<AnnualChangesInputData> annualChanges;
    private InitialInputData initialData;

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public InitialInputData getInitialData() {
        return initialData;
    }

    public void setInitialData(final InitialInputData initialData) {
        this.initialData = initialData;
    }

    public List<AnnualChangesInputData> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final List<AnnualChangesInputData> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
