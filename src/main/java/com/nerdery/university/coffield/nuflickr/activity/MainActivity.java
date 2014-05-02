package com.nerdery.university.coffield.nuflickr.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;
import com.nerdery.university.coffield.nuflickr.R;
import com.nerdery.university.coffield.nuflickr.fragment.FlickrPhotosListFragment;

/**
 * Main activity of the application
 */
public class MainActivity extends BaseActivity implements FlickrPhotosListFragment.OnFragmentInteractionListener {

    private RequestQueue requestQueue;
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

    public RequestQueue getRequestQueue() {
        if( requestQueue == null ) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // Set the default tag if empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if( requestQueue != null ) {
            requestQueue.cancelAll(tag);
        }
    }
}
