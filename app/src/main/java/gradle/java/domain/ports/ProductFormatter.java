package gradle.java.domain.ports;

import gradle.java.domain.Product;

public interface ProductFormatter {

  String formattedProduct(Product product);

  String formattedProductDetail(Product product, Integer unitsLeft);
}
