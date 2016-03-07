package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import natasha.shop.discount.deprecated.PersistentDiscount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PersistentDiscountTest {
    public static final BigDecimal DELTA = new BigDecimal(0.001);
    private Discount persistentDiscount;
    private ShoppingCart shoppingCart;

    @Before
    public void before() {
        persistentDiscount = new PersistentDiscount("Persistent discount", 10);
        shoppingCart = new ShoppingCart();
        Category category = new Category("food");
        shoppingCart.addProduct(new Product(category, "apple", new BigDecimal(30)));
        shoppingCart.addProduct(new Product(category, "test", new BigDecimal(50)));

    }

    @Test
    public void applyDiscount_shouldDiscountPriceOnEachProduct(){

        persistentDiscount.applyDiscount(shoppingCart);

        assertThat(shoppingCart.getAllProductsInCart().get(0).getDiscountedPrice(), closeTo(new BigDecimal(27), DELTA));
        assertThat(shoppingCart.getAllProductsInCart().get(1).getDiscountedPrice(), closeTo(new BigDecimal(45), DELTA));
    }

    @Test
    public void applyDiscount_shouldReturnDiscountMessage(){

        String message = persistentDiscount.applyDiscount(shoppingCart);

        assertThat(message, equalTo("Persistent discount applied:10%"));
    }
}
