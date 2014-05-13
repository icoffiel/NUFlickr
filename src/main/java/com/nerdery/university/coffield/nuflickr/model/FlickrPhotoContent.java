package com.nerdery.university.coffield.nuflickr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iain on 5/6/14.
 */
public class FlickrPhotoContent {

    public static List<FlickrPhoto> ITEMS = new ArrayList<FlickrPhoto>();

    static {
        // Add 3 sample items.
        addItem(new FlickrPhoto(1, "Test Owner One", "Secret 1", 1, 1, "Title One", true, true, true ));
        addItem(new FlickrPhoto(2, "Test Owner Two", "Secret 2", 2, 2, "Title Two", true, true, true ));
        addItem(new FlickrPhoto(3, "Test Owner Three", "Secret 3", 3, 3, "Title Three", true, true, true ));
    }

    private static void addItem(FlickrPhoto flickrPhoto) {
        ITEMS.add(flickrPhoto);
    }
}
