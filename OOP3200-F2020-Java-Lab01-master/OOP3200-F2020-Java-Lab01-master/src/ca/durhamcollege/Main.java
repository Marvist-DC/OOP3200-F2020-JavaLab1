/*
 * Author: Duy Tan Vu & Domenic Catalano
 * Date: November 11, 2020
 */

package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Defining our scanner
        Scanner keyboard = new Scanner(System.in);

        // Variables and constants declarations
        final int NUM_OF_GAMES = 2;
        final int NUM_OF_USERS = 3;
        final int LOWEST_SCORE = 0;
        final int HIGHEST_SCORE = 300;
        int roundScore = 0;
        int[][] scores = new int[NUM_OF_GAMES][NUM_OF_USERS];
        String[] playerNames = {"Tom", "Tan", "Domenic"};
        boolean isValidInput = false;

        for (int round = 0; round < NUM_OF_GAMES; ++round) {
            for (int player = 0; player < NUM_OF_USERS; ++player) {
                System.out.printf("Please enter %s's score for GAME #%i", playerNames[player], round);
                while(!isValidInput)
                {
                    try
                    {

                        roundScore = keyboard.nextInt();
                        isValidInput = true;

                        if((roundScore < LOWEST_SCORE) || (roundScore > HIGHEST_SCORE))
                        {
                            System.out.printf("Error: You must enter a score from %i-%i", LOWEST_SCORE, HIGHEST_SCORE);
                            keyboard.nextLine();
                            isValidInput = false;
                        }
                    }
                    catch (InputMismatchException inputMismatchException)
                    {
                        System.out.println("Error: You must enter a valid whold number");
                        keyboard.nextLine();
                        isValidInput = false;
                    }
                }
            }
        }
    }
}

