package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class UserInterfaceConfigurationTest {
  UserInterface userInterface = mock(HumanUserInterface.class);
  UserInterfaceConfiguration userInterfaceConfig;

  @BeforeEach
  public void setUp() {
    userInterfaceConfig = new UserInterfaceConfiguration();
  }

  @Test
  void setGameMessagesForImpossibleComputer() {
    userInterfaceConfig.setGameMessages("4", userInterface);
    Mockito.verify(userInterface, times(1)).setLoseMessage("You never had a chance!\n");
  }

  @Test
  void setWinningGameMessagesForHardComputer() {
    userInterfaceConfig.setGameMessages("3", userInterface);
    Mockito.verify(userInterface, times(1)).setWinMessage("You win!\n");
  }

  @Test
  void setLosingGameMessagesForHardComputer() {
    userInterfaceConfig.setGameMessages("3", userInterface);
    Mockito.verify(userInterface, times(1)).setLoseMessage("You lose!\n");
  }

  @Test
  void setWinningGameMessagesForEasyComputer() {
    userInterfaceConfig.setGameMessages("2", userInterface);
    Mockito.verify(userInterface, times(1)).setWinMessage("You win!\n");
  }

  @Test
  void setLosingGameMessageForEasyComputer() {
    userInterfaceConfig.setGameMessages("2", userInterface);
    Mockito.verify(userInterface, times(1)).setLoseMessage("You lose!\n");
  }
}