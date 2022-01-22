package entities.gift;

import fileio.input.GiftInputData;

public final class Gift {
    private String productName;
    private Double price;
    private String category;
    private Integer quantity;

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

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
