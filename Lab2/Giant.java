/*
Joshua Genal
Lab 2: Critters - Giant Class
last edited 08/14/2023
Function: Creates a useable "Giant" class for use in the Critters lab.
*/

import java.awt.Color;

// Class definition for a "Giant" critter
public class Giant extends Critter {
  private int moves; // Tracks the number of moves made by the giant

  // Constructor to initialize the Giant object
  public Giant() {
    moves = 0; // Start with zero moves
  }

  // Method to get the current color of the giant, always returns gray
  public Color getColor() {
    return Color.GRAY;
  }

  // Method to represent the giant as a string
  public String toString() {
    // Determine the current cycle of moves (0-23)
    int cycle = moves % 24;
    // Depending on the cycle, return "fee", "fie", "foe", or "fum"
    if (cycle < 6) {
      return "fee";
    } else if (cycle < 12) {
      return "fie";
    } else if (cycle < 18) {
      return "foe";
    } else {
      return "fum";
    }
  }

  // Method to determine the giant's next move
  public Action getMove(CritterInfo info) {
    moves++; // Increment the number of moves

    // If there's an enemy in front, infect it
    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    }
    // If the space in front is empty, hop
    else if (info.getFront() == Neighbor.EMPTY) {
      return Action.HOP;
    }
    // Otherwise, turn right
    else {
      return Action.RIGHT;
    }
  }
}
