package com.zacha.galleryapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class FetchImages extends AsyncTask<ImageView,Void,Bitmap> {

    FlickrPhotoAdapter photoAdapter;
    Context context;

    public FetchImages(FlickrPhotoAdapter photoAdapter, Context context){
        super();
        this.photoAdapter = photoAdapter;
        this.context = context;
    }


    @Override
    protected Bitmap doInBackground(ImageView... imageViews) {
        Flickr flickr = new Flickr(null, "UTF-8");
        List<FlickrPhoto> photos = null;
        try {
            photos = flickr.getFlickrPhotos().getPhotos();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Bitmap bitmapThumbnail = null;
        for (FlickrPhoto photo : photos) {
            URL smallPhotoURL = null;
            try {
                smallPhotoURL = flickr.getFlickrPhotos().getSmallPhoto(photo.getURL());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            InputStream inputStreamSmall = null;
            try {
                inputStreamSmall = smallPhotoURL.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmapThumbnail = BitmapFactory.decodeStream(inputStreamSmall);
            photoAdapter.onImageDownload(bitmapThumbnail,photo);
        }
        //currentAppData.setImageInfos(result);
        return bitmapThumbnail;
    }


    @Override
    protected void onPostExecute( Bitmap bitmap ) {
    }
}
