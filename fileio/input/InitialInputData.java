package fileio.input;

import enums.Cities;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class InitialInputData {

    private List<ChildrenInputData> children;
    private List<GiftInputData> santaGiftsList;
    private List<Enum<Cities>> cities;

}
