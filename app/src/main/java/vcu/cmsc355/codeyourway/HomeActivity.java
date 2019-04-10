package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;
import vcu.cmsc355.codeyourway.TutorialPages.IntroTutorialActivity;
import vcu.cmsc355.codeyourway.TutorialPages.LoopTutorialActivity;
import vcu.cmsc355.codeyourway.TutorialPages.MathFuncTutorialActivity;
import vcu.cmsc355.codeyourway.TutorialPages.SelectionsTutorialActivity;

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


        elementaryProgram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent elementaryIntent = new Intent(HomeActivity.this, IntroTutorialActivity.class);
                startActivity(elementaryIntent);
            }
        });

        loops.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent loops = new Intent(HomeActivity.this, LoopTutorialActivity.class);
                startActivity(loops);
            }
        });

        selections.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent selections = new Intent(HomeActivity.this, SelectionsTutorialActivity.class);
                startActivity(selections);
            }
        });

        mathFunctions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mathFunctions = new Intent(HomeActivity.this, MathFuncTutorialActivity.class);
                startActivity(mathFunctions);
            }
        });

        arrays.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent arrays = new Intent(HomeActivity.this, ArraysTutorialActivity.class);
                startActivity(arrays);
            }
        });

    }


    @Override

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())  {
            case R.id.menuLogout:
                Toast.makeText(this, "Logging user out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                startActivity(new Intent(this,SettingsActivity.class));
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "Opening user profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                finish();
                break;

            case R.id.HallOfFame:
                Toast.makeText(this, "Opening LeaderBoardActivity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, LeaderBoardActivity.class));
                finish();
                break;

            case R.id.home_menu:
                Toast.makeText(this, "Going Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,HomeActivity.class));
                finish();
                break;
        }
        return true;

    }

}
