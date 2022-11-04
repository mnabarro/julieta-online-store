package gradle.java.domain.ports;

public interface StockRepository {

  Integer getStockByReference(String reference);
}
