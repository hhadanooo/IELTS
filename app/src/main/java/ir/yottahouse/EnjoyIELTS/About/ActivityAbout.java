package ir.yottahouse.EnjoyIELTS.About;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.File;
import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.R;

public class ActivityAbout extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView webView = findViewById(R.id.Activity_About_webview);
        Objects.requireNonNull(getSupportActionBar()).hide();

        webView.getSettings().setJavaScriptEnabled(true);
        //Simple_text_WebView.loadUrl("file:///android_asset/" + fileName);
        File file =  new File(getFilesDir().getAbsolutePath() + "/ielts/about/about.html");
        webView.loadUrl("file:///" +file);

    }
}