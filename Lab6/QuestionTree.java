/*
Joshua Genal
CS&145
Lab 6: 20 Questions
QuestionTree
last edited 08/08/2023

Bulk of the code. Interacts with the user and the file system, keeps score, manages the overall 
logic of the 20 Questions game. Responsible for maintaining the binary tree structure and the 
rules for traversing the tree based on user input.
*/

import java.io.*;
import java.util.*;

public class QuestionTree {
    // Root node of the question tree.
    private QuestionNode initialQuestion;
    // User interface to interact with the user.
    private final UserInterface ui;
    // Total games played counter.
    private int totalGamesPlayed;
     // Games lost counter.
    private int gamesLost;

    // Constructor to initialize the question tree with the user interface.
    public QuestionTree(UserInterface ui) {
        if (ui == null) {
            throw new IllegalArgumentException("UserInterface cannot be null");
        }
        this.initialQuestion = new QuestionNode("tree");
        this.ui = ui;
        this.totalGamesPlayed = 0;
        this.gamesLost = 0;
    }

    // Method to load a question tree from a Scanner input.
    public void load(Scanner input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        this.initialQuestion = this.readHelper(input);
    }

    // Recursive helper method to read the question tree from input.
    private QuestionNode readHelper(Scanner input) {
        String nodeType = input.nextLine().trim();
        String nodeData = input.nextLine().trim();
        QuestionNode current = new QuestionNode(nodeData);
        if (nodeType.equals("Q:")) {
            current.setYesLeft(this.readHelper(input));
            current.setNoRight(this.readHelper(input));
        }
        return current;
    }

    // Method to save the question tree to a PrintStream output.
    public void save(PrintStream output) {
        if (output == null) {
            throw new IllegalArgumentException("Output cannot be null");
        }
        this.write(this.initialQuestion, output);
    }

    // Recursive helper method to write the question tree to output.
    private void write(QuestionNode current, PrintStream output) {
        if (current.getYesLeft() == null && current.getNoRight() == null) {
            output.println("A:");
            output.println(current.getStatement());
        } else {
            output.println("Q:");
            output.println(current.getStatement());
            this.write(current.getYesLeft(), output);
            this.write(current.getNoRight(), output);
        }
    }

    // Method to play a single game of 20 Questions.
    public void play() {
        this.totalGamesPlayed++;
        this.initialQuestion = play(this.initialQuestion);
        if (this.initialQuestion == null) {
            this.gamesLost++;
        }
    }

    // Recursive helper method to play a game, returns the modified question node.
    private QuestionNode play(QuestionNode currentQuestion) {
        if (currentQuestion.getYesLeft() == null && currentQuestion.getNoRight() == null) {
            ui.print("Would your object happen to be ");
            if (yesTo(currentQuestion.getStatement() + "?")) {
                ui.println("Great, I got it right!");
                return currentQuestion;
            } else {
                return gatherNewInfo(currentQuestion);
            }
        } else {
            if (yesTo(currentQuestion.getStatement())) {
                currentQuestion.setYesLeft(play(currentQuestion.getYesLeft()));
            } else {
                currentQuestion.setNoRight(play(currentQuestion.getNoRight()));
            }
            return currentQuestion;
        }
    }

    // Method to gather new information if the guess was wrong.
    private QuestionNode gatherNewInfo(QuestionNode current) {
        ui.print("What is the name of your object? ");
        QuestionNode newObject = new QuestionNode(ui.nextLine().trim());
        ui.println("Please give me a yes/no question that");
        ui.println("distinguishes between your object");
        ui.print("and mine--> ");
        String newQuestion = ui.nextLine().trim();
        if (yesTo("And what is the answer for your object?")) {
            return new QuestionNode(newQuestion, newObject, current);
        }
        return new QuestionNode(newQuestion, current, newObject);
    }

    // Method to ask a yes/no question and return the result.
    public boolean yesTo(String prompt) {
        ui.print(prompt + " (y/n)? ");
        return ui.nextBoolean();
    }

    // Getter for total games played.
    public int totalGames() {
        return this.totalGamesPlayed;
    }

    // Getter for games won.
    public int gamesWon() {
        return this.totalGamesPlayed - this.gamesLost;
    }

    // Getter for games lost.
    public int gamesLost() {
        return this.gamesLost;
    }
}
