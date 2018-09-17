package com.zacha.galleryapp;

import android.media.Image;

import java.net.URL;

public class FlickrPhoto {
    Image img;
    private URL url;
    private Integer size; //find out which units they use
    private Integer height;
    private Integer width;
    private String title;

    public FlickrPhoto(URL url, String title ) {
            this.url = url;
            this.title = title;
    }

    public Integer getSize(){
        return this.size;
    }

    public Integer getHeight(){
        return this.height;
    }

    public Integer getWidth(){
        return this.width;
    }

    public String getTitle(){
        return this.title;
    }
    public URL getURL(){
        return this.url;
    }


}
