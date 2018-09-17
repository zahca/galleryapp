package com.zacha.galleryapp;

public class Flickr {

    private FlickrPhotos flickrPhotos;

    public Flickr(){
        flickrPhotos = new FlickrPhotos();
    }

    public FlickrPhotos getFlickrPhotos() {
        return flickrPhotos;
    }
}
