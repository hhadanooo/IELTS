package ir.hhadanooo.ielts.Test.Listen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.hhadanooo.ielts.DialogChlng.DialogChlngShow;
import ir.hhadanooo.ielts.MainActivity;
import ir.hhadanooo.ielts.R;

public class TestListenActivity extends AppCompatActivity {

    DisplayMetrics dm;
    LinearLayout lay_TestL , lay_box_playerTL;
    RelativeLayout lay_playerTL;
    ImageView iv_play_playerTL , iv_ic_org_playerTL , iv_seeAnswer_playerTL , iv_time_TestL , iv_ic_logoPage_TestL
            , iv_arrowBack_TestL , iv_ic_backward_playerTL , iv_ic_forward_playerTL ,iv_audioscripts_playerTL;
    View view_space_playerTL , view_center_see_audio;
    EditText  et_TestL_Result;
    TextView tv_time_TestL , tv_TitleLogo_TestL ,tv_PathLogo_TestL , tv_time_playerTL;
    SeekBar seekBar_playerTL;
    MediaPlayer mPlayer;
    Handler mHandler = new Handler();
    WebView webView_TestL;
    int min = 0;
    int sec = 0;
    int duration = 0;
    long time = 2400000;
    public String fileName = "test.html";
    List<String> answerList = new ArrayList<>();

    @SuppressLint({"ClickableViewAccessibility", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listen);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        init();
        initActionBar();
        CheckIntent();

        Timer(tv_time_TestL);

        if (ActivityCompat.checkSelfPermission(this , Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.READ_EXTERNAL_STORAGE} , 123);
        }


        String intent = "text 1";
        int pageNum = Integer.parseInt(intent.substring(intent.length()-1));

        Log.i("pagenum" , "("+pageNum+")");


