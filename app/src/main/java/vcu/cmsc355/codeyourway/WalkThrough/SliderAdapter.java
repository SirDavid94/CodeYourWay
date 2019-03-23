package vcu.cmsc355.codeyourway.WalkThrough;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import vcu.cmsc355.codeyourway.R;

public class SliderAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public int[] lst_image = {
        R.drawable.logo,
        R.drawable.logo,
        R.drawable.logo,
        R.drawable.logo
    };

    public String[] lst_title = {
            "Welcome",
            "Learn",
            "Code",
            "Play"
    };

    public String[] lst_description = {
            "Welcome to code Your way, With us You'll learn to code from beginning ",
            "Description 2",
            "Description 3",
            "Description 4"
        };


    public int[] lst_backgroundColor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
        Color.rgb(110,49,89),
        Color.rgb(1,188,212)

    };



    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    /*@NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider,container,false);
        LinearLayout layoutSlide = (LinearLayout) view.findViewById(R.id.SliderLayout);
        ImageView imgSlide = (ImageView) view.findViewById(R.id.slideImg);
        TextView textTitle = ( TextView) view.findViewById(R.id.sliderTitle);
        TextView description = ( TextView) view.findViewById(R.id.sliderDesc);
        //layoutSlide.setBackgroundColor(lst_backgroundColor(position));

    };*/


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
