package com.nerdery.university.coffield.nuflickr.activity;

import android.view.View;
import android.widget.AdapterView;
import com.nerdery.university.coffield.nuflickr.R;

import android.os.Bundle;
import android.view.Menu;
import com.nerdery.university.coffield.nuflickr.fragment.FlickrPhotosListFragment;

import javax.swing.text.html.ListView;

/**
 * Main activity of the application
 */
public class MainActivity extends BaseActivity implements android.widget.ListView.OnItemClickListener {

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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
