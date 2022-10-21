package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
public class ProductFormatter {
  private final String referenceTitle = "Reference: ";
  private final String priceTitle = "Price: ";
  private final String newLine = "\n";
  public String formattedProduct(Product product) {

    StringBuilder result = new StringBuilder();

    result.append(product.image).append(newLine);
    result.append(product.description).append(", ");
    result.append(product.higlightedAttribute).append(newLine);
    result.append(priceTitle).append(product.price).append(" €\n");
    result.append(referenceTitle).append(product.reference);
    result.append("\n");

    return result.toString();
  }
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
    result.append(product.higlightedAttribute).append(newLine).append(newLine);
    result.append(descriptionHeading).append(newLine);
    result.append(product.longDescription).append(newLine);
    result.append(newLine);

    return result.toString();
  }
}
