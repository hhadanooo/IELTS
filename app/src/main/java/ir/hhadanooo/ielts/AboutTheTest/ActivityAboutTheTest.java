package ir.hhadanooo.ielts.AboutTheTest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.R;

public class ActivityAboutTheTest extends AppCompatActivity {
    RelativeLayout rel_body,rel_list_item;
    TextView tv_body;
    LinearLayout lin;
    Button btn_more;
    String Type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_test);
        init();
        CheckIntent();


    }
    public void init()
    {
        btn_more = findViewById(R.id.activity_about_test_btn_more);
        rel_body = findViewById(R.id.activity_about_test_rel_body);
        rel_list_item = findViewById(R.id.activity_about_test_rel_list_item);
        tv_body = findViewById(R.id.activity_about_test_tv_body);
        lin = findViewById(R.id.activity_about_test_lin_list_item);
    }
    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Listen") != null)
        {
            Toast.makeText(this,"listen",Toast.LENGTH_LONG).show();
            Type = "Listen";
            SetPropertiesActionBar(false,"Listening");
            SetPropertiesRelBody("Learn all about the Listening test");
            SetPropertiesCustomView(1);
        }else if(getIntent().getExtras().getString("Speak") != null)
        {
            Toast.makeText(this,"speak",Toast.LENGTH_LONG).show();
            Type = "Speak";
            SetPropertiesActionBar(false,"Speaking");
            SetPropertiesRelBody("Learn all about the Speaking test");
            SetPropertiesCustomView(2);
        }else if(getIntent().getExtras().getString("Read") != null)
        {
            Toast.makeText(this,"read",Toast.LENGTH_LONG).show();
            Type = "Read";
            SetPropertiesActionBar(false,"Reading");
            SetPropertiesRelBody("Learn all about the Reading test");
            SetPropertiesCustomView(3);
        }else if (getIntent().getExtras().getString("Write") != null)
        {
            Toast.makeText(this,"write",Toast.LENGTH_LONG).show();
            Type = "Write";
            SetPropertiesRelBody("Learn all about the Writeing test");
            SetPropertiesActionBar(false,"Writeing");
            SetPropertiesCustomView(4);;
        }
    }

    public void SetPropertiesRelBody(String Text)
    {
        tv_body = findViewById(R.id.activity_about_test_tv_body);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        tv_body.setMaxWidth((int) (dm.widthPixels * 0.92));
        tv_body.setText(Text);
        tv_body.setTextSize((int) (dm.widthPixels * 0.015));
        rel_body.getLayoutParams().height = (int)(dm.widthPixels*0.3);

        rel_list_item.getLayoutParams().height = (int)(dm.widthPixels*1.3);






        btn_more.getLayoutParams().width = (int)(dm.widthPixels*0.5);
        btn_more.getLayoutParams().height = (int)(dm.widthPixels*0.14);

        btn_more.setTextSize((int)(dm.widthPixels*0.0185));
    }

    public void SetPropertiesActionBar(boolean menu ,String TextTitle)
    {


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7182E3")));
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_custom_action_bar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        ImageView img_icon_menu = view.findViewById(R.id.actionbar_img_icon_menu);
        if(menu)
        {
            img_icon_menu.setBackground(getResources().getDrawable(R.drawable.icon_menu));
        }else {
            img_icon_menu.setBackground(getResources().getDrawable(R.drawable.icon_arrow_back));
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon_menu.getLayoutParams().width = (int)(dm.widthPixels*0.1);
        img_icon_menu.getLayoutParams().height = (int)(dm.widthPixels*0.1);
        TextView tv_title = view.findViewById(R.id.actionbar_tv_title);
        tv_title.setText(TextTitle);



        tv_title.setTextSize((int) (dm.widthPixels * 0.02));








    }


    public void SetPropertiesCustomView(int check)
    {
        if(check == 1)
        {
            CustomViewItem custom1 = new CustomViewItem(this);
            CustomViewItem custom2 = new CustomViewItem(this);
            CustomViewItem custom3 = new CustomViewItem(this);
            CustomViewItem custom4 = new CustomViewItem(this);

            SetSettingCustomItem("Check out some exmaples of the types of questions you can exect to see in the Listening","Understand the Test Format",custom1);
            SetSettingCustomItem("Understand how the test is marked and what topics might come up","Topics and Marking",custom2);
            SetSettingCustomItem("Tips and tricks to help you perform at your best","Answering Techniques",custom3);
            SetSettingCustomItem("prepare yourself better by taking a quiz","Take Quiz",custom4);


            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);
            lin.addView(custom4);


        }else if(check == 2)
        {
            CustomViewItem custom1 = new CustomViewItem(this);
            CustomViewItem custom2 = new CustomViewItem(this);
            CustomViewItem custom3 = new CustomViewItem(this);
            CustomViewItem custom4 = new CustomViewItem(this);
            CustomViewItem custom5 = new CustomViewItem(this);
            CustomViewItem custom6 = new CustomViewItem(this);

            SetSettingCustomItem("Know what to exect during the Speaking test","Understand the Test Format",custom1);
            SetSettingCustomItem("Understand the different types of questions asked in the Speaking test","Question Types",custom2);
            SetSettingCustomItem("Understand how the Speaking test is marjed","Assessment criteria",custom3);
            SetSettingCustomItem("prepare for the Speaking test with our videos","interview Videos",custom4);
            SetSettingCustomItem("Assess your speaking skills and learn how you can improve them","Checklist",custom5);
            SetSettingCustomItem("Prepare yourself better by taking a quiz","Take Quiz",custom6);

            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);
            lin.addView(custom4);
            lin.addView(custom5);
            lin.addView(custom6);

        }else if(check == 3)
        {
            CustomViewItem custom1 = new CustomViewItem(this);
            CustomViewItem custom2 = new CustomViewItem(this);
            CustomViewItem custom3 = new CustomViewItem(this);
            CustomViewItem custom4 = new CustomViewItem(this);
            CustomViewItem custom5 = new CustomViewItem(this);


            SetSettingCustomItem("Check out some examples of the different types of questions you may expect to see in the reading test","Understand the Test Format",custom1);
            SetSettingCustomItem("Understand how the test in marked and what topics may come up","Topics and marking",custom2);
            SetSettingCustomItem("Check out some tips and strategies to help you perform at your test","Answering techniques",custom3);
            SetSettingCustomItem("Assess your reading skills and learn how you can improve them","Checklist",custom4);
            SetSettingCustomItem("Take a Quiz","Prepare yourself better by taking a quiz",custom5);


            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);
            lin.addView(custom4);
            lin.addView(custom5);

        }else if(check == 4)
        {
            CustomViewItem custom1 = new CustomViewItem(this);
            CustomViewItem custom2 = new CustomViewItem(this);
            CustomViewItem custom3 = new CustomViewItem(this);
            CustomViewItem custom4 = new CustomViewItem(this);
            CustomViewItem custom5 = new CustomViewItem(this);
            CustomViewItem custom6 = new CustomViewItem(this);

            SetSettingCustomItem("Check out the differences between the tasks and what you may expect to see in the writing test","Understand the Test format",custom1);
            SetSettingCustomItem("Understand how the test is marked and what topics may come up.","Marking and Scoring",custom2);
            SetSettingCustomItem("Understand how the writing test is marked based on various criterias","Assessment Criteria",custom3);
            SetSettingCustomItem("Check out some tips and strategies to help you perform at your best","Answering techniques",custom4);
            SetSettingCustomItem("Assess you writing skills and learn how you can improve them","Checklist",custom5);
            SetSettingCustomItem("Prepare yourself better by taking q quiz","Take a quiz",custom6);

            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            custom6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);
            lin.addView(custom4);
            lin.addView(custom5);
            lin.addView(custom6);

        }













    }

    public void SetSettingCustomItem(String Body,String title,CustomViewItem custom)
    {
        //init all view custom view
        TextView tv_title = custom.getTv_title();
        TextView tv_body = custom.getTv_body();
        ImageView img_icon = custom.getImg_icon();

        RelativeLayout relativeLayout = custom.getrel();

        //Give value to view
        custom.SetTextTvTitle(title);
        custom.SetTextTvBody(Body);
        custom.SetIcon(getResources().getDrawable(R.drawable.testimageicon_customview));

        // set width and height icon custom view
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon.getLayoutParams().width = (int)(dm.widthPixels*0.15);
        img_icon.getLayoutParams().height = (int)(dm.widthPixels*0.15);

        //set width and height layout custom view
        relativeLayout.getLayoutParams().width = (int)(dm.widthPixels*0.95);


        //set maxwidth tv body
        tv_body.setMaxWidth((int) (dm.widthPixels * 0.65));

        //set margin
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, (int) (dm.widthPixels * 0.04), 0, 0);
        custom.setLayoutParams(params);


        //set text size tv body,tv title
        tv_body.setTextSize((int) (dm.widthPixels * 0.013));
        tv_title.setTextSize((int) (dm.widthPixels * 0.018));

    }
}
