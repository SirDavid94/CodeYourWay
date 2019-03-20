package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LevelCompletionActivity extends AppCompatActivity {
    Button tryAgain;
    Button nextLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelcompletion_page);


        tryAgain = (Button) findViewById(R.id.tryAgainButton);
        nextLevel = (Button) findViewById(R.id.nextLevelButton);


        tryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent tryAgainIntent = new Intent(LevelCompletionActivity.this, HomeActivity.class);
                startActivity(tryAgainIntent);
            }
        });

        nextLevel.setOnClickListener(new View.OnClickListener() {                        //take to the settings page
            public void onClick(View v) {
                Toast.makeText(LevelCompletionActivity.this, "Button Under Development", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
