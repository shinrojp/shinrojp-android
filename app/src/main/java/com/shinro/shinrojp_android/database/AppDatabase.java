package com.shinro.shinrojp_android.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.shinro.shinrojp_android.helpers.database.NoteDao;
import com.shinro.shinrojp_android.models.Note;

import static com.shinro.shinrojp_android.utils.Constants.DB_NAME;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract NoteDao noteDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

}
