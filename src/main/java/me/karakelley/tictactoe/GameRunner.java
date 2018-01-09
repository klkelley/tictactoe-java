package me.karakelley.tictactoe;

public class GameRunner {

  private UserInterface userInterface;

  public GameRunner(UserInterface userInterface) {
    this.userInterface = userInterface;
  }

  public void start() {
    userInterface.greetUser();
    userInterface.displayBoard();
    // after greet user, start actual game play
  }
}
