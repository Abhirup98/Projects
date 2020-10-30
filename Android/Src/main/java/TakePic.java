package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class TakePic extends AppCompatActivity {

    ImageView im;
    ImageButton b1;
    Database mydb;
    Bitmap photo;
    private static final int CAMERA_REQUEST = 123;
    int Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_pic);
        mydb= new Database(this);
        im=(ImageView)findViewById(R.id.show);
        b1=(ImageButton)findViewById(R.id.b1);

        Uid=getIntent().getExtras().getInt("iduser");

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }


        });
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
            photo= (Bitmap) data.getExtras().get("data");
            im.setImageBitmap(photo);
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG,0,stream);
            byte []pho= stream.toByteArray();
            boolean r= mydb.insertImage(pho,Uid);
            if (r==true)
            {
                Toast.makeText(getApplicationContext(),"IMAGE SAVED",Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(getApplicationContext(),"this image cannot be saved", Toast.LENGTH_LONG).show();
            }
        }

    }
}

