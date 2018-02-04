package me.karakelley.tictactoe;

public class UserInterfaceConfiguration {

  public void setGameMessages(String gameType, UserInterface userInterface) {
    if (gameType.equals("2") || gameType.equals("3")) {
      userInterface.setWinMessage("You win!\n");
      userInterface.setLoseMessage("You lose!\n");
    } else if (gameType.equals("4")) {
      userInterface.setLoseMessage("You never had a chance!\n");
    }
  }
}
