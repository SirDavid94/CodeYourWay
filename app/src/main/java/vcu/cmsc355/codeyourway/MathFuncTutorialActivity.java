package vcu.cmsc355.codeyourway;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MathFuncTutorialActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_fucntions);


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
                Intent questionsIntent = new Intent(MathFuncTutorialActivity.this, MCquestionActivity.class);
                startActivity(questionsIntent);
                Toast.makeText(this, "Button Under Development", Toast.LENGTH_SHORT).show();
                break;

            case R.id.skipButton:
                goToMathLvl();
                break;
        }

    }


    private void goToMathLvl()
    {
        startActivity(new Intent(this, SelectLevelArrayActivity.class));
        finish();
    }
}

