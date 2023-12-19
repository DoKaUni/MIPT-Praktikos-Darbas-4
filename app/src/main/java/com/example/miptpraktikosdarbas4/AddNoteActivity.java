package com.example.miptpraktikosdarbas4;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.miptpraktikosdarbas4.Utils.FileSavingUtils;

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
            String noteTitle = editTextNoteTitle.getText().toString();
            String noteContent = editTextNoteContent.getText().toString();

            String invalidChars = FileSavingUtils.findInvalidChars(noteTitle);

            if (invalidChars.isEmpty()) {
                FileSavingUtils.saveNoteToFile(AddNoteActivity.this, noteTitle, noteContent);
                sendBroadcast(new Intent("refreshList"));

                finish();
            } else {
                String errorMessage = "Invalid characters in the title: " + invalidChars;
                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
