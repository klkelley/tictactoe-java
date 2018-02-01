package me.karakelley.tictactoe.game;

import me.karakelley.tictactoe.UI.HumanUserInterface;
import me.karakelley.tictactoe.players.PlayerFactory;
import me.karakelley.tictactoe.players.PlayerFactoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameConfigurationTest {


  PlayerFactory playerFactory = mock(PlayerFactoryImplementation.class);
  HumanUserInterface userInterfaceMock = mock(HumanUserInterface.class, RETURNS_MOCKS);
  private GameConfiguration gameConfig;

  @BeforeEach
  public void setUp() {
    gameConfig = new GameConfiguration(System.getProperty("configuration"), userInterfaceMock, playerFactory);
  }

  @Test

  public void testGameMenu() {
   gameConfig.gameMenu();
   verify(playerFactory, times(2)).makePlayer(anyString(), anyString(), anyString());
  }
}