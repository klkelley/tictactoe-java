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

    play();
  }


  private void play() {
    int chosenCell = Integer.valueOf(humanPlayer.nextMove());
    boardState.placeMove(chosenCell);
    userInterface.displayBoard();
  }
}