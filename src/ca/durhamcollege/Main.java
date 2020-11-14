/*
 * Author: Duy Tan Vu & Domenic Catalano
 * Date: November 11, 2020
 */

package ca.durhamcollege;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Defining our scanner
        Scanner keyboard = new Scanner(System.in);

        // Variables and constants declarations
        final int NUM_OF_GAMES = 2;
        final int NUM_OF_USERS = 3;
        final int LOWEST_SCORE = 0;
        final int HIGHEST_SCORE = 300;
        int[][] scores = new int[NUM_OF_GAMES][NUM_OF_USERS];
        String[] playerNames = {"Tom", "Tan", "Domenic"};
        boolean isValidInput = false;

        for (int round = 0; round < NUM_OF_GAMES; ++round)
        {
            for (int player = 0; player < NUM_OF_USERS; ++player)
            {
                System.out.printf("Please enter %s's score for GAME #%x: ", playerNames[player], round);
                while(!isValidInput)
                {


                    isValidInput = true;

                    try
                    {
                        if(( < LOWEST_SCORE) || ( > HIGHEST_SCORE))
                        {
                            System.out.printf("Error: You must enter a score between %x and %x inclusive", LOWEST_SCORE, HIGHEST_SCORE);
                            keyboard.nextLine();
                            isValidInput = false;
                        }
                    }
                    catch (InputMismatchException inputMismatchException)
                    {
                        System.out.println("Error: You must enter a whole integer value");
                        keyboard.nextLine();
                        isValidInput = false;
                    }
                }
            }
        }

        // Output results
        for (int player = 0; player < NUM_OF_USERS; ++player)
        {
            System.out.println("\nScore Details for " + playerNames[player]);
            int tempTotal = 0;
            for (int game = 0; game < NUM_OF_GAMES; ++game)
            {
                System.out.print("Game #" + (game + 1) + ": " + scores[player][game] + "\n");
                tempTotal += scores[player][game];
                if (game == 1)
                {
                    DecimalFormat df = new DecimalFormat("#.#");
                    System.out.println("Average for " + playerNames[player] + ": " + df.format(tempTotal / 2));
                }
            }
        }
    }
}