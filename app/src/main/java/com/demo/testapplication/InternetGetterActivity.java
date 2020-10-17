package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class InternetGetterActivity extends AppCompatActivity {

    private  String mailRu = "https://mail.ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_getter);

        // send info to logger using key and value
        //Log.i("Hello", "Hello World");
        //Log.i("mailRu", mailRu);

        // make new thread
        DownloadTask task = new DownloadTask();
        // make try catch - for data from internet
        try {
            String result = task.execute(mailRu).get();
            Log.i("URL", result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // class for download data, any code that will working more time
    // must be start from another thread
    private static class DownloadTask extends AsyncTask<String, Void, String > {
        @Override
        protected String doInBackground(String... strings) {
            // Log.i("URL", strings[0]);
            // return "Готово!";
            StringBuilder result = new StringBuilder();
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(strings[0]);
                // open connection
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                // make reader, reader read by one char
                InputStreamReader reader = new InputStreamReader(in);
                // make buffer reader - to read by string
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // close connection
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result.toString();
        }
    }
}