package gradle.java.infraestructure.presentation;

import gradle.java.domain.UserInterface;
import java.util.Scanner;

public class CliUserInterface implements UserInterface {

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

  public String addToCartOrKeepBrowsingMessage() {
    StringBuilder menuPrompt = new StringBuilder();

    menuPrompt.append(newLine());
    menuPrompt.append(MenuMessages.whatToDoNext).append(newLine());
    menuPrompt.append(MenuMessages.optionNumberOneWithDash).append(MenuMessages.addProductToCart).append(newLine());
    menuPrompt.append(MenuMessages.optionNumberTwoWithDash).append(MenuMessages.keepBrowsing).append(newLine());
    menuPrompt.append(newLine());
    return menuPrompt.toString();
  }
}

