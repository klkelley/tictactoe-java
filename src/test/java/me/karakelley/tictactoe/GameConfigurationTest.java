package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigurationTest {

  private GameConfiguration gameConfiguration;

  @Test
  public void testGetPlayer1MarkerWithConfig() {
    gameConfiguration = new GameConfiguration("src/test/resources/config.json");
    assertEquals("Q", gameConfiguration.getPlayer1marker("markers", "playerOne"));
  }

  @Test
  public void testGetPlayer2MarkerWithConfig() {
    gameConfiguration = new GameConfiguration("src/test/resources/config.json");
    assertEquals("Z", gameConfiguration.getPlayer2marker("markers", "playerTwo"));
  }

  @Test
  public void testGetPlayer1MarkerNoConfig() {
    gameConfiguration = new GameConfiguration(System.getProperty("configuration"));
    assertEquals("X", gameConfiguration.getPlayer1marker("markers", "playerOne"));
  }

  @Test
  public void testGetPlayer2MarkerNoConfig() {
    gameConfiguration = new GameConfiguration(System.getProperty("configuration"));
    assertEquals("O", gameConfiguration.getPlayer2marker("markers", "playerTwo"));
  }
}