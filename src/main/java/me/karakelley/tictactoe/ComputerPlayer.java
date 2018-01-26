package me.karakelley.tictactoe;

public class ComputerPlayer implements Player{
  private AIBehavior aIBehavior;
  private String marker;

  public ComputerPlayer(String marker, AIBehavior aIBehavior) {
    this.marker = marker;
    this.aIBehavior = aIBehavior;

  }

  public String pickMove(BoardState boardState) {
    return aIBehavior.move(boardState);
  }

  @Override
  public String getMarker() {
    return this.marker;
  }
}
