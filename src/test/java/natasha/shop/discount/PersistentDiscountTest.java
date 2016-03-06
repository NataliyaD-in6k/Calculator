package natasha.shop.discount;

import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import natasha.shop.discount.deprecated.PersistentDiscount;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PersistentDiscountTest {
    @Test
    public void applyDiscount_shouldDiscountPriceOnEachProduct(){
        PersistentDiscount persistentDiscount = new PersistentDiscount("Persistent discount", 10);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("apple", 30));
        shoppingCart.addProduct(new Product("app", 50));

        persistentDiscount.applyDiscount(shoppingCart);

        assertThat(shoppingCart.getAllProductsInCart().get(0).getDiscountedPrice(), equalTo(27d));
        assertThat(shoppingCart.getAllProductsInCart().get(1).getDiscountedPrice(), equalTo(45d));
    }
}
