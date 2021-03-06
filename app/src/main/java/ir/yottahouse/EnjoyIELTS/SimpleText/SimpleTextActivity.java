package ir.yottahouse.EnjoyIELTS.SimpleText;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.CustomView.CustomViewItem;
import ir.yottahouse.EnjoyIELTS.R;

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
                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/reading/tips/" + getIntent().getExtras().getString("NameFile") +"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/reading/tips/" + getIntent().getExtras().getString("NameFile") +"/TextTitleMainPage.txt");

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


        }else if(getIntent().getExtras().getString("Listen") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {

                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/listening/tips/"+ getIntent().getExtras().getString("NameFile") +"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/listening/tips/"+getIntent().getExtras().getString("NameFile") +"/TextTitleMainPage.txt");


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

        }else if(getIntent().getExtras().getString("Write") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {

                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/tips/"+getIntent().getExtras().getString("NameFile") +"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/tips/"+getIntent().getExtras().getString("NameFile") +"/TextTitleMainPage.txt");



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
            }else if(getIntent().getExtras().getString("Vocab") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {

                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/vocabulary/"+getIntent().getExtras().getString("NameFile") +"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/vocabulary/"+getIntent().getExtras().getString("NameFile") +"/TextTitleMainPage.txt");


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

        }else if(getIntent().getExtras().getString("Speak") != null)
        {

            if(getIntent().getExtras().getString("Tip") != null)
            {

                if(getIntent().getExtras().getInt("number") != 0)
                {

                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/tips/"+getIntent().getExtras().getString("NameFile") +"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/tips/"+getIntent().getExtras().getString("NameFile") +"/TextTitleMainPage.txt");


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
            }else if(getIntent().getExtras().getString("Vocab") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {

                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/vocabulary/"+ getIntent().getExtras().getString("NameFile")+"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/vocabulary/"+getIntent().getExtras().getString("NameFile") +"/TextTitleMainPage.txt");



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
            else if(getIntent().getExtras().getString("Test") != null)
            {
                if(getIntent().getExtras().getInt("number") != 0)
                {
                    if(getIntent().getExtras().getString("NameFile") != null)
                    {
                        file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/test/" + getIntent().getExtras().getString("NameFile") +"/index.html");
                        File file_text_answer1 = new File(getFilesDir().getAbsolutePath()+"/ielts/speaking/test/" + getIntent().getExtras().getString("NameFile")+"/TextTitleMainPage.txt");



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

        }



        //set value
        Simple_text_WebView.getSettings().setJavaScriptEnabled(true);
        //Simple_text_WebView.loadUrl("file:///android_asset/" + fileName);
        Simple_text_WebView.loadUrl("file:///" + file_html);



        tv_title_Simple_text.setText(TextTitleMainPage);



        // set size
        lay_cartView_Simple_text.getLayoutParams().width = (int) (dm.widthPixels*.9);
        lay_cartView_Simple_text.getLayoutParams().height = (int) (dm.heightPixels*.75);

        tv_title_Simple_text.setTextSize((int) (dm.widthPixels*.015));


        CustomViewItem.progressDialog.dismiss();


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

        Glide.with(this).load(R.drawable.tip_icon).into(iv_ic_logoPage_SimpleText);
        Glide.with(this).load(R.drawable.icon_arrow_back).into(iv_arrowBack_SimpleText);


        tv_TitleLogo_SimpleText.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_SimpleText.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_SimpleText.setText(getIntent().getExtras().getString("NameFile"));
        if(getIntent().getExtras().getString("Read") != null)
        {
            tv_PathLogo_SimpleText.setText("Reading");
        }else if(getIntent().getExtras().getString("Write") != null)
        {
            tv_PathLogo_SimpleText.setText("Writing");
        }else if(getIntent().getExtras().getString("Speak") != null)
        {
            tv_PathLogo_SimpleText.setText("Speaking");
        }else if(getIntent().getExtras().getString("Listen") != null)
        {
            tv_PathLogo_SimpleText.setText("Listening");
        }


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
