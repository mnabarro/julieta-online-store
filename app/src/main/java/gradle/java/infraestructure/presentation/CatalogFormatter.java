package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;


public class CatalogFormatter {
    ProductsChoice productsChoice = new ProductsChoice();
    private final ProductRepository database;
    public CatalogFormatter(ProductRepository database) {
        this.database = database;
    }

    public String formattedCatalogue(ArrayList<Product> catalogue){
        for (Product product : catalogue){
            System.out.println(product.showImage());
            System.out.println(product.showDescription());
            System.out.println(product.showFeaturedAttribute());
            System.out.println(product.showPrice());
            System.out.println(product.showReference());
            System.out.println("\n");
        }
        productsChoice.showProductsToChoose();
        return "";
    }
}
