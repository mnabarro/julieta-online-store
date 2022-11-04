package gradle.java.domain;

import java.util.ArrayList;

public interface CatalogFormatter {

  String formattedCatalog(ArrayList<Product> catalog);
}
