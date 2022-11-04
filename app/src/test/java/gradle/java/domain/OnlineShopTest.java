package gradle.java.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gradle.java.domain.ports.StockRepository;
import gradle.java.domain.ports.UserInterface;
import gradle.java.infraestructure.presentation.CliCatalogFormatter;
import gradle.java.infraestructure.presentation.CliProductFormatter;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import resources.TestDatabase;

class OnlineShopTest {

  private AutoCloseable closeable;
  private TestDatabase database;
  private CliCatalogFormatter cliCatalogFormatter;
  private CliProductFormatter cliProductFormatter;
  private StockRepository stockRepository;
  UserInterface userInterface;

  @BeforeEach
  void setup() {

    closeable = MockitoAnnotations.openMocks(this);
    database = new TestDatabase();
    cliCatalogFormatter = new CliCatalogFormatter();
    cliProductFormatter = Mockito.mock(CliProductFormatter.class);
    stockRepository = Mockito.mock(StockRepository.class);
    userInterface = Mockito.mock(UserInterface.class);

  }

  @AfterEach
  void atLast() throws Exception {
    closeable.close();
  }

  @Test
  void waitForUserInputTest() {
    String response;
    String expectedResponse = "ABC";
    String messageToUser = "Please select an option:";
    OnlineShop onlineShop = new OnlineShop(database, cliCatalogFormatter, cliProductFormatter, stockRepository, userInterface);
    when(userInterface.getUserInput()).thenReturn(expectedResponse);

    response = onlineShop.waitForUserInput(messageToUser);

    assertThat(response).isEqualTo(expectedResponse);
  }

  @Captor
  ArgumentCaptor<String> textOutCaptor;

  @Test
  void showProductsTest() {
    String formattedCatalog = cliCatalogFormatter.formattedCatalog(database.findAll());
    OnlineShop onlineShop = new OnlineShop(database, cliCatalogFormatter, cliProductFormatter, stockRepository, userInterface);

    onlineShop.showProducts();
    verify(userInterface).sendMessage(textOutCaptor.capture());

    assertThat(formattedCatalog).isEqualTo(textOutCaptor.getValue());
  }

  @Test
  void findProductToViewDetailsWithExistingProductTest() {
    String productReference = "W2C";

    Optional<Product> expectedProduct = database.findByReference(productReference);
    OnlineShop onlineShop = new OnlineShop(database, cliCatalogFormatter, cliProductFormatter, stockRepository, userInterface);

    when(onlineShop.waitForUserInput(MenuMessages.whichProductToExplore)).thenReturn(productReference);

    assertThat(onlineShop.findProductToViewDetails()).usingRecursiveComparison().isEqualTo(expectedProduct);
  }

  @Test
  void findProductToViewDetailsWithNonExistingProductTest() {

    String nonExistingProductReference = "W5K";

    OnlineShop onlineShop = new OnlineShop(database, cliCatalogFormatter, cliProductFormatter, stockRepository, userInterface);

    when(onlineShop.waitForUserInput(MenuMessages.whichProductToExplore)).thenReturn(nonExistingProductReference);

    assertThat(onlineShop.findProductToViewDetails()).isEqualTo(Optional.empty());
  }
}
