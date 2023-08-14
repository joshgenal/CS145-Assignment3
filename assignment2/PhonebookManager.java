/*
Joshua Genal
CS145 Assignment 2: Phone book
PhonebookManager

This class manages the phonebook functionality. It allows adding, deleting, and printing contacts
in the phonebook using a linked list. It also contains the inner class ContactInfo that represents
the contact information.

last updated 07/18/2023
*/

public class PhonebookManager {
    private ListNode head; // Reference to the head of the linked list

    // Constructor to initialize the phonebook
    public PhonebookManager() {
        this.head = null;
    }

    // Method to add a contact to the phonebook
    public void addContact(ContactInfo contact) {
        ListNode newNode = new ListNode(contact);
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
        } else {
            ListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext(); // Traverse to the last node
            }
            current.setNext(newNode); // Add the new node at the end of the list
        }
        System.out.println("Contact added successfully!");
    }

    // Method to add a contact at a specific index in the phonebook
    public void addContactAtIndex(int index, ContactInfo contact) {
        // Check if the index is valid
        if (index < 0 || index > getSize()) {
            System.out.println("Invalid index. Contact not added.");
            return;
        }
        ListNode newNode = new ListNode(contact);
        if (index == 0) {
            newNode.setNext(head); // If the index is 0, insert at the beginning
            head = newNode;
        } else {
            ListNode current = head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.getNext(); // Traverse to the node before the given index
                currentIndex++;
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode); // Insert the new node at the specified index
        }
        System.out.println("Contact added successfully at index " + index + "!");
    }

    // Method to delete a contact at a specific index in the phonebook
    public void deleteContactAtIndex(int index) {
        // Check if the index is valid
        if (index < 0 || index >= getSize()) {
            System.out.println("Invalid index. Contact not deleted.");
            return;
        }
        if (index == 0) {
            ListNode deletedNode = head;
            head = head.getNext(); // If the index is 0, delete the head node
            deletedNode.setNext(null);
        } else {
            ListNode current = head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.getNext(); // Traverse to the node before the given index
                currentIndex++;
            }
            ListNode deletedNode = current.getNext();
            current.setNext(deletedNode.getNext()); // Remove the node at the specified index
            deletedNode.setNext(null);
        }
        System.out.println("Contact deleted successfully from index " + index + "!");
    }

    // Method to print the phonebook
    public void printPhonebook() {
        if (head == null) {
            System.out.println("Phonebook is empty!");
        } else {
            ListNode current = head;
            int index = 0;
            while (current != null) {
                System.out.println("Index: " + index);
                System.out.println(current.toString());
                current = current.getNext(); // Traverse through the list and print each node
                index++;
            }
        }
    }

    // Method to get the size of the phonebook
    public int getSize() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++; // Traverse through the list and count the nodes
            current = current.getNext();
        }
        return count;
    }

    // Class representing the contact information
    public static class ContactInfo {
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private String city;

        // Constructor to initialize the contact information
        public ContactInfo(String firstName, String lastName, String phone,
                   String address, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
            this.city = city;
        }

        // Getters and setters for the contact fields

        // Method to represent the contact information as a string
        @Override
        public String toString() {
            return "Contact: " + firstName + " " + lastName + "\n"
                    + "Phone Number: " + phone + "\n"
                    + "Address: " + address + "\n"
                    + "City: " + city + "\n";
        }
    }
}
