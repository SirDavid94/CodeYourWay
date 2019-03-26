package vcu.cmsc355.codeyourway.TutorialPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vcu.cmsc355.codeyourway.GameLevel.LevelSelectionActivity;
import vcu.cmsc355.codeyourway.R;

public class LoopTutorialActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);


        Button BtContinue;
        TextView moduleID;


        BtContinue = (Button) findViewById(R.id.ContinueLoop);
        moduleID = findViewById(R.id.LoopsModuleID);

        Bundle bundle = getIntent().getExtras();
        String module = bundle.getString("module");




        BtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelSelection = new Intent(LoopTutorialActivity.this, LevelSelectionActivity.class);
                levelSelection.putExtra("moduleID",4);
                startActivity(levelSelection);
            }
        });

    }

}





