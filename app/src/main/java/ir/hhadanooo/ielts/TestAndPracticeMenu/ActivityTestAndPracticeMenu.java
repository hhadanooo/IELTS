package ir.hhadanooo.ielts.TestAndPracticeMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.hhadanooo.ielts.AboutTheTest.ActivityAboutTheTest;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.R;

public class ActivityTestAndPracticeMenu extends AppCompatActivity {


    RelativeLayout rel_body,rel_list_item;
    ImageView img_body;
    LinearLayout lin;
    String Type = "";
    int num_type = 0;
    ImageView img_home_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_and_practice_menu);
        init();
        CheckIntent();

        SetPropertiesRelBtnHomeBotton();





        


    }
    public void init()
    {


        rel_body = findViewById(R.id.activity_test_menu_rel_body);
        rel_list_item = findViewById(R.id.activity_test_menu_rel_list_item);
        img_body = findViewById(R.id.activity_test_menu_img_body);
        lin = findViewById(R.id.activity_test_menu_lin_list_item);
        img_home_bottom = findViewById(R.id.activity_test_menu_btn_home);


    }
    public void SetPropertiesRelBtnHomeBotton()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params1.setMargins(0, 0, 0, (int) (dm.heightPixels * 0.03));
        img_home_bottom.setLayoutParams(params1);

        img_home_bottom.getLayoutParams().width = (int)(dm.widthPixels*0.25);
        img_home_bottom.getLayoutParams().height = (int)(dm.widthPixels*0.25);

        img_home_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Listen") != null)
        {
            Type = "Listen";
            num_type = 1;
            SetPropertiesActionBar(true);
            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if(getIntent().getExtras().getString("Speak") != null)
        {
            Type = "Speak";
            num_type = 2;
            SetPropertiesActionBar(true);
            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if(getIntent().getExtras().getString("Read") != null)
        {
            Type = "Read";
            num_type = 3;
            SetPropertiesActionBar(true);
            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if (getIntent().getExtras().getString("Write") != null)
        {
            Type = "Write";
            num_type = 4;
            SetPropertiesRelBody();
            SetPropertiesCustomView();
            SetPropertiesActionBar(true);
        }
    }

    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        if(num_type == 1)
        {

            img_body.setBackground(getResources().getDrawable(R.drawable.page_reading_icon));
        }else if(num_type == 2)
        {

            img_body.setBackground(getResources().getDrawable(R.drawable.page_reading_icon));
        }else if(num_type == 3)
        {

            img_body.setBackground(getResources().getDrawable(R.drawable.page_reading_icon));
        }else if(num_type == 4)
        {

            img_body.setBackground(getResources().getDrawable(R.drawable.page_reading_icon));
        }

        img_body.getLayoutParams().width = (int) (dm.widthPixels*.375);
        img_body.getLayoutParams().height = (int) (dm.widthPixels*.5);
        rel_body.getLayoutParams().height = (int)(dm.widthPixels*0.495);




    }

    public void SetPropertiesActionBar(boolean menu)
    {


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#bcd9f9")));
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();


        ImageView img_icon_menu = view.findViewById(R.id.actionbar_img_icon_menu);
        if(menu)
        {
            img_icon_menu.setBackground(getResources().getDrawable(R.drawable.menu_main));
        }else {
            img_icon_menu.setBackground(getResources().getDrawable(R.drawable.icon_arrow_back));
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon_menu.getLayoutParams().width = (int)(dm.widthPixels*0.1);
        img_icon_menu.getLayoutParams().height = (int)(dm.widthPixels*0.1);
        TextView tv_title = view.findViewById(R.id.actionbar_tv_title);



        tv_title.setTextSize((int) (dm.widthPixels * 0.02));








    }


    public void SetPropertiesCustomView()
    {

            CustomViewItem custom1 = new CustomViewItem(this);
            CustomViewItem custom2 = new CustomViewItem(this);
            CustomViewItem custom3 = new CustomViewItem(this);


            SetSettingCustomItem("","Test",custom1,getResources().getDrawable(R.drawable.reading_icon));
            SetSettingCustomItem("","Practice",custom2,getResources().getDrawable(R.drawable.practice_icon));
            SetSettingCustomItem("","Tips",custom3,getResources().getDrawable(R.drawable.tips_icon));


            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent  = new Intent(ActivityTestAndPracticeMenu.this,ActivityAboutTheTest.class);
                    intent.putExtra(Type, Type);
                    startActivity(intent);
                }
            });
        custom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);



    }

    public void SetSettingCustomItem(String Body, String title, CustomViewItem custom, Drawable icon1)
    {
        //init all view custom view
        TextView tv_title = custom.getTv_title();
        TextView tv_body = custom.getTv_body();
        ImageView img_icon = custom.getImg_icon();
        ImageView img_icon1 = custom.getImg_icon1();

        RelativeLayout relativeLayout = custom.getrel();


        //Give value to view
        custom.SetTextTvTitle(title);
        custom.SetIcon(getResources().getDrawable(R.drawable.arrowmore));
        img_icon1.setBackground(icon1);


        // set width and height icon custom view
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon.getLayoutParams().width = (int)(dm.widthPixels*0.10);
        img_icon.getLayoutParams().height = (int)(dm.widthPixels*0.10);

        img_icon1.getLayoutParams().width = (int)(dm.widthPixels*0.10);
        img_icon1.getLayoutParams().height = (int)(dm.widthPixels*0.10);


        //set width and height layout custom view
        relativeLayout.getLayoutParams().width = (int)(dm.widthPixels*0.95);


        //set maxwidth tv body
        tv_body.setMaxWidth((int) (dm.widthPixels * 0.65));

        tv_body.setTextColor(Color.BLACK);
        tv_title.setTextColor(Color.BLACK);



        //set margin
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, (int) (dm.widthPixels * 0.04), 0, 0);
        custom.setLayoutParams(params);


        //set text size tv body,tv title
        tv_body.setTextSize((int) (dm.widthPixels * 0.010));
        tv_title.setTextSize((int) (dm.widthPixels * 0.013));

        //set center veritcal tv title

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params1.setMargins(0, (int) (dm.widthPixels * 0.04), 0, 0);
        tv_title.setLayoutParams(params1);

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tv_title.getLayoutParams();
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.addRule(RelativeLayout.CENTER_VERTICAL);
        tv_title.setLayoutParams(lp);
    }
}
