package me.karakelley.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardState {
  private String[] grid;

  public BoardState(String[] grid) {
    this.grid = grid;
  }

  public String[] getGrid() {
    return grid;
  }

  public String[] placeMove(int space) {
    grid[space] = "X";
    return grid;
  }
}
