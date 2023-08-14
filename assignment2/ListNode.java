/*
Joshua Genal
CS145 Assignment 2: Phone book
ListNode

This class represents a node in a linked list. It contains the data (contact information) and a
reference to the next node.

last updated 07/18/2023
*/

package assignment2;

public class ListNode {
    private PhonebookManager.ContactInfo data; // Data stored in the node
    private ListNode next; // Reference to the next node

    // Constructor to initialize the node with data
    public ListNode(PhonebookManager.ContactInfo data) {
        this.data = data;
        this.next = null;
    }

    // Constructor to initialize the node with data and next node
    public ListNode(PhonebookManager.ContactInfo data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    // Setter for node data
    public void setData(PhonebookManager.ContactInfo data) {
        this.data = data;
    }

    // Setter for next node
    public void setNext(ListNode next) {
        this.next = next;
    }

    // Getter for node data
    public PhonebookManager.ContactInfo getData() {
        return data;
    }

    // Getter for next node
    public ListNode getNext() {
        return next;
    }

    // Method to represent the node as a string
    @Override
    public String toString() {
        return data.toString();
    }
}
