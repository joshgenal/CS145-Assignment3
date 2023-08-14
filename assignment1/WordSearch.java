/*
Joshua Genal
CS145 Assignment 1: Word Search Generator
Synopsis: Allows a user to generate a wordsearch manually or by importing text. Also supports saving
the game to a file.
last updated 07/26/2023
*/

import java.util.*;
import java.io.*;

public class WordSearch {
    private static char[][] wordSearchGrid;
    private static char[][] solutionGrid;
    private static int gridSize = 10; // default size
    private static Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printIntro();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Choose an option:");
            System.out.println("g - generate a new word search");
            System.out.println("p - print word search");
            System.out.println("s - show solution");
            System.out.println("sf - save word search to a file");
            System.out.println("rf - read words from a file");
            System.out.println("q - quit");
            String option = scanner.nextLine();
            switch (option) {
                case "g":
                    generate();
                    break;
                case "p":
                    print(wordSearchGrid);
                    break;
                case "s":
                    print(solutionGrid);
                    break;
                case "q":
                    isRunning = false;
                    break;
                case "sf":
                    saveToFile();
                    break;
                case "rf":
                    readFromFile();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // This method prints out the intro to the program
    public static void printIntro() {
        System.out.println("Welcome to the Word Search Generator!");
        System.out.println("Let's get started!");
    }

    // This method prompts the user for how many words and what the words are and generate a word
    // search based on those words
    public static void generate() {
        System.out.println("How many words do you want to add?");
        int numWords = scanner.nextInt();
        scanner.nextLine();
        wordSearchGrid = new char[gridSize][gridSize];
        solutionGrid = new char[gridSize][gridSize];
        for (int i = 0; i < numWords; i++) {
            System.out.println("Enter word " + (i + 1) + ": ");
            String word = scanner.nextLine();
            placeWord(word);
        }
        fillRemainingWithRandomLetters();
    }

    // Helper method to place a word in the word search grid
    public static void placeWord(String word) {
        int direction = rand.nextInt(3); // 0 for horizontal, 1 for vertical, 2 for diagonal
        boolean isPlaced = false;
        int tries = 0;
        while (!isPlaced && tries < 100) {
            int startRow = rand.nextInt(gridSize);
            int startCol = rand.nextInt(gridSize);
            switch (direction) {
                case 0:
                    isPlaced = placeWordHorizontal(word, startRow, startCol);
                    break;
                case 1:
                    isPlaced = placeWordVertical(word, startRow, startCol);
                    break;
                case 2:
                    isPlaced = placeWordDiagonal(word, startRow, startCol);
                    break;
            }
            tries++;
        }
    }

    // Helper method to place a word horizontally
    public static boolean placeWordHorizontal(String word, int row, int col) {
        if (col + word.length() <= gridSize) {
            for (int i = 0; i < word.length(); i++) {
                if (wordSearchGrid[row][col + i] != '\u0000' && wordSearchGrid[row][col + i] 
                != word.charAt(i)) {
                    return false;
                }
            }
            for (int i = 0; i < word.length(); i++) {
                wordSearchGrid[row][col + i] = word.charAt(i);
                solutionGrid[row][col + i] = word.charAt(i);
            }
            return true;
        }
        return false;
    }

    // Helper method to place a word vertically
    public static boolean placeWordVertical(String word, int row, int col) {
        if (row + word.length() <= gridSize) {
            for (int i = 0; i < word.length(); i++) {
                if (wordSearchGrid[row + i][col] != '\u0000' && wordSearchGrid[row + i][col] 
                != word.charAt(i)) {
                    return false;
                }
            }
            for (int i = 0; i < word.length(); i++) {
                wordSearchGrid[row + i][col] = word.charAt(i);
                solutionGrid[row + i][col] = word.charAt(i);
            }
            return true;
        }
        return false;
    }

    // Helper method to place a word diagonally
    public static boolean placeWordDiagonal(String word, int row, int col) {
        if (row + word.length() <= gridSize && col + word.length() <= gridSize) {
            for (int i = 0; i < word.length(); i++) {
                if (wordSearchGrid[row + i][col + i] != '\u0000' && wordSearchGrid[row + i]
                [col + i] != word.charAt(i)) {
                    return false;
                }
            }
            for (int i = 0; i < word.length(); i++) {
                wordSearchGrid[row + i][col + i] = word.charAt(i);
                solutionGrid[row + i][col + i] = word.charAt(i);
            }
            return true;
        }
        return false;
    }

    // Helper method to fill up remaining cells with random letters
    public static void fillRemainingWithRandomLetters() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (wordSearchGrid[i][j] == '\u0000') {
                    wordSearchGrid[i][j] = (char) ('A' + rand.nextInt(26));
                    solutionGrid[i][j] = 'X';
                }
            }
        }
    }

    // This method prints the current word search that has been generated
    public static void print(char[][] grid) {
        if (grid != null) {
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("You have not generated a word search yet. Please do so first.");
        }
    }

    // This method prints the solution to the word search that has been generated
    public static void showSolution() {
        print(solutionGrid);
    }

    // This method saves the word search and its solution to a file
    public static void saveToFile() {
        System.out.println("Enter the name of the file to save the word search:");
        String fileName = scanner.nextLine();
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            // Save word search and solution to the file
            saveGridToFile(out, wordSearchGrid);
            out.println();
            saveGridToFile(out, solutionGrid);
            System.out.println("Word search and its solution saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
        }
    }

    // Helper method to save a grid to a file
    public static void saveGridToFile(PrintWriter out, char[][] grid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                out.print(grid[i][j] + " ");
            }
            out.println();
        }
    }

    // This method reads words from a text file and generates the word search
    public static void readFromFile() {
        System.out.println("Enter the name of the file to read words from:");
        String fileName = scanner.nextLine();
        List<String> words = readWordsFromFile(fileName);
        if (!words.isEmpty()) {
            gridSize = Math.max(gridSize, getMaxWordLength(words));
            generateFromWords(words);
            System.out.println("Word search generated from file: " + fileName);
        } else {
            System.out.println("No valid words found in the file.");
        }
    }

    // Helper method to read words from a file
    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().trim().toLowerCase();
                if (isValidWord(word)) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return words;
    }

    // Helper method to check if a word is valid (only contains letters)
    public static boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

    // Helper method to generate the word search from a list of words
    public static void generateFromWords(List<String> words) {
        wordSearchGrid = new char[gridSize][gridSize];
        solutionGrid = new char[gridSize][gridSize];
        for (String word : words) {
            placeWord(word);
        }
        fillRemainingWithRandomLetters();
    }

    // Helper method to get the maximum word length from a list of words
    public static int getMaxWordLength(List<String> words) {
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        return max;
    }
}
