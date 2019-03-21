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

        Button BnNext; //Next Button
        Button BnSkip;  //Skip Button
        HelloMsg = (TextView) findViewById(R.id.HelloMsg); // Implementing message to screen
        HelloMsg.setText("Hello " + LoginActivity.getUser()); // Displays "Hello" and the username
        BnNext = (Button) findViewById(R.id.skipbttn); //Initializing skip button
        BnSkip = (Button) findViewById(R.id.nextbttn); //Initializing next button
        BnNext.setOnClickListener(this);
        BnSkip.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) //Creating switch statement to see what user selects
        {
            case R.id.skipbttn: //If they choose to skip it will take them to RandomFactsActivity
                loadFacts();
                break;

            case R.id.nextbttn: //If they choose next
                Toast.makeText(this, "Button Under Development", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void loadFacts()
    {
        startActivity(new Intent(this, RandomFactsActivity.class)); //Takes them to the next activity which is the RandomFactsActivity
        finish();
    }

}



