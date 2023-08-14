/*
Joshua Genal
Lab 2: Critters - Orca Class
last edited 08/14/2023
Function: Creates a competitive "Orca" class for use in the Critters lab.
*/

import java.awt.Color;
import java.util.Random;
public class Orca extends Critter {
private int corner = 0;
private int infectCount = 0;
private int stepCount = 0;
public static final Random r = new Random();
public Orca() {
corner = r.nextInt(4);
}
public Color getColor() {
return Color.GRAY;
}
public String toString() {
return "O";
}
public Action getMove(CritterInfo info) {
infectCount = info.getInfectCount();
stepCount++;
switch (corner) {
case 0:
if (info.getFront() == Neighbor.OTHER) {
return Action.INFECT;
}
if (info.getDirection() == Direction.NORTH) {
if ((info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.LEFT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.RIGHT;
}
if (info.getDirection() == Direction.EAST) {
if ((info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.RIGHT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.SOUTH) {
if (info.getRight() == Neighbor.OTHER ||
info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
if (info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.RIGHT;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.WEST) {
if (info.getLeft() == Neighbor.OTHER ||
info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL) {
if (info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.LEFT;
}
return Action.RIGHT;
}
case 1:
if (info.getFront() == Neighbor.OTHER) {
return Action.INFECT;
}
if (info.getDirection() == Direction.EAST) {
if ((info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.LEFT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.RIGHT;
}
if (info.getDirection() == Direction.SOUTH) {
if ((info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.RIGHT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.WEST) {
if (info.getRight() == Neighbor.OTHER ||
info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
if (info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.RIGHT;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.NORTH) {
if (info.getLeft() == Neighbor.OTHER ||
info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL) {
if (info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.LEFT;
}
return Action.RIGHT;
}
case 2:
if (info.getFront() == Neighbor.OTHER) {
return Action.INFECT;
}
if (info.getDirection() == Direction.SOUTH) {
if ((info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.LEFT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.RIGHT;
}
if (info.getDirection() == Direction.WEST) {
if ((info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.RIGHT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.NORTH) {
if (info.getRight() == Neighbor.OTHER ||
info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
if (info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.RIGHT;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.EAST) {
if (info.getLeft() == Neighbor.OTHER ||
info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL) {
if (info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.LEFT;
}
return Action.RIGHT;
}
case 3:
if (info.getFront() == Neighbor.OTHER) {
return Action.INFECT;
}
if (info.getDirection() == Direction.WEST) {
if ((info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.LEFT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.RIGHT;
}
if (info.getDirection() == Direction.NORTH) {
if ((info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) && (info.getFront() == Neighbor.SAME ||
info.getFront() == Neighbor.WALL)) {
return Action.RIGHT;
}
if (info.getFront() == Neighbor.EMPTY) {
return Action.HOP;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.EAST) {
if (info.getRight() == Neighbor.OTHER ||
info.getLeft() == Neighbor.SAME || info.getLeft() == Neighbor.WALL) {
if (info.getRight() == Neighbor.SAME ||
info.getRight() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.RIGHT;
}
return Action.LEFT;
}
if (info.getDirection() == Direction.SOUTH) {
if (info.getLeft() == Neighbor.OTHER ||
info.getRight() == Neighbor.SAME || info.getRight() == Neighbor.WALL) {
if (info.getLeft() == Neighbor.SAME ||
info.getLeft() == Neighbor.WALL) {
return Action.INFECT;
}
return Action.LEFT;
}
return Action.RIGHT;
}
}
return Action.HOP;
}
}


