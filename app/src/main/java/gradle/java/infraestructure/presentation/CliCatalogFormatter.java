package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;

public class CliCatalogFormatter implements gradle.java.domain.CatalogFormatter {

  private final CliProductFormatter cliProductFormatter = new CliProductFormatter();

  @Override
  public String formattedCatalog(ArrayList<Product> catalog) {

    StringBuilder result = new StringBuilder();

    for (Product product : catalog) {
      result.append(cliProductFormatter.formattedProduct(product));
      result.append("\n");
    }

    return result.toString();
  }
}
