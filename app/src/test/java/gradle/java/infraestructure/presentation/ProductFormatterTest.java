package gradle.java.infraestructure.presentation;

import static org.junit.jupiter.api.Assertions.*;

import gradle.java.domain.Product;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ProductFormatterTest {

  private final String expectedProductDetail = """
    \uD83D\uDCFA
    Reference: W2C
    Price: 300.99 €
    12 left
    SUMMARY:
    Glamorous panoramic television, 13 inches

    DESCRIPTION:
    With this panoramic television, your friday nights will be boring no more.
    The screen is composed of 14 million pixels.
    Thanks to its low energy consumption design, your bills will stay low.

    """;

  private final String expectedFormattedProduct = """
    \uD83C\uDFB9
    Untuned musical keyboard, 4 octaves
    Price: 1003.0 €
    Reference: X4A
    """;
  private final ArrayList<Product> productList = new ArrayList<>(Arrays.asList(
    new Product(
      "\uD83D\uDCFA",
      "Glamorous panoramic television",
      "13 inches",
      """
        With this panoramic television, your friday nights will be boring no more.
        The screen is composed of 14 million pixels.
        Thanks to its low energy consumption design, your bills will stay low.""",
      300.99,
      "W2C"),
    new Product(
      "\uD83C\uDFB9",
      "Untuned musical keyboard",
      "4 octaves",
      "Tired of your noisy neighbour? Play this untuned musical keyboard for two hours at home and your " +
        "neighbour will be ready to move to a building far away from you.",
      1003.00,
      "X4A"))
  );
  @Test
  void formattedProductTest() {
    ProductFormatter productFormatter = new ProductFormatter();
    String formattedProduct = productFormatter.formattedProduct(productList.get(1));
    assertEquals(formattedProduct, expectedFormattedProduct);
  }

  @Test
  void formattedProductDetailTest() {
    ProductFormatter productFormatter = new ProductFormatter();
    String formattedProductDetail = productFormatter.formattedProductDetail(productList.get(0), 12);
    assertEquals(formattedProductDetail, expectedProductDetail);
  }
}
