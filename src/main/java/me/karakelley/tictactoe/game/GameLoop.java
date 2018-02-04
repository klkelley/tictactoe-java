package me.karakelley.tictactoe.game;

import me.karakelley.tictactoe.UI.UserInterface;
import me.karakelley.tictactoe.players.Player;

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

  public void start(Game game, BoardState boardState) {
    showBoard(boardState);
    play(game, boardState);
  }

  private void play(Game game, BoardState boardState) {
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

  public void reset(BoardState boardState) {
    boardState.resetBoard();
  }
}
