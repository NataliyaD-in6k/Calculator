package natasha.shop;

import natasha.shop.discount.ProductGroupDiscount;
import natasha.shop.discount.TotalCostDiscount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        shoppingCart.addProduct(allProductsInShop.get(1));



        Bill bill = new Bill(shoppingCart);
        Cashbox cashbox = new Cashbox();
//        cashbox.addDiscount(new PersistentDiscount("Persistent discount", 10));
//        cashbox.addDiscount(new ProductDiscount(allProductsInShop.get(2), 20));
        Map<Product, Integer> productGroup = new HashMap<Product, Integer>();
        productGroup.put(allProductsInShop.get(0), 1);
        productGroup.put(allProductsInShop.get(1), 2);
        cashbox.addDiscount(new ProductGroupDiscount(productGroup, 75));
        cashbox.addDiscount(new TotalCostDiscount("Persistent discount", 10, 40));
        cashbox.addDiscount(new TotalCostDiscount("Persistent discount", 1, 0));
        cashbox.processBill(bill);
        List<ProductInCart> allProductsInCart = bill.getShoppingCart().getAllProductsInCart();
        for (ProductInCart productInCart: allProductsInCart){
            System.out.print(productInCart.getProduct().getName()+"..........");
            System.out.print(productInCart.getProduct().getPrice()+"/");
            System.out.println(productInCart.getDiscountedPrice());
        }


    }
}
