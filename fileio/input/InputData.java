package fileio.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class InputData {
    private Integer numberOfYears;
    private Double santaBudget;
    private List<AnnualChangesInputData> annualChanges;
    private InitialInputData initialData;
}
