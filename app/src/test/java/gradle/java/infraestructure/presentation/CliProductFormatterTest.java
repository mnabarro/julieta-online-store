package gradle.java.infraestructure.presentation;

import static org.junit.jupiter.api.Assertions.*;

import gradle.java.domain.Product;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import resources.TestDatabase;
import resources.TestStrings;

class CliProductFormatterTest {

  private final TestDatabase testDb = new TestDatabase();

  private final ArrayList<Product> productList = testDb.findAll();

  @Test
  void formattedProductTest() {
    CliProductFormatter cliProductFormatter = new CliProductFormatter();
    String formattedProduct = cliProductFormatter.formattedProduct(productList.get(1));
    assertEquals(formattedProduct, TestStrings.expectedFormattedProduct);
  }

  @Test
  void formattedProductDetailTest() {
    CliProductFormatter cliProductFormatter = new CliProductFormatter();
    String formattedProductDetail = cliProductFormatter.formattedProductDetail(productList.get(0), 12);
    assertEquals(formattedProductDetail, TestStrings.expectedFormattedProductDetail);
  }
}
