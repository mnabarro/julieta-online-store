package gradle.java.domain;

public interface StockRepository {

  Integer getStockByReference(String reference);
}
