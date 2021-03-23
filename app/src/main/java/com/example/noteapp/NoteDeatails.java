package com.example.noteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NoteDeatails extends AppCompatActivity {
    TextView txtTitle,txtDes;
    String title,des;
    Button removeDetails;
    DataBase db;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_deatails);
        init();
        db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"DataBase").allowMainThreadQueries().build();
        removeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });

    }
    void delete (int id){
        db.noteDAO().delete(id);
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
    }
    void init (){
        txtTitle = findViewById(R.id.txt_title_detals);
        txtDes = findViewById(R.id.txt_des_deails);
        removeDetails = findViewById(R.id.btn_delete_details);
        title = getIntent().getStringExtra("Title");
        des = getIntent().getStringExtra("Des");
        id = getIntent().getIntExtra("id",0);
        txtTitle.setText(title);
        txtDes.setText(des);
    }
    void dialog (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning");
        builder.setMessage("Are you sure you want to delete this note?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                delete(id);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}