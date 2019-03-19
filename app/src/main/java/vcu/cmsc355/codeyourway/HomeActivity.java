package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button elementaryProgram;
    Button loops;
    Button selections;
    Button mathFunctions;
    Button arrays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        elementaryProgram = (Button)findViewById(R.id.introToProgramming);
        loops = (Button)findViewById(R.id.Loops);
        selections = (Button)findViewById(R.id.SelectionsModule);
        mathFunctions = (Button)findViewById(R.id.MathFunc);
        arrays = (Button)findViewById(R.id.SingleDimArray);


        elementaryProgram.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, IntroTutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

        loops.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, LoopTutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

        selections.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, SelectionsTutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

        mathFunctions.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, MathFuncTutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

        arrays.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, ArraysTutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

    }

}
