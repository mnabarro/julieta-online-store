package gradle.java.domain;

import static org.mockito.Mockito.when;

import gradle.java.infraestructure.presentation.MenuMessages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class OnlineShopTest {

  private AutoCloseable closeable;
  @Mock
  UserInterface userInterface;

  @BeforeEach
  void setup () {
    closeable = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void atLast () throws Exception {
    closeable.close();
  }

  @Test
  void showProductsTest() {
  }

  @Test
  void findProductToViewDetailsTest() {
    when(userInterface.waitForUserInput(MenuMessages.whichProductToExplore)).thenReturn("W2C");
  }
}
