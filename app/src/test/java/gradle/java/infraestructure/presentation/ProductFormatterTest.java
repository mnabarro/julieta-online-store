package gradle.java.infraestructure.presentation;

import static org.junit.jupiter.api.Assertions.*;

import gradle.java.domain.Product;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import resources.TestDatabase;
import resources.TestStrings;

class ProductFormatterTest {

  private final TestDatabase testDb = new TestDatabase();

  private final ArrayList<Product> productList = testDb.findAll();

  @Test
  void formattedProductTest() {
    ProductFormatter productFormatter = new ProductFormatter();
    String formattedProduct = productFormatter.formattedProduct(productList.get(1));
    assertEquals(formattedProduct, TestStrings.expectedFormattedProduct);
  }

  @Test
  void formattedProductDetailTest() {
    ProductFormatter productFormatter = new ProductFormatter();
    String formattedProductDetail = productFormatter.formattedProductDetail(productList.get(0), 12);
    assertEquals(formattedProductDetail, TestStrings.expectedFormattedProductDetail);
  }
}
