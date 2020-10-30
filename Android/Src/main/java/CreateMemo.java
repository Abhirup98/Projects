package com.example.user.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class CreateMemo extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    int uid;
    Database myDb;
    EditText tx1, tx2;
    Button bsave, bcancel;
    Spinner sp;
    String year;

    String[] yr={"1995","1996","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_memo);

        tx1 = (EditText) findViewById(R.id.desm);
        tx2 = (EditText) findViewById(R.id.placem);
        sp = (Spinner) findViewById(R.id.yearsm);
        bsave = (Button) findViewById(R.id.b1m);
        bcancel = (Button) findViewById(R.id.b2m);

        sp.setOnItemSelectedListener(CreateMemo.this);

        // List<String> category= new ArrayAdapter<String>(CreateMemo.this);
        // category.add("");

        ArrayAdapter da=new ArrayAdapter(this,android.R.layout.simple_spinner_item,yr);
        da.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(da);

        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDb = new Database(CreateMemo.this);


                String desc = tx1.getText().toString();
                String place = tx2.getText().toString();


                uid = getIntent().getExtras().getInt("iduser");

                Cursor res1 = myDb.getmemoData(uid);

                if (res1 != null && res1.getCount() > 0) {
                    myDb.addmemo(year, place, desc, uid);
                    Toast.makeText(getApplicationContext(), "SUCCESSFUL!!!", Toast.LENGTH_LONG).show();
                    // ClickMe();
                } else {
                    myDb.addmemo( year,place, desc, uid);
                    Toast.makeText(getApplicationContext(), "SUCCESSFUL!!!", Toast.LENGTH_LONG).show();
                    //  ClickMe();
                }


            }
        });

    }

    public void ClickMe() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        year=yr[position];
        Toast.makeText(getApplicationContext(),yr[position],Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}