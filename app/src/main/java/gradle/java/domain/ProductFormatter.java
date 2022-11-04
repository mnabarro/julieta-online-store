package gradle.java.domain;

public interface ProductFormatter {

  String formattedProduct(Product product);

  String formattedProductDetail(Product product, Integer unitsLeft);
}
