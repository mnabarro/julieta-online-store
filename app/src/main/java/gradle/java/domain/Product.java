package gradle.java.domain;

public class Product {
    public final String id;
    public final String image;
    public final String description;
    public final String featuredAttribute;
    public final double price;
    public final String reference;

    public Product(String id, String image, String description, String featuredAttribute, Double price, String reference){
        this.id = id;
        this.image = image;
        this.description = description;
        this.featuredAttribute = featuredAttribute;
        this.price = price;
        this.reference = reference;
    }
}
