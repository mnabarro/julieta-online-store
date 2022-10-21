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
}

