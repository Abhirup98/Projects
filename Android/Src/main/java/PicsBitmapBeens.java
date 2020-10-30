package com.example.user.myapplication;

import android.graphics.Bitmap;

public class PicsBitmapBeens {

    int id;
    Bitmap photo;

    public PicsBitmapBeens(int uid,Bitmap pic)
    {

        this.id=uid;
        this.photo=pic;

    }

    Bitmap get_bitmap()
    {return photo;}

    int getId(){return id;}

}
