package gradle.java.infraestructure.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class CliUserInterfaceTest {

  private static final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private AutoCloseable closeable;

  @BeforeEach
  void setup() {

    closeable = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void atLast() throws Exception {
    closeable.close();
  }

  @BeforeAll
  public static void setStreams() {

    System.setOut(new PrintStream(out));
  }

  @AfterAll
  public static void restoreInitialStreams() {

    System.setOut(originalOut);
  }

  @Test
  void sendMessageTest() {
    String expectedMessage = "Message to send";
    CliUserInterface cliUserInterface = new CliUserInterface();
    cliUserInterface.sendMessage(expectedMessage);
    assertEquals(out.toString().trim(), expectedMessage);
  }
}
