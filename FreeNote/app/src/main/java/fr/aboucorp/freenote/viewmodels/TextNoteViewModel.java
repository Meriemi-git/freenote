package fr.aboucorp.freenote.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.aboucorp.freenote.models.TextNote;
import fr.aboucorp.freenote.repositories.TextNoteRepository;

public class TextNoteViewModel extends AndroidViewModel {
    private final TextNoteRepository textNoteRepository;
    private LiveData<List<TextNote>> allTextNotes;
    public TextNoteViewModel(Application application) {
        super(application);
        textNoteRepository = new TextNoteRepository(application);
        allTextNotes = textNoteRepository.getTextNotes();
    }

    public LiveData<List<TextNote>> getTextNotes() {
        return allTextNotes;
    }

    public void createTextNote(TextNote textNote) {
        textNoteRepository.insertTextNote(textNote);
    }

    public void deleteTextNote(TextNote textNote) {
        textNoteRepository.deleteTextNote(textNote);
    }

    public void updateTextNote(TextNote textNote) {
        textNoteRepository.updateTextNote(textNote);
    }
}
