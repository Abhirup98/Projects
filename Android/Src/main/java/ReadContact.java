package com.example.user.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReadContact extends AppCompatActivity {

    Database dbr;
    Button b;
    int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contact);
        TextView tx,place,ph,des,email;
        tx=(TextView)findViewById(R.id.rcon);
        //ph=(TextView)findViewById(R.id.phnr);
        //des=(TextView)findViewById(R.id.desr);
        //email=(TextView)findViewById(R.id.emr);
        //place=(TextView)findViewById(R.id.placer);

        //b=(Button)findViewById(R.id.ret);
        uid=getIntent().getExtras().getInt("iduser");

        dbr=new Database(this);


        Cursor res = dbr.getcontactData(uid);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();

        if(res!=null && res.getCount()>0){
            while (res.moveToNext()){
                stringBuffer.append("Id: "+res.getString(0)+"\n");
                stringBuffer.append("Name: "+res.getString(1)+"\n");
                stringBuffer.append("Phone: "+res.getString(2)+"\n");
                stringBuffer.append("Email: "+res.getString(3)+"\n");
                stringBuffer.append("Place: "+res.getString(4)+"\n");
                stringBuffer.append("Description: "+res.getString(5)+"\n"+"\n");
            }
            tx.setText(stringBuffer.toString());
            //   ph.setText(stringBuffer1.toString());
            //  email.setText(stringBuffer2.toString());
            //   place.setText(stringBuffer3.toString());
            //   des.setText(stringBuffer4.toString());

            Toast.makeText(this,"Data Retrieved Successfully", Toast.LENGTH_SHORT).show();         }
        else{             Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();         }



    }
}
