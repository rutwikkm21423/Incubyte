package main.java;

import java.util.*;

/**
 * Represents a library system where users can add, borrow, return,
 * and view available books through a menu-driven interface.
 */
public class Library {
    // A map to store books, with the key as the ISBN and the value as the Book object
    private Map<String, Book> books = new HashMap<>();

    /**
     * Adds a new book to the library.
     *
     * @param isbn   The ISBN of the book (must be unique)
     * @param title  The title of the book
     * @param author The author of the book
     * @param year   The publication year of the book
     */
    public void addBook(String isbn, String title, String author, int year) {
        // Only add the book if it doesn't already exist in the library
        if (!books.containsKey(isbn)) {
            books.put(isbn, new Book(isbn, title, author, year, true));
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book with ISBN " + isbn + " already exists!");
        }
    }

    /**
     * Allows a user to borrow a book from the library if it's available.
     *
     * @param isbn The ISBN of the book to be borrowed
     * @throws IllegalStateException if the book is not available or doesn't exist
     */
    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        // Check if the book exists and is available for borrowing
        if (book != null && book.isAvailable()) {
            book.setAvailable(false); // Mark the book as borrowed
            System.out.println("You have successfully borrowed: " + book.getTitle());
        } else {
            throw new IllegalStateException("Book not available");
        }
    }

    /**
     * Allows a user to return a previously borrowed book.
     *
     * @param isbn The ISBN of the book to be returned
     */
    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        // Check if the book exists and is currently borrowed
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true); // Mark the book as available again
            System.out.println("You have successfully returned: " + book.getTitle());
        } else {
            System.out.println("This book is either already available or doesn't exist!");
        }
    }

    /**
     * Retrieves a list of all available books in the library.
     *
     * @return A list of books that are available for borrowing
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        // Loop through all the books and collect the ones that are available
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    /**
     * Displays a list of available books in the library.
     */
    public void displayAvailableBooks() {
        List<Book> availableBooks = getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books are currently available.");
        } else {
            System.out.println("Available Books:");
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }
    }

    /**
     * Main menu that allows users to interact with the library system.
     */
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Read user's choice
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Perform actions based on user input
            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    library.addBook(isbn, title, author, year);
                    break;

                case 2:
                    // Borrow a book
                    System.out.print("Enter ISBN of the book to borrow: ");
                    isbn = scanner.nextLine();
                    library.borrowBook(isbn);
                    break;

                case 3:
                    // Return a book
                    System.out.print("Enter ISBN of the book to return: ");
                    isbn = scanner.nextLine();
                    library.returnBook(isbn);
                    break;

                case 4:
                    // View available books
                    library.displayAvailableBooks();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the library system. Goodbye!");
                    break;

                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5); // Continue until the user chooses to exit

        scanner.close(); // Close the scanner resource
    }
}
