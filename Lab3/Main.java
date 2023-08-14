public class Main {
    public static void main(String[] args) {
        // Create two strings
        String text1 = "Hello";
        String text2 = "World";
        
        // Create LetterInventory instances using the input strings
        LetterInventory inventory1 = new LetterInventory(text1);
        LetterInventory inventory2 = new LetterInventory(text2);
        
        // Print inventory information
        System.out.println("Inventory 1: " + inventory1);
        System.out.println("Inventory 2: " + inventory2);
        
        // Print sizes of the inventories
        System.out.println("Size of Inventory 1: " + inventory1.size());
        System.out.println("Size of Inventory 2: " + inventory2.size());
        
        // Check if inventories are empty
        System.out.println("Is Inventory 1 empty? " + inventory1.isEmpty());
        System.out.println("Is Inventory 2 empty? " + inventory2.isEmpty());
        
        // Choose a letter to get its count from Inventory 1
        char letter = 'o';
        System.out.println("Count of " + letter + " in Inventory 1: " + inventory1.get(letter));
        
        // Update the count of a letter in Inventory 1
        int newValue = 3;
        inventory1.set('e', newValue);
        System.out.println("Updated Inventory 1: " + inventory1);
        
        // Add two inventories together
        LetterInventory sumInventory = inventory1.add(inventory2);
        System.out.println("Sum of Inventory 1 and Inventory 2: " + sumInventory);
        
        // Subtract one inventory from another
        LetterInventory subtractedInventory = inventory1.subtract(inventory2);
        System.out.println("Inventory 1 minus Inventory 2: " + subtractedInventory);
    }
}
