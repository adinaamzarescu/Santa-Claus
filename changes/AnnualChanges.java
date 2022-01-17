package changes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class AnnualChanges {
    private Integer numberOfYears;
    private ArrayList<Class<ChangesList>> annualChanges;

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
