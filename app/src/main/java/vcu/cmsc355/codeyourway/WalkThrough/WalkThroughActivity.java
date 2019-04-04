package vcu.cmsc355.codeyourway.WalkThrough;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import vcu.cmsc355.codeyourway.HomeActivity;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.R;
import vcu.cmsc355.codeyourway.RandomFactsActivity;


public class WalkThroughActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdapter adapterSlide;
    Button buttonNext, buttonSkip, buttonGetStarted;
    TextView helloMsg;
    int position = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // make the activity on full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_walk_through);

        // hide the action bar

        getSupportActionBar().hide();
        buttonNext = findViewById(R.id.btn_next);
        buttonSkip = findViewById(R.id.tv_skip);
        buttonGetStarted = findViewById(R.id.btn_get_started);
        helloMsg =  findViewById(R.id.HelloMsg);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapterSlide = new SliderAdapter(this);
        viewPager.setAdapter(adapterSlide);


        Bundle bundle = getIntent().getExtras();
       // String username = bundle.getString("username");
        //helloMsg.setText("Hello "+ username);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = viewPager.getCurrentItem();
                if (position < 4) {

                    position++;
                    viewPager.setCurrentItem(position);


                }
                if (position == 3) { // when we reach to the last screen


                    loadLastScreen();


                }


            }


        });

        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WalkThroughActivity.this, RandomFactsActivity.class));

            }


        });

        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WalkThroughActivity.this, RandomFactsActivity.class));

            }


        });

    }
    private void loadLastScreen() {

        buttonNext.setVisibility(View.INVISIBLE);
        buttonGetStarted.setVisibility(View.VISIBLE);
        buttonSkip.setVisibility(View.INVISIBLE);

    }
}