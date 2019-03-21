package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectSelectionsLevelActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selections_level);


        Button button1 = findViewById(R.id.level1);
        Button button2 = findViewById(R.id.level2);
        Button button3 = findViewById(R.id.level3);
        Button button4 = findViewById(R.id.level4);
        Button button5 = findViewById(R.id.level5);
        Button button6 = findViewById(R.id.level6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.level1:
                Toast.makeText(this, "Level 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level2:
                Toast.makeText(this, "Level 2 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level3:
                Toast.makeText(this, "Level 3 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level4:
                Toast.makeText(this, "Level 4 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level5:
                Toast.makeText(this, "Level 5 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level6:
                Toast.makeText(this, "Level 6 clicked", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(this,SettingsActivity.class));
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "Opening user profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, CreateProfileActivity.class));
                finish();
                break;
        }
        return true;

    }
}