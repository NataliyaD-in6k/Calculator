package natasha.shop;

import natasha.shop.discount.Discount;

import java.util.ArrayList;
import java.util.List;

public class Cashbox {
    private List<Discount> discounts = new ArrayList<Discount>();

    public void addDiscount(Discount discount){
        discounts.add(discount);
    }

    public void processBill(Bill bill){
        for(Discount d: discounts){
            d.applyDiscount(bill.getShoppingCart());
        }
    }

}
