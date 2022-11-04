package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import gradle.java.domain.ports.ProductFormatter;

public class CliProductFormatter implements ProductFormatter {

  private final String referenceTitle = "Reference: ";
  private final String priceTitle = "Price: ";
  private final String newLine = "\n";

  @Override
  public String formattedProduct(Product product) {

    StringBuilder result = new StringBuilder();

    result.append(product.image).append(newLine);
    result.append(product.description).append(", ");
    result.append(product.highlighted).append(newLine);
    result.append(priceTitle).append(product.price).append(" €\n");
    result.append(referenceTitle).append(product.reference);
    result.append("\n");

    return result.toString();
  }

  @Override
  public String formattedProductDetail(Product product, Integer unitsLeft) {

    String summaryHeading = "SUMMARY:";
    String descriptionHeading = "DESCRIPTION:";
    String unitsLeftText = " left";
    StringBuilder result = new StringBuilder();

    result.append(product.image).append(newLine);
    result.append(referenceTitle).append(product.reference).append(newLine);
    result.append(priceTitle).append(product.price).append(" €\n");
    result.append(unitsLeft.toString()).append(unitsLeftText).append(newLine);
    result.append(summaryHeading).append(newLine);
    result.append(product.description).append(", ");
    result.append(product.highlighted).append(newLine).append(newLine);
    result.append(descriptionHeading).append(newLine);
    result.append(product.longDescription).append(newLine);
    result.append(newLine);

    return result.toString();
  }
}
