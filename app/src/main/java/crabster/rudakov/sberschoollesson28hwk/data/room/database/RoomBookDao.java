package crabster.rudakov.sberschoollesson28hwk.data.room.database;

import androidx.room.*;

import java.util.List;

import crabster.rudakov.sberschoollesson28hwk.data.room.entity.RoomBook;
import crabster.rudakov.sberschoollesson28hwk.data.sqlite.entity.BooksDbContract;

@Dao
public interface RoomBookDao {

    @Insert
    void addBook(RoomBook books);

    @Query("SELECT * FROM " + BooksDbContract.DB_TABLE_NAME)
    List<RoomBook> getBooks();

    @Query("DELETE FROM " + BooksDbContract.DB_TABLE_NAME)
    void deleteBooks();

    @Query("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + BooksDbContract.DB_TABLE_NAME + "'")
    void resetPrimaryKey();

}