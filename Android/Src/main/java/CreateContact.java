package com.example.user.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CreateContact extends AppCompatActivity {
    int uid;
    Database myDb;
    EditText tx1,tx2,tx3,tx4,tx5;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);



        tx1 = (EditText) findViewById(R.id.name1);
        tx2 = (EditText) findViewById(R.id.place);
        tx3 = (EditText) findViewById(R.id.phn);
        tx4 = (EditText) findViewById(R.id.em);
        tx5 = (EditText) findViewById(R.id.des);
        btnClick = (Button) findViewById(R.id.sb);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb = new Database(CreateContact.this);


                String name = tx1.getText().toString();
                String place = tx2.getText().toString();
                String email = tx4.getText().toString();
                String desc = tx5.getText().toString();
                String phone = tx3.getText().toString();
                uid=getIntent().getExtras().getInt("userid");

                Cursor res1 = myDb.getcontactData(uid);

                if (res1 != null && res1.getCount() > 0) {
                    myDb.addcontact(name, phone, email, place, desc,uid);
                    Toast.makeText(getApplicationContext(), "SUCCESSFUL!!!", Toast.LENGTH_LONG).show();

                } else {
                    myDb.addcontact(name, phone, email, place, desc,uid);
                    Toast.makeText(getApplicationContext(), "SUCCESSFUL!!!", Toast.LENGTH_LONG).show();
                }



            }
        });

    }

}
