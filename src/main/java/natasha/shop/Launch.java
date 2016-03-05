package natasha.shop;

import java.util.Arrays;
import java.util.List;

public class Launch {
    public static void main(String[] args) {


        ShoppingCart shoppingCart = new ShoppingCart();

        List<Product> allProductsInShop = Arrays.asList(new Product("orange", 15),
                new Product("potato", 8),
                new Product("cucumber", 10),
                new Product("apple", 3),
                new Product("tomato", 9));
        shoppingCart.addProduct(allProductsInShop.get(0));
        shoppingCart.addProduct(allProductsInShop.get(0));
        shoppingCart.addProduct(allProductsInShop.get(0));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(2));


    }
}
