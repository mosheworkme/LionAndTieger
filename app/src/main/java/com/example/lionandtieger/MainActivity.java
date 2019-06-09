package com.example.lionandtieger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    enum Player {


        ONE, TWO, NO
    }

    Player theCurrentValue = Player.ONE;
    Player[] playersChoice = new Player[9];
    int winnerColumnAndRows[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7,}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private boolean gameOver = false;

    private  Button button;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        playersChoice[0] = Player.NO;
        playersChoice[1] = Player.NO;
        playersChoice[2] = Player.NO;
        playersChoice[3] = Player.NO;
        playersChoice[4] = Player.NO;
        playersChoice[5] = Player.NO;
        playersChoice[6] = Player.NO;
        playersChoice[7] = Player.NO;
        playersChoice[8] = Player.NO;


        button = findViewById ( R.id.button2 );
        gridLayout = findViewById ( R.id.border );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                resetTheGame ( );

            }
        } );


    }

    public void imageViewClick(View imageView) {

        ImageView tappedImageView = (ImageView) imageView;
        int tiTag = Integer.parseInt ( tappedImageView.getTag ( ).toString ( ) );
        if (playersChoice[tiTag] == Player.NO && !gameOver) {
            tappedImageView.setTranslationX ( -2000 );

            playersChoice[tiTag] = theCurrentValue;
            if (theCurrentValue == Player.ONE) {

                tappedImageView.setImageResource ( R.drawable.lion );
                theCurrentValue = Player.TWO;
                Toast.makeText ( MainActivity.this, "PLAYER TWO ITS YOUR TURN", Toast.LENGTH_LONG ).show ( );
            } else if (theCurrentValue == Player.TWO) {

                tappedImageView.setImageResource ( R.drawable.leopard );
                theCurrentValue = Player.ONE;
                Toast.makeText ( MainActivity.this, "PLAYER ONE ITS YOUR TURN", Toast.LENGTH_LONG ).show ( );


            }

            tappedImageView.animate ( ).translationXBy ( 2000 ).alpha ( 1 ).rotation ( 3600 ).setDuration ( 2000 );
            for (int[] winnerColumns : winnerColumnAndRows) {
                if (playersChoice[winnerColumns[0]] ==
                        playersChoice[winnerColumns[1]] && playersChoice[winnerColumns[1]]
                        == playersChoice[winnerColumns[2]] && playersChoice[winnerColumns[0]] != Player.NO) {

                    Toast.makeText ( this, "WE HAVE A WINNER ", Toast.LENGTH_LONG ).show ( );
                    button.setVisibility ( View.VISIBLE );
                    gameOver = true;

                }
            }


        }

    }
    //RESET BUTTON GOOD FOR ALL RESET

    private void resetTheGame() {
        for (int index = 0;index <gridLayout.getChildCount ();index++){



             ImageView imageView = (ImageView) gridLayout.getChildAt ( index );
             imageView.setImageDrawable ( null );
             imageView.setAlpha ( 0.2f );
        }
        gameOver = false;
        theCurrentValue = Player.ONE;
        playersChoice[0] = Player.NO;
        playersChoice[1] = Player.NO;
        playersChoice[2] = Player.NO;
        playersChoice[3] = Player.NO;
        playersChoice[4] = Player.NO;
        playersChoice[5] = Player.NO;
        playersChoice[6] = Player.NO;
        playersChoice[7] = Player.NO;
        playersChoice[8] = Player.NO;

    }


}
