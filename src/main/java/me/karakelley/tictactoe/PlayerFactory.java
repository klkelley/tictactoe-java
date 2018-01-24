package me.karakelley.tictactoe;

public interface PlayerFactory {
  Player makePlayer(String type, String marker);
}
