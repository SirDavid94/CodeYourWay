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
import vcu.cmsc355.codeyourway.Model.Common;

public class SettingsActivity extends AppCompatActivity {
    Button saveButton;
    private Switch modeSwitch;
    Common displayMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Checks NightMode Status and updates Value
        displayMode = new Common(this);

        //Turns on nightmode if true
        if( displayMode.getNightMode()==true) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            //uses default theme if otherwise
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        modeSwitch = findViewById(R.id.Theme_Switch);
        // checks to see if Switched is turned left or right
        if(displayMode.getNightMode() == true) {
            modeSwitch.setChecked(true);
        }


        saveButton = (Button) findViewById(R.id.saveButton);
        //Button directs us to Homepage after changing preferences
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, HomeActivity.class));

            }
        });


        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked)
                { //Turns on NightMode when slided to right side
                    displayMode.setNightMode(true);
                    restartApp();
                } else {
                    //Turns off NightMode when slided to left side
                    displayMode.setNightMode(false);
                    restartApp();
                }

            }
        });
    }

    private void restartApp() {
        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
        finish();
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
