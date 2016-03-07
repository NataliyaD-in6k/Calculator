package natasha.shop;

import java.math.BigDecimal;

public class Product {
    private Category category;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(Category category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
