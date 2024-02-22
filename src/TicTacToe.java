/*
Tic-Tac-Toe Game!
A personal project :)
~
By: Joel Kuruvilla.
Created On: Jan-03-2021.
Updated/Modified On: May-24-2022.
====================================================================================================
Hi! This is a tic-tac-toe game, that I've worked and hope you enjoy! You will have to first
choose your player piece and then you will be instructed to make the first move now! in reference to a 3x3 grid
layout (referred to as the GameBoard).
*/
import javax.swing.*;
import java.util.Scanner; //Importing Scanner Class duh!

public class TicTacToe {
    public static GameBoard gameBoard = new GameBoard();
    public static Player playerOne = new Player();
    public static Opponent playerTwo = new Opponent();
    public static String playerOnePiece;
    public static String playerTwoPiece;
    public static boolean isOpponentAI = false;

    public static void main(String[] agrs) {
        Scanner PlayerChose = new Scanner(System.in); //Creates a (user) Scanner!

        /*Starting Module - Introduces and prepares the game.*/
        //Player 1 Board Game Piece Selection Module:
        System.out.println("Welcome! Before we start, we need to do some quick setup:\n");
        System.out.println("Player 1, Please enter in an 'X' or 'O' to be your playing piece: ");
        playerOnePiece = PlayerChose.nextLine();
        if (playerOnePiece.toLowerCase().equals("x")) {
            playerOnePiece = "X";
            playerTwoPiece = "O";
        }
        else if (playerOnePiece.toLowerCase().equals("o")) {
            playerOnePiece = "O";
            playerTwoPiece = "X";
        }
        else {
            System.out.println("Error - incorrect inputs, starting program again");
            main(agrs);
        }

        //Choice of going against Program as Player Two or another individual.
        System.out.println("Would you like to play against the program? [Yes/No]");
        String userAnswer = PlayerChose.nextLine();
        if (userAnswer.toLowerCase().equals("yes")) {
            isOpponentAI = true;
            System.out.print("Playing against the program.. ");
            System.out.println("Actually that's not done.. SORRY!");
            System.exit(0);
        }
        else if (userAnswer.toLowerCase().equals("no")) {
            System.out.print("Playing against another person.. ");
        }
        else {
            System.out.println("Error - incorrect inputs, starting program again");
            main(agrs);
        }
        System.out.print("You [Player 1] are playing as " + playerOnePiece + ". ");

        /* Game Starts! First Plays are made */
        /*Module kicks off thee first round, and overall game */
        if (playerOnePiece.toLowerCase().equals("x")) {
            System.out.println("Player 2 is playing as 'O'.\n\nAlright the Game is ready to start, Good luck! ");
            if (isOpponentAI) {
                //TBD
            } else {
                System.out.println("Player 1: Please select your starting point [1-9] " +
                        "(refer to README 'How to play' for help)");
                sequenceStartX(PlayerChose.nextInt());
            }
        }
        else if (playerOnePiece.toLowerCase().equals("o")) {
            System.out.println("Player 2 will be playing as 'X'.\n");
            if (isOpponentAI) {
                //TBD
            }
            else {
                System.out.println("Player 1: Please select a starting point [1-9] " +
                        "(Remember to refer to README 'How to play' or 'FAQ' for any help)");
                sequenceStartO(PlayerChose.nextInt());
            }
        }
        else {
            System.out.println("Error - incorrect inputs");
        }
    }


    /** Game starts */
    /* Player goes first, AI opponent makes 2nd move, then player goes again and so on.. */
    public static void sequenceStartX(int playerXPlay) {
        gameBoard.gridOccupy("X", playerXPlay);
        gameBoard.gridOccupy("O", playerTwo.playerTwoChoiceInput());
        //Reruns till A win or draw is accomplished.
        sequenceStartX(playerOne.playerChoiceInput());
    }

    /* Player goes second, AI opponent makes 1st move, then player and so on.. */
    public static void sequenceStartO(int playerOPlay) {
        gameBoard.gridOccupy("O", playerOPlay);
        gameBoard.gridOccupy("X", playerTwo.playerTwoChoiceInput());
        //Reruns till A win or draw is accomplished.
        sequenceStartO(playerOne.playerChoiceInput());
    }
}