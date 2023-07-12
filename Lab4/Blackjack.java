/*
Joshua Genal
CS&145
Lab 4: Deck of Cards
Game

Allows a user to play a game of blackjack.
*/

import java.util.*;

public class Blackjack 
{
    private static Queue<Card> playerCards;
    private static Queue<Card> dealerCards;
    private static int playerScore;
    private static int dealerScore;
    private static Scanner scanner;
    private static int wins;
    private static int losses;

    public static void main(String[] args) 
    {
        // initialize scanner and scores
        scanner = new Scanner(System.in);
        wins = 0;
        losses = 0;

        do 
        {
            // create and shuffle deck, reset player and dealer hands and scores
            Deck deck = new Deck();
            deck.shuffle();
            playerCards = new LinkedList<Card>();
            dealerCards = new LinkedList<Card>();
            playerScore = 0;
            dealerScore = 0;

            System.out.println("Welcome to Blackjack!");

            try 
            {
                // each player gets two cards
            Card card = deck.drawCard();
            playerCards.offer(card);
            playerScore += card.getValue();
    
            card = deck.drawCard();
            dealerCards.offer(card);
            dealerScore += card.getValue();
         
            card = deck.drawCard();
            playerCards.offer(card);
            playerScore += card.getValue();
             
            card = deck.drawCard();
            dealerCards.offer(card);
            dealerScore += card.getValue();
            // calculate initial scores
            playerScore = calculateScore(playerCards);
            dealerScore = calculateScore(dealerCards);
            } 
            catch (Exception e) 
            {
                // if there was a problem drawing cards, print the error and quit
                System.out.println(e.getMessage());
                return;
            }

            while (true) 
            {
                // show player their hand and score, show dealer's first card
                System.out.println("Your hand: " + playerCards.toString() + " (" + playerScore + ")");
                System.out.println("Dealer's hand: " + dealerCards.peek().toString() + " (hidden)");

                // check if player has blackjack or bust
                if (playerScore == 21) 
                {
                    System.out.println("Blackjack! You win!");
                    wins++;
                    break;
                } 
                else if (playerScore > 21) 
                {
                    System.out.println("Bust! You lose.");
                    losses++;
                    break;
                }

                System.out.print("What would you like to do? (hit/stand) ");
                String choice = scanner.next();

                switch (choice.toLowerCase()) 
                {
                    case "hit":
                        try 
                        {
                            // draw a card and recalculate score
                            Card card = deck.drawCard();
                            playerCards.offer(card);
                            playerScore = calculateScore(playerCards);
                        } 
                        catch (Exception e) 
                        {
                            System.out.println(e.getMessage());
                            return;
                        }
                        break;
                    case "stand":
                        // dealer draws cards until they have at least 17 points
                        while (dealerScore < 17) 
                        {
                            try 
                            {
                                dealerCards.offer(deck.drawCard());
                                dealerScore = calculateScore(dealerCards);
                            } 
                            catch (Exception e) 
                            {
                                System.out.println(e.getMessage());
                                return;
                            }
                        }
                        // show final hands and scores
                        System.out.println("Your hand: " + playerCards.toString() + " (" + playerScore +
                                ")");
                        System.out.println("Dealer's hand: " + dealerCards.toString() + " (" + dealerScore +
                                ")");

                        // check for dealer bust, push, dealer win, player win
                        if (dealerScore > 21) 
                        {
                            System.out.println("Dealer bust! You win!");
                            wins++;
                        } 
                        else if (dealerScore == playerScore) 
                        {
                            System.out.println("Push!");
                        } 
                        else if (dealerScore > playerScore) 
                        {
                            System.out.println("Dealer wins!");
                            losses++;
                        } 
                        else 
                        {
                            System.out.println("You win!");
                            wins++;
                        }
                        break;
                    default:
                        // if the input was not "hit" or "stand", ask again
                        System.out.println("Invalid input. Please try again.");
                        break;
                }

                // if the game is over, break the loop
                if (playerScore == 21 || playerScore > 21 || dealerScore > 21) 
                {
                    break;
                }
            }

            // print total wins and losses
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.print("Would you like to play again? (yes/no) ");
        } 
        while (scanner.next().equalsIgnoreCase("yes"));
    }

    private static int calculateScore(Queue<Card> cards) 
    {
        int score = 0;
        int aceCount = 0;

        // calculate total score and count aces
        for (Card card : cards) 
        {
            if (card.getRank() == Card.Rank.ACE) 
            {
                aceCount++;
            }
            score += card.getValue();
        }

        // if score is over 21 and there are aces, count them as 1 instead of 11
        while (score > 21 && aceCount > 0) 
        {
            score -= 10;
            aceCount--;
        }

        return score;
    }
}
