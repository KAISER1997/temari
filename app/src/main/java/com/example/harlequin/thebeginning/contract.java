package com.example.harlequin.thebeginning;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by harlequin on 25/9/17.
 */

public class contract implements BaseColumns {

    public static final String TABLE_NAME="NIGGA";
    public static  final String CRAWLED="CRAWLED";
    public static  final String AUTHORITY="com.example.harlequin.thebeginning";
    public static final Uri Base_Uri=Uri.parse("content://"+AUTHORITY);
    public static final String Path_Task="NIGGA";
    public static final Uri Content_Uri=Base_Uri.buildUpon().appendPath(Path_Task).build();



}
