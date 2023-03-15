package com.example.cprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import com.example.cprogram.R;

public class LoadHtmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_html);

       String filename = getIntent().getStringExtra("filename");

        WebView webView = (WebView)findViewById(R.id.txt_area);
        webView.loadUrl("file:///android_asset/"+filename+".html");


    }
}
