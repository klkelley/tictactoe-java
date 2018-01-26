package me.karakelley.tictactoe;

import java.util.Arrays;
import java.util.Collections;

public class GameLoop {

  private UserInterface userInterface;
  private Player player1;
  private Player player2;
  private Player[] players;

  public GameLoop(UserInterface userInterface, Player player1, Player player2) {
    this.userInterface = userInterface;
    this.player1 = player1;
    this.player2 = player2;
    this.players = new Player[]{player1, player2};
  }

  public void start(BoardState boardState, Game game) {
    showBoard(boardState);

    play(boardState, game);
  }

  private void play(BoardState boardState, Game game) {
    while (!game.gameOver(boardState)) {
      nextPlayersTurn(boardState);
    }
    gameResults(game, boardState);
  }

  private void nextPlayersTurn(BoardState boardState) {
    Player player = currentPlayer();
    String chosenCell = player.pickMove(boardState);
    boardState.placeMove(chosenCell, currentPlayer().getMarker());
    takeTurn();
    showBoard(boardState);
  }

  private Player lastPlayer() {
    return players[1];
  }

  private Player currentPlayer() {
    return players[0];
  }

  private void takeTurn() {
    Collections.reverse(Arrays.asList(players));
  }

  private void gameResults(Game game, BoardState boardState) {
    if (game.tie(boardState)) {
      userInterface.displayTie();
    } else {
      userInterface.displayWinner(findWinner());
    }
  }

  private void showBoard(BoardState boardState) {
    userInterface.clearScreen();
    userInterface.displayBoard(boardState);
  }

  private boolean findWinner() {
    return lastPlayer() == player1;
  }
}
