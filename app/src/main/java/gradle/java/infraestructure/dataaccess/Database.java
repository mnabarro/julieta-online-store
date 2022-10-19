package gradle.java.infraestructure.dataaccess;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;

public class Database implements ProductRepository {
  private final ArrayList<Product> productList = new ArrayList<>(Arrays.asList(
    new Product(
      "1",
      "\uD83D\uDCFA",
      "Glamorous panoramic television, 13 inches",
      "With this panoramic television, your friday nights will be boring no more.",
      300.99,
      "W2C"),
    new Product(
      "2",
      "\uD83C\uDFB9",
      "Untuned musical keyboard, 4 octaves",
      "Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.",
      1003.00,
      "X4A"))
  );

  @Override
  public ArrayList<Product> findAll() {
    return productList;
  }

}
