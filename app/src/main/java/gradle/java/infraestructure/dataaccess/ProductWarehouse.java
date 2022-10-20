package gradle.java.infraestructure.dataaccess;

import static java.util.Map.entry;

import gradle.java.domain.StockRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductWarehouse implements StockRepository {

  private Map<String, Integer> stockDatabase = Map.ofEntries(entry("W2C",12), entry("X4A",15));

  @Override
  public Optional<Integer> getStockByReference(String reference) {
    if( stockDatabase.containsKey(reference)) {
      return Optional.ofNullable(stockDatabase.get(reference));
    }
    return Optional.empty();
  }
}
