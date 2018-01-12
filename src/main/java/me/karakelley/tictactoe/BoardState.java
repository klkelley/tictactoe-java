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

  public String[] placeMove(int space, String marker) {
    grid[space] = marker;
    return grid;
  }

  private String[] initialState() {
    return new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"};
  }
}
