package natasha.shop;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @Before
    public void before() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void addProduct_whenAddProduct_getCountOfProductShouldReturnOne(){

        shoppingCart.addProduct(new Product());

        assertThat(shoppingCart.getCountOfProducts(), equalTo(1));
    }

    @Test
    public void getCountOfProduct_whenShoppingCartNotContainsProduct_shouldReturnZero(){
//        не очивидные названия переменных. Как по нему понять какой продукт был добавлен а какой нет?
        Product product = new Product(null, "test product", new BigDecimal(50));
        Product product1 = new Product(null, "test product 1", new BigDecimal(20));
        shoppingCart.addProduct(product);

        int countOfProduct = shoppingCart.getCountOfProduct(product1);

        assertThat(countOfProduct, equalTo(0));
    }

    @Test
    public void getCountOfProducts_whenCreateEmptyShoppingCart_shouldReturnZero(){
        assertThat(shoppingCart.getCountOfProducts(), equalTo(0));
    }


    @Test
    public void getTotalCost_shouldReturnSumOfAllProductsInCart(){
        Category category = new Category("test category");
        shoppingCart.addProduct(new Product(category, "test product1", new BigDecimal(100)));
        shoppingCart.addProduct(new Product(category, "test product2", new BigDecimal(50)));

        BigDecimal totalCost = shoppingCart.getTotalCost();

        assertThat(totalCost, equalTo(new BigDecimal(150)));
    }

    @Test
    public void getProductsInCartByProduct(){
//        названия переменных никак не помогают понят, какие из них включены в карту а какие нет
        Product product1 = new Product(null, "test product1", new BigDecimal(100));
        Product product2 = new Product(null, "test product2", new BigDecimal(100));
        ProductInCart productInCart1 = new ProductInCart(product1);
        ProductInCart productInCart2 = new ProductInCart(product2);
        ProductInCart productInCart3 = new ProductInCart(product1);
//        не понятно зачем два интерфейса для добавления продукта в карту
        shoppingCart.addProduct(productInCart1);
        shoppingCart.addProduct(productInCart2);
        shoppingCart.addProduct(productInCart3);
        List<ProductInCart> resultList = Arrays.asList(productInCart1, productInCart3);

        List<ProductInCart> productsInCartByProduct = shoppingCart.getProductsInCartByProduct(product1);

        assertThat(productsInCartByProduct, equalTo(resultList));
    }

    @Test
    public void getAllProductsInCart(){
        Product product1 = new Product(null, "test product1", new BigDecimal(100));
        Product product2 = new Product(null, "test product2", new BigDecimal(100));
        ProductInCart productInCart1 = new ProductInCart(product1);
        ProductInCart productInCart2 = new ProductInCart(product2);
        shoppingCart.addProduct(productInCart1);
        shoppingCart.addProduct(productInCart2);
        List<ProductInCart> productsInCart = Arrays.asList(productInCart1, productInCart2);

        List<ProductInCart> allProductsInCart = shoppingCart.getAllProductsInCart();

        assertThat(allProductsInCart, equalTo(productsInCart));
    }
}
