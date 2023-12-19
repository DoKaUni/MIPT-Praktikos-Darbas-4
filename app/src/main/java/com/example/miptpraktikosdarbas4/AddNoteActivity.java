package com.example.miptpraktikosdarbas4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
public class AddNoteActivity extends AppCompatActivity  {

    EditText editTextNoteTitle;
    EditText editTextNoteContent;
    Button buttonAddNote;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.editTextNoteTitle = findViewById(R.id.editTextNoteTitle);
        this.editTextNoteContent = findViewById(R.id.editTextNoteContent);
        this.buttonAddNote = findViewById(R.id.buttonAddNote);

        buttonAddNote.setOnClickListener(view -> {
            // TODO: Add function call to save data into file
        });
    }
}
