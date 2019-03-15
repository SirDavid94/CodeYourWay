package vcu.cmsc355.codeyourway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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

}
