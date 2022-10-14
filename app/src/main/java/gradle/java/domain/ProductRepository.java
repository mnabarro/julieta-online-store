package gradle.java.domain;

import java.util.ArrayList;

public interface ProductRepository {

  ArrayList<Product> findAll();

}
