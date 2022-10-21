package gradle.java.domain;

import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuOptions;
import gradle.java.infraestructure.presentation.MenuMessages;
import gradle.java.infraestructure.presentation.ProductFormatter;
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

        String userChoice = ui.waitForUserInput(MenuMessages.addToCartOrKeepBrowsingMessage());

        if (Objects.equals(userChoice, MenuOptions.addToCart)) {
          System.exit(0);

        } else if (Objects.equals(userChoice, MenuOptions.keepBrowsing)) {
          ui.sendMessage("Keep browsing");
        } else {
          ui.sendMessage(MenuMessages.chooseValidOption);
          ui.waitForUserInput(MenuMessages.pressEnterToContinue);
        }

      } else {
        ui.sendMessage(MenuMessages.productDoesntExists);
        ui.waitForUserInput(MenuMessages.pressEnterToContinue);
      }
    }
  }

  public void showProducts() {

    String formattedCatalog = catalogFormatter.formattedCatalog(database.findAll());

    ui.sendMessage(formattedCatalog);
  }

  public Optional<Product> findProductToViewDetails() {

    String referenceToLookFor = ui.waitForUserInput(MenuMessages.whichProductToExplore);

    return database.findByReference(referenceToLookFor);
  }
}
