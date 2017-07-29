package com.lovepreetsingh.news_app.Model;



import android.provider.BaseColumns;

/**
 * Created by lovepreetsingh on 7/28/17.
 */

public class Contract {

    public static class TABLE_TODO implements BaseColumns {
        public static final String TABLE_NAME = "newsdata";
        public static final String COLUMN_NAME_AUTHER = "author";
        public static final String COLUMN_NAME_TITLE= "title";
        public static final String COLUMN_NAME_DESC = "desc";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_IMAGE = "imageurl";
        public static final String COLUMN_NAME_DATE = "date";

    }
}