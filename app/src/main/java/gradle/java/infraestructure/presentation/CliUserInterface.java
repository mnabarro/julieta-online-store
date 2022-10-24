package gradle.java.infraestructure.presentation;

import gradle.java.domain.UserInterface;
import java.util.Optional;
import java.util.Scanner;

public class CliUserInterface implements UserInterface {

  @Override
  public void sendMessage(String message) {
    System.out.println(message);
  }

  @Override
  public String waitForUserInput(String message,Optional<Object> hardwareLayer) {
    Scanner userInput;
    sendMessage(message);
    if (hardwareLayer.isEmpty()) {
      userInput = new Scanner(System.in);
    } else {
      userInput = ((Scanner) hardwareLayer.get());
    }
    return userInput.nextLine();
  }
}

