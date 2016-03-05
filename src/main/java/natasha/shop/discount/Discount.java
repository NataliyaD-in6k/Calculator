package natasha.shop.discount;

import natasha.shop.ShoppingCart;

public interface Discount {
    String applyDiscount(ShoppingCart shoppingCart);
}
