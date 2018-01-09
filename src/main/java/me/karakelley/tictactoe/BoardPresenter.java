package me.karakelley.tictactoe;

import java.util.ArrayList;

public class BoardPresenter {

  private String board = "   |   |   \n" +
                         " %s | %s | %s \n" +
                         "   |   |   \n" +
                         "___________\n" +
                         "   |   |   \n" +
                         " %s | %s | %s \n" +
                         "   |   |   \n" +
                         "___________\n" +
                         "   |   |   \n" +
                         " %s | %s | %s \n" +
                         "   |   |   \n" +
                         "\n ";

  public String setupBoard() {
    return String.format(board, makeSpaces().toArray());
  }

  private ArrayList<String> makeSpaces() {
    ArrayList<String> spaces = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      spaces.add(Integer.toString(i));
    }

    return spaces;
  }

}
