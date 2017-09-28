package com.example.harlequin.thebeginning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harlequin on 25/9/17.
 */

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="scum.db";
   private static  final int  DATASE_VER=1;








    public DataBase(Context context)
    {
       super(context,DATABASE_NAME,null,DATASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String str="CREATE TABLE "+contract.TABLE_NAME+" ( "+contract._ID +" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                                                                  +contract.CRAWLED+ " TEXT );";

         sqLiteDatabase.execSQL(str);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      onCreate(sqLiteDatabase);
    }
}
