package com.nerdery.university.coffield.nuflickr.model;

/**
 * Created by Iain on 5/1/14.
 */
public class FlickrPhoto {

    long id;
    String owner;
    String secret;
    long server;
    long farm;
    String title;
    boolean ispublic;
    boolean isfriend;
    boolean isfamily;

    public FlickrPhoto(long id, String owner, String secret, long server, long farm, String title, boolean ispublic,
                       boolean isfriend, boolean isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }

    @Override
    public String toString() {
        return "FlickrPhoto{" +
                "title='" + title + '\'' +
                '}';
    }
}
