package natasha.shop;

public class ProductInCart {
    private Product product;
    private double discountedPrice;

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

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
