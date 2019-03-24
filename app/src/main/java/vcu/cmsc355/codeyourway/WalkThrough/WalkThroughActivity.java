package vcu.cmsc355.codeyourway.WalkThrough;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import vcu.cmsc355.codeyourway.HomeActivity;
import vcu.cmsc355.codeyourway.R;


public class WalkThroughActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdapter adapterSlide;
    Button buttonNext, buttonSkip, buttonGetStarted;
    int position = 0 ;
    //TabLayout tabIndicator;
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
        //tabIndicator = findViewById(R.id.tab_indicator);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapterSlide = new SliderAdapter(this);
        viewPager.setAdapter(adapterSlide);

        // setup tablayout with viewpager

        // tabIndicator.setupWithViewPager(viewPager);



        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = viewPager.getCurrentItem();
                if (position < 4) {

                    position++;
                    viewPager.setCurrentItem(position);


                }
                if (position == 3) { // when we reach to the last screen


                    loaddLastScreen();


                }


            }


        });

        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WalkThroughActivity.this, HomeActivity.class));

            }


        });

        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WalkThroughActivity.this, HomeActivity.class));

            }


        });

    }

    private void loaddLastScreen() {

        buttonNext.setVisibility(View.INVISIBLE);
        buttonGetStarted.setVisibility(View.VISIBLE);
        buttonSkip.setVisibility(View.INVISIBLE);




    }
}