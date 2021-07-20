package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainActivity extends AppCompatActivity {

    TextView status;
    static final String path ="src/main/res/raw/";
    public File merged =new File(path,"merged.mp3");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = findViewById(R.id.status);
        status.setText(" ");

        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File song1 = new File(path,"bpm180.mp3");
            File song2 =  new File(path,"song1.mp3");

            mergeSongs(merged,song1,song2);

          //  MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.merged);
          //  mediaPlayer.start();
          //  wait(3000);
          //  mediaPlayer.stop();
            Toast.makeText(MainActivity.this,"WORK",Toast.LENGTH_SHORT).show();
            status.setText("Its working");

        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"dosent work",Toast.LENGTH_SHORT).show();
            status.setText("Dosent work");

        }

    }
    public void mergeSongs(File mergedFile,File song1, File song2) throws IOException {
        byte[] byte1 = Files.readAllBytes(Paths.get("/bpm180.mp3"));
        byte[] byte2 = Files.readAllBytes(Paths.get("/song1.mp3"));
        byte[] out = new byte[byte1.length];
        for (int i=0; i<byte1.length; i++) {
            out[i] = (byte) ((byte1[i] + byte2[i]) >> 1);
        }

    }



}