package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static int c = 1;
    int [] [] game = {{0,0,0},
                      {0,0,0},
                      {0,0,0}};
    int player = 0;
    boolean gameOver = false;



    public void Restart(View view)
    {
        final LinearLayout l = (LinearLayout) findViewById(R.id.WinLayout);
        l.setVisibility(View.INVISIBLE);

        TextView winner =  findViewById(R.id.WinnerText);
        winner.setText("");

        c = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game[i][j] = 0;
            }
            }

           gameOver = false;
        player = 0;


    }

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

                if (c > 5 && c < 9) {
                    //check for 3 X or O in a row for 3 rows
                    for (int i = 0; i < 3; i++) {
                        if (game[i][0] == game[i][1] && game[i][0] == game[i][1] && game[i][0]!=0 ) {
                            gameOver = true;
                            player = game[i][0];
                            break;
                        }
                    }
                    //check for 3 X or O in a row for 3 columns

                    for (int i = 0; i < 3; i++) {
                        if (game[0][i] == game[1][i] && game[1][i] == game[2][i] && game[0][i]!=0)  {
                            gameOver = true;
                            player = game[0][i];
                            break;
                        }
                    }
                    //check for 3 X or O in a row in 2 diagonals

                    if( (game[0][0] == game[1][1] &&game[1][1] == game[2][2] )   ||
                            (game[2][0] == game[1][1] &&game[1][1] == game[0][2])  )
                    {
                        gameOver = true;
                        player = game[1][1];
                    }

                    String winnerName = "";
                    if (gameOver )
                    {
                        if(player == 1 ) {
                            winnerName = "Barcelona";
                        }
                        else {
                            winnerName = "Argentina";

                        }
                        TextView winner =  findViewById(R.id.WinnerText);
                        c = 1;
                        Log.i( "","Game Over");
                        winner.setText(winnerName+" won!");
                        final LinearLayout l = (LinearLayout) findViewById(R.id.WinLayout);
                        l.setVisibility(View.VISIBLE);
                    }

                }
                else if (c==10)
                {
                    TextView winner =  findViewById(R.id.WinnerText);
                    c = 1;
                    Log.i( "","Game Over");
                    winner.setText("It's a tie!");
                    final LinearLayout l = (LinearLayout) findViewById(R.id.WinLayout);
                    l.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}

