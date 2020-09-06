package fr.aboucorp.freenote.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public abstract class Note {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "title")
     public String title;

    public Note(@NonNull String title) {
        this.title = title;
    }
}
