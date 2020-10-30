package com.example.user.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Welcome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:22.572646,88.363895"));
                Intent chooser=Intent.createChooser(intent,"Launch Map");
                startActivity(chooser);

            }
        });

        TextView tx,tx1,tx2,tx3;
        tx=(TextView)findViewById(R.id.t1);
        tx1=(TextView)findViewById(R.id.uname);
        tx2=(TextView)findViewById(R.id.phone);
        // tx3=(TextView)findViewById(R.id.textView3);
        uid=getIntent().getExtras().getInt("id");
        //  String name;
        Cursor res;
        Database db;
        db=new Database(this);
        res=db.getuserData(uid);
        //  name=res.getString(1);
        //tx.setText(name);
        int id;
        String name,phonen,usern;
        name="p";usern="p";phonen="p";id=999;
        if (res != null || res.getCount() > 0) {
            while (res.moveToNext()) {
                id = res.getInt(0);
                name = res.getString(1);
                phonen=res.getString(3);
                usern=res.getString(2);
            }

        }
        if(uid==id) {
            tx.setText(name);
            tx1.setText(usern);
            tx2.setText(phonen);
            //tx3.setText(uid);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,UserLogin.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent1=new Intent(getApplicationContext(),TakePic.class);
            intent1.putExtra("iduser",uid);
            startActivity(intent1);

        }
        else if (id == R.id.nav_gallery) {

            Intent intent1=new Intent(getApplicationContext(),ImageGallary.class);
            intent1.putExtra("uid",uid);
            startActivity(intent1);

        }
        else if (id == R.id.nav_slideshow) {

            Intent intent=new Intent(this,TourFirst.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_con) {

            Intent intent=new Intent(getApplicationContext(),CreateContact.class);
            intent.putExtra("userid",uid);
            startActivity(intent);

        }
        else if (id==R.id.nav_scon) {

            Intent intent1=new Intent(getApplicationContext(),ReadContact.class);
            intent1.putExtra("iduser",uid);
            startActivity(intent1);

        }

        else if (id == R.id.nav_share) {

            Intent intent2=new Intent(getApplicationContext(),CreateMemo.class);
            intent2.putExtra("iduser",uid);
            startActivity(intent2);


        }
        else if (id == R.id.nav_send) {

            Intent intent2=new Intent(getApplicationContext(),ReadMemo.class);
            intent2.putExtra("iduser",uid);
            startActivity(intent2);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
