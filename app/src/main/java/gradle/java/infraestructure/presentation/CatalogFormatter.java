package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;

public class CatalogFormatter {
    ProductsChoice productsChoice = new ProductsChoice();

    public String formattedCatalog(ArrayList<Product> catalog){
        for (Product product : catalog){
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
