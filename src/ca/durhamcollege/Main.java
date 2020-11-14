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

        for (int round = 0; round < NUM_OF_GAMES; ++round)
        {
            for (int player = 0; player < NUM_OF_USERS; ++player)
            {
                boolean isValidInput = false;
                while(!isValidInput)
                {
                    try
                    {
                        int tempScore = 0;
                        System.out.printf("Please enter %s's score for GAME #%d: ", playerNames[player], (round + 1));
                        tempScore = keyboard.nextInt();
                        if(tempScore < LOWEST_SCORE || tempScore > HIGHEST_SCORE)
                        {
                            System.out.printf("Error: You must enter a score between %d and %d inclusive", LOWEST_SCORE, HIGHEST_SCORE);
                            keyboard.nextLine();
                        }
                        else
                        {
                            scores[round][player] = tempScore;
                            isValidInput = true;
                        }
                    }
                    catch (InputMismatchException inputMismatchException)
                    {
                        System.out.println("Error: You must enter a whole integer value");
                        keyboard.nextLine();
                    }
                }
            }
        }

        // Output results
        for (int player = 0; player < NUM_OF_USERS; ++player)
        {
            System.out.printf("\nScore Details for %s:\n", playerNames[player]);
            int tempTotal = 0;
            for (int round = 0; round < NUM_OF_GAMES; ++round)
            {
                System.out.printf("Game #%d: %d\n", (round + 1), scores[round][player]);
                tempTotal += scores[round][player];
                if (round == 1)
                {
                    System.out.printf("Average for %s: %.1f\n", playerNames[player], (float)(tempTotal / 2));
                }
            }
        }
    }
}