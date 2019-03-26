package vcu.cmsc355.codeyourway.TutorialPages;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vcu.cmsc355.codeyourway.GameLevel.LevelSelectionActivity;
import vcu.cmsc355.codeyourway.GamePlay;
import vcu.cmsc355.codeyourway.R;
import vcu.cmsc355.codeyourway.SelectLevelArrayActivity;

public class ArraysTutorialActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays);


        TextView tutorialView;
        TextView moduleID;
        Button BtContinue;


        BtContinue = (Button) findViewById(R.id.ContinueArrays);
        moduleID = findViewById(R.id.ArraysModuleID);

        Bundle bundle = getIntent().getExtras();
        String module = bundle.getString("module");



        BtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelSelection = new Intent(ArraysTutorialActivity.this, LevelSelectionActivity.class);
                levelSelection.putExtra("moduleID",5);
                startActivity(levelSelection);
            }
        });

    }




}





