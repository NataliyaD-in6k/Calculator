package natasha.shop;

import sun.nio.cs.ext.Big5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ProductInCart> productsInCart = new ArrayList<ProductInCart>();

    public void addProduct(Product product) {
        productsInCart.add(new ProductInCart(product));
    }
    public void addProduct(ProductInCart product) {
        productsInCart.add(product);
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

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = new BigDecimal(0);
        for (ProductInCart productInCart : getAllProductsInCart()) {
            totalCost.add(productInCart.getDiscountedPrice());
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
