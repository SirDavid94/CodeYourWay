package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
                startActivity(new Intent(this, ProfileActivity.class));
                finish();
                break;
        }
        return true;

    }
}
