package ir.hhadanooo.ielts.Practice.Listen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ir.hhadanooo.ielts.R;
import ir.hhadanooo.ielts.Test.Listen.TestListenActivity;

public class ListenPracticeBActivity extends AppCompatActivity {

    DisplayMetrics dm;
    LinearLayout lay_PracticeBL , lay_box_playerPBL;
    RelativeLayout lay_playerPBL;
    ImageView iv_play_playerPBL , iv_next_playerPBL , iv_ic_org_playerPBL
            , iv_shareAnswer_playerPBL , iv_checkAnswer_playerPBL , iv_arrowBack_practiceBL
            , iv_ic_logoPage_practiceBL;
    View view_space_playerPBL , viewB_space_button_see_share;
    EditText et_PracticeBL;
    TextView tv_TitleLogo_practiceBL , tv_PathLogo_practiceBL  ,tv_time_playerPBL;

    MediaPlayer mPlayer;
    int duration , sec , min;
    Handler mHandler = new Handler();

    List<String> answerList = new ArrayList<>();

    int finalD = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_practice_b);
        Log.i("RaminMaleki1234", "onCreate: ");
        Objects.requireNonNull(getSupportActionBar()).hide();
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        initActionBar();
        init();
        String intent = "text 1";
        String intent1 = "easy";
        int pageNum = Integer.parseInt(intent.substring(intent.length()-1));

        Log.i("pagenum" , "("+pageNum+")");


        mPlayer = new MediaPlayer();
        try {

            FileInputStream fileInputStream = new FileInputStream(getFilesDir().
                    getAbsolutePath()+"/ielts/listening/practice/" +
                    "transcription/"+intent1+"/"+getIntent().getExtras().getString("NameFile")+"/audio.mp3");
            mPlayer.setDataSource(fileInputStream.getFD());
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        duration = mPlayer.getDuration()/1000;
        iv_play_playerPBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_play_playerPBL.setEnabled(false);
                mPlayer.start();
                ListenPracticeBActivity.this.runOnUiThread(new Runnable() {

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        if(mPlayer != null){
                            int mCurrentPosition = mPlayer.getCurrentPosition() / 1000;

                            if (duration > mCurrentPosition){
                                if(mCurrentPosition < 60){
                                    if (mCurrentPosition < 10){
                                        tv_time_playerPBL.setText("00:0"+mCurrentPosition);
                                    }else {
                                        tv_time_playerPBL.setText("00:"+mCurrentPosition);
                                    }
                                }else {
                                    sec = (mCurrentPosition%60);
                                    min = (mCurrentPosition-sec)/60;
                                    if (min < 10 ){
                                        if (sec < 10){
                                            tv_time_playerPBL.setText("0"+min+":0"+sec);
                                        }else {
                                            tv_time_playerPBL.setText("0"+min+":"+sec);
                                        }
                                    }else {
                                        if (sec < 10){
                                            tv_time_playerPBL.setText(min+":0"+sec);
                                        }else {
                                            tv_time_playerPBL.setText(min+":"+sec);
                                        }
                                    }
                                }
                                mHandler.removeCallbacksAndMessages(null);
                            }
                            Log.i("timerT" , "on");
                        }
                        mHandler.postDelayed(this, 1000);
                    }
                });
            }
        });

        File file = new File(getFilesDir().
                getAbsolutePath()+"/ielts/listening/practice/" +
                "transcription/"+intent1+"/"+getIntent().getExtras().getString("NameFile")+"/answer.txt");

        final StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
            }
            br.close() ;
        }catch (IOException e) {
            e.printStackTrace();
        }

        iv_checkAnswer_playerPBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_checkAnswer_playerPBL.setEnabled(false);
                String result  = String.valueOf(text);
                answerList.clear();
                String test = et_PracticeBL.getText().toString()+" ";
                String[] results = result.split(" ");
                List<String> lis = Arrays.asList(results);
                float darsad =  (100f/lis.size());
                int ttrue = 0;
                float d = 0;
                test = test.replace(   "\n" , " " );
                for (int i = 0; i < lis.size() ;i++ ){
                    if (test.contains(lis.get(i)+" ")){
                        ttrue++;
                        d = d+darsad;
                        if (ttrue == lis.size() ){
                            d = 100;
                        }
                        answerList.add(lis.get(i));
                        test = test.replaceFirst(   lis.get(i) , "true01" );
                        Log.i("tesssst" , ""+test);
                        finalD = (int)d;
                    }
                }
               /* Toast.makeText(ListenPracticeBActivity.this, " number of true answer : "
                        +ttrue+"\n number of answer : "+lis.size()+"\n percentage of true answer : "+d+"%", Toast.LENGTH_LONG).show();*/


                if (ttrue == lis.size() ){
                    final Snackbar snackbar;
                    snackbar = Snackbar.make(v, " results true", Snackbar.LENGTH_LONG);
                    snackbar.setAction("ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snackbar.dismiss();
                        }
                    });
                    snackbar.getView().setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    snackbar.show();
                }else {
                    final Snackbar snackbar;
                    snackbar = Snackbar.make(v, " results is false.\n true results : "+result, Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snackbar.dismiss();
                        }
                    });
                    snackbar.getView().setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    snackbar.show();
                }



            }
        });

        iv_shareAnswer_playerPBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myText =et_PracticeBL.getText().toString();
                if (!myText.isEmpty() && !myText.equals(" ")){
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    if (et_PracticeBL.getText() != null){
                        myText = et_PracticeBL.getText().toString();
                    }
                    sendIntent.putExtra(Intent.EXTRA_TEXT, myText);
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }

            }
        });


    }
    public boolean checkForRepeatTrueAnswer(String answer){
        boolean repeat = false;
        for (int i = 0 ; i < answerList.size() ; i++){
            if (answerList.get(i).equals(answer)){
                repeat = true;
            }
        }
        return repeat;
    }

    private void initActionBar() {

        iv_arrowBack_practiceBL = findViewById(R.id.iv_arrowBack_practiceBL);
        iv_ic_logoPage_practiceBL = findViewById(R.id.iv_ic_logoPage_practiceBL);
        tv_TitleLogo_practiceBL = findViewById(R.id.tv_TitleLogo_practiceBL);
        tv_PathLogo_practiceBL = findViewById(R.id.tv_PathLogo_practiceBL);

        iv_arrowBack_practiceBL.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_practiceBL.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_practiceBL.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_practiceBL.getLayoutParams().height = (int) (dm.widthPixels*.1);

        tv_TitleLogo_practiceBL.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_practiceBL.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_practiceBL.setText("type1");
        tv_PathLogo_practiceBL.setText("Listening");

        iv_arrowBack_practiceBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void init(){
        lay_PracticeBL = findViewById(R.id.lay_PracticeBL);
        lay_box_playerPBL = findViewById(R.id.lay_box_playerPBL);
        lay_playerPBL = findViewById(R.id.lay_playerPBL);
        tv_time_playerPBL = findViewById(R.id.tv_time_playerPBL);
        iv_play_playerPBL = findViewById(R.id.iv_play_playerPBL);
        iv_next_playerPBL = findViewById(R.id.iv_next_playerPBL);
        view_space_playerPBL = findViewById(R.id.view_space_playerPBL);
        iv_ic_org_playerPBL = findViewById(R.id.iv_ic_org_playerPBL);
        et_PracticeBL = findViewById(R.id.et_PracticeBL);
        iv_shareAnswer_playerPBL = findViewById(R.id.iv_shareAnswer_playerPBL);
        iv_checkAnswer_playerPBL = findViewById(R.id.iv_checkAnswer_playerPBL);
        viewB_space_button_see_share = findViewById(R.id.viewB_space_button_see_share);


        lay_PracticeBL.getLayoutParams().width = (int) (dm.widthPixels*.93);


        lay_playerPBL.getLayoutParams().width = (int) (dm.widthPixels*.8);
        lay_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.275);

        lay_box_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.23);

        tv_time_playerPBL.setTextSize((int) (dm.widthPixels*.015));

        //iv_repeat_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        //iv_repeat_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //iv_play_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        iv_play_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //iv_next_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        iv_next_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //view_space_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        view_space_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.16);

        iv_ic_org_playerPBL.getLayoutParams().width = (int) (dm.widthPixels*.21);
        iv_ic_org_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.21);

        et_PracticeBL.getLayoutParams().width = (int) (dm.widthPixels*.75);
        et_PracticeBL.getLayoutParams().height = (int) (dm.widthPixels*.4);

        iv_shareAnswer_playerPBL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_shareAnswer_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.074);

        iv_checkAnswer_playerPBL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_checkAnswer_playerPBL.getLayoutParams().height = (int) (dm.widthPixels*.074);

        viewB_space_button_see_share.getLayoutParams().width = (int) (dm.widthPixels*.2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        mPlayer.stop();
    }
}
