package org.yearup;

import java.util.Scanner;

public class Main
{

    static Scanner scanner =  new Scanner(System.in);

    static Book[] books = new Book[50];

    static int counter = 0;

    public static void main(String[] args)
    {
        System.out.println("Hello!");

        createInventory();



    }


    // create the books array
    private static void createInventory()
    {
        books[0] = new Book(1, "99921-58-10-7", "East of Eden", false, "");
        books[1] = new Book(2, "960-425-059-0", "I Know Why The Caged Bird Sings", false, "");
        books[2] = new Book(3, "9971-5-0210-0", "The Sun Also Rises", false, "");
        books[3] = new Book(4, "80-902734-1-6", "Do Androids Dream of Electric Sheep?", false, "");
        books[4] = new Book(5, "85-359-0277-5", "The Curious Incident of the Dog in the Night-Time", false, "");
        books[5] = new Book(6, "1-84356-028-3", "Cloudy with a Chance of Meatballs", false, "");
        books[6] = new Book(7, "0-684-84328-5", "Pride and Prejudice and Zombies", false, "");
        books[7] = new Book(8, "0-9752298-0-X", "And Then There Were None", false, "");
        counter = 7;

    }


    // show store home screen and get user input
    public static int displayHomeScreen()
    {
        System.out.println();
        System.out.println("Neighborhood Library");
        System.out.println("Home");
        System.out.println("----------------------------------------------------------------");
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
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        for(int i = 0; i <= counter; i++)
        {
            Book book = books[i];

            if (book.isCheckedOut())
            {
                displayBook(book);
            }
        }

    }


    // show checked out books
    public static void displayCheckedOutBooks()
    {
        System.out.println();
        System.out.println("Checked Out Books");
        System.out.println("----------------------------------------------------------------");
        System.out.println();

    }


    // check in a book
    public static void displayCheckInBook()
    {

    }


    // display books
    public static void displayBook(Book book)
    {
        System.out.println();
        System.out.printf("%-5d %-20s %-35s %-5s %s", book.getId(), book.getIsbn(), book.getTitle(), book.isCheckedOut(), book.getCheckedOutTo());
    }
}