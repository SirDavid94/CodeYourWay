/*
Nazmus Saqib
 */
package vcu.cmsc355.codeyourway;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MCquestionActivity extends AppCompatActivity {
    TextView level_header;           //display facts
    TextView questions_num;          //shows the question number
    Button submit;                   //middle submit button
    TextView question;               //question user

    // going to see
    DatabaseHelper db;               //not implemented
    RadioButton answer1;             //answer options user going to choose
    RadioButton answer2;             //
    RadioButton answer3;             //
    RadioButton answer4;             //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcquestion);

        db = new DatabaseHelper(this);
        level_header    = (TextView) findViewById(R.id.levelnumber);               //display current level
        questions_num   = (TextView) findViewById(R.id.question_header);          //Shows the question number
        submit          = (Button) findViewById(R.id.submit);                    //submit button
        question        = (TextView) findViewById(R.id.actual_question);        //shows the question
        answer1         = (RadioButton) findViewById(R.id.MCQ_radioButton1);   //answers to choose
        answer2         = (RadioButton) findViewById(R.id.MCQ_radioButton2);
        answer3         = (RadioButton) findViewById(R.id.MCQ_radioButton3);
        answer4         = (RadioButton) findViewById(R.id.MCQ_radioButton4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setBackgroundColor(Color.GREEN);
            }
        });

    }

    private void getAnswers(String question, String first, String second, String third, String fourth) { //this method should all the questions and answers. the answers will be placed randomly

        this.question.setText(question);// show the question in the text box

        //here on out I created algorithm to show answers randomly
        int random_numbers[] = new int[4];
        for (int i = 0; i < 4; i++) {
            random_numbers[i] = i;
        }
        Collections.shuffle(Arrays.asList(random_numbers)); /*putting random numbers in the array
                                                                to show the answer choice randomly*/
        if(random_numbers[0]==0){       //placing the answers randomly
            answer1.setText(first);     //(I am sorry if I did bad job, also tried to make it as simple as possible)
            answer2.setText(second);
            answer3.setText(third);
            answer4.setText(fourth);
        }else if(random_numbers[0]==1){
            answer1.setText(fourth);
            answer2.setText(third);
            answer3.setText(second);
            answer4.setText(first);
        }else if(random_numbers[0]==3){
            answer1.setText(second);
            answer2.setText(first);
            answer3.setText(fourth);
            answer4.setText(third);
        }else if(random_numbers[0]==4){
            answer1.setText(third);
            answer2.setText(fourth);
            answer3.setText(first);
            answer4.setText(second);
        }

    }

}
