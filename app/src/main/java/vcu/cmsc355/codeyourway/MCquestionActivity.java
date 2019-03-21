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

public class MCquestionActivity extends AppCompatActivity {
    TextView    level_header;           //display facts
    TextView    questions_num;          //click to show the next random facts
    Button      submit;                 //middle submit button
    TextView    question;               //question user going to see
    DatabaseHelper db;                  //not implemented
    RadioButton question1;              //answer options user going to choose
    RadioButton question2;              //
    RadioButton question3;              //
    RadioButton question4;              //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcquestion);

        db              =    new DatabaseHelper(this);
        level_header    =   (TextView) findViewById(R.id.levelnumber);               //display current level
        questions_num   =   (TextView) findViewById(R.id.question_header);          //Shows the question number
        submit          =   (Button) findViewById(R.id.submit);                    //submit button
        question1      =   (RadioButton) findViewById(R.id.MCQ_radioButton1);     //answers to choose
        question2      =   (RadioButton) findViewById(R.id.MCQ_radioButton2);
        question3      =   (RadioButton) findViewById(R.id.MCQ_radioButton3);
        question4      =   (RadioButton) findViewById(R.id.MCQ_radioButton4);
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        question1.setBackgroundColor(Color.GREEN);
    }
});

    }

}
