package com.zacha.galleryapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FlickrPhotoAdapter extends BaseAdapter{

    private Activity activity;
    ArrayList<Bitmap> bitmaps;
    ArrayList<FlickrPhoto> flickrPhotos;

    public FlickrPhotoAdapter(Activity activity){
        this.activity = activity;
        bitmaps = new ArrayList<>();
        flickrPhotos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return bitmaps.size();
    }

    @Override
    public Object getItem(int i) {
        return bitmaps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        LinearLayout container ;
        TextView textView;
        PhotoInfo photoInfo = new PhotoInfo(activity.getApplicationContext());
        FlickrPhoto flickrPhoto = flickrPhotos.get(i);
        if (convertView == null) {

            textView = new TextView(activity.getApplicationContext());

            imageView = new ImageView(activity.getApplicationContext());
            imageView.setLayoutParams(new GridView.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);

        } else {
            photoInfo = (PhotoInfo) convertView;
        }

        photoInfo.setTextView(flickrPhoto.getTitle());

        photoInfo.setImageView(bitmaps.get(i));
        //container.findViewWithTag(i).imageView.setImageBitmap(bitmaps.get(i));
        return photoInfo;
    }

    public void onImageDownload(final Bitmap bitmap, final FlickrPhoto flickrPhoto){

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bitmaps.add(bitmap);
                flickrPhotos.add(flickrPhoto);
                notifyDataSetChanged();
            }
        });

    }
}
