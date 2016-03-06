package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ProductGroupDiscountTest {
    private ProductGroupDiscount productGroupDiscount;
    private Product product;
    private ShoppingCart shoppingCart;

    @Before
    public void before(){
        HashMap<Product, Integer> productGroup = new HashMap<Product, Integer>();
        product = new Product(null, "a", 10);
        productGroup.put(product, 2);
        productGroupDiscount = new ProductGroupDiscount("TestDiscount", productGroup, 10);
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void applyDiscount_shouldSetDiscountedPriceOnGroupOfProduct(){
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        productGroupDiscount.applyDiscount(shoppingCart);

        assertThat(shoppingCart.getAllProductsInCart().get(0).getDiscountedPrice(), equalTo(9d));
        assertThat(shoppingCart.getAllProductsInCart().get(1).getDiscountedPrice(), equalTo(9d));
        assertThat(shoppingCart.getAllProductsInCart().get(2).getDiscountedPrice(), equalTo(10d));
    }

    @Test
    public void applyDiscount_shouldReturnMessage(){
        String message = productGroupDiscount.applyDiscount(shoppingCart);

        assertThat(message, equalTo("TestDiscount is applied! Discount 10%"));
    }
}
