package com.tanka.accessories.todoroom.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tanka.accessories.todoroom.data.model.Note;

import java.util.List;

/**
 * Created by Marcin Lowicki 1/12/19.
 */

@Dao
public interface NoteDao {

    @Insert
    void insertAll(Note... notes);

    @Update
    void updateAll(Note... notes);

    @Query("SELECT * FROM note")
    List<Note> getAllNotes();

    @Query("SELECT * FROM note where title LIKE :keyword")
    List<Note> getNote(String keyword);

    @Delete
    void deleteAll(Note... notes);

    @Update
    void editNote(Note note);

    @Query("UPDATE Note SET `title` = :txTitle, `body` = :txBody, `date` = :txDate, `type` = :txType   WHERE id = :tid")
    void updateNote(long tid, String txTitle, String txBody, String txDate, String txType);
}
