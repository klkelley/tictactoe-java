package me.karakelley.tictactoe;

public class Game {

  private UserInterface userInterface;
  private HumanPlayer humanPlayer;
  private BoardState boardState;
  private ValidatorFactory validator;

  public Game(UserInterface userInterface, HumanPlayer humanPlayer, BoardState boardState, ValidatorFactory validator) {
    this.userInterface = userInterface;
    this.humanPlayer = humanPlayer;
    this.boardState = boardState;
    this.validator = validator;
  }

  public void start() {
    userInterface.greetUser();
    userInterface.userPrompt("Please press \"ENTER\" to continue\n", validator.make("EnterValidator"));
    userInterface.displayBoard(boardState.getGrid());

    play();
  }

  private void play() {
    String chosenCell = userInterface.userPrompt("Please enter an available cell:\n", validator.make("NumberValidator"));
    boardState.placeMove(chosenCell, humanPlayer.getMarker());
    userInterface.displayBoard(boardState.getGrid());
  }
}
