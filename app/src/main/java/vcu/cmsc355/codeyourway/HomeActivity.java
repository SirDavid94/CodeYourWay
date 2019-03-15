package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button elementaryProgram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        elementaryProgram = (Button)findViewById(R.id.elementaryProgramming);
        elementaryProgram.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, TutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

    }

}
