package gradle.java.domain;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductRepository {

  ArrayList<Product> findAll();
  Optional<Product> findByReference(String reference);

}
