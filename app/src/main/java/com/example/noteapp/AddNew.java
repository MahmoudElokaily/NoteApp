package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddNew extends AppCompatActivity {
    TextView txtNewNote;
    EditText etxtTitle,etxtDes;
    Button btnSave,btnRemove;
    Calendar c;
    String Today,currentTime;
    DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        init();
        db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"DataBase").allowMainThreadQueries().build();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (etxtTitle.getText().toString().isEmpty()){
                  etxtTitle.setError("This Text can't be Empty");
              }
              else {
                  btnSaveClick();
              }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddNew.this,"Note not Saved",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    private void init(){
        txtNewNote = findViewById(R.id.txt_new_note);
        etxtTitle = findViewById(R.id.etxt_title);
        etxtDes = findViewById(R.id.etxt_des);
        btnSave = findViewById(R.id.btn_save);
        btnRemove = findViewById(R.id.btn_remove);
        c = Calendar.getInstance();
        Today = c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH)) + "/" + c.get(Calendar.DAY_OF_MONTH);
        currentTime = c.get(Calendar.HOUR)+ ":" + c.get(Calendar.MINUTE);
    }

    private void btnSaveClick (){
        Toast.makeText(AddNew.this,"ADD",Toast.LENGTH_SHORT).show();
        Note note = new Note(etxtTitle.getText().toString(),etxtDes.getText().toString(),Today,currentTime);
        db.noteDAO().insertAll(note);
        Intent i = new Intent(AddNew.this,MainActivity.class);
        startActivity(i);
    }
}