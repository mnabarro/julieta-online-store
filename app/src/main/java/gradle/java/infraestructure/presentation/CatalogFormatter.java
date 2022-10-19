package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;

public class CatalogFormatter {
    public String formattedCatalog(ArrayList<Product> catalog){
        for (Product product : catalog){
            System.out.println(product.image);
            System.out.println(product.description);
            System.out.println(product.featuredAttribute);
            System.out.println(product.price);
            System.out.println(product.reference);
            System.out.println("\n");
        }
        return "";
    }
}
