package gradle.java;

import java.util.ArrayList;

public class OnlineShop {
    private final CatalogueFormater catalogueFormater = new CatalogueFormater();
    private final ProductWarehouse productWarehouse = new ProductWarehouse();

    public void showProducts() {

        ArrayList<Product> catalogue = productWarehouse.findAll();

        String formattedCatalogue = catalogueFormater.format(catalogue);
        System.out.println(formattedCatalogue);
    }
}
