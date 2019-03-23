package vcu.cmsc355.codeyourway.WalkThrough;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import vcu.cmsc355.codeyourway.R;


public class WalkThroughActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdapter adapterSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_walk_through);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapterSlide = new SliderAdapter(this);
        viewPager.setAdapter(adapterSlide);

    }


}