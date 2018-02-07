package me.karakelley.tictactoe;

public class PlayerFactoryImplementation implements PlayerFactory{

  private UserInterface userInterface;
  private Game game;
  private final String IMPOSSIBLE_COMPUTER = "4";
  private final String EASY_COMPUTER = "2";
  private final String HARD_COMPUTER = "3";
  private final String HUMAN = "1";

  public PlayerFactoryImplementation(UserInterface userInterface, Game game) {
    this.userInterface = userInterface;
    this.game = game;
  }

  @Override
  public Player makePlayer(String type, String currentPlayerMarker, String opponentMarker) {
    Player newPlayer = null;

    if (type.equals(HUMAN)) {
      newPlayer = new HumanPlayer(currentPlayerMarker, userInterface);
    } else if (type.equals(EASY_COMPUTER) || type.equals(HARD_COMPUTER)) {
      newPlayer = new ComputerPlayer(currentPlayerMarker, new EasyBehavior());
    } else if (type.equals(IMPOSSIBLE_COMPUTER)) {
      newPlayer = new ComputerPlayer(currentPlayerMarker, new ImpossibleBehavior(currentPlayerMarker, opponentMarker, game));
    }
    return newPlayer;
  }
}
