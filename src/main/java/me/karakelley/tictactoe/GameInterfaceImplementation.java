package me.karakelley.tictactoe;

public class GameInterfaceImplementation implements GameInterfaceFactory {

  private BoardPresenter boardPresenter;
  private IO io;
  private final String HUMAN_GAME = "1";
  private final String EASY_COMPUTER = "2";
  private final String HARD_COMPUTER = "3";

  public GameInterfaceImplementation(IO io, BoardPresenter boardPresenter) {
    this.io = io;
    this.boardPresenter = boardPresenter;
  }

  @Override
  public UserInterface makeGameInterface(String gameType, UserInterface userInterface) {
    if (gameType.equals(HUMAN_GAME)) {
      return userInterface;
    } else if (gameType.equals(EASY_COMPUTER) || gameType.equals(HARD_COMPUTER)) {
      return new HumanUserInterface(io, boardPresenter, "You win!\n", "You lose!\n");
    } else {
      return new HumanUserInterface(io, boardPresenter, "You never had a chance!\n", "You never had a chance!\n");
    }
  }
}
