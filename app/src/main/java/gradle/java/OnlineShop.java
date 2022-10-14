package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuPresentation;
import java.util.ArrayList;

public class OnlineShop {
    private final ProductRepository database;
    private final MenuPresentation menuPresentation;

    public OnlineShop(ProductRepository database) {
        this.menuPresentation = new MenuPresentation(database);
        this.database = database;
    }

    public void showProducts() {

        CatalogFormatter catalogFormatter = new CatalogFormatter(database);
        ArrayList<Product> catalogue = database.findAll();

        String formattedCatalogue = catalogFormatter.formattedCatalogue(catalogue);
        System.out.println(formattedCatalogue);
        menuPresentation.decideWhatToDoNext();
    }
}
