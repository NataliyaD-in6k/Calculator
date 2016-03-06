package natasha.shop;

public class Product {
    private Category category;
    private String name;
    private double price;

    public Product() {
    }

    public Product(Category category, String name, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
