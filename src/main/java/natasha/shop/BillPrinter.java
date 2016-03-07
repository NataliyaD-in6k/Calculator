package natasha.shop;

import java.math.BigDecimal;

public class BillPrinter {
    private Bill bill;

    public BillPrinter(Bill bill) {
        this.bill = bill;
    }

    public void printBill(){
        printTopMessages();
        printProductsWithPrices();
        printTotalCost();
        printBottomMessages();
    }

    private void printTopMessages(){
        for(String message:bill.getTopMessages()){
            System.out.println(message);
        }
    }

    private void printBottomMessages() {
        for(String message : bill.getBottomMessages()) {
            System.out.println(message);
        }
    }

    private void printProductsWithPrices() {
        for (ProductInCart productInCart: bill.getShoppingCart().getAllProductsInCart()){
            System.out.print(productInCart.getProduct().getName()+"..........");
            System.out.print(productInCart.getProduct().getPrice()+"/");
            System.out.println(productInCart.getDiscountedPrice());
        }
    }

    private void printTotalCost(){
        BigDecimal totalCost = bill.getShoppingCart().getTotalCost();
        System.out.println("Total cost.........."+totalCost);
    }
}
