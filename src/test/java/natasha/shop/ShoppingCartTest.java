package natasha.shop;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @Before
    public void before() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void getCountOfProducts_whenCreateEmptyShoppingCart_shouldReturnZero(){
        assertThat(shoppingCart.getCountOfProducts(), equalTo(0));
    }

    @Test
    public void addProduct_whenAddProduct_getCountOfProductShouldReturnOne(){

        shoppingCart.addProduct(new Product());

        assertThat(shoppingCart.getCountOfProducts(), equalTo(1));
    }
}
