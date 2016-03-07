package natasha.shop.discount;

import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;
import java.math.BigDecimal;

public class TotalCostDiscount implements Discount{
    private String name;
    private int percentOfDiscount;
    private BigDecimal totalCostCondition;

    public TotalCostDiscount(String name, int percentOfDiscount, BigDecimal totalCostCondition) {
        this.name = name;
        this.percentOfDiscount = percentOfDiscount;
        this.totalCostCondition = totalCostCondition;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        if (shoppingCart.getTotalCost().compareTo(totalCostCondition) == -1){
            return null;
        }
        for (ProductInCart p : shoppingCart.getAllProductsInCart()) {
            BigDecimal price = p.getDiscountedPrice();
            BigDecimal discount = price.divide(new BigDecimal(100)).multiply(new BigDecimal(percentOfDiscount));
            p.setDiscountedPrice(price.add(discount.negate()));
        }
        return name + " applied:" + percentOfDiscount + "%";
    }
}
