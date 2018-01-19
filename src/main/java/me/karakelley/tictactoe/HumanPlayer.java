package me.karakelley.tictactoe;

public class HumanPlayer implements Player{
  private String marker;

  public String getMarker() {
    return marker;
  }

  public HumanPlayer(String marker) {
    this.marker = marker;
  }

}
