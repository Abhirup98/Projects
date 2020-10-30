package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        final Button b1,b2,b3;
        final EditText ed1,ed2;
        final Database db;

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b3=(Button)findViewById(R.id.button3);

        //tx1 = (TextView)findViewById(R.id.textView3);
        //tx1.setVisibility(View.GONE);
        db=new Database(this);

        b1.setOnClickListener(new View.OnClickListener() {
            //int counter = 3;
            String e1,pass1,email,passw;
            int id;
            @Override
            public void onClick(View v) {
                email=ed1.getText().toString();
                passw=ed2.getText().toString();
                Cursor res = db.check(email);

                if (res != null || res.getCount() > 0) {
                    while (res.moveToNext()) {
                        id = res.getInt(0);
                        e1 = res.getString(2);
                        pass1 = res.getString(4);                     }

                }
                if (email.equals(e1) && passw.equals(pass1)) {
                    Toast.makeText(getApplicationContext(), "LogIN Successfull", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),Welcome.class);
                    i.putExtra("id",id);
                    startActivity(i);
                    Intent intent=new Intent(UserLogin.this,CreateContact.class);
                    intent.putExtra("uid",id);
                    Intent intent1=new Intent(UserLogin.this,ReadMemo.class);
                    intent1.putExtra("uid",id);    }
                else { Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_LONG).show();
                }
                ed1.setText("");
                ed2.setText("");

            }
        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignin();
            }
        });



    }

    void opensignin()
    {
        Intent intent=new Intent(this,UserRegistration.class);
        startActivity(intent);
    }
}




