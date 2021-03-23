package com.example.noteapp;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface NoteDAO {
    @Query("SELECT * FROM Note")
    List<Note> getAllNotes();

    @Insert
    void insertAll(Note...Note);

   @Query("DELETE  FROM Note WHERE id ==:nid")
    void delete(int nid);
}
