package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigurationTest {

  private GameConfiguration gameConfiguration;

  @Test
  public void testGetPlayer1MarkerWithConfig() {
    System.setProperty("configuration", "src/test/resources/config.json");
    gameConfiguration = new GameConfiguration();
    assertEquals("Q", gameConfiguration.getPlayer1marker());
  }

  @Test
  public void testGetPlayer2MarkerWithConfig() {
    System.setProperty("configuration", "src/test/resources/config.json");
    gameConfiguration = new GameConfiguration();
    assertEquals("Z", gameConfiguration.getPlayer2marker());
  }

  @Test
  public void testGetPlayer1MarkerNoConfig() {
    System.clearProperty("configuration");
    gameConfiguration = new GameConfiguration();
    assertEquals("X", gameConfiguration.getPlayer1marker());
  }

  @Test
  public void testGetPlayer2MarkerNoConfig() {
    System.clearProperty("configuration");
    gameConfiguration = new GameConfiguration();
    assertEquals("O", gameConfiguration.getPlayer2marker());
  }
}