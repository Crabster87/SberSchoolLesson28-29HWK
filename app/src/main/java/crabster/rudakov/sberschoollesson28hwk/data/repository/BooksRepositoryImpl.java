package crabster.rudakov.sberschoollesson28hwk.data.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.*;

import crabster.rudakov.sberschoollesson28hwk.data.database.BookDbHelper;
import crabster.rudakov.sberschoollesson28hwk.data.entity.BooksDbContract;
import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;
import crabster.rudakov.sberschoollesson28hwk.domain.BooksRepository;

public class BooksRepositoryImpl implements BooksRepository {

    private final BookDbHelper mHelper;

    public BooksRepositoryImpl(BookDbHelper mHelper) {
        this.mHelper = mHelper;
    }

    @Override
    public void addBook() {
        SQLiteDatabase sqLiteDatabase = mHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BooksDbContract.BooksEntry.ISBN, "978-3-16-148410-0");
        values.put(BooksDbContract.BooksEntry.TITLE, "Our life is a pain");
        values.put(BooksDbContract.BooksEntry.AUTHOR, "John Doe");
        values.put(BooksDbContract.BooksEntry.SHELF_NUMBER, 13);

        sqLiteDatabase.insert(BooksDbContract.DB_TABLE_NAME, null, values);
    }

    @Override
    public List<Book> books() {
        String[] columns = {
                BooksDbContract.BooksEntry._ID,
                BooksDbContract.BooksEntry.ISBN,
                BooksDbContract.BooksEntry.TITLE,
                BooksDbContract.BooksEntry.AUTHOR,
                BooksDbContract.BooksEntry.SHELF_NUMBER
        };
        SQLiteDatabase sqLiteDatabase = mHelper.getReadableDatabase();

        List<Book> books = new ArrayList<>();
        try (Cursor cursor = sqLiteDatabase.query(
                BooksDbContract.DB_TABLE_NAME, columns, null, null, null, null, null)){
            while (cursor.moveToNext()) {
                books.add(new Book(
                        cursor.getLong(cursor.getColumnIndexOrThrow(BooksDbContract.BooksEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BooksDbContract.BooksEntry.ISBN)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BooksDbContract.BooksEntry.TITLE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(BooksDbContract.BooksEntry.AUTHOR)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(BooksDbContract.BooksEntry.SHELF_NUMBER))));
            }
        }
        return books;
    }

}