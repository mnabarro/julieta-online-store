package gradle.java;

import gradle.java.domain.Product;
import java.util.ArrayList;

public class OnlineShop {
    private final CatalogueFormatter catalogueFormatter = new CatalogueFormatter();
    private final ProductWarehouse productWarehouse = new ProductWarehouse();

    public void showProducts() {

        ArrayList<Product> catalogue = productWarehouse.findAll();

        String formattedCatalogue = catalogueFormatter.format(catalogue);
        System.out.println(formattedCatalogue);
    }
}
