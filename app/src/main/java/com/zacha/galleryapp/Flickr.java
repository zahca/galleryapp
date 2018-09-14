package com.zacha.galleryapp;

public class Flickr {

    private String apiKey;
    private String format;
    private FlickrPhotos flickrPhotos;

    public Flickr(String apiKey, String format){
        this.apiKey = apiKey;
        this.format = format;
        flickrPhotos = new FlickrPhotos(apiKey, format);
    }

    public FlickrPhotos getFlickrPhotos() {
        return flickrPhotos;
    }
}
