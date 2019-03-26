package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LevelCompletionActivity extends AppCompatActivity {
    Button tryAgain;
    Button nextLevel;
    TextView completionMessage, congratulationMessage, passingScore,totalScore,failedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelcompletion_page);
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



            passingScore.setTextColor(Color.GREEN);

            int score = (int)((scoreInt/total)*100);

            if(score >= 80)
            {
                totalScore.setTextColor(Color.GREEN);
                failedMessage.setVisibility(View.INVISIBLE);
            }
            else
            {
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
