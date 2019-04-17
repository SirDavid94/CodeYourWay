package vcu.cmsc355.codeyourway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.app.Activity;
import android.widget.Toast;

public class BadgeActivity extends AppCompatActivity {

    public class AndroidGridViewDisplayImages extends AppCompatActivity {
        Integer[] imageIDs = {
                R.drawable.badge11,R.drawable.badge12,R.drawable.badge13,R.drawable.badge14,
                R.drawable.badge15, R.drawable.badge21,R.drawable.badge22,R.drawable.badge23,
                R.drawable.badge24,R.drawable.badge25, R.drawable.badge31,R.drawable.badge32,
                R.drawable.badge33,R.drawable.badge34,R.drawable.badge35, R.drawable.badge41,
                R.drawable.badge42,R.drawable.badge43,R.drawable.badge44,R.drawable.badge45,
                 R.drawable.badge51,R.drawable.badge52,R.drawable.badge53,R.drawable.badge54,
                R.drawable.badge55, R.drawable.extra1,R.drawable.extra2,R.drawable.extra3
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_badge);
            GridView androidGridView = findViewById(R.id.group);
            androidGridView.setAdapter(new ImageAdapterGridView(this));

            androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent,
                                        View v, int position, long id) {
                    Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
                }
            });

        }

        public class ImageAdapterGridView extends BaseAdapter {
            private Context mContext;
            public ImageAdapterGridView(Context c) {
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

            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView mImageView;

                if (convertView == null) {
                    mImageView = new ImageView(mContext);
                    mImageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                    mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mImageView.setPadding(8, 8, 8, 8);
                } else {
                    mImageView = (ImageView) convertView;
                }
                mImageView.setImageResource(imageIDs[position]);
                return mImageView;
            }
        }
    }
}
