package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static vcu.cmsc355.codeyourway.R.id.btn_home;

public class ExtraChallengesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_challenges);
        Button buttonHome,buttonBadgeList;
        buttonHome = findViewById(R.id.btn_home);
        buttonBadgeList = findViewById(R.id.btn_badges_list);





        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {                                               //take to the home page
                Intent homeIntent = new Intent(ExtraChallengesActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });


        buttonBadgeList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(ExtraChallengesActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });


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
                startActivity(new Intent(ExtraChallengesActivity.this, ProfileActivity.class));
                finish();
                break;

            case R.id.HallOfFame:
                Toast.makeText(this, "Opening LeaderBoardActivity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ExtraChallengesActivity.this, LeaderBoardActivity.class));
                finish();
                break;

            case R.id.home_menu:
                Toast.makeText(this, "Going Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,HomeActivity.class));
                finish();
                break;
        }
        return true;

    }



}
