/*
Joshua Genal
CS145 Assignment 1: Word Search Generator
Synopsis: Invites the user to create and play a word search, calls the method to do so, and then invites the user to play again.
Winter 2023
*/



import java.util.*;

public class JGWordSearch 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int loop = 0;

        System.out.println("Hey! Let's play a game together!");
        System.out.println("I choose... Word Search!!! (^.^)");
        while (loop == 0) 
        {
            System.out.println("How many words would you like to use? (up to 6)");
            String answer = in.next();
            int numOfWords = Integer.parseInt(answer);
            String[] words = new String[numOfWords];
            for (int i = 0; i < numOfWords; i++) 
            {
                System.out.println("Please type in word number " + (i + 1) + ": ");
                answer = in.next();
                words[i] = answer;
            }

            WordSearchGenerator newGame = new WordSearchGenerator(calculateGridSize(numOfWords), words);
            //call method
            newGame.filler();
            System.out.println("Play again?");
            answer = in.next();
            if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') 
            {
                loop = 0;
            } 
            else 
            {
                loop = 1;
            }
        }
    }

    //grid size
    public static int calculateGridSize(int numOfWords) 
    {
        int gridSize = 0;
        if (numOfWords < 3) 
        {
            gridSize = numOfWords * 7;
        } 
        else if (numOfWords < 5) 
        {
            gridSize = numOfWords * 4;
        } 
        else if (numOfWords < 6) 
        {
            gridSize = numOfWords * 4;
        } 
        else if (numOfWords < 7) 
        {
            gridSize = numOfWords * 3;
        } 
        else 
        {
            gridSize = numOfWords;
        }
        return gridSize;
    }
}
