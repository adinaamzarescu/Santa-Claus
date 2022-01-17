package entities.gift;

import fileio.input.GiftInputData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * Class used for gifts
 */
public class Gift {
    private String productName;
    private Double price;
    private String category;
    private Integer quantity;

    /**
     * Constructor
     * @param gift gift
     */
    public Gift(final GiftInputData gift) {
        setCategory(gift.getCategory());
        setPrice(gift.getPrice());
        setQuantity(gift.getQuantity());
        setProductName(gift.getProductName());
    }

}
