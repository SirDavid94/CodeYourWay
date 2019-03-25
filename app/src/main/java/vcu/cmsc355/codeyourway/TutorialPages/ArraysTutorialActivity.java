package vcu.cmsc355.codeyourway.TutorialPages;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vcu.cmsc355.codeyourway.R;
import vcu.cmsc355.codeyourway.SelectLevelArrayActivity;

public class ArraysTutorialActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays);


        TextView tutorialView;
        Button BtNext;
        Button BtSkip;

        BtNext = (Button) findViewById(R.id.nextButton);
        BtSkip = (Button) findViewById(R.id.skipButton);

        BtNext.setOnClickListener(this);
        BtSkip.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextButton:
                Toast.makeText(this, "Button Under Development", Toast.LENGTH_SHORT).show();
                break;

            case R.id.skipButton:
                goToArrLvl();
                break;
        }

    }


    private void goToArrLvl()
    {
        startActivity(new Intent(this, SelectLevelArrayActivity.class));
        finish();
    }
}

