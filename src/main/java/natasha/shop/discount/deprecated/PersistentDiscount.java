package natasha.shop.discount.deprecated;

import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;
import natasha.shop.discount.Discount;

import java.math.BigDecimal;

public class PersistentDiscount implements Discount {
    private String name;
    private int percentOfDiscount;

    public PersistentDiscount(String name, int percentOfDiscount) {
        this.name = name;
        this.percentOfDiscount = percentOfDiscount;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        for (ProductInCart p : shoppingCart.getAllProductsInCart()) {
            BigDecimal price = p.getDiscountedPrice();
            p.setDiscountedPrice(price.add(price.divide(new BigDecimal(100)).multiply(new BigDecimal(percentOfDiscount).negate())));
        }
        return name + " applied:" + percentOfDiscount + "%";
    }
}
