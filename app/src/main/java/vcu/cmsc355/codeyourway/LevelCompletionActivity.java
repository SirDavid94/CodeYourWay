package vcu.cmsc355.codeyourway;

/**
 * Class LevelCompletionActivity displays after User has successfully completed a game level
 * It display the game stats and informs the user if they passed a level or not
 * Game data is uploaded if user earns a badge with a score greater than 80%
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import vcu.cmsc355.codeyourway.Model.Awards;


public class LevelCompletionActivity extends AppCompatActivity {
    Button tryAgain;
    Button nextLevel;
    int awardPoint = 1; //point to award to user every time they complete a level
    TextView completionMessage, congratulationMessage,
             passingScore,totalScore,failedMessage;

    //FireBase instance
    FirebaseDatabase database;
    DatabaseReference Award;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelcompletion_page);

        //Ranking Instantiation
        database = FirebaseDatabase.getInstance();
        Award = database.getReference("Awards");
        completionMessage = findViewById(R.id.completionMessage);
        congratulationMessage = findViewById(R.id.congratulationMessage);
        passingScore = findViewById(R.id.passingScoreMessage);
        totalScore = findViewById(R.id.scoreMessage);
        failedMessage = findViewById(R.id.failedMessage);
        tryAgain = (Button) findViewById(R.id.tryAgainButton);
        nextLevel = (Button) findViewById(R.id.nextLevelButton);

        //Gets all data sent from previous page
         Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String totalString     = bundle.getString("total");
            String incorrectString = bundle.getString("Incorrect");
            String scoreString     = bundle.getString("correct");
            int completedLevel     = bundle.getInt("levelID",1);
            int completedModule    = bundle.getInt("moduleID",1);

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

               //Creates User data to generate award data for upload to online Database
                final Awards awardUpload = new Awards("bash",
                        awardPoint,completedModule,completedLevel);

                //Uses user's Username as a key to upload data to Database
                Award.child(Awards.getUser())
                        .setValue(awardUpload);

            }
            else
            {
                // If score is less than 80% then the user failed the level
                totalScore.setTextColor(Color.RED);
                congratulationMessage.setText("Sorry you fucked up. Try Again!!");
                congratulationMessage.setTextColor(Color.RED);
            }
            // Sets the user's score to the display page
            totalScore.setText(" YOUR SCORE :    "+ score + "%");
        }

        //Starts the same game Level over again
        tryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent tryAgainIntent = new Intent(LevelCompletionActivity.this, GamePlay.class);
                startActivity(tryAgainIntent);
            }
        });

        //Starts the next Game Level when the button is clicked
        nextLevel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(LevelCompletionActivity.this,GamePlay.class));
            }
        });
    }
}
