package crabster.rudakov.sberschoollesson28hwk.data.room.repository;

import java.util.List;
import java.util.ArrayList;

import crabster.rudakov.sberschoollesson28hwk.data.room.entity.RoomBooksDbContract;
import crabster.rudakov.sberschoollesson28hwk.data.room.entity.RoomBook;
import crabster.rudakov.sberschoollesson28hwk.domain.BooksRepository;
import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;

public class RoomBooksRepositoryImpl implements BooksRepository {

    private final RoomBooksDbContract mRoomBooksDbContract;

    public RoomBooksRepositoryImpl(RoomBooksDbContract mRoomBooksDbContract) {
        this.mRoomBooksDbContract = mRoomBooksDbContract;
    }

    private Book convert(RoomBook roomBook) {
        return new Book(roomBook.bookId, roomBook.isbn, roomBook.title, roomBook.author, roomBook.shelfNumber);
    }

    @Override
    public void addBook(String isbn, String title, String author, int shelfNumber) {
        RoomBook book = new RoomBook(isbn, title, author, shelfNumber);
        mRoomBooksDbContract.roomBookDao().addBook(book);
    }

    @Override
    public List<Book> books() {
        List<RoomBook> roomBooks = mRoomBooksDbContract.roomBookDao().getBooks();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < roomBooks.size(); i++) {
            books.add(convert(roomBooks.get(i)));
        }
        return books;
    }

    @Override
    public void deleteBooks() {
        mRoomBooksDbContract.roomBookDao().deleteBooks();
        mRoomBooksDbContract.roomBookDao().resetPrimaryKey();
    }

}
