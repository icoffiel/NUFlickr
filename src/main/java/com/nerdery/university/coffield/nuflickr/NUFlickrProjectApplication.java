package com.nerdery.university.coffield.nuflickr;

import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

/**
 * Created by Iain on 5/6/14.
 */
public class NUFlickrProjectApplication extends BaseProjectApplication {
    private static final String TAG = "NUFlickrProjectApplication";

    // A reference other classes can access
    private static NUFlickrProjectApplication mInstance;

    // Global requests queue for volley
    private RequestQueue requestQueue;

    /**
     * Allow other methods to get the application instance
     * @return
     */
    public static NUFlickrProjectApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Create static instance
        mInstance = this;
    }

    /**
     * Get the request view
     * @return The Volley Request Queue. Will be created if null
     */
    public RequestQueue getRequestQueue() {
        if( requestQueue == null ) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

    /**
     * Adds the specified request to the global queue, if tag is specified
     * then it is used else Default TAG is used.
     *
     * @param req
     * @param tag
     * @param <T>
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // Set the default tag if empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }

    /**
     * Adds the specified request to the global queue using the Default TAG.
     *
     * @param req
     * @param <T>
     */
    public <T> void addToRequestQueue(Request<T> req) {
        // set the default tag if tag is empty
        req.setTag(TAG);

        getRequestQueue().add(req);
    }

    /**
     * Cancels all pending requests by the specified TAG, it is important
     * to specify a TAG so that the pending/ongoing requests can be cancelled.
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if( requestQueue != null ) {
            requestQueue.cancelAll(tag);
        }
    }
}
