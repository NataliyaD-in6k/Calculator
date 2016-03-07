package natasha.shop;

import natasha.shop.discount.GiftDiscount;
import natasha.shop.discount.TotalCostDiscount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CashboxTest {

    @Test
    public void processBill_shouldAddMessage(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product(null, "item", new BigDecimal(200)));
        Bill bill = new Bill(shoppingCart);
        Cashbox cashbox = new Cashbox();
        cashbox.addDiscount(new TotalCostDiscount("Discount from 100$", 10, new BigDecimal(100)));

        cashbox.processBill(bill);

        assertThat(bill.getBottomMessages().get(0), equalTo("Discount from 100$ applied:10%"));
    }
}
