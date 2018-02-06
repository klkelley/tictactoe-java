package me.karakelley.tictactoe;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameConfigurationTest {


  PlayerFactory playerFactory = mock(PlayerFactoryImplementation.class);
  HumanUserInterface userInterfaceMock = mock(HumanUserInterface.class, RETURNS_MOCKS);
  private GameConfiguration gameConfig;

  @Before
  public void setUp() {
    gameConfig = new GameConfiguration(System.getProperty("configuration"), userInterfaceMock, playerFactory);
  }

  @Test

  public void testGameMenu() {
   gameConfig.gameMenu();
   verify(playerFactory, times(2)).makePlayer(anyString(), anyString(), anyString());
  }
}