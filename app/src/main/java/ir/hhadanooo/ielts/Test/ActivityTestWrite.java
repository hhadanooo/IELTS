package ir.hhadanooo.ielts.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.hhadanooo.ielts.CustomView.CustomEditText;
import ir.hhadanooo.ielts.R;

public class ActivityTestWrite extends AppCompatActivity {
    RelativeLayout rel_body, rel_main_page,rel_title_main_page;
    ImageView img_body;
    TextView tv1_about_icon,tv2_about_icon,tv_title_main_page;
    ImageView img_back;
    ImageView img_see_example,img_shareanswer,img_submit;
    CustomEditText et_main_page;
    ImageView img_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_write);
        getSupportActionBar().hide();
        init();
        SetPropertiesRelBody();



    }
    public void init()
    {
        rel_body = findViewById(R.id.activity_test_Write_rel_body);
        rel_main_page = findViewById(R.id.activity_test_write_rel_main_page);
        rel_title_main_page= findViewById(R.id.activity_test_write_rel_title_main_page);

        img_body = findViewById(R.id.activity_test_write_img_body);


        tv1_about_icon = findViewById(R.id.activity_test_write_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_test_write_tv2_about_icon);

        tv_title_main_page = findViewById(R.id.activity_test_write_tv_title_main_page);


        img_back = findViewById(R.id.activity_test_write_actionbar_img_icon_back);

        img_see_example = findViewById(R.id.activity_test_write_img_see_example);
        img_shareanswer = findViewById(R.id.activity_test_write_img_shareanswer);
        img_submit = findViewById(R.id.activity_test_write_img_submit);


        et_main_page = findViewById(R.id.activity_test_write_edit_text_main_page);

        img_timer = findViewById(R.id.activity_test_write_img_timer);




        checkIntent();
        SetPropertiesMainPage();





    }

    public void checkIntent()
    {
        if(getIntent().getExtras().getString("Write") != null)
        {
            if(getIntent().getExtras().getString("Academic") != null)
            {
                if(getIntent().getExtras().getInt("Number") != 0)
                {
                    tv2_about_icon.setText("Writing/Academic");
                    tv_title_main_page.setText("TOPIC Academic " + getIntent().getExtras().getInt("Number"));
                }
            }else if(getIntent().getExtras().getString("General") != null)
            {
                if(getIntent().getExtras().getInt("Number") != 0)
                {


                    tv2_about_icon.setText("Writing/General");
                    tv_title_main_page.setText("TOPIC General " + getIntent().getExtras().getInt("Number"));

                }
            }
        }
    }
    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        tv1_about_icon.setText("Test");


        img_body.setBackground(getResources().getDrawable(R.drawable.tip_icon));

        img_body.getLayoutParams().width = (int) (dm.widthPixels*.17);
        img_body.getLayoutParams().height = (int) (dm.widthPixels*.17);

        rel_body.getLayoutParams().height = (int)(dm.heightPixels*0.16);



        tv1_about_icon.setTextSize((int) (dm.widthPixels * 0.020));
        tv2_about_icon.setTextSize((int) (dm.widthPixels * 0.0125));

        tv1_about_icon.setTextColor(Color.BLACK);

        img_body.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        img_body.getLayoutParams().height = (int) (dm.widthPixels*0.25);


        img_back.getLayoutParams().width = (int) (dm.widthPixels*.1);
        img_back.getLayoutParams().height = (int) (dm.widthPixels*.1);




        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void SetPropertiesMainPage()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        rel_main_page.getLayoutParams().width = (int) (dm.widthPixels*.90);
        rel_main_page.getLayoutParams().height = (int)(dm.heightPixels*0.78);

        rel_title_main_page.getLayoutParams().width = (int) (dm.widthPixels*.75);
        rel_title_main_page.getLayoutParams().height = (int)(dm.heightPixels*0.10);

        tv_title_main_page.setMaxWidth((int) (dm.widthPixels * 0.65));
        tv_title_main_page.setMaxHeight((int) (dm.heightPixels * 0.13));

        tv_title_main_page.setTextSize((int) (dm.widthPixels * 0.013));

        tv_title_main_page.setTextColor(Color.BLACK);


        img_see_example.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        img_see_example.getLayoutParams().height = (int) (dm.heightPixels*0.04);

        et_main_page.getLayoutParams().width = (int) (dm.widthPixels*0.75);
        et_main_page.getLayoutParams().height = (int) (dm.heightPixels*0.35);

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


        img_shareanswer.getLayoutParams().width = (int) (dm.widthPixels*0.295);
        img_shareanswer.getLayoutParams().height = (int) (dm.heightPixels*0.045);

        img_submit.getLayoutParams().width = (int) (dm.widthPixels*0.295);
        img_submit.getLayoutParams().height = (int) (dm.heightPixels*0.045);



        img_timer.getLayoutParams().width = (int) (dm.widthPixels*0.15);
        img_timer.getLayoutParams().height = (int) (dm.widthPixels*0.15);






        img_see_example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img_shareanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }
}
