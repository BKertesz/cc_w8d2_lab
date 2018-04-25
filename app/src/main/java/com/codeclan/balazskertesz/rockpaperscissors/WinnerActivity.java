package com.codeclan.balazskertesz.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {


    TextView display;
    TextView scoreDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String winner = extras.getString("winner");
        String score = extras.getString("score");
        //This 4 lines gets the intent
        //Gets the winner text and score text from the intent

        scoreDisplay = (TextView) findViewById(R.id.winnerScoreID);
        scoreDisplay.setText(score);
        //Sets up the score display and set the text to the score String

        display = (TextView) findViewById(R.id.textDisplayID);
        display.setText(winner);
        //Sets up and displays winner text

    }

    public void goBack(View view){

        //Unused method which restarts the game activity
        Intent intent = new Intent(this,RockPaperScissorsActivity.class);
        startActivity(intent);

    }
}
