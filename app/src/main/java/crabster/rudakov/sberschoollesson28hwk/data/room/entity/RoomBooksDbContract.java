package crabster.rudakov.sberschoollesson28hwk.data.room.entity;

import androidx.room.RoomDatabase;
import androidx.room.Database;

import crabster.rudakov.sberschoollesson28hwk.data.room.database.RoomBookDao;

@Database(entities = {RoomBook.class}, version = 2)
public abstract class RoomBooksDbContract extends RoomDatabase {

    public abstract RoomBookDao roomBookDao();

}
