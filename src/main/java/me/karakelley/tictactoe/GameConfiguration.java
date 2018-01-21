package me.karakelley.tictactoe;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class GameConfiguration {
  private String player1marker;
  private String player2marker;
  private String path;
  private Parser parser;

  public GameConfiguration(String path) {
    this.path = path;
    this.parser = setupParser();
    this.player1marker = "X";
    this.player2marker = "O";
  }

  public String getPlayer1marker(String markers, String player) {
    setPlayer1Marker(markers, player);
    return player1marker;
  }

  public String getPlayer2marker(String markers, String player) {
    setPlayer2Marker(markers, player);
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

  private void setPlayer1Marker(String markers, String player) {
    if (validParser()) {
      player1marker = parser.getValues(markers, player);
    }
  }

  private void setPlayer2Marker(String markers, String player) {
    if (validParser()) {
      player2marker = parser.getValues(markers, player);
    }
  }

  private boolean validParser() {
    return parser != null;
  }
}
