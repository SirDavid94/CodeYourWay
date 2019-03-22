package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WalkthroughActivity extends AppCompatActivity implements View.OnClickListener {
        TextView HelloMsg;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        Button BnNext;
        Button BnSkip;
        HelloMsg = (TextView) findViewById(R.id.HelloMsg);
        //HelloMsg.setText("Hello " + LoginActivity.getUser());
        BnNext = (Button) findViewById(R.id.skipbttn);
        BnSkip = (Button) findViewById(R.id.nextbttn);
        BnNext.setOnClickListener(this);
        BnSkip.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.skipbttn:
                loadFacts();
                break;

            case R.id.nextbttn:
                Toast.makeText(this, "Button Under Development", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void loadFacts()
    {
        startActivity(new Intent(this, RandomFactsActivity.class));
        finish();
    }

}



