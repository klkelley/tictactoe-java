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

  public GameConfiguration() {
    this.parser = setupParser();
    this.player1marker = "X";
    this.player2marker = "O";
  }

  public String getPlayer1marker() {
    setPlayer1Marker();
    return player1marker;
  }

  public String getPlayer2marker() {
    setPlayer2Marker();
    return player2marker;
  }

  private Parser setupParser() {
    if (path != null) {
      try {
        parser = new Parser(new FileReader(path), new JSONParser());
      } catch (IOException|ParseException e) {
        throw new RuntimeException(e);
      }
    }
    return parser;
  }

  private void setPlayer1Marker() {
    if (validParser()) {
      player1marker = parser.firstMarker();
    }
  }

  private void setPlayer2Marker() {
    if (validParser()) {
      player2marker = parser.secondMarker();
    }
  }

  private boolean validParser() {
    return parser != null;
  }
}
