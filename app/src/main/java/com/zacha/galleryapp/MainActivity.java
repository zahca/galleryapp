package com.zacha.galleryapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    FlickrPhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoAdapter = new FlickrPhotoAdapter(this);
        GridView grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(photoAdapter);

        FetchImages fetch = new FetchImages(photoAdapter,getApplicationContext());
        fetch.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }
}
