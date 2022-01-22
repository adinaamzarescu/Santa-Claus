package fileio.output;

import entities.gift.Gift;

public final class GiftOutputData {
    private String productName;
    private Double price;
    private String category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

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
