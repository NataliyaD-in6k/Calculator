package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GiftDiscountTest {
    private ShoppingCart shoppingCart;
    private Discount discount;
    private Product gift;

    @Before
    public void before() {
        shoppingCart = new ShoppingCart();
        Category category = new Category("food");
        Product product = new Product(category, "a", new BigDecimal(10));
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(new Product(category, "apple", new BigDecimal(10)));
        gift = new Product(category, "makaroons", new BigDecimal(20));
        discount = new GiftDiscount(category, gift);
    }

    @Test
    public void applyDiscount_shouldAddTheGiftToShoppingCart(){
        discount.applyDiscount(shoppingCart);

        assertThat(shoppingCart.getCountOfProduct(gift), equalTo(1));
    }

    @Test
    public void applyDiscount_shouldReturnMessage(){

        String message = discount.applyDiscount(shoppingCart);

        assertThat(message, equalTo("You got a makaroons as a gift!"));

    }
}
