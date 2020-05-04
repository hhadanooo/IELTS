package ir.hhadanooo.ielts.HelpPageStartTest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import ir.hhadanooo.ielts.R;

public class HelpStartTestActivity extends AppCompatActivity {


    WebView webView;

    public String fileName = "test.html";

    ExtendedFloatingActionButton start_test;

    DisplayMetrics dm;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_start_test);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        // init webView
        webView = findViewById(R.id.help_start_WebView);
        start_test = findViewById(R.id.start_test);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);


        start_test.getLayoutParams().width = (int) (dm.widthPixels*.55);
        start_test.getLayoutParams().height = (int) (dm.widthPixels*.13);
    }
}
