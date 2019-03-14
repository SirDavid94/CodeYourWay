//Nazmus Saqib
package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RandomFacts extends AppCompatActivity {
    TextView        next_random;        //show the next random facts
    Button          home;               //bottom right button
    Button          settings;           //bottom left

    DatabaseHelper  db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_facts);
        db          =       new DatabaseHelper(this);
        next_random =       (TextView) findViewById(R.id.Show_next_page);               //Shows the next random facts
        home        =       (Button)findViewById(R.id.home_from_random_facts);          //home button
        settings    =       (Button)findViewById(R.id.settings_from_random_activity);   //setting button
        settings.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent settingsIntent = new Intent(RandomFacts.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {                            //take to the home page
            public void onClick(View v) {
                Intent homeIntent = new Intent(RandomFacts.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });
    }
            }
