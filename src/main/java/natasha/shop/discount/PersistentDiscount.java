package natasha.shop.discount;

import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;

public class PersistentDiscount implements Discount {
    private String name;
    private int percentOfDiscount;

    public PersistentDiscount(String name, int percentOfDiscount) {
        this.name = name;
        this.percentOfDiscount = percentOfDiscount;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        for (ProductInCart p : shoppingCart.getAllProductsInCart()) {
            double price = p.getDiscountedPrice();
            p.setDiscountedPrice(price - (price / 100 * percentOfDiscount));
        }
        return name + " applied:" + percentOfDiscount + "%";
    }
}
