package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;
import vcu.cmsc355.codeyourway.TutorialPages.SelectionsTutorialActivity;

public class SettingsActivity extends AppCompatActivity {
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        backButton = (Button) findViewById(R.id.backbutton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(SettingsActivity.this, HomeActivity.class));
                onBackPressed();
            }
        });

        Switch  modeSwitch = findViewById(R.id.Theme_Switch);
        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked)
                { //Turns on Nightmode when slide to right
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    //Turns off Nightmode when slide to left
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

            }
        });
    }

    @Override

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
                startActivity(new Intent(SettingsActivity.this, ProfileActivity.class));
                finish();
                break;

            case R.id.HallOfFame:
                Toast.makeText(this, "Opening LeaderBoardActivity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LeaderBoardActivity.class));
                finish();
                break;

            case R.id.home_menu:
                Toast.makeText(this, "Going Home", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
        return true;

    }

}
