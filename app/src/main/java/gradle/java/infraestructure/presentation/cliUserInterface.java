package gradle.java.infraestructure.presentation;

import gradle.java.domain.UserInterface;
import java.util.Scanner;

public class cliUserInterface implements UserInterface {

  @Override
  public void sendMessage(String message) {
    System.out.println(message);
  }

  @Override
  public String waitForUserInput(String message) {
    sendMessage(message);
    Scanner userInput = new Scanner(System.in);
    return userInput.nextLine();
  }

  @Override
  public String newLine() {
    return "\n";
  }
  public String addToCartOrKeepBrowsingMessage(){
    StringBuilder textMenu = new StringBuilder();

    textMenu.append(newLine());
    textMenu.append(MenuMessages.whatToDoNext).append(newLine());
    textMenu.append(MenuMessages.optionNumberOneWithDash).append(MenuMessages.addProductToCart).append(newLine());
    textMenu.append(MenuMessages.optionNumberTwoWithDash).append(MenuMessages.keepBrowsing).append(newLine());
    textMenu.append(newLine());
    return textMenu.toString();
    }
}

