package natasha.shop;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private ShoppingCart shoppingCart;
    private List<String> topMessages = new ArrayList<String>();
    private List<String> bottomMessages = new ArrayList<String>();

    public Bill(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addMessageToTop(String message) {
        if (message != null) {
            topMessages.add(message);
        }
    }

    public void addMessageToBottom(String message) {
        if (message != null) {
            bottomMessages.add(message);
        }
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public List<String> getTopMessages() {
        return topMessages;
    }

    public List<String> getBottomMessages() {
        return bottomMessages;
    }
}
