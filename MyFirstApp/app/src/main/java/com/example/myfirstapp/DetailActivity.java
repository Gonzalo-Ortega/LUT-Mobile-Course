package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.myfirstapp.ITEM_INDEX", -1);

        if (index > -1) {
            int image = getImage(index);
            ImageView view = (ImageView) findViewById(R.id.imageView);
            scaleImage(view, image);
        }
    }

    private int getImage(int index) {
        switch (index) {
            case 0: return R.drawable.dog;
            case 1: return R.drawable.cat;
            case 2: return R.drawable.pig;
            default: return -1;
        }
    }

    private void scaleImage(ImageView view, int image) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), image, options);

        int imageWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imageWidth > screenWidth) {
            int ratio = Math.round( (float) imageWidth/ (float) screenWidth );
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), image, options);
        view.setImageBitmap(scaledImage);
    }
}