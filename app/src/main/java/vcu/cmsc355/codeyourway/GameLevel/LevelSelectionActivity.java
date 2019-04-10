package vcu.cmsc355.codeyourway.GameLevel;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import vcu.cmsc355.codeyourway.GamePlay;
import vcu.cmsc355.codeyourway.LoginActivity;
import vcu.cmsc355.codeyourway.ProfileActivity;
import vcu.cmsc355.codeyourway.R;
import vcu.cmsc355.codeyourway.SettingsActivity;

public class LevelSelectionActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton backBtn;

    int moduleIdentification, moduleNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        Button button1 = findViewById(R.id.level1);
        Button button2 = findViewById(R.id.level2);
        Button button3 = findViewById(R.id.level3);
        Button button4 = findViewById(R.id.level4);
        Button button5 = findViewById(R.id.level5);
        Button button6 = findViewById(R.id.level6);
        TextView moduleID = findViewById(R.id.ModuleID);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);


        Bundle bundle = getIntent().getExtras();
         moduleNum = bundle.getInt("moduleID");
        moduleID.setText("MOD:  "+moduleNum);

        moduleIdentification = moduleNum;



    }

    public  void backButton(){

        backBtn =





    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.level1:
                Toast.makeText(this, "Starting Level 1 ", Toast.LENGTH_SHORT).show();
                Intent level1 = new Intent (LevelSelectionActivity.this, GamePlay.class);
                level1.putExtra("moduleID", moduleNum);
                level1.putExtra("level", 1);
                startActivity(level1);
                break;

            case R.id.level2:
                Toast.makeText(this, "Starting Level 2 ", Toast.LENGTH_SHORT).show();
                Intent level2 = new Intent (LevelSelectionActivity.this, GamePlay.class);
                level2.putExtra("moduleID", moduleNum);
                level2.putExtra("level", 2);
                startActivity(level2);
                break;

            case R.id.level3:
                Toast.makeText(this, "Starting Level 3 ", Toast.LENGTH_SHORT).show();
                Intent level3 = new Intent (LevelSelectionActivity.this, GamePlay.class);
                level3.putExtra("moduleID", moduleNum);
                level3.putExtra("level", 3);
                startActivity(level3);
                break;

            case R.id.level4:
                Toast.makeText(this, "Starting Level 4 ", Toast.LENGTH_SHORT).show();
                Intent level4 = new Intent (LevelSelectionActivity.this, GamePlay.class);
                level4.putExtra("moduleID", moduleNum);
                level4.putExtra("level", 4);
                startActivity(level4);
                break;

            case R.id.level5:
                Toast.makeText(this, "Starting Level 5 ", Toast.LENGTH_SHORT).show();
                Intent level5 = new Intent (LevelSelectionActivity.this, GamePlay.class);
                level5.putExtra("moduleID", moduleNum);
                level5.putExtra("level", 5);
                startActivity(level5);
                break;

            case R.id.level6:
                Toast.makeText(this, "Starting Level 6 ", Toast.LENGTH_SHORT).show();
                Intent level6 = new Intent (LevelSelectionActivity.this, GamePlay.class);
                level6.putExtra("moduleID", moduleNum);
                level6.putExtra("level", 6);
                startActivity(level6);
                break;
        }
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
                startActivity(new Intent(this, SettingsActivity.class));
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "Opening user profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ProfileActivity.class));
                finish();
                break;
        }
        return true;

    }
}
