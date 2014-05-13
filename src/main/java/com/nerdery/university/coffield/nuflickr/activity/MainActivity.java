package com.nerdery.university.coffield.nuflickr.activity;

import android.os.Bundle;
import android.view.Menu;
import com.nerdery.university.coffield.nuflickr.R;
import com.nerdery.university.coffield.nuflickr.fragment.FlickrPhotosListFragment;

/**
 * Main activity of the application
 */
public class MainActivity extends BaseActivity implements FlickrPhotosListFragment.OnFragmentInteractionListener {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if( savedInstanceState == null ) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new FlickrPhotosListFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}
