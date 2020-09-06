package fr.aboucorp.freenote.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.aboucorp.freenote.daos.TextNoteDao;
import fr.aboucorp.freenote.db.FreeNoteDatabase;
import fr.aboucorp.freenote.models.TextNote;
import fr.aboucorp.freenote.utils.BackgroundRunner;

public class TextNoteRepository {

    private final TextNoteDao textNoteDao;
    private LiveData<List<TextNote>> allTextNotes;

    public TextNoteRepository(Application application) {
        FreeNoteDatabase db = FreeNoteDatabase.getInstance(application);
        this.textNoteDao = db.textNoteDao();
        allTextNotes = textNoteDao.getTextNotes();
    }

    // --- GET ---
    public LiveData<List<TextNote>> getTextNotes(){ return this.allTextNotes; }

    // --- CREATE ---
    public void insertTextNote(TextNote textNote){
        BackgroundRunner runner = new BackgroundRunner() {
            @Override
            protected void execute() {
                textNoteDao.insertTextNote(textNote);
            }
        };
        runner.startAsync();
    }

    // --- DELETE ---
    public void deleteTextNote(TextNote textNote) {
        BackgroundRunner runner = new BackgroundRunner() {
            @Override
            protected void execute() {
                textNoteDao.deleteTextNote(textNote);
            }
        };
        runner.startAsync();
    }
    // --- UPDATE ---
    public void updateTextNote(TextNote textNote){
        BackgroundRunner runner = new BackgroundRunner() {
            @Override
            protected void execute() {
                textNoteDao.updateTextNote(textNote);
            }
        };
        runner.startAsync();
    }


}
