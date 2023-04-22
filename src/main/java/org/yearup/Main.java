package org.yearup;

import java.util.Scanner;

public class Main
{

    static Scanner scanner =  new Scanner(System.in);

    static Book[] books = new Book[50];

    static int counter = 0;


    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("Hello! Welcome to");

        createInventory();

        while (true)
        {
            int selection = displayHomeScreen();

            if (selection == 1)
            {
                displayAvailableBooks();
            }
            else if (selection == 2)
            {
                displayCheckedOutBooks();
            }
            else if (selection == 3)
            {
                System.out.println();
                System.out.println("Thank you! See you next time!");
                break;
            }
            else
            {
                System.out.println();
                System.out.println("You selected an invalid option.");
            }

            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------");
        }

    }


    // create the books array
    private static void createInventory()
    {
        books[0] = new Book(1, "99921-58-10-7", "East of Eden", false, "");
        books[1] = new Book(2, "960-425-059-0", "Harry Potter", false, "");
        books[2] = new Book(3, "9971-5-0210-0", "The Sun Also Rises", false, "");
        books[3] = new Book(4, "80-902734-1-6", "Twilight", false, "");
        books[4] = new Book(5, "85-359-0277-5", "Burned Alive", false, "");
        books[5] = new Book(6, "1-84356-028-3", "Rich Dad Poor Dad", false, "");
        books[6] = new Book(7, "0-684-84328-5", "Pride and Prejudice and Zombies", false, "");
        books[7] = new Book(8, "0-9752298-0-X", "And Then There Were None", false, "");
        counter = 7;

    }


    // show store home screen and get user input
    public static int displayHomeScreen()
    {
        System.out.println();
        System.out.println("Neighborhood Library\n");
        System.out.println("Home");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("What you would like to do?");
        System.out.println("1. List all available books");
        System.out.println("2. List all checked out books");
        System.out.println("3. Exit");
        System.out.print("Please enter your option: ");
        int selection = scanner.nextInt();
        scanner.nextLine();

        return selection;
    }


    // show available books
    public static void displayAvailableBooks()
    {
        System.out.println();
        System.out.println("Available Books");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("ID        ISBN                  Title                                ");

        for(int i = 0; i <= counter; i++)
        {
            Book book = books[i];

            if (!book.isCheckedOut())
            {
                displayBook(book);
            }
        }


        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Please select the follow options");
        System.out.println("C - To Check Out a book");
        System.out.println("X - To go back to the Home screen");
        System.out.print("Enter your selection: ");
        String option = scanner.nextLine().strip();

        if(option.equalsIgnoreCase("c") || option.equalsIgnoreCase("C"))
        {
            displayCheckOutBook();
        }
        else if (option.equalsIgnoreCase("X") || option.equalsIgnoreCase("x"))
        {
            displayHomeScreen();
        }
    }


    // show checked out books
    public static void displayCheckedOutBooks()
    {
        System.out.println();
        System.out.println("Checked Out Books");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("ID        ISBN                  Title                                  Who checked out?");


        for(int i = 0; i <= counter; i++)
        {
            Book book = books[i];

            if (book.isCheckedOut())
            {
                displayBook(book);
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Please select the follow options");
        System.out.println("C - To Check In a book");
        System.out.println("X - To go back to the Home screen");
        System.out.print("Enter your selection: ");
        String option = scanner.nextLine().strip();

        if(option.equalsIgnoreCase("C") || option.equalsIgnoreCase("c"))
        {
            displayCheckInBook();
        }
        else if (option.equalsIgnoreCase("X") || option.equalsIgnoreCase("x"))
        {
            displayHomeScreen();
        }

    }


    // check out a book
    public static void displayCheckOutBook()
    {

        System.out.println();
        System.out.print("What is your name? ");
        String name = scanner.nextLine().strip();

        System.out.print("Please select the book ID you want to check out: ");
        int input = scanner.nextInt();

        books[input - 1].checkOut(name);

        System.out.println("Check out completed.");
    }


    // check in a book
    public static void displayCheckInBook()
    {
        System.out.println();
        System.out.print("Enter the book's ID to check in: ");
        int input = scanner.nextInt();

        books[input - 1].checkIn();

        System.out.println("Check in completed.");
    }


    // display books
    public static void displayBook(Book book)
    {
        System.out.println();
        System.out.printf("%-5d %-20s %-35s %15s\n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
    }
}