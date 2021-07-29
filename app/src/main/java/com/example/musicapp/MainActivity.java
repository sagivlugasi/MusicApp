package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    static int c = 1;

    public void DropIn(View view)
    {
        ImageView counter = (ImageView)  view;
        counter.setTranslationY(-1000f);
        if(c % 2 == 0) {
            counter.setImageResource(R.drawable.fcb);
        }
        else
        {
            counter.setImageResource(R.drawable.arg);
        }
        counter.animate().translationYBy(1000f).setDuration(300);


    }

    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        i1 = (ImageView) findViewById(R.id.Image1);
        i2 = (ImageView) findViewById(R.id.Image2);
        i3 = (ImageView) findViewById(R.id.Image3);
        i4 = (ImageView) findViewById(R.id.Image4);
        i5 = (ImageView) findViewById(R.id.Image5);
        i6 = (ImageView) findViewById(R.id.Image6);
        i7 = (ImageView) findViewById(R.id.Image7);
        i8 = (ImageView) findViewById(R.id.Image8);
        i9 = (ImageView) findViewById(R.id.Image9);

         */



    }

}

