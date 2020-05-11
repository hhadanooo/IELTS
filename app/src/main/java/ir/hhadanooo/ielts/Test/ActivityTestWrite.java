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

    TextView tv_TitleLogo_SimpleText,tv_PathLogo_SimpleText,tv_title_main_page;
    ImageView img_back;
    ImageView img_see_example,img_shareanswer,img_submit;
    CustomEditText et_main_page;
    ImageView img_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_write);
        getSupportActionBar().hide();
        initActionBar();
        init();

        SetPropertiesRelBody();



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

        tv_TitleLogo_SimpleText.setText("Text1");
        tv_PathLogo_SimpleText.setText("Listening");



        iv_arrowBack_SimpleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void init()
    {
        rel_body = findViewById(R.id.activity_test_Write_rel_body);
        rel_main_page = findViewById(R.id.activity_test_write_rel_main_page);
        rel_title_main_page= findViewById(R.id.activity_test_write_rel_title_main_page);


        tv_title_main_page = findViewById(R.id.activity_test_write_tv_title_main_page);

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
                    tv_PathLogo_SimpleText.setText("Writing/Academic");
                    tv_title_main_page.setText("TOPIC Academic " + getIntent().getExtras().getInt("Number"));
                }
            }else if(getIntent().getExtras().getString("General") != null)
            {
                if(getIntent().getExtras().getInt("Number") != 0)
                {

                    tv_PathLogo_SimpleText.setText("Writing/General");
                    tv_title_main_page.setText("TOPIC General " + getIntent().getExtras().getInt("Number"));

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
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        rel_main_page.getLayoutParams().width = (int) (dm.widthPixels*.90);
        //rel_main_page.getLayoutParams().height = (int)(dm.heightPixels*0.78);

        rel_title_main_page.getLayoutParams().width = (int) (dm.widthPixels*.75);
        rel_title_main_page.getLayoutParams().height = (int)(dm.widthPixels*0.22);

        tv_title_main_page.setMaxWidth((int) (dm.widthPixels * 0.65));
        tv_title_main_page.setMaxHeight((int) (dm.heightPixels * 0.13));

        tv_title_main_page.setTextSize((int) (dm.widthPixels * 0.011));

        tv_title_main_page.setTextColor(Color.BLACK);


        img_see_example.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        img_see_example.getLayoutParams().height = (int) (dm.widthPixels*0.074);

        et_main_page.getLayoutParams().width = (int) (dm.widthPixels*0.75);
        et_main_page.getLayoutParams().height = (int) (dm.widthPixels*0.59);

        img_submit.setBackground(getDrawable(R.drawable.submit_icon1));
        img_see_example.setBackground(getDrawable(R.drawable.seesample_icon1));
        img_shareanswer.setBackground(getDrawable(R.drawable.shareanswer_icon1));

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



        img_timer.getLayoutParams().width = (int) (dm.widthPixels*0.07);
        img_timer.getLayoutParams().height = (int) (dm.widthPixels*0.07);






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
