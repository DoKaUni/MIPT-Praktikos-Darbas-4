package com.example.miptpraktikosdarbas4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;

import android.os.Bundle;

import com.example.miptpraktikosdarbas4.Utils.ListViewUtils;

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

        BroadcastReceiver refreshListReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ListViewUtils.populateList(context, listItems, adapter);
            }
        };
        registerReceiver(refreshListReceiver, new IntentFilter("refreshList"));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListViewUtils.populateList(this, listItems, adapter);
    }


}