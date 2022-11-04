package gradle.java.domain;

import gradle.java.domain.ports.CatalogFormatter;
import gradle.java.domain.ports.ProductFormatter;
import gradle.java.domain.ports.ProductRepository;
import gradle.java.domain.ports.StockRepository;
import gradle.java.domain.ports.UserInterface;
import java.util.Objects;
import java.util.Optional;

public class OnlineShop {

  private final ProductRepository database;
  private final CatalogFormatter catalogFormatter;
  private final ProductFormatter productFormatter;
  private final StockRepository productWarehouse;
  private final UserInterface ui;

  public OnlineShop(ProductRepository database, CatalogFormatter catalogFormatter, ProductFormatter productFormatter,
    StockRepository productWarehouse, UserInterface userInterface) {
    this.database = database;
    this.catalogFormatter = catalogFormatter;
    this.productFormatter = productFormatter;
    this.productWarehouse = productWarehouse;
    this.ui = userInterface;
  }

  public void run() {

    while (true) {

      showProducts();

      Optional<Product> productILookFor = findProductToViewDetails();

      if (productILookFor.isPresent()) {

        Integer itemStock = productWarehouse.getStockByReference(productILookFor.get().reference);

        ui.sendMessage(productFormatter.formattedProductDetail(productILookFor.get(), itemStock));

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

  void showProducts() {

    String formattedCatalog = catalogFormatter.formattedCatalog(database.findAll());

    ui.sendMessage(formattedCatalog);
  }

  Optional<Product> findProductToViewDetails() {

    String referenceToLookFor = waitForUserInput(MenuMessages.whichProductToExplore);

    return database.findByReference(referenceToLookFor);
  }

  String waitForUserInput(String message) {
    ui.sendMessage(message);
    return ui.getUserInput();
  }
}
