package ir.hhadanooo.ielts.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.hhadanooo.ielts.R;

public class ActivityTestWrite extends AppCompatActivity {
    RelativeLayout rel_body, rel_main_page,rel_title_main_page;
    ImageView img_body;
    TextView tv1_about_icon,tv2_about_icon,tv_title_main_page;
    ImageView img_back;

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


        SetPropertiesMainPage();





    }
    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        tv1_about_icon.setText("Test");
        tv2_about_icon.setText("Writing/Academic");

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
        rel_title_main_page.getLayoutParams().height = (int)(dm.heightPixels*0.13);

        tv_title_main_page.setMaxWidth((int) (dm.widthPixels * 0.65));
        tv_title_main_page.setMaxHeight((int) (dm.heightPixels * 0.13));

        tv_title_main_page.setTextSize((int) (dm.widthPixels * 0.013));
        tv_title_main_page.setText("TOPIC");
        tv_title_main_page.setTextColor(Color.BLACK);

        



    }
}
