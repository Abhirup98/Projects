package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.WallpaperManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;


public class ImageGallary extends AppCompatActivity {

    GridView gd;
    Database mydb;
    ArrayList<PicsBeen> al;
    ArrayList<PicsBitmapBeens> bl;
    static ArrayList<PicsBitmapBeens> fullpic;
    Cursor res;
    byte[] pic;
    int Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallary);

        Uid=getIntent().getExtras().getInt("uid");
        gd = (GridView) findViewById(R.id.grid);
        mydb = new Database(this);
        al = new ArrayList<PicsBeen>();
        bl = new ArrayList<PicsBitmapBeens>();
        res = mydb.getimageData(Uid);
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                int id=res.getInt(0);
                pic = res.getBlob(1);
                Bitmap bitmap =
                        BitmapFactory.decodeByteArray(pic, 0, pic.length);
                Drawable d = new BitmapDrawable(getResources(), bitmap);
                PicsBitmapBeens pbb = new
                        PicsBitmapBeens(id,bitmap);
                PicsBeen pb = new PicsBeen(d);
                al.add(pb);
                bl.add(pbb);
                GridAdapter ga = new GridAdapter(getApplicationContext(), al);
                gd.setAdapter(ga);
                registerForContextMenu(gd);
            }
            fullpic=new ArrayList<>(bl);
        }
        gd.setOnItemClickListener(new
                                          AdapterView.OnItemClickListener() {
                                              @Override
                                              public void onItemClick(AdapterView<?> parent,
                                                                      View view, int position, long id) {
                                                  Intent i=new
                                                          Intent(getApplicationContext(),ImagePreview.class);
                                                  i.putExtra("possition",position);
                                                  startActivity(i);
                                              }
                                          });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("OPTIONS");
        menu.add(0, v.getId(), 0, "SET AS WALLPAPER");
        menu.add(0, v.getId(), 0, "DELETE");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int pos;
        if ((item.getTitle() == "SET AS WALLPAPER")) {
            AdapterView.AdapterContextMenuInfo acm =
                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            pos = acm.position;
            PicsBitmapBeens pb = bl.get(pos);
            Bitmap bit = pb.get_bitmap();
            WallpaperManager w = WallpaperManager.getInstance(getApplicationContext());
            try {
                w.setBitmap(bit);

                Toast.makeText(getApplicationContext(),"WALLPAPER SET",Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      /* if(item.getTitle()=="DELETE"){
            AdapterView.AdapterContextMenuInfo acm =
                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            pos = acm.position;
            PicsBitmapBeens pb = bl.get(pos);
            int idd=pb.id;
            //int id=pos;
            // String ID=Integer.toString(pos);
            mydb.deletePic(Integer.toString(idd));
        }*/
        return true;

    }
}

