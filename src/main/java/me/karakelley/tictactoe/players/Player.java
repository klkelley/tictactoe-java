package me.karakelley.tictactoe.players;

import me.karakelley.tictactoe.game.BoardState;

public interface Player {
  String getMarker();
  String pickMove(BoardState boardState);
}
