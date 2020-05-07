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
import android.widget.Toast;

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

        init();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



        if(getIntent().getExtras().getString("Read") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "ReadTip"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }


        }else if(getIntent().getExtras().getString("Listen") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "ListenTip"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }

        }else if(getIntent().getExtras().getString("Write") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "WriteTip"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }else if(getIntent().getExtras().getString("Vocab") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "WriteVocab"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }

        }else if(getIntent().getExtras().getString("Speak") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "SpeakTip"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }else if(getIntent().getExtras().getString("Vocab") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "SpeakVocab"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }
            else if(getIntent().getExtras().getString("Test") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    String file_name = "SpeakTest"+getIntent().getExtras().getInt("number");
                    Toast.makeText(SimpleTextActivity.this,file_name,Toast.LENGTH_LONG).show();
                }
            }

        }




        //set value
        Simple_text_WebView.getSettings().setJavaScriptEnabled(true);
        Simple_text_WebView.loadUrl("file:///android_asset/" + fileName);
        tv_title_Simple_text.setText("Title");







        // set size
        lay_cartView_Simple_text.getLayoutParams().width = (int) (dm.widthPixels*.9);
        lay_cartView_Simple_text.getLayoutParams().height = (int) (dm.heightPixels*.75);

        tv_title_Simple_text.setTextSize((int) (dm.widthPixels*.015));




    }
    public void init()
    {
        // init webView
        Simple_text_WebView = findViewById(R.id.Simple_text_WebView);
        lay_cartView_Simple_text = findViewById(R.id.lay_cartView_Simple_text);
        tv_title_Simple_text = findViewById(R.id.tv_title_Simple_text);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }



}
