package vcu.cmsc355.codeyourway;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Collections;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.Question;

public class GamePlay extends AppCompatActivity {

    int moduleID = 0;
    int levelID = 0;
    int index = 0;
    int correct = 0;
    int wrong  = 0;
    int total = 1;
    DatabaseReference reference;
    int correctAnswer;
    ProgressBar progressBar;
    Button buttonA, buttonB, buttonC, buttonD;
    TextView txtScore, txtQuestionNum, question_text;
    TextView currentModule, currentLevel;


    //Firebase Instantiation
    FirebaseDatabase database;
    DatabaseReference questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);

        //firebase reference
        database = FirebaseDatabase.getInstance();
        questions = database.getReference("module1");

        currentModule  = findViewById(R.id.CurrentModule);
        currentLevel   = findViewById(R.id.CurrentLevel);
        txtQuestionNum = findViewById(R.id.txtTotalQuestion);
        question_text  = findViewById(R.id.questionMultipleAnswer);
        buttonA        = findViewById(R.id.btnAnswerA);
        buttonB        = findViewById(R.id.btnAnswerB);
        buttonC        = findViewById(R.id.btnAnswerC);
        buttonD        = findViewById(R.id.btnAnswerD);


        Bundle bundle = getIntent().getExtras();
         moduleID = bundle.getInt("moduleID");
         levelID  = bundle.getInt("level");

         currentLevel.setText( "LVL : "+ levelID);
         currentModule.setText("MOD : "+moduleID);

        UpdateQuestion();
    }

    private void UpdateQuestion() {


        if (total > 5)
        {
            // Open Done Activity
            onFinish();
        }

        else
        {

            reference = FirebaseDatabase.getInstance().getReference().child("module1").child(String.valueOf(total));
            //questions.child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    question_text.setText(question.getQuestion());
                    buttonA.setText(question.getAnswerA());
                    buttonB.setText(question.getAnswerB());
                    buttonC.setText(question.getAnswerC());
                    buttonD.setText(question.getAnswerD());


                    buttonA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (buttonA.getText().toString().equals(question.getCorrectAnswer()))
                            {
                                buttonA.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        buttonA.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        UpdateQuestion();
                                    }
                                },1500);
                            }

                            else {
                                //answer is wrong...  Correct answer turns green and selection t

                                wrong++;

                                buttonA.setBackgroundColor(Color.RED);


                                if (buttonB.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonB.setBackgroundColor(Color.GREEN);

                                }
                                else if (buttonC.getText().toString().equals(question.getCorrectAnswer() ))
                                {
                                    buttonC.setBackgroundColor(Color.GREEN);
                                }

                                else if ( buttonD.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonD.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        buttonA.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonB.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonC.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonD.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        UpdateQuestion();
                                    }
                                },1500);



                            }
                        }
                    });


                    buttonB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (buttonB.getText().toString().equals(question.getCorrectAnswer()))
                            {
                                buttonB.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        buttonB.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        UpdateQuestion();
                                    }
                                },1500);
                            }

                            else {
                                //answer is wrong...  Correct answer turns green and selection t

                                wrong++;

                                buttonB.setBackgroundColor(Color.RED);


                                if (buttonA.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonA.setBackgroundColor(Color.GREEN);

                                }
                                else if (buttonC.getText().toString().equals(question.getCorrectAnswer() ))
                                {
                                    buttonC.setBackgroundColor(Color.GREEN);
                                }

                                else if ( buttonD.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonD.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        buttonA.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonB.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonC.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonD.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        UpdateQuestion();
                                    }
                                },1500);



                            }

                        }
                    });


                    buttonC.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (buttonC.getText().toString().equals(question.getCorrectAnswer()))
                            {
                                buttonC.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        buttonC.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        UpdateQuestion();
                                    }
                                },1500);
                            }

                            else {
                                //answer is wrong...  Correct answer turns green and selection t

                                wrong++;

                                buttonC.setBackgroundColor(Color.RED);


                                if (buttonB.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonB.setBackgroundColor(Color.GREEN);

                                }
                                else if (buttonA.getText().toString().equals(question.getCorrectAnswer() ))
                                {
                                    buttonA.setBackgroundColor(Color.GREEN);
                                }

                                else if ( buttonD.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonD.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        buttonA.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonB.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonC.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonD.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        UpdateQuestion();
                                    }
                                },1500);



                            }
                        }
                    });

                    buttonD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (buttonD.getText().toString().equals(question.getCorrectAnswer()))
                            {
                                buttonD.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        buttonD.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        UpdateQuestion();
                                    }
                                },1500);
                            }

                            else {
                                //answer is wrong...  Correct answer turns green and selection t

                                wrong++;

                                buttonD.setBackgroundColor(Color.RED);


                                if (buttonB.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonB.setBackgroundColor(Color.GREEN);

                                }
                                else if (buttonC.getText().toString().equals(question.getCorrectAnswer() ))
                                {
                                    buttonC.setBackgroundColor(Color.GREEN);
                                }

                                else if ( buttonA.getText().toString().equals(question.getCorrectAnswer()))
                                {
                                    buttonA.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        buttonA.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonB.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonC.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        buttonD.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        UpdateQuestion();
                                    }
                                },1500);



                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            total++;
        }


        }
    public void onFinish() {
       // tv.setText("Completed");
        Intent completed = new Intent(GamePlay.this, LevelCompletionActivity.class);
        completed.putExtra("total",String.valueOf(total));
        completed.putExtra("correct",String.valueOf(correct));
        completed.putExtra("Incorrect",String.valueOf(wrong));
        startActivity(completed);
    }

}