package com.lovepreetsingh.news_app.Utilities;

/**
 * Created by lovepreetsingh on 7/28/17.
 */

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class NetworkUtils {

    private static  final String n= Key.key_value;

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String BASE_URL = "https://newsapi.org/v1/articles";

    private static final String source = "the-next-web";

    private static final String sortby = "latest";

    final  static String SOURCE_PARA ="source";

    final static  String SORT_PARA= "sortBy";

    final static String API_PARA ="apiKey" ;


    public static URL buildUrl()
    {
        Uri builtUri= Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(SOURCE_PARA,source)
                .appendQueryParameter(SORT_PARA,sortby)
                .appendQueryParameter(API_PARA,n)
                .build();

        URL url=null;

        try{

            url=new URL(builtUri.toString());
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }


        Log.v(TAG, "Built URI" +url);

        return url;

    }


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }




}
