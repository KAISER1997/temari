package com.example.harlequin.thebeginning;

import android.content.AsyncTaskLoader;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by harlequin on 24/9/17.
 */

public class spider extends android.support.v4.content.AsyncTaskLoader  {


    Context cou;
    public spider(Context context)
    {
        super(context);
        cou=context;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();



    }

    @Override
    public String loadInBackground() {

        System.out.println("DIE");

        String stfu = "http://jsoup.org";
        Set<String> store = new HashSet<String>();
        Queue<String> waiting = new LinkedList<>();
        Document doc = null;
        waiting.add(stfu);

        int u = 0;
        while (1 != 0) {

            String ss = waiting.remove();
            if ((store.contains(ss))) {
                continue;
            }

            if (!(store.contains(ss))) {
                System.out.println("FUCK - "+ss);
                ContentValues cv=new ContentValues();
                cv.put(contract.CRAWLED,ss);
                cou.getContentResolver().insert(contract.Content_Uri,cv);

                ++u;
                if (u == 30)
                    break;
                store.add(ss);
                Elements links = InListe(ss);
                for (Element lint : links) {
                    String absHref = lint.attr("abs:href");
                    waiting.add(absHref);

                    //System.out.println(absHref);

                }


            }


        }

        return("");

    }
    public static Elements InListe(String hoe) {

        Document doc = null;
        try {
            doc = Jsoup.connect(hoe).get();
        } catch (IOException e) {

            e.printStackTrace();
        }

        Elements links = doc.select("a[href]");
        return (links);


    }




    }

