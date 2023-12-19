package com.example.miptpraktikosdarbas4.Utils;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.File;
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
}
