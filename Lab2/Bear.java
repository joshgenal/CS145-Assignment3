/*
Joshua Genal
Lab 2: Critters - Bear Class
last edited 08/14/2023
Function: Creates a useable "Bear" class for use in the Critters lab.
*/

import java.awt.Color;

// Class definition for a "Bear" critter
public class Bear extends Critter {
  private Color color; // Stores the color of the bear (either white or black)
  private boolean slash; // Flag to alternate between "/" and "\" representations

  // Constructor
  public Bear(boolean polar) {
    // If the bear is a polar bear, set color to white; otherwise, set color to black
    if (polar) {
      color = Color.WHITE;
    } else {
      color = Color.BLACK;
    }
    slash = true; // Start with "/"
  }

  // Method to determine the bear's next move
  public Action getMove(CritterInfo info) {
    // If there's an enemy in front, infect it
    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    }
    // If the space in front is empty, hop
    else if (info.getFront() == Neighbor.EMPTY) {
      return Action.HOP;
    }
    // Otherwise, turn left
    else {
      return Action.LEFT;
    }
  }

  // Method to get the current color of the bear
  public Color getColor() {
    return color;
  }

  // Method to represent the bear as a string
  public String toString() {
    // If slash is true, return "/" and set slash to false; otherwise, return "\" and set slash to true
    if (slash) {
      slash = false;
      return "/";
    } else {
      slash = true;
      return "\\";
    }
  }
}
