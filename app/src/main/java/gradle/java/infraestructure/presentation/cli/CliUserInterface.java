package gradle.java.infraestructure.presentation.cli;

import gradle.java.domain.ports.UserInterface;
import java.util.Scanner;

public class CliUserInterface implements UserInterface {

  @Override
  public void sendMessage(String message) {
    System.out.println(message);
  }

  @Override
  public String getUserInput() {
    Scanner userInput = new Scanner(System.in);
    return userInput.nextLine();
  }
}

