package com.example.campos_luis.pig;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.TextView;

// This is extending an action
public class MainActivity extends ActionBarActivity {
    private FrameLayout die1, die2;
    private TextView P1, P2,Round;
    private Button roll, hold;
    // 
    private int P1Score;
    private int FinalScore1;
    private int Player2Score;
    private int RoundScore;
    // main constructor 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // I added the code below
        Intent intent = getIntent();
        Player2Score = intent.getIntExtra("P2Score", 0);
        // Retrieve own score back
        int prevScore = intent.getIntExtra("Player1Score", 0);
        // set the FinalScore1
        setFinalScore(prevScore);

        //  am commenting this out for the meantime i am intersted in keeping track of Player 1 score right now
        Toast.makeText(this, "The Player2Score is: " + Player2Score, Toast.LENGTH_LONG).show();
        // Toast.makeText(this, "The P1Score is: " + prevScore, Toast.LENGTH_LONG).show();
        // end of the code i added

        roll = (Button) findViewById(R.id.button);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();


            }
        });

        hold = (Button)findViewById(R.id.hold);
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the round score first
                int tempRound = getRoundScore();
                // then add it to the final score
                addScore(tempRound);
                // get the P1Score from roll die
                int TmpScore = getFinalScore();
                if(TmpScore >=100){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("You Won!");
                    alertDialog.setMessage("Winner!!!!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,Player2.class);
                    intent.putExtra("P1Score", TmpScore);
                    // also send back player2 score
                    intent.putExtra("Player2Score",Player2Score);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }

            }
        });


        die1 = (FrameLayout) findViewById(R.id.die1);
        die2 = (FrameLayout) findViewById(R.id.die2);
        // Now to change the Player1 Score
        P1=(TextView)findViewById(R.id.p1);
        int IntegerScore = getFinalScore();
        String stringScore = Integer.toString(IntegerScore);
        P1.setText("P1: "+stringScore);
        // Now to change the Player1 Score
        P2=(TextView)findViewById(R.id.p2);
        int IntegerScore2 = Player2Score;
        String stringScore2 = Integer.toString(IntegerScore2);
        P2.setText("P2: "+stringScore2);
        // The score during the round
        // Round=(TextView)findViewById(R.id.round);
        // int RScore = getRoundScore();
        // String stringRScore = Integer.toString(RScore);
        // Round.setText("Round: "+stringRScore);

    }

    //get two random ints between 1 and 6 inclusive
    public void rollDice() {
        int val1 = 1 + (int) (6 * Math.random());
        int val2 = 1 + (int) (6 * Math.random());
        setDie(val1, die1);
        setDie(val2, die2);
        int value = val1 + val2;
        setScore(value);
        // addScore(value);
        // printScore();
        if (val1 ==1 || val2 == 1){
            Toast.makeText(this, "You got a 1: ", Toast.LENGTH_LONG).show();
            // get the score to send
            int TmpScore = getFinalScore();
            Intent intent = new Intent(MainActivity.this,Player2.class);
            intent.putExtra("P1Score", TmpScore);
            // also send back player2 score
            intent.putExtra("Player2Score",Player2Score);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);

        }
        // if you dont get a one add the value to the round score
        else {
            setRoundScore(value);
            updateRound();
            printScore();
        }

    }
    // start of my code
    public void setScore(int value){
        P1Score = value;
    }
    public int getScore(){
        return P1Score;
    }
    public int getFinalScore(){
        return FinalScore1;
    }
    public void addScore(int number){
        FinalScore1 += number;
    }
    public void setFinalScore(int prevScore){
        FinalScore1 = prevScore;
    }
    // for debugging purposes
    public void printScore(){
        Toast.makeText(this, "Score so Far: " + FinalScore1, Toast.LENGTH_LONG).show();
    }
    public void setRoundScore(int round){
        RoundScore += round;
    }
    public int getRoundScore(){
        return RoundScore;
    }
    public void updateRound(){
        // The score during the round
        Round=(TextView)findViewById(R.id.round);
        int RScore = getRoundScore();
        String stringRScore = Integer.toString(RScore);
        Round.setText("Round: "+stringRScore);

    }
    // end of my code

    //set the appropriate picture for each die per int
    public void setDie(int value, FrameLayout layout) {
        Drawable pic = null;

        switch (value) {
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                break;
            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                break;
        }
        layout.setBackground(pic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
/*
* AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
alertDialog.setTitle("Alert");
alertDialog.setMessage("Alert message to be shown");
alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
    new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    });
alertDialog.show();*/