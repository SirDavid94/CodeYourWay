package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WalkthroughActivity extends AppCompatActivity implements View.OnClickListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        Button BnNext;
        Button BnSkip;

        BnNext = (Button) findViewById(R.id.skipbttn);
        BnSkip = (Button) findViewById(R.id.nextbttn);
        BnNext.setOnClickListener(this);
        BnSkip.setOnClickListener(this);



    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.skipbttn:
                break;

            case R.id.nextbttn:
            loadHome();
                break;
        }

    }

    private void loadHome()
    {
        startActivity(new Intent(this,WalkthroughActivity.class));
        finish();
    }

}



