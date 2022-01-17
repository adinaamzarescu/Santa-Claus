package fileio.output;

import entities.gift.Gift;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiftOutputData {
    private String productName;
    private Double price;
    private String category;

    /**
     * Constructor
     * @param gift gift object
     */
    public GiftOutputData(final Gift gift) {
        setCategory(gift.getCategory());
        setPrice(gift.getPrice());
        setProductName(gift.getProductName());
    }
}
