package ir.hhadanooo.ielts.TestAndPracticeMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
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

import ir.hhadanooo.ielts.AboutTheTest.ActivityAboutTheTest;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.MainActivity;
import ir.hhadanooo.ielts.MorePrep.ActivityMorePrep;
import ir.hhadanooo.ielts.R;

public class ActivityTestAndPracticeMenu extends AppCompatActivity {


    RelativeLayout rel_body,rel_list_item;
    TextView tv_body;
    LinearLayout lin;
    Button btn_more;
    String Type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_and_practice_menu);
        init();
        CheckIntent();
        SetPropertiesCustomView();

        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTestAndPracticeMenu.this , ActivityMorePrep.class);
                //intent.putExtra("Write","write");
                startActivity(intent);
            }
        });



        


    }
    public void init()
    {
        btn_more = findViewById(R.id.activity_test_menu_btn_more);
        rel_body = findViewById(R.id.activity_test_menu_rel_body);
        rel_list_item = findViewById(R.id.activity_test_menu_rel_list_item);
        tv_body = findViewById(R.id.activity_test_menu_tv_body);
        lin = findViewById(R.id.activity_test_menu_lin_list_item);
    }
    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Listen") != null)
        {
            Type = "Listen";
            SetPropertiesActionBar(true,"Listening");
            SetPropertiesRelBody("Learn more about the Listening test and practice your skills!");
        }else if(getIntent().getExtras().getString("Speak") != null)
        {
            Type = "Speak";
            SetPropertiesActionBar(true,"Speaking");
            SetPropertiesRelBody("Learn more about the Speaking test and practice your skills!");
        }else if(getIntent().getExtras().getString("Read") != null)
        {
            Type = "Read";
            SetPropertiesActionBar(true,"Reading");
            SetPropertiesRelBody("Learn more about the Reading test and practice your skills!");
        }else if (getIntent().getExtras().getString("Write") != null)
        {
            Type = "Write";
            SetPropertiesRelBody("Learn more about the Writeing test and practice your skills!");
            SetPropertiesActionBar(true,"Writeing");
        }
    }

    public void SetPropertiesRelBody(String Text)
    {
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


    public void SetPropertiesCustomView()
    {

        String[] titles = {"Practice Test(s)","About the Listening Test"};

            CustomViewItem custom1 = new CustomViewItem(this);
            CustomViewItem custom2 = new CustomViewItem(this);

            SetSettingCustomItem("","Practice Test(s)",custom1);
            SetSettingCustomItem("","About the Listening Test",custom2);


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


            lin.addView(custom1);
            lin.addView(custom2);



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
        custom.SetIcon(getResources().getDrawable(R.drawable.testimageicon_customview));


        // set width and height icon custom view
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon.getLayoutParams().width = (int)(dm.widthPixels*0.12);
        img_icon.getLayoutParams().height = (int)(dm.widthPixels*0.12);


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
        tv_body.setTextSize((int) (dm.widthPixels * 0.010));
        tv_title.setTextSize((int) (dm.widthPixels * 0.015));

        //set center veritcal tv title
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tv_title.getLayoutParams();
        lp.addRule(RelativeLayout.CENTER_VERTICAL);
        tv_title.setLayoutParams(lp);
    }
}
