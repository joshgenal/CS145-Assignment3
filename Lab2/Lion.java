/*
Joshua Genal
Lab 2: Critters - Lion Class
last edited 08/14/2023
Function: Creates a useable "Lion" class for use in the Critters lab.
*/

import java.awt.Color;
import java.util.Random;

// Class definition for a "Lion" critter
public class Lion extends Critter {
  private Color color; // Stores the current color of the lion (Red, Green, or Blue)
  private int moves; // Stores the number of moves made by the lion

  // Constructor
  public Lion() {
    moves = 0; // Initialize moves to 0
    pickColor(); // Choose an initial color
  }

  // Method to pick a random color (Red, Green, Blue)
  public void pickColor() {
    Random random = new Random(); // Create a new random number generator
    int choice = random.nextInt(3); // Choose a random number between 0 and 2
    // Depending on the random number, pick a color
    switch (choice) {
      case 0:
        color = Color.RED;
        break;
      case 1:
        color = Color.GREEN;
        break;
      case 2:
        color = Color.BLUE;
        break;
    }
  }

  // Method to get the current color of the lion
  public Color getColor() {
    // If it's time to switch colors (every three moves)
    if (moves % 3 == 0) {
      pickColor(); // Pick a new color
    }
    return color; // Return the current color
  }

  // Method to represent the lion as a string, always represented as "L"
  public String toString() {
    return "L";
  }

  // Method to determine the lion's next move
  public Action getMove(CritterInfo info) {
    moves++; // Increase the count of moves
    // If there's an enemy in front, infect it
    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    }
    // If there's a wall in front or to the right, turn left
    else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
      return Action.LEFT;
    }
    // If there's a fellow Lion in front, turn right
    else if (info.getFront() == Neighbor.SAME) {
      return Action.RIGHT;
    }
    // Otherwise, hop
    else {
      return Action.HOP;
    }
  }
}
