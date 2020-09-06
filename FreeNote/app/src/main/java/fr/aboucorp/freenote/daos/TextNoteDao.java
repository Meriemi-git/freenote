package fr.aboucorp.freenote.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.aboucorp.freenote.models.TextNote;
@Dao
public interface TextNoteDao {
    @Query("SELECT * FROM text_note")
    LiveData<List<TextNote>> getTextNotes();
    @Insert
    void insertTextNote(TextNote textNote);
    @Delete
    void deleteTextNote(TextNote textNote);
    @Update
    void updateTextNote(TextNote textNote);
}
