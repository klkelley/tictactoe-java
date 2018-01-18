package me.karakelley.tictactoe;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class GameConfiguration {
  private String player1marker;
  private String player2marker;
  private String path = System.getProperty("configuration");
  private Parser parser;

  public GameConfiguration() throws IOException, ParseException {
    this.parser = setupParser();
    this.player1marker = "X";
    this.player2marker = "O";
  }

  public String getPlayer1marker() throws IOException, ParseException {
    setPlayerMarkers();
    return player1marker;
  }

  public String getPlayer2marker() throws IOException, ParseException {
    setPlayerMarkers();
    return player2marker;
  }

  private Parser setupParser() throws IOException, ParseException {
    if (path != null) {
      parser = new Parser(new FileReader(path), new JSONParser());
    }
    return parser;
  }

  private void setPlayerMarkers() throws IOException, ParseException {
    if (parser != null) {
      player1marker = parser.firstMarker();
      player2marker = parser.secondMarker();
    }
  }
}
