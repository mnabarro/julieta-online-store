package gradle.java.domain;

import java.util.Optional;

public interface StockRepository {

  Optional<Integer> getStockByReference(String reference);
}
