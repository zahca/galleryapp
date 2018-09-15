package com.zacha.galleryapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchImages extends AsyncTask<ImageView,Void,Bitmap> {

    ImageView imageView;

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
        List result = new ArrayList();
        Integer totalCount = photos.size();
        Integer currentIndex = 0;
        Bitmap bitmapThumbnail = null;
        for (FlickrPhoto photo : photos) {
            currentIndex++;
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
            //result.add(new ImageInfo(photo.getTitle(),bitmapThumbnail ,bitmapMedium ));
            //publishProgress(currentIndex, totalCount);
        }
        //currentAppData.setImageInfos(result);
        return bitmapThumbnail;
    }

    @Override
    protected void onPostExecute(Bitmap result){

    }
}
