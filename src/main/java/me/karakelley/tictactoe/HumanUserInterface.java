package me.karakelley.tictactoe;


public class HumanUserInterface implements UserInterface {
  private IO io;
  private BoardPresenter boardPresenter;
  private static final String TIE = "It's a tie!\n";
  private static final String WELCOME = "Welcome to Tic Tac Toe!\n";
  private String playerOneWins;
  private String playerTwoWins;


  public HumanUserInterface(IO io, BoardPresenter boardPresenter, String playerOneWins, String playerTwoWins) {
    this.io = io;
    this.boardPresenter = boardPresenter;
    this.playerOneWins = playerOneWins;
    this.playerTwoWins = playerTwoWins;
  }

  public String userPrompt(String message, Validator validator) {
    String input;

    do {
      displayMessage(message);
      input = io.getInput();

    } while(!validator.isValidInput(input));
      return input;
  }

  public void displayTie() {
    displayMessage(TIE);
  }

  public void displayBoard(BoardState board) {
    displayMessage(boardPresenter.prettify(board.getGrid()));
  }

  public void greetUser() {
    displayMessage(WELCOME);
  }

  public void displayWinner(boolean firstPlayerWins) {
    displayMessage(String.format(winningStatement(firstPlayerWins)));
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void displayMessage(String message) {
    io.display(message);
  }

  public String winningStatement(boolean firstPlayerWins) {
    return firstPlayerWins ? playerOneWins : playerTwoWins;
  }
}
