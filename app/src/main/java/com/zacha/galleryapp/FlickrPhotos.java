package com.zacha.galleryapp;

import android.util.JsonReader;

import java.io.InputStreamReader;
import java.util.List;

public class FlickrPhotos {
    private String apiKey;
    private String format;

    public FlickrPhotos(String apiKey, String format){
        this.apiKey = apiKey;
        this.format = format;
    }

    public List<FlickrPhoto> getPhotos() {
        JsonReader jsonHttpClient = new JsonReader(new InputStreamReader(in, "UTF-8"));
        String url = String.format(/*replace this with given url */, format, apiKey);
        PhotoSetsJSON photoSetJson = jsonHttpClient.Get(url, new ArrayList<NameValuePair>(), PhotoSetsJSON.class);
        return photoSetJson.getPhotoset().getPhoto();
    }
}
