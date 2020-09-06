package fr.aboucorp.freenote.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "text_note")
public class TextNote extends Note {
    @ColumnInfo(name = "text")
    public String text;

    public TextNote(@NonNull String title) {
        super(title);
    }
}
