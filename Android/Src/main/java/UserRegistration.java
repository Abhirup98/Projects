package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegistration extends AppCompatActivity {

    EditText name,email,phone,pass,conpass;
    Database db;
    String na,em,paw,cpw;
    String ph_no;
    int flag=0;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.ph);
        pass=(EditText)findViewById(R.id.pw);
        conpass=(EditText)findViewById(R.id.pwc);

        b1=(Button)findViewById(R.id.sb);
        db=new Database(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                na=name.getText().toString();
                em=email.getText().toString();
                ph_no=phone.getText().toString();
                paw=pass.getText().toString();
                cpw=conpass.getText().toString();
                Cursor res=db.getuserData();
                if (res!=null && res.getCount()>0){
                    while (res.moveToNext()) {
                        //id = res.getInt(0);
                        String e = res.getString(2);
                        String pass1 = res.getString(4);

                        if (em.equals(e)) {
                            Toast.makeText(getApplicationContext(), "this email is already in datebase", Toast.LENGTH_LONG).show();
                            email.setText("");
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==0){
                        if(paw.equals(cpw)){
                            db.adduser(na,em,ph_no,paw);
                            Snackbar.make(v, "SUCCESSFULL!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            // Toast.makeText(getApplicationContext(),"SUCCESSFUL!!!",Toast.LENGTH_LONG).show();
                            openlogin();
                        }



                        else {

                            Snackbar.make(v, "PASSWORDS DONT MATCH!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            // Toast.makeText(getApplicationContext(),"PASSWORD DONT MATCH!!!",Toast.LENGTH_LONG).show();

                        }
                    }
                }
                else {
                    if(paw.equals(cpw)) {
                        boolean r = db.adduser(na, em, ph_no, paw);
                        if(r == true) {
                            Snackbar.make(v, "SUCCESSFULL!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            // Toast.makeText(getApplicationContext(),"SUCCESSFUL!!!",Toast.LENGTH_LONG).show();
                            openlogin();
                        }
                        else{                Snackbar.make(v, "UNSUCCESSFULL!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            //Toast.makeText(getApplicationContext(),"UNSUCCESSFUL!!!",Toast.LENGTH_LONG).show();
                        }
                    }

                    else {

                        Snackbar.make(v, "PASSWORDS DONT MATCH!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        //  Toast.makeText(getApplicationContext(),"PASSWORD DONT MATCH!!!",Toast.LENGTH_LONG).show();
                    }
                }



            }         });







    }

    void openlogin()
    {
        Intent intent=new Intent(this,UserLogin.class);
        startActivity(intent);
    }

}