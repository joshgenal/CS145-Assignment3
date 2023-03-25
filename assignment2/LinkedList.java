/*
Joshua Genal
CS145 Assignment 2: Phone book
LinkedList
Winter 2023
*/
package assignment2;

import java.util.List;
import static java.lang.String.format;

public class LinkedList 
{
    private ListNode head;
    private ListNode tail;
    private int length;

    public LinkedList() 
    {
        head = null;
        length = 0;
    }

    public void add(String firstName, String lastName, String phone, String address, String city) 
    {
        ListNode current = head;
        ListNode newNode = new ListNode(new ListNode.Contact(firstName, lastName, phone, address, city));

        if (isEmpty()) 
        {
            head = newNode;
            tail = newNode;
            length++;
        } 
        else 
        {
            ListNode previous = null;
            while (current != null && current.data.getLastName().compareToIgnoreCase(newNode.data.getLastName()) < 0) 
            {
                previous = current;
                current = current.getNext();
            }

            if (previous == null) 
            {
                newNode.setNext(head);
                head = newNode;
            } 
            else if (current == null) 
            {
                previous.setNext(newNode);
                tail = newNode;
            } 
            else 
            {
                previous.setNext(newNode);
                newNode.setNext(current);
            }
            length++;
        }
    }

    public void delete(String name) 
    {
        ListNode current = head;
        ListNode previous = null;
        boolean found = false;

        if (isEmpty()) 
        {
            System.out.println("The list is empty!");
        } 
        else 
        {
            while (current != null) 
            {
                if (current.data.getFullName().equals(name)) 
                {
                    found = true;
                    break;
                }
                previous = current;
                current = current.getNext();
            }

            if (found) 
            {
                if (previous == null) 
                {
                    head = head.getNext();
                } 
                else if (current == tail) 
                {
                    tail = previous;
                    tail.setNext(null);
                } 
                else 
                {
                    previous.setNext(current.getNext());
                }
                length--;
                System.out.printf("Successfully deleted Contact: %s\n", name);
            } 
            else 
            {
                System.out.println("Contact does not exist!");
            }
        }
    }

    public void modifyLast(String originalFullName, String newName) 
    {
        ListNode current = head;
        boolean found = false;

        if (isEmpty()) 
        {
            System.out.println("The list is empty!");
        } 
        else 
        {
            while (current != null) 
            {
                if (current.data.getFullName().equals(originalFullName)) 
                {
                    current.data.setLastName(newName);
                    System.out.println("Updated Contact Information: ");
                    System.out.print(current.toString());
                    found = true;
                    break;
                }
                current = current.getNext();
            }

            if (!found) 
            {
                System.out.println("The name you entered did not a match a contact");
            }
        }
    }
    public void modifyPhone(String originalPhone, String newPhone) 
    {
        ListNode current = head;
        boolean found = false;

        if (isEmpty()) 
        {
            System.out.println("The list is empty!");
        } 
        else 
        {
            while (current != null) 
            {
                if (current.data.getPhone().equals(originalPhone)) 
                {
                    current.data.setPhone(newPhone);
                    System.out.println("Updated Contact Information: ");
                    System.out.print(current.toString());
                    found = true;
                    break;
                }
                current = current.getNext();
            }

            if (!found) 
            {
                System.out.println("The number you entered did not a match a contact");
            }
        }
    }

    public void modifyAddress(String fullName, String newAddress, String newCity) 
    {
    ListNode current = head;
    boolean found = false;

    if (isEmpty()) 
    {
        System.out.println("The list is empty!");
    } 
    else 
    {
        while (current != null) 
        {
            if (current.data.getFullName().equals(fullName)) 
            {
                current.data.setAddress(newAddress);
                current.data.setCity(newCity);
                System.out.println("Updated Contact Information: ");
                System.out.print(current.toString());
                found = true;
                break;
            }
            current = current.getNext();
        }

        if (!found) 
        {
            System.out.println("The name you entered did not match a contact");
        }
    }
} 


    public void searchByFullName(String name) 
    {
    ListNode current = head;
    boolean found = false;

    if (isEmpty()) 
    {
        System.out.println("The list is empty!");
    } 
    else 
    {
        int index = 0;
        while (current != null) 
        {
            String currentName = current.data.getFullName().toLowerCase();
            if (currentName.contains(name.toLowerCase())) 
            {
                System.out.printf("Index = %s\n", (index + 1));
                System.out.println(current.toString());
                found = true;
            }
            current = current.getNext();
            index++;
        }

        if (!found) 
        {
            System.out.printf("No matches for name: %s", name);
        }
    }
} 

    public void searchByPhone(String phone) 
    {
    ListNode current = head;
    boolean found = false;

    if (isEmpty()) 
    {
        System.out.println("The list is empty!");
    } 
    else 
    {
        int index = 0;
        while (current != null) 
        {
            String currentPhone = current.data.getPhone();
            if (currentPhone.equals(phone)) 
            {
                System.out.printf("Index = %s\n", (index + 1));
                System.out.println(current.toString());
                found = true;
            }
            current = current.getNext();
            index++;
        }

        if (!found) 
        {
            System.out.printf("No matches found for phone number: %s\n", phone);
        }
    }
} 


    public boolean isEmpty() 
    {
        return (length == 0);
    }

    public int size() 
    {
        return length;
    }

    public void printList() 
    {
    ListNode tempNode = head;
    if (head == null) 
    {
        System.out.println("The list is empty!");
    } 
    else 
    {
        int index = 0;
        while (tempNode != null) 
        {
            System.out.printf("Index = %s\n", (index + 1));
            System.out.print(tempNode.data.toString());
            tempNode = tempNode.getNext();
            index++;
        }
    }
} 


    @Override
   public String toString() 
   {
    ListNode temp = head;
    StringBuilder contacts = new StringBuilder();
    int index = 0;
    while (temp != null) 
    {
        contacts.append(String.format("Index = %s\n%s\n", (index + 1), temp.data.toString()));
        temp = temp.getNext();
        index++;
    }
    return contacts.toString();
} 


}
