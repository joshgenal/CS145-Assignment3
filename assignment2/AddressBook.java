/*
Joshua Genal
CS145 Assignment 2: Phone book
AddressBook
Winter 2023
*/
package assignment2;

import java.util.Scanner;

public class AddressBook 
{
    private Scanner input = new Scanner(System.in);
    private boolean run = true;
    private LinkedList list = new LinkedList();

    public AddressBook() 
    {
        do 
        {
        run = runProgram();
        } 
        while(run);
    }

    public void save() 
    {
        System.out.println("Create a new contact: ");
        System.out.print("Name: ");
        String[] name = input.nextLine().split(" ");
        if (name.length < 2) 
        {
            System.out.println("Please enter a valid first and last name separated by a space.");
            return;
        }
        String firstName = name[0];
        String lastName = name[1];
        System.out.println("Please Input Phone number in format: 555-555-5555");
        System.out.print("Phone Number: ");
        String phone = input.nextLine();
        System.out.print("Address (Street and Number): ");
        String address = input.nextLine();
        System.out.print("City: ");
        String city = input.nextLine();
        System.out.println("");
        list.add(firstName, lastName, phone, address, city);
        System.out.println("Your contact has been added successfully!");
        System.out.println("");
    }
public void search() 
{
        System.out.println("Search by full name or phone number: ");
        String query = input.nextLine();
        LinkedList.Node result = list.searchByFullName(query);
                if (result == null) 
                {
            result = list.searchByPhone(query);
        }
        if (result != null) 
        {
            System.out.println("Contact found: ");
            System.out.println(result.getData().toString());
        } 
        else 
        {
            System.out.println("No contact found.");
        }
    }

   public void delete() 
   {
        System.out.println("Enter the full name of the contact you want to delete: ");
        String nameToDelete = input.nextLine(); 
        boolean deleted = list.delete(nameToDelete);
                if (deleted) 
                {
            System.out.println("Contact deleted successfully.");
        } 
        else 
        {
            System.out.println("No contact found with the given full name.");
        }
    }

   public void modify() 
   {
        System.out.println("Enter the full name of the contact you want to modify: ");
        String fullName = input.nextLine();
        LinkedList.Node node = list.searchByFullName(fullName);
        if (node != null) 
        {
            System.out.println("Enter the new information for the contact (leave blank to keep the current value):");
            System.out.print("New phone number: ");
            String newPhone = input.nextLine();
            System.out.print("New address: ");
            String newAddress = input.nextLine();
            System.out.print("New city: ");
            String newCity = input.nextLine();
            list.modifyAddress(node, newPhone, newAddress, newCity);
            System.out.println("Contact updated successfully.");
        } 
        else 
        {
            System.out.println("No contact found with the given full name.");
        }
    }

    public void view() 
    {
        System.out.println("All contacts:");
        list.printList();
    }
    
   public boolean runProgram() 
   {
    menu();
    System.out.print("Input a command: ");
    MenuOption response = getMenuOption();
    System.out.println("");
    switch (response) 
    {
        case SAVE:
            save();
            break;
        case SEARCH:
            search();
            break;
        case DELETE:
            delete();
            break;
        case MODIFY:
            modify();
            break;
        case VIEW:
            view();
            break;
        case QUIT:
            run = false;
            break;
        default:
            break;
    }
    return run;
}

    private MenuOption getMenuOption() 
    {
        String inputString = input.nextLine();
        if (inputString.length() > 0) 
        {
            char inputChar = inputString.charAt(0);
            switch (inputChar) 
            {
                case '1': return MenuOption.SAVE;
                case '2': return MenuOption.SEARCH;
                case '3': return MenuOption.DELETE;
                case '4': return MenuOption.MODIFY;
                case '5': return MenuOption.VIEW;
                case '6': return MenuOption.QUIT;
            }
        }
        return MenuOption.INVALID;
    }

    public void menu() 
    {
        System.out.printf("(1) Save New Contact%n(2) Look for someone%n(3) Delete%n(4) Modify%n(5) View All%n(6) Quit Program");
    }

    public static void main(String[] args) 
    {
        new AddressBook();
    }
}

enum MenuOption 
{
    SAVE, SEARCH, DELETE, MODIFY, VIEW, QUIT, INVALID
}
