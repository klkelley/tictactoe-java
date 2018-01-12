package me.karakelley.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardState {
  private String[] grid;

  public BoardState() {
    this.grid = initialState();
  }

  public String[] getGrid() {
    return this.grid;
  }

  public String[] placeMove(String space, String marker) {
    grid[Integer.parseInt(space)] = marker;
    return grid;
  }

  private String[] initialState() {
    return new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"};
  }

  public boolean fullBoard() {
    boolean full = true;
    for (int i = 0; i < grid.length; i++) {
      if (grid[i] == "-") {
        full = false;
      }
    }
    return full;
  }
}
