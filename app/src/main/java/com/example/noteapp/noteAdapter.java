package com.example.noteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class noteAdapter extends RecyclerView.Adapter<noteAdapter.ViewHolder> {
    List<Note> passedList;
    clickListener clicked;
    public noteAdapter(List<Note> passedList) {
        this.passedList = passedList;
    }
    public void setClicked(clickListener clicked) {
        this.clicked = clicked;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item1,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note temp = passedList.get(position);
        String title = temp.getTitle();
        String date = temp.getDate();
        String time = temp.getTime();
        holder.txtTitle.setText(title);
        holder.txtDate.setText(date);
        holder.txtTime.setText(time);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked.onNoteClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return passedList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle,txtDate,txtTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtTime = itemView.findViewById(R.id.txt_time);
        }
    }
    public interface clickListener{
        void onNoteClick(int position);
    }
}
