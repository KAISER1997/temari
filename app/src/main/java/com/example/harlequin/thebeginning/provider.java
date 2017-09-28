package com.example.harlequin.thebeginning;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by harlequin on 25/9/17.
 */

public class provider extends ContentProvider {
    public static final int Tasks=100;
    public static final int Task_id=101;
    public static final UriMatcher uu=match();
DataBase dbhelper;

    public static UriMatcher match()
    {
        UriMatcher ob=new UriMatcher(UriMatcher.NO_MATCH);

      ob.addURI(contract.AUTHORITY,contract.Path_Task,Tasks);
        ob.addURI(contract.AUTHORITY,contract.Path_Task+"/#",Task_id);
        return ob;

    }







    @Override
    public boolean onCreate() {
        dbhelper=new DataBase(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
       Cursor retCursor=null;
       final SQLiteDatabase bd=dbhelper.getReadableDatabase();
        int match=uu.match(uri);
        switch(match)
        {
            case Tasks:
                retCursor=bd.query(contract.TABLE_NAME,strings,s,strings1,null,null,s1);
                break;


        }
        return retCursor;




    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final SQLiteDatabase bd=dbhelper.getWritableDatabase();
        int choice=uu.match(uri);
        Uri ReturnUri=null;
        switch(choice)  {

            case Tasks:
             long id=bd.insert(contract.TABLE_NAME,null,contentValues);
                if(id!=-1)
                ReturnUri= ContentUris.withAppendedId(contract.Content_Uri,id);
                break;
            default:
                throw new UnsupportedOperationException("dsd");

        }


Cursor cc=bd.rawQuery("select * from "+contract.TABLE_NAME,null);
        System.out.println("GTFO - "+cc.getCount());
      getContext().getContentResolver().notifyChange(uri,null);
        return ReturnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
