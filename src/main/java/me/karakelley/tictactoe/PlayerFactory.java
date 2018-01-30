package me.karakelley.tictactoe;

public interface PlayerFactory {
  Player makePlayer(String type, String currentPlayermarker, String opponentMarker);
}
