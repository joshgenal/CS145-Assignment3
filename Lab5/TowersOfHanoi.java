/*
Joshua Genal
CS &145
Lab 6: Towers Of Hanoi
*/
import java.util.Scanner;

public class TowersOfHanoi 
{

    public static void main(String[] args) 
    {
        Solver.showWelcomeMessage();
        Solver.runMainMenu();
    }

    public static class Solver 
    {

        private static boolean isStopped = false;
        private static boolean isAsciiTowerDisplayed = false;

        public static void showWelcomeMessage() 
        {
            System.out.println("\nWelcome to the Towers of Hanoi Puzzle Solver!");
            displayAsciiTower();
        }

        public static void displayAsciiTower() 
        {
            String towerRow = " %3s        %3s       %3s%n";

            System.out.printf(towerRow, "^", "^", "^");
            System.out.printf(towerRow, "!", "!", "!");
            System.out.printf(towerRow, "*", " ", "!");
            System.out.printf(towerRow, "***", " ", "!");
            System.out.printf(towerRow, "*****", " ", "!");
            System.out.println("--------------------------");
        }

        public static void runMainMenu() 
        {
            int numberOfDisks = getNumberOfDisks();
            displayPuzzleSolution(numberOfDisks);

            Scanner in = new Scanner(System.in);
            while (!isStopped) 
            {
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
                        runMainMenu();
                        break;
                    default:
                        System.out.println("\nSorry, I didn't understand your answer. Please say 'yes' or 'no'.");
                        break;
                }
            }
        }

        public static int getNumberOfDisks() 
        {
            Scanner console = new Scanner(System.in);
            int numberOfDisks;

            System.out.println("\nThere are five disks to play with.");
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

            if (numberOfDisks > 5) 
            {
                System.out.println();
                System.out.println("That's too many disks!");
                System.out.println("We'll play with five disks instead.");
                numberOfDisks = 5;
            }
            return numberOfDisks;
        }

        public static void displayPuzzleSolution(int numberOfDisks) 
        {
            System.out.println("\nWe solved the puzzle!\n");
            String solutionSteps = solveTowerOfHanoi(numberOfDisks, 1, 3);

            for (String step : solutionSteps.split(";")) 
            {
                System.out.printf("We moved a disk from tower %s.", step);
                System.out.println();
            }

            if (!isAsciiTowerDisplayed) 
            {
                displayAsciiSolvedTower();
            }
        }

            public static void displayAsciiSolvedTower() 
            {
            String towerRow = " %3s        %3s       %3s%n";

            System.out.printf(towerRow, "^", "^", "^");
            System.out.printf(towerRow, "!", "!", "!");
            System.out.printf(towerRow, "!", "!", "*");
            System.out.printf(towerRow, "!", "!", "***");
            System.out.printf(towerRow, "!", "!", "*****");
            System.out.println("--------------------------");
            isAsciiTowerDisplayed = true;
        }

        public static String solveTowerOfHanoi(int numberOfDisks, int fromTower, int toTower) 
        {
            if(numberOfDisks == 1) 
            {
                return fromTower + " to Tower " + toTower + ";";
            } 
            else 
            {
                String step1, step2, step3;
                int helpTower = 6 - fromTower - toTower;

                step1 = solveTowerOfHanoi(numberOfDisks - 1, fromTower, helpTower);
                step2 = fromTower + " to Tower " + toTower + ";";
                step3 = solveTowerOfHanoi(numberOfDisks - 1, helpTower, toTower);

                return step1 + step2 + step3;
            }
        }
    }
}
