package natasha.shop.discount;

import natasha.shop.Product;
import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Принцып применения этой скидки абсолютно не понятен.
// Ни тесты ни сам код не предоставляеют возможности быстро разобраться в
// в логике этого класса.
public class ProductGroupDiscount implements Discount {
    private String name;
    private Map<Product, Integer> productGroup = new HashMap<Product, Integer>();
    private int amount;

//    класс не должен выставлять наружу способ хранения инофмации в нем.
//    в данном случае не очивидно как должна использоваться это карта и как ее правильно сформировать.
    public ProductGroupDiscount(String name, Map<Product, Integer> productGroup, int amount) {
        this.name = name;
        this.productGroup = productGroup;
        this.amount = amount;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        int countOfGroups = countOfGroups(shoppingCart);
        if(countOfGroups == 0){
            return null;
        }
        applyDiscountToGroups(shoppingCart, countOfGroups);
        return name+" is applied! Discount "+amount+"$";
    }

    private void applyDiscountToGroups(ShoppingCart shoppingCart, int countOfGroups) {
        for (Product product : productGroup.keySet()) {
            List<ProductInCart> productsToDiscount = shoppingCart.getProductsInCartByProduct(product);
            productsToDiscount = productsToDiscount.subList(0, countOfGroups * productGroup.get(product));
            for (ProductInCart productInCart : productsToDiscount) {
                productInCart.setDiscountedPrice(productInCart.getDiscountedPrice().add(new BigDecimal(amount).negate()));
            }
        }
    }

    private int countOfGroups(ShoppingCart shoppingCart) {
        int count = 0;
        while (true) {
            if (!isExistsGroup(shoppingCart, count + 1)) {
                return count;
            }
            count++;
        }
    }

    private boolean isExistsGroup(ShoppingCart shoppingCart, int i) {
        for (Product product : productGroup.keySet()) {
            if (shoppingCart.getCountOfProduct(product) < productGroup.get(product) * i) {
                return false;
            }
        }
        return true;
    }
}
