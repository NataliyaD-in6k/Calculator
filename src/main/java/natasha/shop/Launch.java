package natasha.shop;

import natasha.shop.discount.GiftDiscount;
import natasha.shop.discount.ProductGroupDiscount;
import natasha.shop.discount.TotalCostDiscount;
import natasha.shop.discount.deprecated.PersistentDiscount;
import natasha.shop.discount.deprecated.ProductDiscount;

import java.math.BigDecimal;
import java.util.*;

public class Launch {
    public static void main(String[] args) {


        ShoppingCart shoppingCart = new ShoppingCart();

        List<Category> categories = Arrays.asList(new Category("Food"),
                                                new Category("Tech"),
                                                new Category("Home products"));

        List<Product> allProductsInShop = Arrays.asList(new Product(categories.get(0), "orange", new BigDecimal(15)),
                new Product(categories.get(0), "potato", new BigDecimal(8)),
                new Product(categories.get(0), "cucumber", new BigDecimal(10)),
                new Product(categories.get(0), "apple", new BigDecimal(3)),
                new Product(categories.get(0), "tomato", new BigDecimal(9)),
                new Product(categories.get(1), "vacuum", new BigDecimal(500)),
                new Product(categories.get(1), "fen", new BigDecimal(100)),
                new Product(categories.get(2), "plate", new BigDecimal(50)));
        shoppingCart.addProduct(allProductsInShop.get(0));
        shoppingCart.addProduct(allProductsInShop.get(0));
        shoppingCart.addProduct(allProductsInShop.get(0));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(2));
        shoppingCart.addProduct(allProductsInShop.get(1));
        shoppingCart.addProduct(allProductsInShop.get(5));



        Bill bill = new Bill(shoppingCart);
        Cashbox cashbox = new Cashbox();
        cashbox.addDiscount(new PersistentDiscount("Persistent discount", 10));
        Map<Product, Integer> productGroup = new HashMap<Product, Integer>();
        productGroup.put(allProductsInShop.get(0), 1);
        productGroup.put(allProductsInShop.get(1), 2);
        cashbox.addDiscount(new ProductGroupDiscount("Orange-potato group", productGroup, 20));

        cashbox.addDiscount(new GiftDiscount(categories.get(1), allProductsInShop.get(6)));
        cashbox.processBill(bill);
        List<ProductInCart> allProductsInCart = bill.getShoppingCart().getAllProductsInCart();
        for (ProductInCart productInCart: allProductsInCart){
            System.out.print(productInCart.getProduct().getName()+"..........");
            System.out.print(productInCart.getProduct().getPrice()+"/");
            System.out.println(productInCart.getDiscountedPrice());
        }
        List<String> bottomMessages = bill.getBottomMessages();
        for(String message:bottomMessages) {
            System.out.println(message);
        }


    }
}
