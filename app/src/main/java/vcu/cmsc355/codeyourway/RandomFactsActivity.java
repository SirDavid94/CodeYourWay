/*
    Created by Namus Saqib
    Purpose for this page is to show random facts of java. If the user is new user, he or she will
    see this page as a 3rd page, old user will see as 2nd page
 */
package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RandomFactsActivity extends AppCompatActivity {
    TextView facts_content;     //display facts
    TextView next_random;       //click to show the next random facts
    Button home;                //bottom right button
    Button settings;            //bottom left
    DatabaseHelper db;          //not implemented will implement when we have sql server
    String display_fact = "";   //Display the fact after randomize

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_facts);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // Change the label for for this activity only
//            Objects.requireNonNull(getSupportActionBar()).setTitle("Random Facts");
//        }

        db = new DatabaseHelper(this);
        facts_content = (TextView) findViewById(R.id.facts_conten);                //display the random facts
        next_random = (TextView) findViewById(R.id.Show_next_page);               //Shows the next random facts
        home = (Button) findViewById(R.id.home_from_random_facts);               //home button
        settings = (Button) findViewById(R.id.settings_from_random_activity);   //setting button

        random_facts();                         //everytime user visit RandomFactsActivity page, they will see a facts
        facts_content.setText(display_fact);   //this should display the random facts

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {                                           //take to the settings page
                Intent settingsIntent = new Intent(RandomFactsActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {                                               //take to the home page
                Intent homeIntent = new Intent(RandomFactsActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        next_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                        //call the random facts method
//                Intent next_randomIntent = new Intent(RandomFactsActivity.this, )
                random_facts();
                facts_content.setText(display_fact); //display the next random facts if clicked on "show me the next random facts"
            }
        });


    }


    public void random_facts() {
        String[] facts = new String[4];                                                 //need this to store 5 random facts about java or Android studio in general
        facts[0] = "The java programming language is developed by james gosling";
        facts[1] = "Java is the second most popular language and is very popular among the developers";
        facts[2] = "Java is free from the concept of Pointer as adding pointers to Java language would compromise security and the robustness, making this language more complex.";
        facts[3] = "In Java, The meaning of Final keyword is not final. It has different meanings in java. It can be Final class, Final method, Final field or Final variable.";

        Random rand = new Random();
        int random_num = rand.nextInt(4);                                         //getting a random number from 0 to 3 to show the random facts
        if (random_num == 4) {
            random_num = 3;
        }
        display_fact = facts[random_num];
    }
}
