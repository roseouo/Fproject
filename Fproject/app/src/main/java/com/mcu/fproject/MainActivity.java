package com.mcu.fproject;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        Document doc;
        try {
            doc = Jsoup.connect("https://zh.wikipedia.org/wiki/Git").get();
            String title = doc.title();


            TextView v =findViewById(R.id.Textview);
            v.setText(doc.select("div.mw-parser-output > p").get(5).text());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
////                    Document doc = Jsoup.connect("https://zh.wikipedia.org/wiki/Git").get();
//                    Document doc = Jsoup.connect("https://zh.wikipedia.org/wiki/Git")
//                            .data("query", "Java")
//                            .userAgent("Mozilla")
//                            .cookie("auth", "token")
//                            .timeout(3000)
//                            .post();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }

