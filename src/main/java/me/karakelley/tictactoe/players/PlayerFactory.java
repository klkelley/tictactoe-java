package me.karakelley.tictactoe.players;

public interface PlayerFactory {
  Player makePlayer(String type, String currentPlayermarker, String opponentMarker);
}
