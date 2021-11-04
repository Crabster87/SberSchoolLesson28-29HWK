package crabster.rudakov.sberschoollesson28hwk.domain;

import java.util.List;

import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;

public class BooksInteractor {

    private final BooksRepository mRepository;

    public BooksInteractor(BooksRepository repository) {
        mRepository = repository;
    }

    public List<Book> getBooks() {
        mRepository.addBook();
        return mRepository.books();
    }

}