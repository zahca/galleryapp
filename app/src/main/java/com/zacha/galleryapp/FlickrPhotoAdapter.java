package com.zacha.galleryapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class FlickrPhotoAdapter extends BaseAdapter{

    private Activity activity;
    ArrayList<Bitmap> bitmaps;

    public FlickrPhotoAdapter(Activity activity){
        this.activity = activity;
        bitmaps = new ArrayList<>();
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

        if (convertView == null) {
            imageView = new ImageView(activity.getApplicationContext());
            imageView.setLayoutParams(new GridView.LayoutParams(200, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(bitmaps.get(i));
        return imageView;
    }

    public void onImageDownload(final Bitmap bitmap){

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Are image views being created?");
                bitmaps.add(bitmap);
                notifyDataSetChanged();
            }
        });

    }
}
