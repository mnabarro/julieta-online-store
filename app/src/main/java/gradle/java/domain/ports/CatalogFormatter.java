package gradle.java.domain.ports;

import gradle.java.domain.Product;
import java.util.ArrayList;

public interface CatalogFormatter {

  String formattedCatalog(ArrayList<Product> catalog);
}
