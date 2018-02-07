package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class GameConfigurationTest {


  PlayerFactory playerFactory = mock(PlayerFactoryImplementation.class);
  HumanUserInterface userInterfaceMock = mock(HumanUserInterface.class, RETURNS_MOCKS);
  private GameConfiguration gameConfig;
  private GameInterfaceFactory gameInterfaceFactory = mock(GameInterfaceImplementation.class, RETURNS_MOCKS);

  @BeforeEach
  public void setUp() {
    gameConfig = new GameConfiguration(System.getProperty("configuration"), userInterfaceMock, playerFactory);
  }

  @Test

  public void testGameMenu() {
   gameConfig.gameMenu(gameInterfaceFactory);
   verify(playerFactory, times(2)).makePlayer(anyString(), anyString(), anyString());
  }

  @Test
  public void testReturnsUserInterface() {
    when(gameInterfaceFactory.makeGameInterface("1", userInterfaceMock)).thenCallRealMethod();
    gameConfig.gameMenu(gameInterfaceFactory);
    assertTrue(gameConfig.getGameInterface() instanceof UserInterface);
  }
}