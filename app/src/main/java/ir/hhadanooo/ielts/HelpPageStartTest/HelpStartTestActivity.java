package ir.hhadanooo.ielts.HelpPageStartTest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import ir.hhadanooo.ielts.R;

public class HelpStartTestActivity extends AppCompatActivity {


    WebView webView;

    public String fileName = "test.html";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_start_test);


        // init webView
        webView = findViewById(R.id.help_start_WebView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
    }
}
