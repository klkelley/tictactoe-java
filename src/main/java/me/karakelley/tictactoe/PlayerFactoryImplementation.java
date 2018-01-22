package me.karakelley.tictactoe;

public class PlayerFactoryImplementation implements PlayerFactory{
  @Override
  public Player makePlayer(String type, String marker) {
    Player newPlayer = null;

    if (type.equals("1")) {
      newPlayer = new HumanPlayer(marker);
    }
    return newPlayer;
  }
}
