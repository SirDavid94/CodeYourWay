package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.QuestionScore;

public class LevelCompletionActivity extends AppCompatActivity {
    Button tryAgain;
    Button nextLevel;
    TextView completionMessage, congratulationMessage, passingScore,totalScore,failedMessage;

    //Firebase instance
    FirebaseDatabase database;
    DatabaseReference ScoresDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelcompletion_page);

        //Question score Instantiation
        database = FirebaseDatabase.getInstance();
        ScoresDatabase = database.getReference("LeaderBoard");


        completionMessage = findViewById(R.id.completionMessage);
        congratulationMessage = findViewById(R.id.congratulationMessage);
        passingScore = findViewById(R.id.passingScoreMessage);
        totalScore = findViewById(R.id.scoreMessage);
        failedMessage = findViewById(R.id.failedMessage);


        tryAgain = (Button) findViewById(R.id.tryAgainButton);
        nextLevel = (Button) findViewById(R.id.nextLevelButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String totalString= bundle.getString("total");
            String incorrectString = bundle.getString("Incorrect");
            String scoreString = bundle.getString("correct");

            double total = (double)Integer.parseInt(totalString);
            int incorrect = Integer.parseInt(incorrectString);
            double scoreInt = (double)Integer.parseInt(scoreString);

            //Sets the passing score to green
            passingScore.setTextColor(Color.GREEN);


            // Calculates Percentage for passing score
            int score = (int)((scoreInt/(total-1))*100);

            // If score is 80% or greater then the user has passed the level
            if(score >= 80)
            {
                totalScore.setTextColor(Color.GREEN);
                failedMessage.setVisibility(View.INVISIBLE);

               /* ScoresDatabase.child(String.format("%s_%s", Common.currentUser.getUsername(), Common.CategoryID))
                        .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser.getUsername(), Common.CategoryID),
                                Common.currentUser.getUsername(),
                                String.valueOf(score))); */
            }
            else
            {
                // If score is less than 80% then the user failed the level
                totalScore.setTextColor(Color.RED);
                congratulationMessage.setText("Sorry you fucked up. Try Again!!");
                congratulationMessage.setTextColor(Color.RED);
            }

            totalScore.setText(" YOUR SCORE :    "+ score + "%");
        }


        tryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent tryAgainIntent = new Intent(LevelCompletionActivity.this, GamePlay.class);
                startActivity(tryAgainIntent);
            }
        });

        nextLevel.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
               startActivity(new Intent(LevelCompletionActivity.this,GamePlay.class));
            }
        });
    }
}
