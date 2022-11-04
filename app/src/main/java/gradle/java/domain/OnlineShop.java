package gradle.java.domain;

import gradle.java.infraestructure.presentation.CliCatalogFormatter;
import gradle.java.infraestructure.presentation.CliProductFormatter;
import java.util.Objects;
import java.util.Optional;

public class OnlineShop {

  private final ProductRepository database;
  private final CliCatalogFormatter cliCatalogFormatter;
  private final CliProductFormatter cliProductFormatter;
  private final StockRepository productWarehouse;
  private final UserInterface ui;

  public OnlineShop(ProductRepository database, CliCatalogFormatter cliCatalogFormatter, CliProductFormatter cliProductFormatter,
    StockRepository productWarehouse, UserInterface userInterface) {
    this.database = database;
    this.cliCatalogFormatter = cliCatalogFormatter;
    this.cliProductFormatter = cliProductFormatter;
    this.productWarehouse = productWarehouse;
    this.ui = userInterface;
  }

  public void run() {

    while (true) {

      showProducts();

      Optional<Product> productILookFor = findProductToViewDetails();

      if (productILookFor.isPresent()) {

        Integer itemStock = productWarehouse.getStockByReference(productILookFor.get().reference);

        ui.sendMessage(cliProductFormatter.formattedProductDetail(productILookFor.get(), itemStock));

        String userChoice = waitForUserInput(MenuMessages.addToCartOrKeepBrowsingMessage());

        if (Objects.equals(userChoice, MenuOptions.addToCart)) {
          System.exit(0);

        } else if (Objects.equals(userChoice, MenuOptions.keepBrowsing)) {
          ui.sendMessage("Keep browsing");
        } else {
          ui.sendMessage(MenuMessages.chooseValidOption);
          waitForUserInput(MenuMessages.pressEnterToContinue);
        }

      } else {
        ui.sendMessage(MenuMessages.productDoesntExists);
        waitForUserInput(MenuMessages.pressEnterToContinue);
      }
    }
  }

  public void showProducts() {

    String formattedCatalog = cliCatalogFormatter.formattedCatalog(database.findAll());

    ui.sendMessage(formattedCatalog);
  }

  public Optional<Product> findProductToViewDetails() {

    String referenceToLookFor = waitForUserInput(MenuMessages.whichProductToExplore);

    return database.findByReference(referenceToLookFor);
  }

  public String waitForUserInput(String message) {
    ui.sendMessage(message);
    return ui.getUserInput();
  }
}
