/*
The Player (a.k.a Player 1).
=
By: Joel Kuruvilla.
Created on: Jan-03-2021.
This File was created on: Jan-21-2021.
~
This File was updated/modified on: May-24-2022.
=
Hi o/ The user/player operations are here.
*/
import java.util.Scanner;

public class Player {
    Scanner PlayerChose = new Scanner(System.in);

    /* User input for Player 1 to decide where their next symbol on the GameBoard would go */
    public int playerChoiceInput() {
        System.out.println("Player 1's turn!");
        return PlayerChose.nextInt();
    }
}
