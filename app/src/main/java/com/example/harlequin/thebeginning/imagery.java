package com.example.harlequin.thebeginning;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class imagery extends AppCompatActivity {


    private static final int Num=30;
    private adaptBaby adapter;
    private RecyclerView rw;
    Cursor vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vv=getContentResolver().query(contract.Content_Uri,null,null,null,null);
        System.out.println("HOE "+vv.getCount());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagery);
        rw=(RecyclerView)findViewById(R.id.hoora);
        LinearLayoutManager love=new LinearLayoutManager(this);
        rw.setLayoutManager(love);
        adapter=new adaptBaby(Num,vv);
        rw.setAdapter(adapter);










    }
}
