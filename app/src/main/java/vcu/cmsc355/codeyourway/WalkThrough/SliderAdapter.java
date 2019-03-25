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
            "Welcome to CodeYourWay ",
            "Learn",
            "Code",
            "Play"
    };

    public String[] lst_description = {
            "Welcome to code Your way, With us You'll learn to code from beginning, There are tutorials to " +
                    "explain what you get to see in every page and a link to learn more ",
            "There are 6 various Modules in the app containing various levels",
            "You will be presented with various challenges which gets harder with a new level and you get" +
                    "to win a badge for a successful level completion",
            "Also you can play the Extra modules to win more badges and Rank higher than your " +
                    "friends on the Leaderboard "
        };

    public SliderAdapter (Context cOntext ) {
        this.context = cOntext;


    }


    public int[] lst_backgroundColor = {
            Color.WHITE,
            Color.WHITE,
            Color.WHITE,
            Color.WHITE

    };



    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider,container,false);
        LinearLayout layoutSlide = (LinearLayout) view.findViewById(R.id.SliderLayout);
        ImageView imgSlide = (ImageView) view.findViewById(R.id.slideImg);
        TextView textTitle = ( TextView) view.findViewById(R.id.sliderTitle);
        TextView description = ( TextView) view.findViewById(R.id.sliderDesc);
        layoutSlide.setBackgroundColor(lst_backgroundColor[position]);
        imgSlide.setImageResource(lst_image[position]);
        textTitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
