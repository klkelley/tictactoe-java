package me.karakelley.tictactoe;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class GameConfiguration {
  private String gameType;
  private final String HUMAN_PLAYER_SELECTION = "1";
  private final String OPPONENT_TYPE = "\nChoose an opponent:\n(1) Human\n(2) Easy Computer Player\n(3) Hard Computer Player\n(4) Impossible Computer Player\n";
  private String player1marker = "X";
  private String player2marker = "O";
  private String path;
  private Parser parser;
  private UserInterface userInterface;
  private UserInterface gameInterface;
  private PlayerFactory playerFactory;
  private Player player1;
  private Player player2;

  public GameConfiguration(String path, UserInterface userInterface, PlayerFactory playerFactory) {
    this.path = path;
    this.userInterface = userInterface;
    this.parser = setupParser();
    this.playerFactory = playerFactory;
  }

  public void gameMenu(GameInterfaceFactory gameInterfaceFactory) {
    userInterface.greetUser();

    setUpPlayers();
    setupInterface(gameInterfaceFactory);
  }

  public Player getPlayer2() {
    return player2;
  }

  public Player getPlayer1() {
    return player1;
  }

  public UserInterface getGameInterface() {
    return gameInterface;
  }

  private void setupInterface(GameInterfaceFactory gameInterfaceFactory) {
    gameInterface = gameInterfaceFactory.makeGameInterface(gameType, userInterface);
  }

  private void chooseGameType() {
    gameType = userInterface.userPrompt(OPPONENT_TYPE, new PlayerTypeValidator());
    player2 = playerFactory.makePlayer(gameType, getPlayer2marker(), getPlayer1marker());
  }

  private void setUpPlayers() {
    chooseGameType();
    player1 = playerFactory.makePlayer(HUMAN_PLAYER_SELECTION, getPlayer1marker(), getPlayer2marker());
  }

  private String getPlayer1marker() {
    setPlayer1Marker("markers", "playerOne");
    return player1marker;
  }

  private String getPlayer2marker() {
    setPlayer2Marker("markers", "playerTwo");
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

