package gradle.java.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuMessages;
import gradle.java.infraestructure.presentation.ProductFormatter;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import resources.TestDatabase;

class OnlineShopTest {

  private AutoCloseable closeable;
  TestDatabase database;
  CatalogFormatter catalogFormatter;
  ProductFormatter productFormatter;
  StockRepository stockRepository;
  UserInterface userInterface;

  @BeforeEach
  void setup() {

    closeable = MockitoAnnotations.openMocks(this);
    database = new TestDatabase();
    catalogFormatter = Mockito.mock(CatalogFormatter.class);
    productFormatter = Mockito.mock(ProductFormatter.class);
    stockRepository = Mockito.mock(StockRepository.class);
    userInterface = Mockito.mock(UserInterface.class);

  }

  @AfterEach
  void atLast() throws Exception {
    closeable.close();
  }

  @Test
  void showProductsTest() {
  }

  @Test
  void findProductToViewDetailsWithExistingProductTest() {
    String productReference = "W2C";

    Optional<Product> expectedProduct = database.findByReference(productReference);
    OnlineShop onlineShop = new OnlineShop(database, catalogFormatter, productFormatter, stockRepository, userInterface);

    when(userInterface.waitForUserInput(MenuMessages.whichProductToExplore)).thenReturn(productReference);

    assertThat(onlineShop.findProductToViewDetails()).usingRecursiveComparison().isEqualTo(expectedProduct);
  }

  @Test
  void findProductToViewDetailsWithNonExistingProductTest() {

    String nonExistingProductReference = "W5K";

    OnlineShop onlineShop = new OnlineShop(database, catalogFormatter, productFormatter, stockRepository, userInterface);

    when(userInterface.waitForUserInput(MenuMessages.whichProductToExplore)).thenReturn(nonExistingProductReference);

    assertThat(onlineShop.findProductToViewDetails()).isEqualTo(Optional.empty());
  }
}
