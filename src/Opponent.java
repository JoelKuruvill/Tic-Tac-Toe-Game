/*
The Players [Player 1] Opponent (AI or 2nd Human player (a.k.a. Player 2)).
=
By: Joel Kuruvilla.
Created on: Jan-03-2021.
This File was created on: Jan-21-2021.
~
This File was updated/modified on: May-24-2022.
=
The 'AI' opponent that you are (maybe optionally) playing against. This is where AI activities would be stored.
2nd Human player [Player 2] actions are also stored here!
*/
import java.util.Scanner;

public class Opponent {
    Scanner PlayerTwoChose = new Scanner(System.in);

    public void pickONumber() {
        double AIchosenGrid = Math.random() * 10;
        if (AIchosenGrid < 0 || AIchosenGrid > 9) {
            pickONumber();
        }
    }

    /* User input for Player 2 to decide where their next symbol on the GameBoard would go */
    public int playerTwoChoiceInput() {
        System.out.println("Now Player 2's turn!");
        return PlayerTwoChose.nextInt();
    }
}
