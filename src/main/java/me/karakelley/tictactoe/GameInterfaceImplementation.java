package me.karakelley.tictactoe;

public class GameInterfaceImplementation implements GameInterfaceFactory {

  private BoardPresenter boardPresenter;
  private IO io;

  public GameInterfaceImplementation(IO io, BoardPresenter boardPresenter) {
    this.io = io;
    this.boardPresenter = boardPresenter;
  }

  @Override
  public UserInterface makeGameInterface(String gameType, UserInterface userInterface) {
    if (gameType.equals("1")) {
      return userInterface;
    } else if (gameType.equals("2") || gameType.equals("3")) {
      return new HumanUserInterface(io, boardPresenter, "You win!\n", "You lose!\n");
    } else {
      return new HumanUserInterface(io, boardPresenter, "You never had a chance!\n", "You never had a chance!\n");
    }
  }
}
