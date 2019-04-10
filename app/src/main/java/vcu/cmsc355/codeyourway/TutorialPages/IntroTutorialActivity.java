package vcu.cmsc355.codeyourway.TutorialPages;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vcu.cmsc355.codeyourway.GameLevel.LevelSelectionActivity;
import vcu.cmsc355.codeyourway.GamePlay;
import vcu.cmsc355.codeyourway.HomeActivity;
import vcu.cmsc355.codeyourway.LeaderBoardActivity;
import vcu.cmsc355.codeyourway.LoginActivity;
import vcu.cmsc355.codeyourway.ProfileActivity;
import vcu.cmsc355.codeyourway.R;
import vcu.cmsc355.codeyourway.SettingsActivity;

public class IntroTutorialActivity extends AppCompatActivity {
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_to_programming);

        Button backButton;
        backButton = (Button) findViewById(R.id.backbtn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button BtContinue;
        BtContinue = (Button) findViewById(R.id.ContinueIntro);



        BtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelSelection = new Intent(IntroTutorialActivity.this, LevelSelectionActivity.class);
                levelSelection.putExtra("moduleID", 1);
                startActivity(levelSelection);
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:
                Toast.makeText(this, "Logging user out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                startActivity(new Intent(this, SettingsActivity.class));
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "Opening user profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(IntroTutorialActivity.this, ProfileActivity.class));
                finish();
                break;

            case R.id.HallOfFame:
                Toast.makeText(this, "Opening LeaderBoardActivity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LeaderBoardActivity.class));
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

