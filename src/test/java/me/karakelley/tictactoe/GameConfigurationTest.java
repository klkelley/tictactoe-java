package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameConfigurationTest {


  private PlayerFactory playerFactory = mock(PlayerFactoryImplementation.class);
  private HumanUserInterface userInterfaceMock = mock(HumanUserInterface.class, RETURNS_MOCKS);
  private GameConfiguration gameConfig;
  private UserInterfaceConfiguration userInterfaceConfig = new UserInterfaceConfiguration();

  @BeforeEach
  public void setUp() {
    gameConfig = new GameConfiguration(System.getProperty("configuration"), userInterfaceMock, playerFactory);
  }

  @Test

  public void testGameMenu() {
   gameConfig.gameMenu(userInterfaceConfig);
   verify(playerFactory, times(2)).makePlayer(anyString(), anyString());
  }
}