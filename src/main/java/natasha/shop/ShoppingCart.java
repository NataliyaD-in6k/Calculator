package natasha.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ProductInCart> productsInCart = new ArrayList<ProductInCart>();

    public void addProduct(Product product) {
        productsInCart.add(new ProductInCart(product));
    }

    public void addProducts(List<Product> productList) {
        for (Product product : productList) {
            addProduct(product);
        }
    }

    public int getCountOfProduct(Product product) {
        int count = 0;
        for (ProductInCart p : productsInCart) {
            if (p.getProduct() == product) {
                count++;
            }
        }
        return count;
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (ProductInCart productInCart : getAllProductsInCart()) {
            totalCost += productInCart.getDiscountedPrice();
        }
        return totalCost;
    }


    public List<ProductInCart> getProductsInCartByProduct(Product product){
        List<ProductInCart> productInCartList = new ArrayList<ProductInCart>();
        for (ProductInCart p : productsInCart) {
            if (p.getProduct() == product) {
                productInCartList.add(p);
            }
        }
        return productInCartList;
    }

    public int getCountOfProducts(){
        return productsInCart.size();
    }

    public List<ProductInCart> getAllProductsInCart(){
        return productsInCart;
    }
}
