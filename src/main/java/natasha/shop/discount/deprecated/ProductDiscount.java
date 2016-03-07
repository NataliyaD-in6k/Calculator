package natasha.shop.discount.deprecated;

import natasha.shop.Product;
import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;
import natasha.shop.discount.Discount;

import java.math.BigDecimal;
import java.util.List;

public class ProductDiscount implements Discount {
    private Product product;
    private int percent;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public ProductDiscount(Product product, int percent) {
        this.product = product;
        this.percent = percent;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        List<ProductInCart> allProductsInCart = shoppingCart.getAllProductsInCart();
        for (ProductInCart productInCart : allProductsInCart) {
            Product currentProduct = productInCart.getProduct();
            if(currentProduct == product){
                BigDecimal discountedPrice = productInCart.getDiscountedPrice().divide(new BigDecimal(100 * (100 - percent)));
                productInCart.setDiscountedPrice(discountedPrice);

            }
        }
        return "Applied discount for "+product.getName();
    }
}
