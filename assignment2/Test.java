/*
Joshua Genal
CS145 Assignment 2: Phone book
Test

This class provides a user interface to interact with the phonebook. It displays a menu and allows
the user to add contacts, add contacts at a specific index, delete contacts at a specific index, 
print the phonebook, and quit the program.

last updated 07/18/2023
*/

//menu version

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        PhonebookManager phonebookManager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Phonebook Menu");
            System.out.println("1. Add a contact");
            //my solution for the beggining(0), middle((n-1)/2), end(n-1) criteria
            System.out.println("2. Add a contact at index");
            System.out.println("3. Delete a contact at index");
            System.out.println("4. Print phonebook");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();

                    PhonebookManager.ContactInfo contact = new PhonebookManager.ContactInfo(
                           firstName, lastName, phone, address, city);
                    phonebookManager.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter first name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    phone = scanner.nextLine();
                    System.out.print("Enter address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    city = scanner.nextLine();

                    contact = new PhonebookManager.ContactInfo(firstName, lastName, phone, address
                           , city);
                    phonebookManager.addContactAtIndex(index, contact);
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    index = scanner.nextInt();
                    scanner.nextLine();
                    phonebookManager.deleteContactAtIndex(index);
                    break;
                case 4:
                    phonebookManager.printPhonebook();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the phonebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }
}





/* old version (

public class Test {
    public static void main(String[] args) {
        PhonebookManager phonebookManager = new PhonebookManager();

        // Add sample contacts
        phonebookManager.addContactAtEnd("first", "last", "phone#", "streetaddress", "city");
        phonebookManager.addContactAtBeginning("first", "last", "phone#", "streetaddress", "city");
        phonebookManager.addContactAtMiddle(""first", "last", "phone#", "streetaddress", "city");

        // Print the phonebook
        phonebookManager.printPhonebook();

        // Modify a contact
        phonebookManager.modifyContact("first", "last", "phone#", "streetaddress", "city");

        // Print the phonebook again to see the changes
        phonebookManager.printPhonebook();

        // Delete a contact
        phonebookManager.deleteContact("first", "last");

        // Print the phonebook again to see the changes
        phonebookManager.printPhonebook();
    }
} */
