package main.java;

/**
 * Represents a book in the library with its ISBN, title, author, publication year,
 * and availability status.
 */
public class Book {
    // The unique identifier for the book (e.g., ISBN)
    private String isbn;

    // The title of the book
    private String title;

    // The author of the book
    private String author;

    // The publication year of the book
    private int publicationYear;

    // A flag indicating whether the book is available for borrowing
    private boolean available;

    /**
     * Constructor to create a new book object with the specified details.
     *
     * @param isbn The ISBN of the book
     * @param title The title of the book
     * @param author The author of the book
     * @param year The publication year of the book
     * @param available Whether the book is available for borrowing
     */
    public Book(String isbn, String title, String author, int year, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = year;
        this.available = available;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the publication year of the book.
     *
     * @return The publication year of the book
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Returns whether the book is available for borrowing.
     *
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability of the book.
     *
     * @param available true if the book is to be marked as available, false otherwise
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
