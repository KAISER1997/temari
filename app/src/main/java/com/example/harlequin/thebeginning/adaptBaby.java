package com.example.harlequin.thebeginning;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by harlequin on 26/9/17.
 */

public class adaptBaby extends RecyclerView.Adapter<adaptBaby.green>  {

    int NoOfItems;
    Cursor mcursor;


public adaptBaby(int NofItems,Cursor op)
{
    NoOfItems=NofItems;
    mcursor=op;


}

    @Override
    public green onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context=parent.getContext();
        LayoutInflater ob=LayoutInflater.from(context);
        View view=ob.inflate(R.layout.itemboi,parent,false);

green dum=new green(view);
        return dum;




    }

    @Override
    public void onBindViewHolder(green holder, int position) {

         holder.bind(position);


    }

    @Override
    public int getItemCount() {
        return NoOfItems;
    }


    public class green extends RecyclerView.ViewHolder {

        TextView l1;
        TextView crawled;

        public green(View iteview) {
            super(iteview);
            l1 = (TextView) iteview.findViewById(R.id.count);
            crawled = (TextView) iteview.findViewById(R.id.cobra);


        }
        void bind(int listIndex)
        {
          int q1=mcursor.getColumnIndex(contract._ID);
            int q2=mcursor.getColumnIndex(contract.CRAWLED);

          //  l1.setText(String.valueOf(listIndex));
         // crawled.setText(String.valueOf(2*listIndex));
            mcursor.moveToPosition(listIndex);
            int id=mcursor.getInt(q1);
            String as=mcursor.getString(q2);
            l1.setText(id+"");
            crawled.setText(as+"");

           System.out.println("kaiser "+as+" "+id);
        }

    }








}
