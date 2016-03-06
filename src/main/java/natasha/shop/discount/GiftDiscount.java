package natasha.shop.discount;

import natasha.shop.Category;
import natasha.shop.Product;
import natasha.shop.ProductInCart;
import natasha.shop.ShoppingCart;

import java.util.List;

public class GiftDiscount implements Discount{
    private Category category;
    private Product gift;

    public GiftDiscount(Category category, Product gift) {
        this.category = category;
        this.gift = gift;
    }

    public String applyDiscount(ShoppingCart shoppingCart) {
        List<ProductInCart> allProductsInCart = shoppingCart.getAllProductsInCart();
        for(ProductInCart p: allProductsInCart){
            if (p.getProduct().getCategory() == category){
                ProductInCart giftWrapper = new ProductInCart(gift);
                giftWrapper.setDiscountedPrice(0);
                shoppingCart.addProduct(giftWrapper);
                return "You got a "+gift.getName()+" as gift!";
            }
        }
        return null;
    }
}
