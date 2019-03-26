package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.QuestionScore;

public class Done extends AppCompatActivity {

    Button btnTryAgain, btnNextLevel;
    TextView txtResultScore,getTxtResultQuestion;
    ProgressBar progressBar;

    //Firebase instance
    FirebaseDatabase database;
    DatabaseReference ScoresDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        database = FirebaseDatabase.getInstance();
        ScoresDatabase = database.getReference("Question_Score");

        txtResultScore = (TextView) findViewById(R.id.txtTotalScore);
        getTxtResultQuestion = (TextView) findViewById(R.id.txtTotalQuestion);
        progressBar = (ProgressBar) findViewById(R.id.doneProgressBar);
        btnTryAgain = (Button)findViewById(R.id.btnTryAgain);
        btnNextLevel = (Button) findViewById(R.id.btnNextLevel);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tryAgain = new Intent(Done.this,GamePlay.class);
                startActivity(tryAgain);
                finish();
            }
        });

        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextLevel = new Intent(Done.this,HomeActivity.class);
                startActivity(nextLevel);
                finish();
            }
        });

        Bundle extra = getIntent().getExtras();
        if (extra != null)
        {
            int score = extra.getInt("SCORE");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");

            txtResultScore.setText(String.format("SCORE : %d", score));
            getTxtResultQuestion.setText(String.format("CORRECT : %d / %d", correctAnswer, totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);

            ScoresDatabase.child(String.format("%s_%s", Common.currentUser.getUsername(), Common.CategoryID))
                .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser.getUsername(), Common.CategoryID),
                        Common.currentUser.getUsername(),
                        String.valueOf(score)));

        }

    }
}
