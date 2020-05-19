package ir.hhadanooo.ielts.SimpleText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import ir.hhadanooo.ielts.R;

public class SimpleTextActivity extends AppCompatActivity {


    LinearLayout lay_cartView_Simple_text;
    TextView tv_title_Simple_text ,tv_TitleLogo_SimpleText , tv_PathLogo_SimpleText;
    WebView Simple_text_WebView;
    DisplayMetrics dm;
    ImageView iv_arrowBack_SimpleText , iv_ic_logoPage_SimpleText;
    public String fileName = "test.html";

    String TextTitleMainPage = "";

    File file_html;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_text);

        Objects.requireNonNull(getSupportActionBar()).hide();

        init();
        initActionBar();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



        if(getIntent().getExtras().getString("Read") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {
                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/reading/tips/tips"+ getIntent().getExtras().getInt("number") +"/index.html");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/reading/tips/tips"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");

                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }



                }
            }


        }else if(getIntent().getExtras().getString("Listen") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/listening/tips/tips"+ getIntent().getExtras().getInt("number") +"/index.html");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/listening/tips/tips"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");


                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }
            }

        }else if(getIntent().getExtras().getString("Write") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/tips/tips"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/tips/tips"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");



                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }


                }
            }else if(getIntent().getExtras().getString("Vocab") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/vocab/vocab"+ getIntent().getExtras().getInt("number") +"/index.html");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/vocab/vocab"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");


                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }

        }else if(getIntent().getExtras().getString("Speak") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/tips/tips"+ getIntent().getExtras().getInt("number") +"/index.html");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/tips/tips"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");


                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }




                }
            }else if(getIntent().getExtras().getString("Vocab") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/vocab/vocab"+ getIntent().getExtras().getInt("number") +"/index.html");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/vocab/vocab"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");



                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }
            }
            else if(getIntent().getExtras().getString("Test") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/test/test"+ getIntent().getExtras().getInt("number") +"/index.html");
                    File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/test/test"+ getIntent().getExtras().getInt("number") +"/TextTitleMainPage.txt");



                    try {

                        InputStream inputStream = new FileInputStream(file_text_answer1);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextTitleMainPage = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }


                }
            }

        }



        //set value
        Simple_text_WebView.getSettings().setJavaScriptEnabled(true);
        Simple_text_WebView.loadUrl("file:///android_asset/" + fileName);



        tv_title_Simple_text.setText(TextTitleMainPage);



        // set size
        lay_cartView_Simple_text.getLayoutParams().width = (int) (dm.widthPixels*.9);
        lay_cartView_Simple_text.getLayoutParams().height = (int) (dm.heightPixels*.75);

        tv_title_Simple_text.setTextSize((int) (dm.widthPixels*.015));




    }
    public void init()
    {

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        // init webView
        Simple_text_WebView = findViewById(R.id.Simple_text_WebView);
        lay_cartView_Simple_text = findViewById(R.id.lay_cartView_Simple_text);
        tv_title_Simple_text = findViewById(R.id.tv_title_Simple_text);




    }


    private void initActionBar() {

        iv_arrowBack_SimpleText = findViewById(R.id.iv_arrowBack_SimpleText);
        iv_ic_logoPage_SimpleText = findViewById(R.id.iv_ic_logoPage_SimpleText);
        tv_TitleLogo_SimpleText = findViewById(R.id.tv_TitleLogo_SimpleText);
        tv_PathLogo_SimpleText = findViewById(R.id.tv_PathLogo_SimpleText);

        iv_arrowBack_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        tv_TitleLogo_SimpleText.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_SimpleText.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_SimpleText.setText("Text1");
        tv_PathLogo_SimpleText.setText("Listening");

        iv_arrowBack_SimpleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }



}
