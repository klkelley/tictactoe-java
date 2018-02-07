package me.karakelley.tictactoe;

public interface UserInterfaceFactory {
  public UserInterface makeGameInterface(String gameType, UserInterface userInterface);
}
