package crabster.rudakov.sberschoollesson28hwk.domain.model;

public class Book {

    public final long bookId;
    public final String isbn;
    public final String title;
    public final String author;
    public final int shelfNumber;

    public Book(long bookId, String isbn, String title, String author, int shelfNumber) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.shelfNumber = shelfNumber;
    }

}