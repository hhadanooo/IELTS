package ir.hhadanooo.ielts.SimpleText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import ir.hhadanooo.ielts.R;

public class SimpleTextActivity extends AppCompatActivity {


    LinearLayout lay_cartView_Simple_text;
    TextView tv_title_Simple_text;
    WebView Simple_text_WebView;
    DisplayMetrics dm;
    public String fileName = "test.html";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_text);
        CheckIntent();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        String title_Page = getIntent().getExtras().getString("TitlePage");

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        // init webView
        Simple_text_WebView = findViewById(R.id.Simple_text_WebView);
        lay_cartView_Simple_text = findViewById(R.id.lay_cartView_Simple_text);
        tv_title_Simple_text = findViewById(R.id.tv_title_Simple_text);

        Simple_text_WebView.getSettings().setJavaScriptEnabled(true);
        Simple_text_WebView.loadUrl("file:///android_asset/" + fileName);


        lay_cartView_Simple_text.getLayoutParams().width = (int) (dm.widthPixels*.9);
        lay_cartView_Simple_text.getLayoutParams().height = (int) (dm.heightPixels*.75);

        tv_title_Simple_text.setTextSize((int) (dm.widthPixels*.015));

        //set String title_page
        tv_title_Simple_text.setText("Title");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void CheckIntent()
    {
        if(Objects.requireNonNull(getIntent().getExtras()).getString("Listen") != null)
        {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Listening");

        }else if(getIntent().getExtras().getString("Speak") != null)
        {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Speaking");
        }else if(getIntent().getExtras().getString("Read") != null)
        {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Reading");
        }else if (getIntent().getExtras().getString("Write") != null)
        {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Writing");
        }
    }

}
