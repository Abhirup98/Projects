package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class TourFirst extends AppCompatActivity {


    GridView simpleGrid;
    int logos[] = {R.drawable.del, R.drawable.wb, R.drawable.mah, R.drawable.raj, R.drawable.as,
            R.drawable.gu, R.drawable.kar, R.drawable.ker, R.drawable.miz, R.drawable.ta1, R.drawable.mp,R.drawable.ka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_first);
        simpleGrid = (GridView) findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(TourFirst.this,TourSecond.class);
                intent.putExtra("image", position); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
    }
}


