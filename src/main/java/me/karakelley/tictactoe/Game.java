package me.karakelley.tictactoe;

public class Game {

  private UserInterface userInterface;
  private HumanPlayer humanPlayer;
  private BoardState boardState;

  public Game(UserInterface userInterface, HumanPlayer humanPlayer, BoardState boardState) {
    this.userInterface = userInterface;
    this.humanPlayer = humanPlayer;
    this.boardState = boardState;
  }

  public void start() {
    userInterface.greetUser();
    userInterface.userPrompt("Please press \"ENTER\" to continue", new EnterValidator());
    userInterface.displayBoard(boardState.getGrid());

    play();
  }

  private void play() {
    String chosenCell = userInterface.userPrompt("Please enter an available cell:\n", new NumberValidator());
    boardState.placeMove(chosenCell, humanPlayer.getMarker());
    userInterface.displayBoard(boardState.getGrid());
  }
}
