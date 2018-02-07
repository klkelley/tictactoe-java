package me.karakelley.tictactoe;

public interface GameInterfaceFactory {
  public UserInterface makeGameInterface(String gameType, UserInterface userInterface);
}
