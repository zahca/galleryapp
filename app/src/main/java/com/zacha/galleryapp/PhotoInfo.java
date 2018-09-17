package com.zacha.galleryapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PhotoInfo extends LinearLayout{

    TextView textView;
    ImageView imageView;


    public PhotoInfo(Context context) {
        super(context);
        this.textView = new TextView(getContext());
        this.imageView = new ImageView(getContext());
        initializeViews(context);
    }

    public void setTextView(String text){
        textView = (TextView) findViewById(R.id.info);
        textView.setText(text);
    }

    public void setImageView(Bitmap bitmap){
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
    }

    public PhotoInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.PhotoInfo);
        textView.setText(attributes.getText(0));
        initializeViews(context);
    }

    public PhotoInfo(Context context,
                       AttributeSet attrs,
                       int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.photoinfo_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }
}
