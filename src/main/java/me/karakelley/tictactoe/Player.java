package me.karakelley.tictactoe;

public interface Player {
  String getMarker();
  String pickMove(BoardState boardState);
}
