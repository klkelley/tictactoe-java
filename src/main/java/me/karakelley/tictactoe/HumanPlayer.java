package me.karakelley.tictactoe;

public class HumanPlayer implements Player {
  private String marker;
  private UserInterface UI;


  public HumanPlayer(String marker, UserInterface UI)
  {
    this.marker = marker;
    this.UI = UI;
  }

  public String pickMove(BoardState boardState) {
    return UI.userPrompt("\nPlease enter an available cell:\n", new NumberValidator(boardState));
  }

  public String getMarker() {
    return marker;
  }
}
