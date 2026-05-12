package com.example.exp6webviewpractice;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    WebView webview;
    Button button;

    EditText URLtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.Webview1);
        button = findViewById(R.id.button);
        URLtext = findViewById(R.id.editTextText);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());

        webview.loadUrl("https://www.google.com");

        button.setOnClickListener(view -> {

            String URL = URLtext.getText().toString();

            if(!URL.startsWith("https://")){
                URL = "https://"+URL;
            }
            webview.loadUrl(URL);
        });

    }

    @Override
    public void onBackPressed() {

        if (webview.canGoBack()){
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }

    }
}