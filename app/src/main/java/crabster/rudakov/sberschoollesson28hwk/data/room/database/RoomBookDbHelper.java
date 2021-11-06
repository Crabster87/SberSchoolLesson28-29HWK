package crabster.rudakov.sberschoollesson28hwk.data.room.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Objects;

import crabster.rudakov.sberschoollesson28hwk.data.room.entity.RoomBooksDbContract;
import crabster.rudakov.sberschoollesson28hwk.data.sqlite.entity.BooksDbContract;

public class RoomBookDbHelper {

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
        }
    };

    public static RoomBooksDbContract getDatabase(@Nullable Context context) {
        return Room.databaseBuilder(Objects.requireNonNull(context).getApplicationContext(),
                RoomBooksDbContract.class,
                BooksDbContract.DB_FILE_NAME)
                .addMigrations(MIGRATION_1_2)
                .build();
    }

}
