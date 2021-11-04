package crabster.rudakov.sberschoollesson28hwk.domain;

import java.util.List;

import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;

public interface BooksRepository {

    void addBook();

    List<Book> books();

}
