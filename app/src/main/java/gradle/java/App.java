/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle.java;

import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.dataaccess.Database;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.ProductFormatter;

public class App {
    public static void main(String[] args) {

        ProductRepository database = new Database();
        CatalogFormatter catalogFormatter = new CatalogFormatter();
        ProductFormatter productFormatter = new ProductFormatter();

        OnlineShop onlineShop = new OnlineShop(database, catalogFormatter, productFormatter);

        onlineShop.showCliShop();

    }
}
