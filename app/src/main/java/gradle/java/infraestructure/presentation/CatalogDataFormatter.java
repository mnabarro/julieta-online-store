package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;

public class CatalogDataFormatter {
    private final ProductDataFormatter productDataFormatter = new ProductDataFormatter();
    public String formattedCatalog(ArrayList<Product> catalog){
        StringBuilder result = new StringBuilder();

        for (Product product : catalog){
            result.append(productDataFormatter.productInfo(product));
            result.append("\n");
        }

        return result.toString();
    }
}
