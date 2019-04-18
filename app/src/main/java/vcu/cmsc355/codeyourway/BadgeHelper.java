package vcu.cmsc355.codeyourway;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


    public class BadgeHelper extends BaseAdapter {
    private Context mContext;

    // Constructor
    public BadgeHelper(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imageIDs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(225, 225));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imageIDs[position]);
        return imageView;
    }

    //Referencing images in one array to pass to Gridview
    public Integer[] imageIDs = {
            R.drawable.badge11,R.drawable.badge12,R.drawable.badge13,R.drawable.badge14,R.drawable.badge15,R.drawable.badge16,
            R.drawable.badge21,R.drawable.badge22,R.drawable.badge23,R.drawable.badge24,R.drawable.badge25,R.drawable.badge26,
            R.drawable.badge31,R.drawable.badge32,R.drawable.badge33,R.drawable.badge34,R.drawable.badge35,R.drawable.badge36,
            R.drawable.badge41,R.drawable.badge42,R.drawable.badge43,R.drawable.badge44,R.drawable.badge45,R.drawable.badge46,
            R.drawable.badge51,R.drawable.badge52,R.drawable.badge53,R.drawable.badge54,R.drawable.badge55,R.drawable.badge56,
            R.drawable.extra1,R.drawable.extra2,R.drawable.extra3
    };
}
