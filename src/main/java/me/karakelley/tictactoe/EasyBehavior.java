package me.karakelley.tictactoe;

import java.util.List;
import java.util.Random;

public class EasyBehavior implements AIBehavior {

  @Override
  public String move(BoardState boardState) {
    return availableCells(boardState).get(randomCell(boardState)).toString();
  }

  private int randomCell(BoardState boardState) {
    Random generator = new Random();
    return generator.nextInt(availableCells(boardState).size());
  }

  private List<Integer> availableCells(BoardState boardState) {
    return boardState.availableCells();
  }
}
