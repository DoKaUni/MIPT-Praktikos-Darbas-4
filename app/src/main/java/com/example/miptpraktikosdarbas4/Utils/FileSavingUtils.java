package com.example.miptpraktikosdarbas4.Utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSavingUtils {

    public static void saveNoteToFile(Context context, String noteTitle, String noteContent) {
        File notesDir = new File(context.getFilesDir(), "Notes");
        if (!notesDir.exists()) {
                notesDir.mkdirs();
        }

        String filePath = notesDir.getAbsolutePath() + File.separator + noteTitle + ".txt";

        File file = new File(filePath);

        try {
            FileWriter fileWriter = new FileWriter(file);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(noteContent);

            bufferedWriter.close();

            Log.d("saveNoteToFile", "Note saved successfully");
            Log.d("saveNoteToFile", notesDir.getAbsolutePath());

        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public static String findInvalidChars(String noteTitle) {
        StringBuilder invalidChars = new StringBuilder();
        String characters = "[^a-zA-Z0-9_-]";
        Pattern pattern = Pattern.compile(characters);
        Matcher matcher = pattern.matcher(noteTitle);

        while (matcher.find()) {
            invalidChars.append(matcher.group());
        }

        return invalidChars.toString();
    }
}
