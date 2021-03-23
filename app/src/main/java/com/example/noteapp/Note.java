package com.example.noteapp;

import javax.sql.StatementEvent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int  id;
    @ColumnInfo(name = "NoteTitle")
    private String title;
    @ColumnInfo(name = "NoteDes")
    private String Des;
    @ColumnInfo(name = "Date")
    private String date;
    @ColumnInfo(name = "Time")
    private String time;

    public Note(String title, String Des, String date, String time) {
        this.title = title;
        this.Des = Des;
        this.date = date;
        this.time = time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
