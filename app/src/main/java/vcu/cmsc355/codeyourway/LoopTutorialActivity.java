package vcu.cmsc355.codeyourway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoopTutorialActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);



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
                Toast.makeText(this, "Button Under Development", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
