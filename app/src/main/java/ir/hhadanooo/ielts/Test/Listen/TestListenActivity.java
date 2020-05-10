package ir.hhadanooo.ielts.Test.Listen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ir.hhadanooo.ielts.R;

public class TestListenActivity extends AppCompatActivity {

    DisplayMetrics dm;
    LinearLayout lay_TestL , lay_box_playerTL;
    RelativeLayout lay_playerTL;
    ImageView iv_play_playerTL , iv_ic_org_playerTL , iv_seeAnswer_playerTL , iv_time_TestL , iv_ic_logoPage_TestL , iv_arrowBack_TestL;
    View view_space_playerTL ;
    EditText et_TestL , et_TestL_Result;
    TextView tv_time_TestL , tv_TitleLogo_TestL ,tv_PathLogo_TestL;
    SeekBar seekBar_playerTL;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listen);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        initActionBar();

        lay_TestL = findViewById(R.id.lay_TestL);
        lay_playerTL = findViewById(R.id.lay_playerTL);
        iv_play_playerTL = findViewById(R.id.iv_play_playerTL);
        iv_ic_org_playerTL = findViewById(R.id.iv_ic_org_playerTL);
        iv_seeAnswer_playerTL = findViewById(R.id.iv_seeAnswer_playerTL);
        iv_time_TestL = findViewById(R.id.iv_time_TestL);
        view_space_playerTL = findViewById(R.id.view_space_playerTL);
        et_TestL = findViewById(R.id.et_TestL);
        tv_time_TestL = findViewById(R.id.tv_time_TestL);
        lay_box_playerTL = findViewById(R.id.lay_box_playerTL);
        seekBar_playerTL = findViewById(R.id.seekBar_playerTL);
        et_TestL_Result = findViewById(R.id.et_TestL_Result);




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




        et_TestL.getLayoutParams().width = (int) (dm.widthPixels*.75);
        et_TestL.getLayoutParams().height = (int) (dm.widthPixels*.4);


        iv_seeAnswer_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_seeAnswer_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.074);

       // seekBar_playerTL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        seekBar_playerTL.getLayoutParams().height = (int) (dm.widthPixels*.03);

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

        et_TestL.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (et_TestL.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }
                return false;

            }
        });

        CheckIntent();


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

}
