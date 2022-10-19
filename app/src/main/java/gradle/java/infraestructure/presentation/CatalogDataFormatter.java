package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;

public class CatalogDataFormatter {
    private final ProductFormatter productFormatter = new ProductFormatter();
    public String formattedCatalog(ArrayList<Product> catalog){

        StringBuilder result = new StringBuilder();

        for (Product product : catalog){
            result.append(productFormatter.formattedProduct(product));
            result.append("\n");
        }

        return result.toString();
    }
}
