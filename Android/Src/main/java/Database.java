package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.sql.Blob;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tourism.db";
    public static final String CONTACT_TABLE = "Contact";
    public static final String USER_TABLE = "User";
    public static final String MEMO_TABLE = "Memo";
    public static final String IMAGE_TABLE = "Image";



    // cols for user table
    public static final String UCOL_1 = "u_id";
    public static final String UCOL_2 = "u_name";
    public static final String UCOL_3 = "u_email";
    public static final String UCOL_4 = "u_ph";
    public static final String UCOL_5 = "u_pass";

    //cols for contact table

    public static final String ECOL_1 = "C_ID";
    public static final String ECOL_2 = "P_NAME";
    public static final String ECOL_3 = "P_PH";
    public static final String ECOL_4 = "P_EMAIL";
    public static final String ECOL_5 = "PLACE";
    public static final String ECOL_6 = "DES";
    public static final String ECOL_7= "u_id";

    //cols for memo table

    public static final String MCOL_1 = "M_ID";
    public static final String MCOL_2 = "M_YEAR";
    public static final String MCOL_3 = "M_PLACE";
    public static final String MCOL_4 = "M_DESC";
    public static final String MCOL_5 = "u_id";

    //cols for image table

    public static final String ICOL_1 = "I_ID";
    public static final String ICOL_2 = "IMAGE";
    public static final String ICOL_3 = "CAPTION";
    public static final String ICOL_4 = "YEAR";
    public static final String ICOL_5 = "u_id";



    public Database(Context context) {    super(context, DATABASE_NAME, null, 1);     }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //user
        db.execSQL("CREATE TABLE " + USER_TABLE + "(u_id INTEGER PRIMARY KEY AUTOINCREMENT,u_name TEXT,u_email TEXT,u_ph TEXT,u_pass TEXT)");
        //contact
        db.execSQL("CREATE TABLE " + CONTACT_TABLE + "(C_ID INTEGER PRIMARY KEY AUTOINCREMENT,P_NAME TEXT,P_PH TEXT,P_EMAIL TEXT,PLACE TEXT,DES TEXT,u_id INTEGER)");
        //memo
        db.execSQL("CREATE TABLE " + MEMO_TABLE + "(M_ID INTEGER PRIMARY KEY AUTOINCREMENT,M_YEAR TEXT,M_PLACE TEXT,M_DESC TEXT,u_id INTEGER)");
        //image
        db.execSQL("CREATE TABLE " + IMAGE_TABLE + "(I_ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB,CAPTION TEXT,YEAR TEXT,u_id INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CONTACT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MEMO_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + IMAGE_TABLE);
        onCreate(db);
    }


    //USER
    public boolean adduser(String name, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UCOL_2, name);
        contentValues.put(UCOL_3, email);
        contentValues.put(UCOL_4, phone);
        contentValues.put(UCOL_5, password);
        Long result = db.insert(USER_TABLE,null,contentValues);
        db.close();
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor check(String email){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("Select * from " + USER_TABLE + " WHERE " + UCOL_3 + "='" + email + "'",null);
        return c;
    }

    public Cursor getuserData(int id){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + USER_TABLE + " WHERE " + UCOL_1 + "='" + id + "'",null);
        return res;     }

    public Cursor getuserData(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + USER_TABLE,null);
        return res;     }

    //CONTACT
    public boolean addcontact(String pname, String phone, String pemail, String place,String des,int uid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ECOL_2, pname);
        contentValues.put(ECOL_3, phone);
        contentValues.put(ECOL_4, pemail);
        contentValues.put(ECOL_5, place);
        contentValues.put(ECOL_6, des);
        contentValues.put(ECOL_7, uid);

        Long result = db.insert(CONTACT_TABLE,null,contentValues);
        db.close();
        if(result==-1){
            return false;         }
        else {             return true;         }
    }

    public Cursor contactByuserid(int u_id, int cid){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + CONTACT_TABLE + " WHERE " + ECOL_7 + "='" + u_id + "'" + " AND " + ECOL_1 + "='" + cid + "'" ,null);
        return res;     }

    public Cursor contactByid(int cid){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + CONTACT_TABLE + " WHERE " + ECOL_1 + "='" + cid + "'",null);
        return res;     }

    public Cursor getcontactData(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + CONTACT_TABLE,null);
        return res;     }

    public Cursor getcontactData(int u_id){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + CONTACT_TABLE+" WHERE "+ECOL_7 + "='" + u_id +"'",null);
        return res;     }

    //MEMO
    public boolean addmemo(String year,String place,String descr,int uid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MCOL_2, year);
        contentValues.put(MCOL_3, place);
        contentValues.put(MCOL_4,descr);
        contentValues.put(MCOL_5, uid);

        Long result = db.insert(MEMO_TABLE,null,contentValues);
        db.close();
        if(result==-1){
            return false;         }
        else {             return true;         }
    }

    public Cursor getmemoData(int u_id){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + MEMO_TABLE+" WHERE "+MCOL_5 + "='" + u_id +"'",null);
        return res;     }

    //IMAGE
    public boolean addimage(Blob img, String cap, String yr, int uid) {
        SQLiteDatabase db = this.getWritableDatabase();
        String im=img.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ICOL_2,im);
        contentValues.put(ICOL_3, cap);
        contentValues.put(ICOL_4,yr);
        contentValues.put(MCOL_5, uid);

        Long result = db.insert(IMAGE_TABLE,null,contentValues);
        db.close();
        if(result==-1){
            return false;         }
        else {             return true;         }
    }

    public boolean insertImage(byte[] p,int uid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //String im=img.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ICOL_2,p);
        //contentValues.put(ICOL_3, cap);
        //contentValues.put(ICOL_4,yr);
        contentValues.put(MCOL_5, uid);

        Long result = db.insert(IMAGE_TABLE,null,contentValues);
        db.close();
        if(result==-1){
            return false;         }
        else {             return true;         }
    }

    public Cursor getimageData(int u_id){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + IMAGE_TABLE+" WHERE "+MCOL_5 + "='" + u_id +"'",null);
        return res;     }

}