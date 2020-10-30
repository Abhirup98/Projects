package com.example.user.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class PicsBeen {

    int id;
    Bitmap photo;
    Drawable drawable;

    public PicsBeen(Drawable d)
    {

        //this.id=uid;
        //this.photo=pic;
        this.drawable=d;

    }

    Drawable get_pic()
    {return drawable;}

    int getId(){return id;}

}

