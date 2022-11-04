package gradle.java.domain.ports;

import gradle.java.domain.Product;
import java.util.ArrayList;
import java.util.Optional;

public interface ProductRepository {

  ArrayList<Product> findAll();

  Optional<Product> findByReference(String reference);

}
