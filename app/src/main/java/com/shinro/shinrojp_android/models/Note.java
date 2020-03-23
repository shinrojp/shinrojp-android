package com.shinro.shinrojp_android.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "note")
public class Note {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    public int note_id;

    @ColumnInfo(name = "title")
    public String note_title;

    @NotNull
    @ColumnInfo(name = "content")
    public String note_content;

    @Ignore
    public Note() {}

    public Note(@NotNull int note_id, String note_title, String note_content) {
        this.note_id = note_id;
        this.note_title = note_title;
        this.note_content = note_content;
    }

    @Ignore
    public Note(String note_title, String note_content) {
        this.note_title = note_title;
        this.note_content = note_content;
    }
}
