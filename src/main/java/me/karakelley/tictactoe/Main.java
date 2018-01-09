package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    UI userInterface = new UI(System.out, System.in);
    BoardInterface boardInterface = new BoardInterface();
    GameRunner gameRunner = new GameRunner(userInterface, boardInterface);

    gameRunner.start();
  }
}
