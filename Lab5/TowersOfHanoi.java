/*
Joshua Genal
CS &145
Lab 6: Towers Of Hanoi
last modified 08/01/2023
This program is a basic solution to the Towers of Hanoi puzzle. It allows the user to input the
number of disks they want to play with, up to a limit of 4. It uses recursion to move the disks
from the starting tower to the destination tower following the rules of the Towers of Hanoi game.
*/

import java.util.Scanner;

public class TowersOfHanoi 
{
    public static void main(String[] args) 
    {
        Solver solver = new Solver();
        solver.run();
    }

    public static class Solver 
    {
        private boolean isStopped = false;

        // Start the game
        public void run() 
        {
            showWelcomeMessage();
            while (!isStopped) 
            {
                runMainMenu();
            }
        }

        // Display welcome message
        public void showWelcomeMessage() 
        {
            System.out.println("\nWelcome to the Towers of Hanoi Puzzle Solver!");
        }

        // Main game menu
        public void runMainMenu() 
        {
            int numberOfDisks = getNumberOfDisks();
            displayPuzzleSolution(numberOfDisks);

            Scanner in = new Scanner(System.in);
            System.out.print("\nDo you want to play again? ");
            String userInput = in.nextLine();
            String playAgain = userInput.replaceAll("\\s", "");
            playAgain = playAgain.toUpperCase();
            String firstChar = playAgain.substring(0, 1);

            switch (firstChar) 
            {
                case "N":
                    isStopped = true;
                    System.out.println("\nThank you for trying the Towers of Hanoi Demo!");
                    break;
                case "Y":
                    // Nothing to do, the loop will restart the game
                    break;
                default:
                    System.out.println("\nSorry, I didn't understand your answer.");
                    System.out.println("\nPlease say 'yes' or 'no'.");
                    break;
            }
        }

        // Get the number of disks from the user
        public int getNumberOfDisks() 
        {
            Scanner console = new Scanner(System.in);
            int numberOfDisks;

            System.out.println("\nThere are four disks to play with.");
            System.out.print("How many disks do you want to play with?  ");

            while (true) 
            {
                try 
                {
                    String input = console.next();
                    numberOfDisks = Integer.parseInt(input);
                    break;
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Sorry, that's not a number. Please try again.");
                    System.out.print("How many disks do you want to play with?  ");
                }
            }

            if (numberOfDisks > 4) 
            {
                System.out.println();
                System.out.println("That's too many disks!");
                System.out.println("We'll play with four disks instead.");
                numberOfDisks = 4;
            }
            return numberOfDisks;
        }

        // Display the steps to solve the puzzle
        public void displayPuzzleSolution(int numberOfDisks) 
        {
            System.out.println("\nWe solved the puzzle!\n");
            String solutionSteps = solveTowerOfHanoi(numberOfDisks, 1, 3);

            for (String step : solutionSteps.split(";")) 
            {
                System.out.printf("We moved a disk from tower %s.\n", step);
            }
            System.out.println("Puzzle solved!");
        }

        // Recursive function to solve the Towers of Hanoi puzzle
        private String solveTowerOfHanoi(int numberOfDisks, int fromTower, int toTower) 
        {
            StringBuilder solution = new StringBuilder();

            if(numberOfDisks == 1) 
            {
                solution.append(fromTower).append(" to Tower ").append(toTower).append(";");
            } 
            else 
            {
                int helpTower = 6 - fromTower - toTower;

                solution.append(solveTowerOfHanoi(numberOfDisks - 1, fromTower, helpTower));
                solution.append(fromTower).append(" to Tower ").append(toTower).append(";");
                solution.append(solveTowerOfHanoi(numberOfDisks - 1, helpTower, toTower));
            }
            return solution.toString();
        }
    }
}
