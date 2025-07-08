package level2and3;

@JsonSerializable(directory = "src/resources/Product.json")

public class Product {

    private String productName;
    private double price;
    private int stock;

    public Product(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
}
