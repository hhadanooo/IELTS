package ir.hhadanooo.ielts.Practice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.hhadanooo.ielts.R;

public class Activity_practice_read extends AppCompatActivity {
    RelativeLayout rel_body,rel_main_page,rel_title_main_page;
    ImageView img_body;
    TextView tv1_about_icon,tv2_about_icon;

    ImageView img_back;

    TextView tv_title_main_page,tv_count;

    RelativeLayout rel_text;
    TextView tv_text;

    ImageView img_see_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_read);
        getSupportActionBar().hide();
        init();
        CheckIntent();
        SetPropertiesRelBody();
        SetPropertiesMainPage();

    }

    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Easy") != null)
        {
            tv_title_main_page.setText("Find any World/Words that show 'Age'      Easy ");
            tv_text.setText("Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elitLorem ipsum  dolor  sit  amet, consectetur adipsiscing elit"
                    +"Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolorLorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor");

        }else if(getIntent().getExtras().getString("Normal") != null) {

            tv_title_main_page.setText("Find any World/Words that show 'Age'     Normal ");
            tv_text.setText("Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elitLorem ipsum  dolor  sit  amet, consectetur adipsiscing elit"
                    +"Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolorLorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor");

        }else if(getIntent().getExtras().getString("Hard") != null)
        {

            tv_title_main_page.setText("Find any World/Words that show 'Age'     Hard ");
            tv_text.setText("Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elitLorem ipsum  dolor  sit  amet, consectetur adipsiscing elit"
                    +"Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolorLorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor Lorem ipsum  dolor  sit  amet, consectetur adipsiscing elit,Lorem ipsum  dolor");


        }
    }

    public void init()
    {
        rel_body = findViewById(R.id.activity_practice_read_rel_body);
        img_body = findViewById(R.id.activity_practice_read_img_body);

        rel_main_page = findViewById(R.id.activity_practice_read_rel_main_page);
        rel_title_main_page = findViewById(R.id.activty_practice_read_rel_title);

        tv1_about_icon = findViewById(R.id.activity_practice_read_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_practice_read_tv2_about_icon);

        img_back = findViewById(R.id.activity_practice_read_actionbar_img_icon_back);

        tv_title_main_page = findViewById(R.id.activity_practice_read_tv_title_main_page);
        tv_count = findViewById(R.id.activity_practice_read_tv_count);

        rel_text =findViewById(R.id.activty_practice_read_rel_text);
        tv_text = findViewById(R.id.activity_practice_read_tv_text);

        img_see_answer = findViewById(R.id.activity_practice_read_img_see_answer);
    }

    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        tv1_about_icon.setText("Practice");
        tv2_about_icon.setText("Reading");

        img_body.setBackground(getResources().getDrawable(R.drawable.practice_icon));


        rel_body.getLayoutParams().height = (int)(dm.heightPixels*0.16);

        tv1_about_icon.setTextSize((int) (dm.widthPixels * 0.017));
        tv2_about_icon.setTextSize((int) (dm.widthPixels * 0.01));

        tv1_about_icon.setTextColor(Color.BLACK);

        img_body.getLayoutParams().width = (int) (dm.widthPixels*0.15);
        img_body.getLayoutParams().height = (int) (dm.widthPixels*0.15);


        img_back.getLayoutParams().width = (int) (dm.widthPixels*.1);
        img_back.getLayoutParams().height = (int) (dm.widthPixels*.1);



        img_see_answer.setBackground(getDrawable(R.drawable.seeanswer_icon1));

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





    }
    public void SetPropertiesMainPage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        rel_main_page.getLayoutParams().width = (int) (dm.widthPixels * .90);
        rel_main_page.getLayoutParams().height = (int) (dm.heightPixels * 0.78);

        rel_title_main_page.getLayoutParams().width = (int) (dm.widthPixels * .80);
        rel_title_main_page.getLayoutParams().height = (int) (dm.heightPixels * 0.16);


        rel_text.getLayoutParams().width = (int) (dm.widthPixels * .80);
        rel_text.getLayoutParams().height = (int) (dm.heightPixels * 0.42);

        tv_title_main_page.setMaxWidth((int) (dm.widthPixels * 0.75));

        tv_title_main_page.setTextColor(Color.BLACK);
        tv_title_main_page.setTextSize((int) (dm.widthPixels * 0.02));



        tv_text.setMaxWidth((int) (dm.widthPixels * 0.80));
        tv_text.setTextSize((int) (dm.widthPixels * 0.016));

        tv_text.setTextColor(Color.BLACK);




        img_see_answer.getLayoutParams().width = (int) (dm.widthPixels * 0.30);
        img_see_answer.getLayoutParams().height = (int) (dm.heightPixels * 0.05);

        tv_count.setTextSize((int) (dm.widthPixels * 0.022));
    }
}
