package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
public class ProductFormatter {

  public String formattedProduct(Product product) {

    StringBuilder result = new StringBuilder();

    result.append(product.image).append("\n");
    result.append(product.description).append(", ");
    result.append(product.higlightedAttribute).append("\n");
    result.append("Price: ").append(product.price).append(" €\n");
    result.append("Reference: ").append(product.reference);
    result.append("\n");

    return result.toString();
  }
  public String formattedProductDetail(Product product, Integer unitsLeft) {

    StringBuilder result = new StringBuilder();

    result.append(product.image).append("\n");
    result.append("Reference: ").append(product.reference).append("\n");
    result.append("Price: ").append(product.price).append(" €\n");
    result.append(unitsLeft.toString()).append(" left").append("\n");
    result.append("SUMMARY:").append("\n");
    result.append(product.description).append(", ");
    result.append(product.higlightedAttribute).append("\n\n");
    result.append("DESCRIPTION:").append("\n");
    result.append(product.longDescription).append("\n");
    result.append("\n");

    return result.toString();
  }
}
