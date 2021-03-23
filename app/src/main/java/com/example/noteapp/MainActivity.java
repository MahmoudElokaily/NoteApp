package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    FloatingActionButton btnAdd;
    noteAdapter adapter;
    List<Note> notes;
    DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,AddNew.class);
                startActivity(i);
            }
        });
        adapter.setClicked(new noteAdapter.clickListener() {
            @Override
            public void onNoteClick(int position) {
               go(position);
            }
        });
    }
    private void init(){
        btnAdd = findViewById(R.id.btn_add);
        rv  = findViewById(R.id.r_v);
        rv.setLayoutManager(new LinearLayoutManager(this));
        notes = new ArrayList<>();
        db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"DataBase").allowMainThreadQueries().build();
        notes = db.noteDAO().getAllNotes();
        adapter = new noteAdapter(notes);
        rv.setAdapter(adapter);
    }
    private void go(int position){
        Intent i = new Intent(MainActivity.this,NoteDeatails.class);
        i.putExtra("Title",notes.get(position).getTitle());
        i.putExtra("Des",notes.get(position).getDes());
        i.putExtra("id",notes.get(position).getId());
        startActivity(i);
    }
}