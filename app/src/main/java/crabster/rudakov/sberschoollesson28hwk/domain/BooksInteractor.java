package crabster.rudakov.sberschoollesson28hwk.domain;

import java.util.*;

import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;

public class BooksInteractor {

    private final BooksRepository mRepository;

    public BooksInteractor(BooksRepository repository) {
        mRepository = repository;
    }

    public void addSingleBook() {
        mRepository.addBook("978-3-16-148410-0", "Our life is a pain", "John Doe", 13);
    }

    public List<Book> getBooks() {
        return mRepository.books();
    }

    public void deleteAllBooks() {
        mRepository.deleteBooks();
    }

}