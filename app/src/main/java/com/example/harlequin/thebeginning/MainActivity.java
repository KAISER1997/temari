package com.example.harlequin.thebeginning;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
LoaderManager mm= getSupportLoaderManager();
        LoaderManager.LoaderCallbacks<String> vv=MainActivity.this;
        mm.initLoader(1,null,this);
        ((TextView)findViewById(R.id.stfu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,imagery.class);
                startActivity(it);

            }
        });


    }


    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        System.out.println("NUDES");
        return new spider(this);
    }



    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        System.out.println("fuck you");
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
