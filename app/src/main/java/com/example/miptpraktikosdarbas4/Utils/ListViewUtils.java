package com.example.miptpraktikosdarbas4.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListViewUtils {
    public static void populateList(Context context, ArrayList<String> listItems, ArrayAdapter<String> adapter) {
        File internalStorageDir = context.getFilesDir();

        File notesDir = new File(internalStorageDir, "Notes");
        if (notesDir.exists()) {
            File[] files = notesDir.listFiles();

            if (files != null) {
                listItems.clear();

                for (File file : files)
                    listItems.add(removeExtension(file.getName()));

                adapter.notifyDataSetChanged();
            }
        }
    }
    private static String removeExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        return fileName.substring(0, lastDotIndex);
    }

    public static String loadNoteData(Context context, String noteTitle) {
        File internalStorageDir = context.getFilesDir();

        File notesDir = new File(internalStorageDir, "Notes");
        File noteFile = new File(notesDir, noteTitle + ".txt");

        Log.d("loadNoteData", noteFile.getAbsolutePath());

        StringBuilder content = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(noteFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            br.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void deleteNote(Context context, String noteTitle) {
        File internalStorageDir = context.getFilesDir();
        File notesDir = new File(internalStorageDir, "Notes");
        File noteFile = new File(notesDir, noteTitle + ".txt");

        if (noteFile.exists()) {
            boolean deleted = noteFile.delete();
            if (deleted) {
                Log.d("DeleteNote", "Note deleted successfully: " + noteTitle);
            } else {
                Log.d("DeleteNote", "Failed to delete note: " + noteTitle);
            }
        } else {
            Log.d("DeleteNote", "Note file not found: " + noteTitle);
        }
    }
}
