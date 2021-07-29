package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static int c = 1;
    int [] [] game = {{0,0,0},
                      {0,0,0},
                      {0,0,0}};
    int player = 0;
    boolean gameOver = false;

    public void DropIn(View view)
    {
        if (!gameOver) {
            ImageView counter = (ImageView) view;
            if (counter.getDrawable() == null) {
                counter.setTranslationY(-1000f);
                if (c % 2 == 0) {
                    counter.setImageResource(R.drawable.fcb);
                    player = 1;
                } else {
                    counter.setImageResource(R.drawable.arg);
                    player = 2;
                }
                counter.animate().translationYBy(1000f).setDuration(300);
                c++;

                int x = Integer.parseInt(String.valueOf(counter.getTag().toString().charAt(0)));
                int y = Integer.parseInt(String.valueOf(counter.getTag().toString().charAt(2)));
                game[x][y] = player;

                for (int i = 0; i < 3; i++) {
                    Log.i("array", String.valueOf((game[i][0]) + "  " + (game[i][1]) + " " + game[i][2]));
                }
                Log.i("array", "________________________");

                if (c > 5) {
                    for (int i = 0; i < 3; i++) {
                        if (game[i][0] == game[i][1] && game[i][0] == game[i][1] && game[i][0]!=0 ) {
                            gameOver = true;
                            player = game[i][0];
                            break;
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        if (game[0][i] == game[1][i] && game[1][i] == game[2][i] && game[i][0]!=0)  {
                            gameOver = true;
                            player = game[0][i];
                            break;
                        }
                    }
                    if( (game[0][0] == game[1][1] &&game[1][1] == game[2][2] )   ||
                            (game[2][0] == game[1][1] &&game[1][1] == game[0][2])  )
                    {
                        gameOver = true;
                        player = game[1][1];
                    }
                    if (gameOver && player == 2)
                    {
                        Toast.makeText(MainActivity.this, "Argentina won!",Toast.LENGTH_LONG).show();
                        c = 1;
                        Log.i( "","Game Over");
                    }
                    else if (gameOver)
                    {
                        Toast.makeText(MainActivity.this, "Barcelona won!",Toast.LENGTH_LONG).show();
                        c = 1;
                        Log.i( "","Game Over");

                    }


                }
            }
        }

    }

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

