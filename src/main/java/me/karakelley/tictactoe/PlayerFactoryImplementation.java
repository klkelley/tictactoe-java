package me.karakelley.tictactoe;

public class PlayerFactoryImplementation implements PlayerFactory{
  private UserInterface UI;

  public PlayerFactoryImplementation(UserInterface UI) {
    this.UI = UI;
  }

  @Override
  public Player makePlayer(String type, String marker) {
    Player newPlayer = null;

    if (type.equals("1")) {
      newPlayer = new HumanPlayer(marker, UI);
    } else if (type.equals("2")) {
      newPlayer = new ComputerPlayer(marker, new EasyBehavior());
    }
    return newPlayer;
  }
}
