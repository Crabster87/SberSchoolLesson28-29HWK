package crabster.rudakov.sberschoollesson28hwk.data.sqlite.entity;

import android.provider.BaseColumns;

public interface BooksDbContract {

    String DB_FILE_NAME = "books.db";
    String DB_TABLE_NAME = "books";
    int DB_VERSION = 1;

    interface BooksEntry extends BaseColumns {
        String ISBN = "ISBN";
        String TITLE = "TITLE";
        String AUTHOR = "AUTHOR";
        String SHELF_NUMBER = "SHELF_NUMBER";
    }

}