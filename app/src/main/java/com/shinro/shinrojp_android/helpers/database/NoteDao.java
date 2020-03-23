package com.shinro.shinrojp_android.helpers.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.shinro.shinrojp_android.models.Note;
import java.util.List;

import io.reactivex.Observable;

@Dao
public interface NoteDao {

    @Query("select * from note")
    Observable<List<Note>> getAllNote();

    @Query("select * from note order by title desc")
    Observable<List<Note>> sortNoteDesc();

    @Query("select * from note order by title asc")
    Observable<List<Note>> sortNoteAsc();

    @Query("select * from note where title like :key_word")
    Observable<List<Note>> searchNoteContainKeyWord(String key_word);

    @Query("select * from note where title = :key_word")
    Observable<List<Note>> searchNoteSimilarKeyWord(String key_word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNote(Note note);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

}
