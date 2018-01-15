package me.karakelley.tictactoe;

public class BoardState {
  private String[] grid;
  private int boardSize;

  public BoardState() {
    this.boardSize = 3;
    this.grid = initialState();
  }

  public String[] getGrid() {
    return this.grid;
  }

  public String[] placeMove(String space, String marker) {
    grid[Integer.parseInt(space)] = marker;
    return grid;
  }

  public boolean fullBoard() {
    boolean full = true;
    for (int i = 0; i < gridLength(); i++) {
      if (cellBlank(i)) {
        full = false;
      }
    }
    return full;
  }

  public boolean cellAvailable(int cell) {
    return cellInBounds(cell) && cellBlank(cell);
  }

  public String[][] winningCombinations() {
    String[][] combinations = new String[rows().length + columns().length+ diagonals().length][boardSize];
    System.arraycopy(rows(), 0, combinations, 0, rows().length);
    System.arraycopy(columns(), 0, combinations, rows().length,  columns().length);
    System.arraycopy(diagonals(), 0, combinations,  columns().length + rows().length, diagonals().length);

    return combinations;
  }

  private String[] initialState() {
    String[] initialState = new String[gridLength()];
    for (int i = 0; i < gridLength(); i++) {
      initialState[i] = "-";
    }
    return initialState;
  }

  private boolean cellInBounds(int cell) {
    return cell >= 0 && cell < gridLength();
  }

  private boolean cellBlank(int cell) {
    return grid[cell].equals("-");
  }

  private int gridLength() {
    Double gridLength = Math.pow(boardSize, 2);
    return gridLength.intValue();
  }

  private String[][] rows() {
    String[][] rows = new String[boardSize][boardSize];
    int index = 0;
      for (int i = 0; i < boardSize; i++) {
        for (int n = 0; n < boardSize; n++) {
          rows[i][n] = grid[index];
          index++;
        }
      }
    return rows;
  }

  private String[][] columns() {
    String[][] columns = new String[boardSize][boardSize];
    String[][] rows = rows();
    for (int i = 0; i < boardSize; i++) {
      for (int n = 0; n < boardSize; n++) {
        columns[i][n] = rows[n][i];
      }
    }
    return columns;
  }

  private String[] leftDiagonal() {
    String[] leftDiagonal = new String[boardSize];
    String[][] rows = rows();
    for (int i = 0; i < rows.length; i++) {
      leftDiagonal[i] = rows[i][i];
    }
    return leftDiagonal;
  }

  private String[] rightDiagonal() {
    String[] rightDiagonal = new String[boardSize];
    String[][] rows = rows();
    for (int i = 0; i < rows.length; i++) {
      int cell = boardSize - 1;
      rightDiagonal[i] = rows[i][cell - i];
    }
    return rightDiagonal;
  }

  private String[][] diagonals() {
    String[][] diagonals = new String[boardSize-1][boardSize];
    diagonals[0] = leftDiagonal();
    diagonals[1] = rightDiagonal();
    return diagonals;
  }
}
