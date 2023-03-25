/*
Joshua Genal
CS &145
Lab 3: Letter Inventory
*/
import java.util.Arrays;
import java.util.Scanner;

public class LetterInventory 
{
    private static final int ALPHABET_COUNT = 26;
    private static int[] letterCounts;
    private static boolean hasInput = false;
    private static boolean playAgain = true;

    public static void main(String[] args) 
    {
        printIntro();
        while (playAgain) 
        {
            printMenu();
        }
    }

    public static void printIntro() 
    {
        System.out.println("Welcome to Letter Inventory!");
        System.out.println("This program counts how many times each letter appears in your text.");
        System.out.println();
    }

    public static void printMenu() 
    {
        Scanner menuConsole = new Scanner(System.in);
        System.out.println("MAIN MENU");
        System.out.println("1. Count letters in text");
        System.out.println("2. Display letter counts");
        System.out.println("3. Quit");
        System.out.print("Enter your choice (1-3): ");

        int choice = 0;
        try 
        {
            choice = Integer.parseInt(menuConsole.next());
        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number from 1 to 3.");
            printMenu();
        }

        switch (choice) 
        {
            case 1:
                String input = getInput();
                countLetters(input);
                hasInput = true;
                break;
            case 2:
                if (!hasInput) 
                {
                    System.out.println("Please enter some text first.");
                } 
                else 
                {
                    printCounts();
                }
                break;
            case 3:
                playAgain = false;
                break;
            default:
                System.out.println("Invalid input. Please enter a number from 1 to 3.");
                printMenu();
                break;
        }
    }

    public static String getInput() 
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the text you want to count letters for: ");
        String input = console.nextLine().replaceAll("\\s", "");
        return input;
    }

    public static void countLetters(String input) 
    {
        letterCounts = new int[ALPHABET_COUNT];
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) 
        {
            char letter = input.charAt(i);
            if (Character.isLetter(letter)) 
            {
                letterCounts[letter - 'a']++;
            }
        }
    }

    public static void printCounts() 
    {
        System.out.println("LETTER COUNTS");
        System.out.println("+------+-------------------+");
        System.out.println("|  No. |  Letter           |");
        System.out.println("+------+-------------------+");
        for (int i = 0; i < ALPHABET_COUNT; i++) 
        {
            System.out.printf("|  %-3d |  %-15c |%n", letterCounts[i], 'A' + i);
        }
        System.out.println("+------+-------------------+");

        StringBuilder sortedInput = new StringBuilder("[ ");
        for (int i = 0; i < ALPHABET_COUNT; i++) 
        {
            for (int j = 0; j < letterCounts[i]; j++) 
            {
                char letter = (char) ('a' + i);
                sortedInput.append(letter);
            }
        }
        sortedInput.append("]");
        System.out.printf("%nSorted User Input: %s%n%n", sortedInput.toString());
    }
}
