package com.example.miapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebSiteExample extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_site_example);

        wv1 = (WebView)findViewById(R.id.wv_1);
        String URL = getIntent().getStringExtra("sitioweb");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("https://" + URL);
    }

    public void volver(View view){
        finish();
    }
}
