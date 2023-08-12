/*
Joshua Genal
06/30/23
CS &145
Lab # 1: Guessing Game
This program will allow the user to play a game in which they'll attempt to guess a
randomly
assigned integer and will receive feedback as to whether their guesses are higher
or lower
than the solution. They'll have 5 chances to succeed if they want to avoid a
somewhat patronizing
message.The game will offer to continue, will keep track of various statistics, and
will spit them
out in summary when the player quits.
*/
import java.util.Scanner;
public class JGGuessingGame {

 private static int totalGuesses;
 private static int totalGames;
 private static int wins;
 private static int losses;
 private static double average;
 private static int bestGame = 9999;

 private static final Scanner input = new Scanner(System.in);
 public static void main(String[] args) {
 intro();
 char ch;
 do {
 playOneGame();
 System.out.print("\n\nDo you want to play again? y/n ");
 ch = input.next().charAt(0);
 } while (ch == 'y' || ch == 'Y');

 showResults();
 }

 public static void intro() {
 System.out.println("This program allows you to play a guessing game.\n" +
 "I will think of a number between 1 and 100 and will allow
you to guess until\n" +
 "you get it. For each guess, I will tell you whether the
right answer is higher\n" +
 "or lower than your guess.\n\nYou have 5 chances.\n");
 }

 public static void playOneGame() {
 int range = 100;
 int number = 1 + (int)(range * Math.random());
 int numGuesses = 5;

 System.out.println("I'm thinking of a number between 1 and " + range +
"...");
 for (int i = 0; i < numGuesses; i++) {
 System.out.print("Your guess? ");
 int guess = input.nextInt();
 totalGuesses++;

 if (guess == number) {
 if (totalGuesses == 1) {
 System.out.println("You got it right in 1 guess!");
 } else {
 System.out.println("Congratulations! You guessed the number in " +
(i+1) + " tries.");
 }
 wins++;
 break;
 } else if (guess < number) {
 System.out.println("The number is greater than " + guess + ".");
 } else {
 System.out.println("The number is less than " + guess + ".");
 }

 if (i == numGuesses - 1) {
 losses++;
 System.out.println("You have run out of guesses! The number was " +
number);
 }
 }

 if (numGuesses < bestGame) {
 bestGame = numGuesses;
 }

 totalGames++;
 average = ((double)totalGuesses / totalGames);
 }

 public static void showResults() {
 System.out.println("Overall results:");
 System.out.println("total games: " + totalGames);
 System.out.println("total wins: " + wins);
 System.out.println("total losses: " + losses);
 System.out.printf("total guesses: %d\n", totalGuesses);
 System.out.printf("guesses/game: %.1f\n", average);
 System.out.println("best game: " + bestGame);
 }
}
