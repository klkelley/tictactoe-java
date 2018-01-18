package me.karakelley.tictactoe;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigurationTest {

  private GameConfiguration gameConfiguration;

  @Test
  public void testGetPlayer1MarkerWithConfig() throws IOException, ParseException {
    System.setProperty("configuration", "/Users/karakelley/IdeaProjects/tictactoe/src/test/resources/config.json");
    gameConfiguration = new GameConfiguration();
    assertEquals("Q", gameConfiguration.getPlayer1marker());
  }

  @Test
  public void testGetPlayer2MarkerWithConfig() throws IOException, ParseException {
    System.setProperty("configuration", "/Users/karakelley/IdeaProjects/tictactoe/src/test/resources/config.json");
    gameConfiguration = new GameConfiguration();
    assertEquals("Z", gameConfiguration.getPlayer2marker());
  }

  @Test
  public void testGetPlayer1MarkerNoConfig() throws IOException, ParseException {
    System.clearProperty("configuration");
    gameConfiguration = new GameConfiguration();
    assertEquals("X", gameConfiguration.getPlayer1marker());
  }

  @Test
  public void testGetPlayer2MarkerNoConfig() throws IOException, ParseException {
    System.clearProperty("configuration");
    gameConfiguration = new GameConfiguration();
    assertEquals("O", gameConfiguration.getPlayer2marker());
  }
}