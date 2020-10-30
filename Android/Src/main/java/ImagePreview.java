package com.example.user.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class ImagePreview extends AppCompatActivity {

    ImageView image;
    PicsBitmapBeens pb;
    int posi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        image=(ImageView)findViewById(R.id.imagep);
        posi=getIntent().getExtras().getInt("possition");
        pb=ImageGallary.fullpic.get(posi);
        Bitmap bit=pb.get_bitmap();
        image.setImageBitmap(bit);

    }
}
