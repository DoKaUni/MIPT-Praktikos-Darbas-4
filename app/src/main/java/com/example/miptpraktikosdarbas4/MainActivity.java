package com.example.miptpraktikosdarbas4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listViewNotes;
    Button buttonAddNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonAddNote = findViewById(R.id.buttonAddNote);

        this.listViewNotes = findViewById(R.id.listViewNotes);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.listItems);
        this.listViewNotes.setAdapter(adapter);

        buttonAddNote.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddNoteActivity.class);
            view.getContext().startActivity(intent);
        });
    }
}