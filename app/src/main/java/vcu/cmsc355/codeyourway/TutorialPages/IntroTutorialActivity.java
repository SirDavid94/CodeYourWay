package vcu.cmsc355.codeyourway.TutorialPages;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vcu.cmsc355.codeyourway.GamePlay;
import vcu.cmsc355.codeyourway.R;

public class IntroTutorialActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_to_programming);


        TextView tutorialView;
        Button BtContinue;


        BtContinue = (Button) findViewById(R.id.ContinueIntro);

        BtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroTutorialActivity.this, GamePlay.class));
            }
        });


    }

}

