package com.example.miptpraktikosdarbas4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miptpraktikosdarbas4.Utils.ListViewUtils;

import java.util.ArrayList;

public class ViewNoteActivity extends AppCompatActivity {

    private Spinner spinnerNotes;
    private TextView textViewnoteTitle;
    private TextView textViewNoteContent;
    private Button buttonDeleteNote;

    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        spinnerNotes = findViewById(R.id.spinnerNotes);
        textViewnoteTitle = findViewById(R.id.textViewNoteTitle);
        textViewNoteContent = findViewById(R.id.textViewNoteContent);
        buttonDeleteNote = findViewById(R.id.buttonDeleteNote);

        listItems = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerNotes.setAdapter(adapter);

        ListViewUtils.populateList(this, listItems, adapter);

        spinnerNotes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                textViewnoteTitle.setText((String) parentView.getItemAtPosition(position));
                textViewNoteContent.setText(ListViewUtils.loadNoteData(ViewNoteActivity.this, textViewnoteTitle.getText().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });

        buttonDeleteNote.setOnClickListener(View ->{
                String selectedFileName = (String) spinnerNotes.getSelectedItem();
                ListViewUtils.deleteNote(this, selectedFileName);
                sendBroadcast(new Intent("refreshList"));

                finish();
        });
    }
}
