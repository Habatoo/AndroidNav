package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private TextView textViewTextShow;
    private ImageView imageViewShowImage;
    private String imageUrl = "https://avatars3.githubusercontent.com/u/34543104?s=460&v=4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_getter);

        // send info to logger using key and value
        //Log.i("Hello", "Hello World");
        //Log.i("mailRu", mailRu);
        textViewTextShow = findViewById(R.id.textViewTextShow);
        imageViewShowImage = findViewById(R.id.imageViewShowImage);

    }

    public void showText(View view) {
        // make new thread
        DownloadTask task = new DownloadTask();
        // make try catch - for data from internet
        try {
            String result = task.execute(mailRu).get();
            Log.i("URL", result);
            textViewTextShow.setText(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showImage(View view) {
        DownloadImageTask downloadTask = new DownloadImageTask();
        Bitmap bitmap = null;
        try {
            bitmap = downloadTask.execute(imageUrl).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageViewShowImage.setImageBitmap(bitmap);
    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            URL imageUrl = null;
            HttpURLConnection urlConnection = null;

            try {
                imageUrl = new URL(strings[0]);
                urlConnection = (HttpURLConnection) imageUrl.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
               if (urlConnection != null) {
                   urlConnection.disconnect();
               }
            }
            return null;
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