package helloworld.example.com.hw4_a;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // in order to react to user touch.
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageView imageView = (ImageView) v;
                imageView.setImageResource(R.drawable.changed1); // change image.
            }
        });
    }

    public class ImageAdapter extends BaseAdapter { //extend BaseAdapter to connect gridView.
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
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
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]); //set each element with image.
            return imageView;
        }

        // references to our images
        public Integer[] mThumbIds = {R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,R.drawable.original1,
                R.drawable.original1}; //image array.
    }
}
