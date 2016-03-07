package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TotalCostDiscountTest {

    public static final BigDecimal DELTA = new BigDecimal(0.001);

    @Test
    public void applyDiscount_shouldDiscountPriceOnEachProduct(){
        Discount persistentDiscount = new TotalCostDiscount("Persistent discount", 10, new BigDecimal(50));
        ShoppingCart shoppingCart = new ShoppingCart();
        Category food = new Category("food");
        shoppingCart.addProduct(new Product(food, "apple", new BigDecimal(30)));
        shoppingCart.addProduct(new Product(food, "app", new BigDecimal(50)));

        persistentDiscount.applyDiscount(shoppingCart);

        assertThat(shoppingCart.getAllProductsInCart().get(0).getDiscountedPrice(), closeTo(new BigDecimal(27), DELTA));
        assertThat(shoppingCart.getAllProductsInCart().get(1).getDiscountedPrice(), closeTo(new BigDecimal(45), DELTA));
    }
}
