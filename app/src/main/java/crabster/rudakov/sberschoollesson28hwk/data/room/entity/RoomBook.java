package crabster.rudakov.sberschoollesson28hwk.data.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import crabster.rudakov.sberschoollesson28hwk.data.sqlite.entity.BooksDbContract;

@Entity(tableName = BooksDbContract.DB_TABLE_NAME)
public class RoomBook {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BooksDbContract.BooksEntry._ID)
    public long bookId;
    @ColumnInfo(name = BooksDbContract.BooksEntry.ISBN)
    public String isbn;
    @ColumnInfo(name = BooksDbContract.BooksEntry.TITLE)
    public String title;
    @ColumnInfo(name = BooksDbContract.BooksEntry.AUTHOR)
    public String author;
    @ColumnInfo(name = BooksDbContract.BooksEntry.SHELF_NUMBER)
    public int shelfNumber;

    public RoomBook(String isbn, String title, String author, int shelfNumber) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.shelfNumber = shelfNumber;
    }

}
