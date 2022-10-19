package gradle.java.domain;

public class Product {
    public final String image;
    public final String description;
    public final String higlightedAttribute;
    public final String longDescription;
    public final double price;
    public final String reference;

    public Product(String image, String description, String highlightedAtrribute, String longDescription, Double price, String reference){
        this.reference = reference;
        this.image = image;
        this.description = description;
        this.higlightedAttribute = highlightedAtrribute;
        this.longDescription = longDescription;
        this.price = price;
    }
}
