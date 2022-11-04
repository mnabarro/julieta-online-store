package gradle.java.infraestructure.dataaccess;

import gradle.java.domain.Product;
import gradle.java.domain.ports.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Database implements ProductRepository {

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

  @Override
  public ArrayList<Product> findAll() {
    return productList;
  }

  public Optional<Product> findByReference(String reference) {
    for (Product product : productList) {
      if (Objects.equals(product.reference, reference)) {
        return Optional.of(product);
      }
    }
    return Optional.empty();
  }
}
