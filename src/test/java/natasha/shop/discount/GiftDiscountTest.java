package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GiftDiscountTest {

    @Test
    public void applyDiscount_shouldReturnMessage(){
        Category category = new Category("food");
        Product gift = new Product(category, "makaroons", 20);
        Discount discount = new GiftDiscount(category, gift);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product(category, "apple", 10));


        String message = discount.applyDiscount(shoppingCart);

        assertThat(message, equalTo("You got a makaroons as gift!"));

    }
}
