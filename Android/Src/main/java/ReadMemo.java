package com.example.user.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;

public class ReadMemo extends AppCompatActivity {

    Database dbr;
    Button b;
    int uid;
    ListView l;
    TextView t;

    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_memo);
        uid = getIntent().getExtras().getInt("iduser");
        // t=(TextView)findViewById(R.id.rmemo);
        dbr = new Database(this);
        Cursor res = dbr.getmemoData(uid);
        StringBuffer stringBuffer = new StringBuffer();


        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                stringBuffer.append("Id: " + res.getString(0) + "\n");
                stringBuffer.append("Year: " + res.getString(1) + "\n");
                stringBuffer.append("Place: " + res.getString(2) + "\n");
                stringBuffer.append("Description: " + res.getString(3) + "\n\n");
                //  stringBuffer.append("Place: " + res.getString(4) + "\n\n");
            }

            s=stringBuffer.toString();
            l = (ListView) findViewById(R.id.listview);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Collections.singletonList(s));
            l.setAdapter(adapter);
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }
            });
        }
    }
}


