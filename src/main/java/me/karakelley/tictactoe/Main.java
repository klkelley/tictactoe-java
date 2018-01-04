package me.karakelley.tictactoe;

public class Main {

    public static void main(String args[]) {
        UI userInterface = new UI();
        userInterface.display(userInterface.message("Welcome to Tic Tac Toe!"));
    }
}
