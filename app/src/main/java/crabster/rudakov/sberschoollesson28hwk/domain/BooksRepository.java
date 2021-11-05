package crabster.rudakov.sberschoollesson28hwk.domain;

import java.util.List;

import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;

public interface BooksRepository {

    void addBook(String isbn, String title, String author, int shelfNumber);

    List<Book> books();

    void deleteBooks();

}