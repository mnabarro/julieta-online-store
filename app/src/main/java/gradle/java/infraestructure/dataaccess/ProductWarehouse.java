package gradle.java.infraestructure.dataaccess;

import static java.util.Map.entry;

import gradle.java.domain.StockRepository;
import java.util.Map;

public class ProductWarehouse implements StockRepository {

  private final Map<String, Integer> stockDatabase = Map.ofEntries(entry("W2C", 12), entry("X4A", 15));

  @Override
  public Integer getStockByReference(String reference) {
    if (stockDatabase.containsKey(reference)) {
      return stockDatabase.get(reference);
    }
    return 0;
  }
}
