package com.zacha.galleryapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    FlickrPhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        System.out.println("Hello this is the start of the app");
        photoAdapter = new FlickrPhotoAdapter(this);
        GridView grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(photoAdapter);

    }

    @Override
    protected void onResume(){
        super.onResume();
        FetchImages fetch = new FetchImages(photoAdapter,getApplicationContext());
        fetch.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        //new FetchImages(photoAdapter, new ImageView(this)).doInBackground();
    }
}
