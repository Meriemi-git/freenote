package fr.aboucorp.freenote.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.aboucorp.freenote.daos.TextNoteDao;
import fr.aboucorp.freenote.models.TextNote;

@Database(entities = {TextNote.class}, version = 1,exportSchema = true)
public abstract class FreeNoteDatabase extends RoomDatabase {
    public static final String DB_NAME="free_note.db";
    public abstract TextNoteDao textNoteDao();
    private static FreeNoteDatabase instance;

    public static FreeNoteDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),FreeNoteDatabase.class,DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

}
