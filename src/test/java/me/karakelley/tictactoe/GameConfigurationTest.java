package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class GameConfigurationTest {

  private final String OPPONENT_TYPE = "\nChoose an opponent:\n(1) Human\n(2) Easy Computer Player\n(3) Hard Computer Player\n(4) Impossible Computer Player\n";
  PlayerFactory playerFactory = mock(PlayerFactoryImplementation.class, RETURNS_MOCKS);
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

  @Test
  public void inValidPath() {
    RuntimeException exception = assertThrows(RuntimeException.class, () -> new GameConfiguration("", userInterfaceMock, playerFactory));
    assertEquals("java.io.FileNotFoundException:  (No such file or directory)", exception.getMessage());
  }

  @Test
  public void testGetPlayer2() {
    when(userInterfaceMock.userPrompt(OPPONENT_TYPE, new PlayerTypeValidator())).thenReturn("1");
    when(playerFactory.makePlayer("1", "X", "0")).thenCallRealMethod();
    gameConfig.gameMenu();
    assertTrue(gameConfig.getPlayer2() instanceof Player);
  }

  @Test
  public void testGetPlayer1() {
    when(userInterfaceMock.userPrompt(OPPONENT_TYPE, new PlayerTypeValidator())).thenReturn("1");
    when(playerFactory.makePlayer("1", "X", "0")).thenCallRealMethod();
    gameConfig.gameMenu();
    assertTrue(gameConfig.getPlayer1() instanceof Player);
  }

  @Test
  public void testPlayerMarkersAreSetWhenValidParser() {
   gameConfig = new GameConfiguration("src/test/resources/config.json", userInterfaceMock, playerFactory);
   when(userInterfaceMock.userPrompt(OPPONENT_TYPE, new PlayerTypeValidator())).thenReturn("1");
   when(playerFactory.makePlayer("1", gameConfig.getPlayer1marker(), gameConfig.getPlayer2marker())).thenCallRealMethod();
   gameConfig.gameMenu();
   assertEquals("Q", gameConfig.getPlayer1marker());
  }
}