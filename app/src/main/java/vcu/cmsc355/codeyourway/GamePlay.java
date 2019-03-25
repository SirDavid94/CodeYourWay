package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.Question;

public class GamePlay extends AppCompatActivity implements View.OnClickListener {
// variable Declaration
    final static long INTERVAL = 1000;
    final static long TIMEOUT = 1000;
    int progressValue = 0;

    int index =0;
    int score = 0;
    int thisQuestion = 0;
    int totalQuestion = 10;
    int correctAnswer;
    ProgressBar progressBar;
    Button buttonA,buttonB,buttonC,buttonD;
    TextView txtScore, txtQuestionNum,question_text, question_fill;


    //Firebase Instantiation
    FirebaseDatabase database;
    DatabaseReference questions;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);

        //firebase reference
        database = FirebaseDatabase.getInstance();
        questions = database.getReference("Questions");
        loadQuestion(Common.CategoryID);

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtQuestionNum = (TextView) findViewById(R.id.txtTotalQuestion);
        question_text = (TextView) findViewById(R.id.questionMultipleAnswer);
        question_fill =  (TextView) findViewById(R.id.questionFillAnswer);
        buttonA = (Button)findViewById(R.id.btnAnswerA);
        buttonB = (Button)findViewById(R.id.btnAnswerB);
        buttonC = (Button)findViewById(R.id.btnAnswerC);
        buttonD = (Button)findViewById(R.id.btnAnswerD);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(index <totalQuestion)
        {
            Button clickedButton = (Button)v;
            if (clickedButton.getText().equals(Common.questionList.get(index).getCorrectAnswer()))
            {
                score+=1;
                correctAnswer++;
                showQuestion(index);
                

            }
            else
            {
                Intent done = new Intent(GamePlay.this, Done.class);
                Bundle dataSend = new Bundle();
                dataSend.putInt("SCORE",score);
                dataSend.putInt("TOTAL",totalQuestion);
                dataSend.putInt("CORRECT",correctAnswer);
                done.putExtras(dataSend);
                startActivity(done);
                finish();
            }

            txtScore.setText(String.format("%d",score));
        }
    }

    private void showQuestion(int index) {

        if (index < totalQuestion)
        {
            thisQuestion++;
            txtQuestionNum.setText(String.format("%d / %d", thisQuestion, totalQuestion));
            progressBar.setProgress(0);
            progressValue=0;

            if (Common.questionList.get(index).getIsFillAnswer().equals ("false"))
            {
                question_text.setText(Common.questionList.get(index).getQuestion());
                question_text.setVisibility(View.VISIBLE);
                question_fill.setVisibility(View.INVISIBLE);
            }

            else

            {
                question_fill.setText(Common.questionList.get(index).getQuestion());
                question_text.setVisibility(View.INVISIBLE);
                question_fill.setVisibility(View.VISIBLE);
            }

            buttonA.setText(Common.questionList.get(index).getAnswerA());
            buttonB.setText(Common.questionList.get(index).getAnswerB());
            buttonC.setText(Common.questionList.get(index).getAnswerC());
            buttonD.setText(Common.questionList.get(index).getAnswerD());


        }
        else
        {
            //Final Question
            Intent done = new Intent(GamePlay.this, Done.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE",score);
            dataSend.putInt("TOTAL",totalQuestion);
            dataSend.putInt("CORRECT",correctAnswer);
            done.putExtras(dataSend);
            startActivity(done);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        totalQuestion = Common.questionList.size();
        //progressBar.setProgress(0);
        progressValue++;
    }

    private void loadQuestion(String categoryId)
    {
        if ( Common.questionList.size() > 0)
        {
            Common.questionList.clear();
        }

       questions.orderByChild("CategoryID").equalTo(categoryId)
               .addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       for (DataSnapshot postSnapshot : dataSnapshot.getChildren())
                       {
                           Question ques = postSnapshot.getValue(Question.class);
                           Common.questionList.add(ques);
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });

        Collections.shuffle(Common.questionList);

    }

}
