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

        scoreDisplay = (TextView) findViewById(R.id.winnerScoreID);
        scoreDisplay.setText(score);

        display = (TextView) findViewById(R.id.textDisplayID);
        display.setText(winner);

    }

    public void goBack(View view){
        Intent intent = new Intent(this,RockPaperScissorsActivity.class);
        startActivity(intent);

    }
}
