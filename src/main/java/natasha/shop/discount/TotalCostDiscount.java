package natasha.shop.discount;

import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;

public class TotalCostDiscount implements Discount{
    private String name;
    private int percentOfDiscount;
    private double totalCostCondition;

    public TotalCostDiscount(String name, int percentOfDiscount, double totalCostCondition) {
        this.name = name;
        this.percentOfDiscount = percentOfDiscount;
        this.totalCostCondition = totalCostCondition;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        if (shoppingCart.getTotalCost() < totalCostCondition){
            return null;
        }
        for (ProductInCart p : shoppingCart.getAllProductsInCart()) {
            double price = p.getDiscountedPrice();
            p.setDiscountedPrice(price - (price / 100 * percentOfDiscount));
        }
        return name + " applied:" + percentOfDiscount + "%";
    }
}
