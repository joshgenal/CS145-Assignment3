/*
Joshua Genal
CS &145
Lab 3: Letter Inventory
last edited: 08/14/2023
Function: This LetterInventory class stores letter counts in a string, and performs
operations like add,
subtract on counts. */

public class LetterInventory {
private static final int ALPHABET_COUNT = 26;
private int[] letterCounts;
private int size;
// Constructor that computes and stores letter counts in the input string
public LetterInventory(String data) {
letterCounts = new int[ALPHABET_COUNT];
data = data.toLowerCase();
for (char letter : data.toCharArray()) {
if (Character.isLetter(letter)) {
letterCounts[letter - 'a']++;
size++;
}
}
}
// Returns count of a letter in inventory. Ignores case. Throws exception for
non-letters
public int get(char letter) {
letter = Character.toLowerCase(letter);
if (!Character.isLetter(letter)) {
throw new IllegalArgumentException("Input character is not a letter.");
}
return letterCounts[letter - 'a'];
}
// Sets count of a letter to a value. Ignores case. Throws exception for non-
letters or
// negative values
public void set(char letter, int value) {
letter = Character.toLowerCase(letter);
if (!Character.isLetter(letter) || value < 0) {
throw new IllegalArgumentException("Invalid letter or value.");
}
size -= letterCounts[letter - 'a']; // deduct old count from size
letterCounts[letter - 'a'] = value;
size += value; // add new value to size
}
// Returns total count of letters in the inventory
public int size() {
return size;
}
// Checks if inventory is empty
public boolean isEmpty() {
return size == 0;
}
// Returns a string representation of the inventory
public String toString() {
StringBuilder sb = new StringBuilder("[");
for (int i = 0; i < ALPHABET_COUNT; i++) {
for (int j = 0; j < letterCounts[i]; j++) {
sb.append((char) ('a' + i));
}
}
sb.append("]");
return sb.toString();
}
// Adds two inventories together and returns a new LetterInventory
public LetterInventory add(LetterInventory other) {
StringBuilder sb = new StringBuilder();
for (int i = 0; i < ALPHABET_COUNT; i++) {
int count = this.letterCounts[i] + other.letterCounts[i];
for (int j = 0; j < count; j++) {
sb.append((char) ('a' + i));
}
}
return new LetterInventory(sb.toString());
}
// Subtracts another inventory from this one. Returns a new LetterInventory or
null if any
// count is negative
public LetterInventory subtract(LetterInventory other) {
StringBuilder sb = new StringBuilder();
for (int i = 0; i < ALPHABET_COUNT; i++) {
int count = this.letterCounts[i] - other.letterCounts[i];
if (count < 0) {
return null;
}
for (int j = 0; j < count; j++) {
sb.append((char) ('a' + i));
}
}
return new LetterInventory(sb.toString());
}
}
