package me.karakelley.tictactoe;

public class BoardPresenter {

  public String prettify(String[] board) {
    return boardBuilder(board);
  }

  private String boardBuilder(String[] grid) {
    StringBuilder board = new StringBuilder();
    String blankSpace = "   |   |   \n";
    String rowDivider = "___________\n";

    for (int i = 0; i < Math.sqrt(grid.length); i++){
      board.append(blankSpace);
      board.append(" %s | %s | %s \n");
      board.append(blankSpace);
      if (i < Math.sqrt(grid.length) - 1) {
        board.append(rowDivider);
      }
    }
    board.append("\n\n");

    return String.format(board.toString(), updatedBoardGrid(grid));
  }

  private String[] updatedBoardGrid(String[] grid) {
    String[] newGrid = new String[grid.length];
    for (int n = 0; n < grid.length; n++) {
      if (grid[n].equals("-")) {
        newGrid[n] = Integer.toString(n);
      } else {
        newGrid[n] = grid[n];
      }
    }
    return newGrid;
  }
}
