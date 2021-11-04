package crabster.rudakov.sberschoollesson28hwk.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import crabster.rudakov.sberschoollesson28hwk.data.entity.BooksDbContract;

public class BookDbHelper extends SQLiteOpenHelper {

    public BookDbHelper(@Nullable Context context) {
        super(context, BooksDbContract.DB_FILE_NAME, null, BooksDbContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryString = String.format("CREATE TABLE %s (%s integer PRIMARY KEY autoincrement, %s text, %s text, %s text, %s integer)",
                BooksDbContract.DB_TABLE_NAME,
                BooksDbContract.BooksEntry._ID,
                BooksDbContract.BooksEntry.ISBN,
                BooksDbContract.BooksEntry.TITLE,
                BooksDbContract.BooksEntry.AUTHOR,
                BooksDbContract.BooksEntry.SHELF_NUMBER);

        sqLiteDatabase.execSQL(queryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            String queryString = String.format("ALTER TABLE %s ADD COLUMN %s text",
                    BooksDbContract.DB_TABLE_NAME,
                    BooksDbContract.BooksEntry.AUTHOR);
            sqLiteDatabase.execSQL(queryString);
        }
        if (oldVersion < 3) {
            String queryString = String.format("ALTER TABLE %s ADD COLUMN %s integer",
                    BooksDbContract.DB_TABLE_NAME,
                    BooksDbContract.BooksEntry.SHELF_NUMBER);
            sqLiteDatabase.execSQL(queryString);
        }
    }

}
