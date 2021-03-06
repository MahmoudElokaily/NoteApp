package com.example.noteapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract NoteDAO noteDAO();
}
