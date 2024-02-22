/*
Tic-Tac-Toe GameBoard:
=
By: Joel Kuruvilla.
Created On: Jan-03-2021.
This File was created on: Jan-21-2021.
~
This File was updated/modified on: May-24-2022.
=
The 'board' that the game takes place on!
*/

import java.util.Scanner;

public class GameBoard extends TicTacToe {
    public String[][] theGrid = {{"","",""}, {"","",""}, {"","",""}};
    public String q1, q2, q3, q4, q5, q6, q7, q8, q9;
    protected Scanner emergencyPlay = new Scanner(System.in);
    public boolean isGridFull = false;

    /* Constructor */
    public GameBoard() {
        q1 = q2 = q3 = q4 = q5 = q6 = q7 = q8 = q9 = " ";
    }

    /* Translates 1-9 to 3x3 coordinates and pushes to execute appropriate actions accordingly */
    public void gridOccupy(String piece, int selection) {
        boolean isEmergencyPlay = false;
        if(selection > 0 && selection < 10) {
            if (selection == 1 && checkNotOccupied(piece, 0, 0)) {
                q1 = piece;
            } else if (selection == 2 && checkNotOccupied(piece, 0, 1)) {
                q2 = piece;
            } else if (selection == 3 && checkNotOccupied(piece, 0, 2)) {
                q3 = piece;
            } else if (selection == 4 && checkNotOccupied(piece, 1, 0)) {
                q4 = piece;
            } else if (selection == 5 && checkNotOccupied(piece, 1, 1)) {
                q5 = piece;
            } else if (selection == 6 && checkNotOccupied(piece, 1, 2)) {
                q6 = piece;
            } else if (selection == 7 && checkNotOccupied(piece, 2, 0)) {
                q7 = piece;
            } else if (selection == 8 && checkNotOccupied(piece, 2, 1)) {
                q8 = piece;
            } else if (selection == 9 && checkNotOccupied(piece, 2, 2)) {
                q9 = piece;
            } else {
                System.out.print("Grid already taken. Please try again! ");
                isEmergencyPlay = true;
                gridOccupy(piece, emergencyPlay.nextInt());
            }
        }
        else {
            System.out.print("Out of Bound Selection; Enter an integer number between 1 and 9! ");
            isEmergencyPlay = true;
            gridOccupy(piece, emergencyPlay.nextInt());
        }
        //Directs to Game End Sequence, otherwise Main() moves to next step of the Sequence Process.
        if (gameCheckWin(piece)) {
            gridVisual();
            gameEndSequence(piece, isGridFull);
        } else if (!isEmergencyPlay) {
            gridVisual();
        }
    }


    /* Checks if selected spot on the Grid is unoccupied */
    public boolean checkNotOccupied(String piece, int x, int y) {
        if (theGrid[x][y].equals(TicTacToe.playerOnePiece) || theGrid[x][y].equals(TicTacToe.playerTwoPiece)) {
            return false;
        }
        else {
            theGrid[x][y] = piece;
            return true;
        }
    }

    /* Conducts win validations on an ongoing game to see if a player has won the game */
    public boolean gameCheckWin(String piece) {
        /* Horizontal checks */
        for (int i=0; i<theGrid.length; i++) {
            if (theGrid[i][0].equals(piece) && theGrid[i][1].equals(piece) && theGrid[i][2].equals(piece)) {
                return true;
            }
        }
        /* Vertical checks */
        for (int i=0; i<theGrid.length; i++) {
            if (theGrid[0][i].equals(piece) && theGrid[1][i].equals(piece) && theGrid[2][i].equals(piece)) {
                return true;
            }
        }
        /* Diagonal checks */
        if (theGrid[0][0].equals(piece) && theGrid[1][1].equals(piece) && theGrid[2][2].equals(piece)) {
            return true;
        }
        else if (theGrid[0][2].equals(piece) && theGrid[1][1].equals(piece) && theGrid[2][0].equals(piece)) {
            return true;
        }

        /* GameBoard Fullness check */
        if (!theGrid[0][0].equals("") && !theGrid[0][1].equals("") && !theGrid[0][2].equals("")) {
            if (!theGrid[1][0].equals("") && !theGrid[1][1].equals("") && !theGrid[1][2].equals("")) {
                if (!theGrid[2][0].equals("") && !theGrid[2][1].equals("") && !theGrid[2][2].equals("")) {
                    isGridFull = true;
                }
            }
        }
        /* Checks if the Grid is full, before returning */
        if (isGridFull) {
            return true;
        } else {
            return false;
        }
    }


    /** GameBoard Output Methods*/
    /* Outputs the a visual representation of the grid onto console for the user */
    public void gridVisual() {
        System.out.println(q1 + " | " + q2 + " | " + q3 + "\n" + q4 + " | " + q5 + " | " + q6 + "\n" +
                q7 + " | " + q8 + " | " + q9 + "\n");
    }

    /* Outputs Congratulations & Thanks for playing to the players messages  and ends the Program */
    private void gameEndSequence(String piece, boolean isGridFullQ) {
        if (isGridFullQ) {
            System.out.println("\nAll open grids have been filled! No winners this time!\n");
        }
        else {
            if (TicTacToe.playerOnePiece.equals(piece)) {
                System.out.println("\nPlayer 1 has won!!\n");
            }
            else {
                if (TicTacToe.isOpponentAI) {
                    System.out.println("\nPlayer 2 [AI] has won!\n");
                } else {
                    System.out.println("\nPlayer 2 Wins!\n");
                }
            }
        }
        System.out.println("Thanks you all for playing! <3 \n\t\t- Joel Kuruvilla");
        System.exit(1);
    }
}