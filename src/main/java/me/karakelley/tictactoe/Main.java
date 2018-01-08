package me.karakelley.tictactoe;

public class Main {

    public static void main(String args[]) {
      UI userInterface = new UI(System.out);
      userInterface.welcomeMessage();
      userInterface.displayBoard();
    }
}
