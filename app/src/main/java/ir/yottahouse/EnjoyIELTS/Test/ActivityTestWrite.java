package ir.yottahouse.EnjoyIELTS.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.CustomView.CustomEditText;
import ir.yottahouse.EnjoyIELTS.CustomView.CustomViewItem;
import ir.yottahouse.EnjoyIELTS.Fragment.SlideFragmentTestReading;
import ir.yottahouse.EnjoyIELTS.R;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class ActivityTestWrite extends AppCompatActivity {
    RelativeLayout rel_body, rel_main_page,rel_title_main_page , layMgt;

    TextView tv_TitleLogo_SimpleText,tv_PathLogo_SimpleText;
    ImageView img_back;
    ImageView img_see_example,img_shareanswer,img_submit;
    CustomEditText et_main_page;
    ImageView img_timer;
    Chronometer tv_timer;
    long time;

    String TextSeeSample,TextTitleMainPage;

    SharedPreferences sharedPreferences_et_Text;
    SharedPreferences.Editor editor_sharedPreferences_et_Text;
    String name_sharedPreferences;
    WebView webView_title;
    File file_html;


    TourGuide mtg;
    SharedPreferences showHelppp;
    boolean showHelp = false;
    boolean isShow = false;
    Handler handler_timer;
    //Runnable_Timer runnable_timer;
    boolean check_chronometer = false;
    boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_write);

        handler_timer = new Handler();
        //runnable_timer = new Runnable_Timer();
        showHelppp = getSharedPreferences("show" ,MODE_PRIVATE);
        showHelp = showHelppp.getBoolean("webView_title" , false);

        Objects.requireNonNull(getSupportActionBar()).hide();
        initActionBar();
        init();

        SetPropertiesRelBody();
        time = 2400000;

        tv_timer.start();


        tv_timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(chronometer.getText().toString().equals("40:00") || check_chronometer)
                {
                    if(!check_chronometer) check_chronometer = true;
                    if(check)
                    {
                        Glide.with(ActivityTestWrite.this).load(ActivityTestWrite.this.getDrawable(R.drawable.timer_icon)).into(img_timer);
                        check = false;
                    }else {
                        Glide.with(ActivityTestWrite.this).load(ActivityTestWrite.this.getDrawable(R.drawable.timer_iconw)).into(img_timer);
                        check = true;
                    }
                }
            }
        });


    }
    private void initActionBar() {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        ImageView iv_arrowBack_SimpleText = findViewById(R.id.activity_test_write_iv_arrowBack_SimpleText);
        ImageView iv_ic_logoPage_SimpleText = findViewById(R.id.Activity_test_write_iv_ic_logoPage_SimpleText);
        tv_TitleLogo_SimpleText = findViewById(R.id.Activity_test_write_tv_TitleLogo_SimpleText);
        tv_PathLogo_SimpleText = findViewById(R.id.Activity_test_Write_tv_PathLogo_SimpleText);

        iv_arrowBack_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_SimpleText.setBackground(getDrawable(R.drawable.test_menue));

        tv_TitleLogo_SimpleText.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_SimpleText.setTextSize((int) (dm.widthPixels*.012));


        tv_TitleLogo_SimpleText.setText(getIntent().getExtras().getString("NameFile"));



        Glide.with(this).load(R.drawable.test_menue).into(iv_ic_logoPage_SimpleText);
        Glide.with(this).load(R.drawable.icon_arrow_back).into(iv_arrowBack_SimpleText);

        iv_arrowBack_SimpleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler_timer.removeCallbacks(runnable_timer);
                finish();
                onBackPressed();
            }
        });

    }
    @SuppressLint("ClickableViewAccessibility")
    public void init()
    {
        webView_title = findViewById(R.id.activity_test_write_webview_title);
        layMgt = findViewById(R.id.layMgt);

        webView_title.getSettings().setJavaScriptEnabled(true);



        rel_body = findViewById(R.id.activity_test_Write_rel_body);
        rel_main_page = findViewById(R.id.activity_test_write_rel_main_page);
        rel_title_main_page= findViewById(R.id.activity_test_write_rel_title_main_page);




        img_see_example = findViewById(R.id.activity_test_write_img_see_example);
        img_shareanswer = findViewById(R.id.activity_test_write_img_shareanswer);
        img_submit = findViewById(R.id.activity_test_write_img_submit);


        et_main_page = findViewById(R.id.activity_test_write_edit_text_main_page);

        img_timer = findViewById(R.id.activity_test_write_img_timer);

        tv_timer = findViewById(R.id.activity_test_write_tv_timer);
        sharedPreferences_et_Text = getSharedPreferences("et_text_value",MODE_PRIVATE);
        editor_sharedPreferences_et_Text = sharedPreferences_et_Text.edit();



        if (!showHelp){
            isShow = true;
            layMgt.setVisibility(View.VISIBLE);
            mtg = TourGuide.init(this).with(TourGuide.Technique.CLICK);
            mtg.setPointer(new Pointer())
                    .setToolTip( new ToolTip()
                            .setTextColor(Color.parseColor("#212122"))
                            .setDescription("You can write your answer here")
                            .setBackgroundColor(Color.parseColor("#bcd9f9"))
                            .setShadow(true).setGravity(Gravity.BOTTOM ))
                    .setOverlay(new Overlay()) ;
            mtg.playOn(et_main_page) ;
            showHelppp.edit().putBoolean("webView_title" , true).apply();
            showHelp = true;
        }
        et_main_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShow){
                    mtg.cleanUp();
                }
            }
        });


        layMgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShow){
                    layMgt.setVisibility(View.GONE);
                    mtg.cleanUp();
                    isShow = false;
                }
            }
        });

        checkIntent();
        SetPropertiesMainPage();


        webView_title.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (webView_title.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }

                return false;
            }
        });


    }

    public void checkIntent()
    {
        if(getIntent().getExtras().getString("Write") != null)
        {
            if(getIntent().getExtras().getString("Academic") != null)
            {
                if(getIntent().getExtras().getInt("Number") != 0)
                {

                    File file_text_see_sample = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/test/academic/" +getIntent().getExtras().getString("name") +"/TextSeeSample.txt");

                    try {

                        InputStream inputStream = new FileInputStream(file_text_see_sample);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextSeeSample = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/test/academic/" + getIntent().getExtras().getString("name") + "/index.html");






                    name_sharedPreferences = "TextWriteAcademic"+getIntent().getExtras().getInt("Number");
                    tv_PathLogo_SimpleText.setText("Writing/Academic");

                    }
            }else if(getIntent().getExtras().getString("General") != null)
            {
                if(getIntent().getExtras().getInt("Number") != 0)
                {


                    File file_text_see_sample = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/test/general/"+ getIntent().getExtras().getString("name") +"/TextSeeSample.txt");

                    try {

                        InputStream inputStream = new FileInputStream(file_text_see_sample);
                        String text = "";
                        byte[] bytes = new byte[8192];
                        inputStream.read(bytes);
                        for(byte b:bytes)
                        {
                            text+= (char) b;
                        }
                        TextSeeSample = text;
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                    file_html = new File(getFilesDir().getAbsolutePath()+"/ielts/writing/test/general/"+ getIntent().getExtras().getString("name")+"/index.html");




                    name_sharedPreferences = "TextWriteGeneral"+getIntent().getExtras().getInt("Number");
                    tv_PathLogo_SimpleText.setText("Writing/General");


                }
            }
        }
    }
    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


    }

    public void SetPropertiesMainPage()
    {
        final DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        rel_main_page.getLayoutParams().width = (int) (dm.widthPixels*.90);
        //rel_main_page.getLayoutParams().height = (int)(dm.heightPixels*0.78);

        rel_title_main_page.getLayoutParams().width = (int) (dm.widthPixels*.75);
        rel_title_main_page.getLayoutParams().height = (int)(dm.widthPixels*0.45);


        webView_title.loadUrl("file:///" + file_html);


        img_see_example.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        img_see_example.getLayoutParams().height = (int) (dm.widthPixels*0.074);

        et_main_page.getLayoutParams().width = (int) (dm.widthPixels*0.75);
        et_main_page.getLayoutParams().height = (int) (dm.widthPixels*0.59);

        //img_submit.setBackground(getDrawable(R.drawable.submit_icon1));
        //img_see_example.setBackground(getDrawable(R.drawable.seesample_icon1));
        //img_shareanswer.setBackground(getDrawable(R.drawable.shareanswer_icon1));

        //set max line 40
        et_main_page.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // if enter is pressed start calculating
                if (keyCode == KeyEvent.KEYCODE_ENTER
                        && event.getAction() == KeyEvent.ACTION_UP) {

                    // get EditText text
                    String text = ((EditText) v).getText().toString();

                    // find how many rows it cointains
                    int editTextRowCount = text.split("\\n").length;

                    // user has input more than limited - lets do something
                    // about that
                    if (editTextRowCount >= 40) {

                        // find the last break
                        int lastBreakIndex = text.lastIndexOf("\n");

                        // compose new text
                        String newText = text.substring(0, lastBreakIndex);

                        // add new text - delete old one and append new one
                        // (append because I want the cursor to be at the end)
                        ((EditText) v).setText("");
                        ((EditText) v).append(newText);

                    }
                }

                return false;
            }
        });




        img_shareanswer.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        img_shareanswer.getLayoutParams().height = (int) (dm.widthPixels*0.074);

        img_submit.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        img_submit.getLayoutParams().height = (int) (dm.widthPixels*0.074);



        img_timer.getLayoutParams().width = (int) (dm.widthPixels*0.1);
        img_timer.getLayoutParams().height = (int) (dm.widthPixels*0.1);

        Glide.with(this).load(R.drawable.timer_icon).into(img_timer);


        et_main_page.setText(sharedPreferences_et_Text.getString(name_sharedPreferences,""));

        //Toast.makeText(this,name_sharedPreferences,Toast.LENGTH_LONG).show();

        Glide.with(this).load(R.drawable.seesample_icon1).into(img_see_example);
        Glide.with(this).load(R.drawable.shareanswer_icon1).into(img_shareanswer);
        Glide.with(this).load(R.drawable.submit_icon1).into(img_submit);

        img_see_example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dia = new Dialog(ActivityTestWrite.this);
                dia.setContentView(R.layout.layout_dialog_audioscripts);
                TextView tv_audioScripts = dia.findViewById(R.id.tv_audioScripts);

                tv_audioScripts.getLayoutParams().width = (int) (dm.widthPixels*.8);
                //tv_audioScripts.getLayoutParams().height = (int) (Height);
                tv_audioScripts.setTextSize((int) (dm.widthPixels*.015));
                tv_audioScripts.setText(TextSeeSample);
                dia.show();
            }
        });
        img_shareanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_main_page.getText().toString().isEmpty())
                {
                    String shareBody =et_main_page.getText().toString();
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, ""));
                }else {
                    Toast.makeText(getApplicationContext(),"Please Write Something!",Toast.LENGTH_LONG).show();
                }
            }
        });
        img_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_main_page.getText().toString().isEmpty())
                {
                    editor_sharedPreferences_et_Text.putString(name_sharedPreferences,et_main_page.getText().toString()).apply();
                    Toast.makeText(getApplicationContext(),"Your Text Saved!",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Please Write Something!",Toast.LENGTH_LONG).show();
                }
            }
        });

        CustomViewItem.progressDialog.dismiss();

    }

    /*
    public void Timer(final TextView tv_timer)
    {
        new CountDownTimer(time,1000) {
            @Override
            public void onTick(long l) {
                time = l;
                int minute =(int) time / 60000;
                int second = (int) time % 60000 / 1000;
                String timestring = "" + minute;
                timestring += ":";
                if(second < 10) timestring += "0";
                timestring += second;
                tv_timer.setText(timestring);

                if(minute == 0 && second == 0)
                {

                    handler_timer.postDelayed(runnable_timer,500);
                    Toast.makeText(ActivityTestWrite.this,"Time is over",Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFinish() {

            }
        }.start();
    }

    public class Runnable_Timer implements Runnable
    {

        boolean check = false;
        @Override
        public void run() {
            if(check)
            {
                Glide.with(ActivityTestWrite.this).load(ActivityTestWrite.this.getDrawable(R.drawable.timer_icon)).into(img_timer);
                check = false;
            }else {
                Glide.with(ActivityTestWrite.this).load(ActivityTestWrite.this.getDrawable(R.drawable.timer_iconw)).into(img_timer);
                check = true;
            }
            handler_timer.postDelayed(this,1000);

        }
    }

     */

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //handler_timer.removeCallbacks(runnable_timer);
        finish();
    }
}
