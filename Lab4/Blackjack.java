/*
Joshua Genal
CS&145
Lab 4: Deck of Cards
Game
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
        scanner = new Scanner(System.in);
        wins = 0;
        losses = 0;

        do 
        {
            Deck deck = new Deck();
            deck.shuffle();
            playerCards = new LinkedList<Card>();
            dealerCards = new LinkedList<Card>();
            playerScore = 0;
            dealerScore = 0;

            System.out.println("Welcome to Blackjack!");

            try 
            {
                playerCards.offer(deck.drawCard());
                dealerCards.offer(deck.drawCard());
                playerCards.offer(deck.drawCard());
                dealerCards.offer(deck.drawCard());
            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
                return;
            }

            while (true) 
            {
                System.out.println("Your hand: " + playerCards.toString() + " (" + playerScore + ")");
                System.out.println("Dealer's hand: " + dealerCards.peek().toString() + " (hidden)");

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
                            playerCards.offer(deck.drawCard());
                            playerScore = calculateScore(playerCards);
                        } 
                        atch (Exception e) {
                            System.out.println(e.getMessage());
                            return;
                        }
                        break;
                    case "stand":
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
                        System.out.println("Your hand: " + playerCards.toString() + " (" + playerScore +
                                ")");
                        System.out.println("Dealer's hand: " + dealerCards.toString() + " (" + dealerScore +
                                ")");

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
                        System.out.println("Invalid input. Please try again.");
                        break;
                }

                if (playerScore == 21 || playerScore > 21 || dealerScore > 21) 
                {
                    break;
                }
            }

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

        for (Card card : cards) 
        {
            if (card.getRank() == Rank.ACE) 
            {
                aceCount++;
            }
            score += card.getValue();
        }

        while (score > 21 && aceCount > 0) 
        {
            score -= 10;
            aceCount--;
        }

        return score;
        }
}

