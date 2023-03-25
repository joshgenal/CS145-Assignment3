/*
Joshua Genal
CS145 Assignment 1: Word Search Generator
Synopsis: Creates a word search with user input, then shows the solution upon request.
Winter 2023
*/

import java.util.*;

public class WordSearchGenerator 
{

    public int size;
    public String[] words = new String[3];
    public char[][] grid = new char[size][size];
    Random rn = new Random();
    Scanner in = new Scanner(System.in);

    public WordSearchGenerator(int size, String[] words) 
    {
        this.size = size;
        this.words = words;
    }

    public void filler() 
    {
        char[][] temp = new char[size][size];
        char[][] grid = new char[size][size];
        for (int row = 0; row < size; row++) 
        {
            for (int col = 0; col < size; col++) 
            {
                char c = (char) (rn.nextInt(26) + 'a');
                grid[row][col] = c;
                temp[row][col] = 'X';
            }
        }
        for (int i = 0; i < words.length; i++) 
        {
            int rand = rn.nextInt(2);
            if (rand == 1) {
                int randomX = rn.nextInt(size - words[i].length());
                int randomY = rn.nextInt(size - words[i].length());
                for (int g = 0; g < words[i].length(); g++) 
                {
                    grid[randomX][randomY + g] = words[i].charAt(g);
                    temp[randomX][randomY + g] = words[i].charAt(g);
                }
            } 
            else 
            {
                int randomX = rn.nextInt(size - words[i].length());
                int randomY = rn.nextInt(size - words[i].length());
                for (int g = 0; g < words[i].length(); g++) 
                {
                    grid[randomX + g][randomY] = words[i].charAt(g);
                    temp[randomX + g][randomY] = words[i].charAt(g);
                }
            }
        }
        print(grid);
        System.out.println("ready for the solution?");
        String answer = in.next();
        if (answer.charAt(0) != 'n') 
        {
            solutionPrint(temp);
        }
    }

    public void print(char[][] grid) 
    {
        for (int row = 0; row < size; row++) 
        {
            for (int col = 0; col < size; col++) 
            {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void solutionPrint(char[][] temp) 
    {
        for (int row = 0; row < size; row++) 
        {
            for (int col = 0; col < size; col++) 
            {
                System.out.print(temp[row][col] + " ");
            }
            System.out.println();
        }
    }
}
