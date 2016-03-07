package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ProductGroupDiscountTest {
    private ProductGroupDiscount productGroupDiscount;
    private ShoppingCart shoppingCart;

    @Before
    public void before(){
        HashMap<Product, Integer> productGroup = new HashMap<Product, Integer>();
        Category category = new Category("food");
        Product product = new Product(category, "apple", new BigDecimal(10));
        productGroup.put(product, 2);
        productGroupDiscount = new ProductGroupDiscount("Apple set discount", productGroup, 1);
        shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
    }

    @Test
    public void applyDiscount_shouldSetDiscountedPriceOnGroupOfProduct(){
        productGroupDiscount.applyDiscount(shoppingCart);

        assertThat(shoppingCart.getAllProductsInCart().get(0).getDiscountedPrice(), equalTo(new BigDecimal(9)));
        assertThat(shoppingCart.getAllProductsInCart().get(1).getDiscountedPrice(), equalTo(new BigDecimal(9)));
        assertThat(shoppingCart.getAllProductsInCart().get(2).getDiscountedPrice(), equalTo(new BigDecimal(10)));
    }

    @Test
    public void applyDiscount_shouldReturnMessage(){
        String message = productGroupDiscount.applyDiscount(shoppingCart);

        assertThat(message, equalTo("Apple set discount is applied! Discount 1$"));
    }
}
