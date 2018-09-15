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
        for (FlickrPhoto photo : photos) {
            currentIndex++;
            List sizes = flickr.getFlickrPhotos().getSizes(photo.getId());
            String thumbnailUrl = sizes.get(0).getSource();
            String mediumUrl = sizes.get(4).getSource();
            InputStream inputStreamThumbnail = null,inputStreamMedium=null;
            try {
                inputStreamThumbnail = new URL(thumbnailUrl).openStream();
                inputStreamMedium = new URL(mediumUrl).openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmapThumbnail = BitmapFactory.decodeStream(inputStreamThumbnail);
            Bitmap bitmapMedium = BitmapFactory.decodeStream(inputStreamMedium);
            result.add(new ImageInfo(photo.getTitle(),bitmapThumbnail ,bitmapMedium ));
            publishProgress(currentIndex, totalCount);
        }
        currentAppData.setImageInfos(result);*/
        //return result;
        return null;
    }
}