        mPlayer = new MediaPlayer();
        try {

            FileInputStream fileInputStream = new FileInputStream(getFilesDir().
                    getAbsolutePath()+"/ielts/listening/test/test"+pageNum+"/audio.mp3");
            mPlayer.setDataSource(fileInputStream.getFD());
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        duration = mPlayer.getDuration()/1000;


        iv_play_playerTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_play_playerTL.setEnabled(false);
                mPlayer.start();
                seekBar_playerTL.setMax(duration);
                TestListenActivity.this.runOnUiThread(new Runnable() {

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        if(mPlayer != null){
                            int mCurrentPosition = mPlayer.getCurrentPosition() / 1000;
                            seekBar_playerTL.setProgress(mCurrentPosition);
                            if (duration > mCurrentPosition){
                                if(mCurrentPosition < 60){
                                    if (mCurrentPosition < 10){
                                        tv_time_playerTL.setText("00:0"+mCurrentPosition);
                                    }else {
                                        tv_time_playerTL.setText("00:"+mCurrentPosition);
                                    }
                                }else {
                                    sec = (mCurrentPosition%60);
                                    min = (mCurrentPosition-sec)/60;
                                    if (min < 10 ){
                                        if (sec < 10){
                                            tv_time_playerTL.setText("0"+min+":0"+sec);
                                        }else {
                                            tv_time_playerTL.setText("0"+min+":"+sec);
                                        }
                                    }else {
                                        if (sec < 10){
                                            tv_time_playerTL.setText(min+":0"+sec);
                                        }else {
                                            tv_time_playerTL.setText(min+":"+sec);
                                        }
                                    }
                                }
                                mHandler.removeCallbacksAndMessages(null);
                            }else {

                                iv_ic_forward_playerTL.setEnabled(false);
                                iv_ic_backward_playerTL.setEnabled(false);
                            }
                            Log.i("timerT" , "on");
                        }
                        mHandler.postDelayed(this, 1000);
                    }
                });
            }
        });


        iv_ic_forward_playerTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer != null){
                    forwardSong(10000);

                }
            }
        });
        iv_ic_backward_playerTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer != null){
                    rewindSong(10000);

                }
            }
        });

        iv_seeAnswer_playerTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView_TestL.getSettings().setJavaScriptEnabled(true);
                webView_TestL.loadUrl("file:///android_asset/" + fileName);
            }
        });

        File file = new File(getFilesDir().
                getAbsolutePath()+"/ielts/listening/test/test"+pageNum+"/audioscripts.txt");

        final StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
            br.close() ;
        }catch (IOException e) {
            e.printStackTrace();
        }

        iv_audioscripts_playerTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dia = new Dialog(TestListenActivity.this);
                dia.setContentView(R.layout.layout_dialog_audioscripts);
               /* Objects.requireNonNull(dia.getWindow()).setLayout((int) (dm.widthPixels*.9)
                        , (int) (dm.heightPixels*.75) );*/

                TextView tv_audioScripts = dia.findViewById(R.id.tv_audioScripts);
                tv_audioScripts.getLayoutParams().width = (int) (dm.widthPixels*.8);
                tv_audioScripts.getLayoutParams().height = (int) (dm.heightPixels*.7);
                tv_audioScripts.setTextSize((int) (dm.widthPixels*.015));
                tv_audioScripts.setText(text);
                dia.show();

            }
        });


    }


    public void rewindSong(int seekBackwardTime ) {
        if (mPlayer != null) {
            int currentPosition = mPlayer.getCurrentPosition();
            if (currentPosition - seekBackwardTime >= 0) {
                mPlayer.seekTo(currentPosition - seekBackwardTime);
            } else {
                mPlayer.seekTo(0);
            }
        }
    }

    public void forwardSong(int seekForwardTime) {
        if (mPlayer != null) {
            int currentPosition = mPlayer.getCurrentPosition();
            if (currentPosition + seekForwardTime <= mPlayer.getDuration()) {
                mPlayer.seekTo(currentPosition + seekForwardTime);
            } else {
                mPlayer.seekTo(mPlayer.getDuration());
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlayer.stop();
    }

    @SuppressLint({"ClickableViewAccessibility", "SetJavaScriptEnabled"})
    public void init(){
        lay_TestL = findViewById(R.id.lay_TestL);
        lay_playerTL = findViewById(R.id.lay_playerTL);
        iv_play_playerTL = findViewById(R.id.iv_play_playerTL);
        iv_ic_org_playerTL = findViewById(R.id.iv_ic_org_playerTL);
        iv_seeAnswer_playerTL = findViewById(R.id.iv_seeAnswer_playerTL);
        iv_time_TestL = findViewById(R.id.iv_time_TestL);
        view_space_playerTL = findViewById(R.id.view_space_playerTL);
        webView_TestL = findViewById(R.id.webView_TestL);
        tv_time_TestL = findViewById(R.id.tv_time_TestL);
        lay_box_playerTL = findViewById(R.id.lay_box_playerTL);
        seekBar_playerTL = findViewById(R.id.seekBar_playerTL);
        et_TestL_Result = findViewById(R.id.et_TestL_Result);
        iv_ic_backward_playerTL = findViewById(R.id.iv_ic_backward_playerTL);
        iv_ic_forward_playerTL = findViewById(R.id.iv_ic_forward_playerTL);
        tv_time_playerTL = findViewById(R.id.tv_time_playerTL);
        iv_audioscripts_playerTL = findViewById(R.id.iv_audioscripts_playerTL);
        view_center_see_audio = findViewById(R.id.view_center_see_audio);



        //iv_ic_backward_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.8);
        iv_ic_backward_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.05);

        //iv_ic_forward_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.8);
        iv_ic_forward_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.05);

        tv_time_playerTL.setTextSize((int) (dm.widthPixels*.015));


        lay_TestL.getLayoutParams().width = (int) (dm.widthPixels*.93);


        lay_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.8);
        lay_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.275);



        lay_box_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.23);



        //iv_play_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        iv_play_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //view_space_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        view_space_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.16);

        iv_ic_org_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.21);
        iv_ic_org_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.21);

        iv_time_TestL.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_time_TestL.getLayoutParams().height = (int) (dm.widthPixels*.1);




        webView_TestL.getLayoutParams().width = (int) (dm.widthPixels*.75);
        webView_TestL.getLayoutParams().height = (int) (dm.widthPixels*.4);

        webView_TestL.getSettings().setJavaScriptEnabled(true);
        webView_TestL.loadUrl("file:///android_asset/" + fileName);


        iv_seeAnswer_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_seeAnswer_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.074);

        iv_audioscripts_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_audioscripts_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.074);


        view_center_see_audio.getLayoutParams().width = (int) (dm.widthPixels*.15);

        // seekBar_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        seekBar_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.03);
        //seekBar_playerTL.setEnabled(false);
        seekBar_playerTL.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {

            int originalProgress;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Nothing here..
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                originalProgress = seekBar.getProgress();
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int arg1, boolean fromUser) {
                if(fromUser){
                    seekBar.setProgress( originalProgress);
                }
            }
        });

        tv_time_TestL.setTextSize((int) (dm.widthPixels*.015));

        et_TestL_Result.getLayoutParams().width = (int) (dm.widthPixels*.75);
        et_TestL_Result.getLayoutParams().height = (int) (dm.widthPixels*.4);
        et_TestL_Result.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (et_TestL_Result.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }
                return false;

            }
        });

        webView_TestL.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (webView_TestL.hasFocus()) {
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


    public void CheckIntent()
    {
        if(getIntent().getExtras().getInt("Number") != 0)
        {
            Toast.makeText(this,""+getIntent().getExtras().getInt("Number"),Toast.LENGTH_LONG).show();
        }
    }

    private void initActionBar() {

        iv_ic_logoPage_TestL = findViewById(R.id.iv_ic_logoPage_TestL);
        tv_TitleLogo_TestL = findViewById(R.id.tv_TitleLogo_TestL);
        tv_PathLogo_TestL = findViewById(R.id.tv_PathLogo_TestL);
        iv_arrowBack_TestL = findViewById(R.id.iv_arrowBack_TestL);

        iv_arrowBack_TestL.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_TestL.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_TestL.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_TestL.getLayoutParams().height = (int) (dm.widthPixels*.1);

        tv_TitleLogo_TestL.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_TestL.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_TestL.setText("Test1");
        tv_PathLogo_TestL.setText("Listening");

        iv_arrowBack_TestL.setOnClickListener(new View.OnClickListener() {
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
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

}
