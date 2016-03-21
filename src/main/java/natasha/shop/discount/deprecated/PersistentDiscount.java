// старый код надо удлалять а не перемешать в другие пакеты / папки
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
//            по коду не понятно, почему мы делаем скидку на скидку - а именно так это читается
            BigDecimal price = p.getDiscountedPrice();
//            слишком длинная сложная и низкоуровневая операциия для этого медота
            p.setDiscountedPrice(price.add(price.divide(new BigDecimal(100)).multiply(new BigDecimal(percentOfDiscount).negate())));
        }
//        опять таки - разные уровни абстракции
        return name + " applied:" + percentOfDiscount + "%";
    }
}
