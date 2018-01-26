package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameConfigurationTest {

  Validator validatorMock = mock(PlayerTypeValidator.class);
  PlayerFactory playerFactory = mock(PlayerFactory.class);
  HumanUserInterface userInterfaceMock = mock(HumanUserInterface.class);
  private GameConfiguration gameConfig;

  @BeforeEach
  public void setUp() {
    gameConfig = new GameConfiguration(System.getProperty("configuration"), userInterfaceMock, playerFactory);
  }

  @Test
  public void testChooseOpponent() {
    when(userInterfaceMock.userPrompt("\nChoose an opponent:\n(1) Human\n(2) Easy Computer Player\n(3) Hard Computer Player\n(4) Impossible Computer Player\n", validatorMock)).thenReturn("1");
    when(validatorMock.isValidInput("1")).thenReturn(true);
    gameConfig.chooseOpponent("1");
    verify(playerFactory, times(1)).makePlayer("1", "O");
  }
}