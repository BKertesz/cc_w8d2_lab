package com.codeclan.balazskertesz.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RockPaperScissorsActivity extends AppCompatActivity {

    Button rock;
    Button scissors;
    Button paper;

    TextView display;
    TextView score;

    Game game;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();

//        if(savedInstanceState != null){
//            game.setWins(savedInstanceState.getInt("wins"));
//            game.setLose(savedInstanceState.getInt("loses"));
//            game.setDraws(savedInstanceState.getInt("draws"));
//        }


        setContentView(R.layout.activity_rock_paper_scissors);
        rock = findViewById(R.id.buttonRockID);
        scissors = findViewById(R.id.buttonScissorsID);
        paper = findViewById(R.id.buttonPaperID);
        display = findViewById(R.id.textDisplay);

        score = findViewById(R.id.scoreID);
        intent = new Intent(this, WinnerActivity.class);

//        setButtonColors();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        // This method saves data to the outside storage
        // Gets called automatically every time app goes to other activity
        savedInstanceState.putInt("wins",game.getWins());
        savedInstanceState.putInt("loses",game.getLose());
        savedInstanceState.putInt("draws",game.getDraws());


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onResume(){
        super.onResume();
        // When you return to the activity it displays the score again
        score.setText(game.displayScore());

    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //This method loads the game score data from outside storage back to the class
        //Gets run every time you return to the activity
        game.setDraws(savedInstanceState.getInt("draws"));
        game.setWins(savedInstanceState.getInt("wins"));
        game.setLose(savedInstanceState.getInt("loses"));
    }


    public void getPlayerHand(View view){
        Button button = (Button) view;
        game.setPlayer(button.getText().toString());
        game.randomComputerHand();
        displayWinnerText();

    }

    public void displayWinnerText(){
//        display.setText(game.handsPlayedText());
        score.setText(game.displayScore());
        intent.putExtra("winner",game.handsPlayedText());
        intent.putExtra("score",game.displayScore());
        startActivity(intent);

    }

    public void setButtonColors(){
        rock.setBackgroundColor(getResources().getColor(R.color.rockButton));
        paper.setBackgroundColor(getResources().getColor(R.color.paperButton));
        scissors.setBackgroundColor(getResources().getColor(R.color.scissorButton));
    }


}
