package natasha.shop;

import java.math.BigDecimal;

public class ProductInCart {
    private Product product;
    private BigDecimal discountedPrice;

    public ProductInCart(Product product) {
        this.product = product;
        this.discountedPrice = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
