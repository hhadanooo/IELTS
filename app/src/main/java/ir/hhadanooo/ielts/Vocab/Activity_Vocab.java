package ir.hhadanooo.ielts.Vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.R;
import ir.hhadanooo.ielts.SimpleText.SimpleTextActivity;
import ir.hhadanooo.ielts.Tips.ActivityTips;

public class Activity_Vocab extends AppCompatActivity {
    RelativeLayout rel_body,rel_list_item;
    ImageView img_body;
    LinearLayout lin;
    String Type = "";
    int num_type = 0;

    TextView tv1_about_icon,tv2_about_icon;

    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__vocab);
        getSupportActionBar().hide();
        init();
        CheckIntent();




    }
    public void init()
    {


        rel_body = findViewById(R.id.activity_vocab_rel_body);
        rel_list_item = findViewById(R.id.activity_vocab_rel_list_item);
        img_body = findViewById(R.id.activity_vocab_img_body);
        lin = findViewById(R.id.activity_vocab_lin_list_item);

        tv1_about_icon = findViewById(R.id.activity_vocab_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_vocab_tv2_about_icon);

        img_back = findViewById(R.id.activity_vocab_actionbar_img_icon_back);





    }


    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Write") != null)
        {
            Type = "Write";
            num_type = 1;

            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if(getIntent().getExtras().getString("Speak") != null)
        {

            Type = "Speak";
            num_type = 3;

            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }
    }

    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);



        if(num_type == 1)
        {
            tv1_about_icon.setText("Vocab");
            tv2_about_icon.setText("Writeing");

            img_body.setBackground(getResources().getDrawable(R.drawable.tip_icon));
        }if(num_type == 3)
        {
            tv1_about_icon.setText("Vocab");
            tv2_about_icon.setText("Speaking");

            img_body.setBackground(getResources().getDrawable(R.drawable.tip_icon));
        }

        img_body.getLayoutParams().width = (int) (dm.widthPixels*.25);
        img_body.getLayoutParams().height = (int) (dm.widthPixels*.25);

        rel_body.getLayoutParams().height = (int)(dm.heightPixels*0.27);
        rel_list_item.getLayoutParams().height = (int) (dm.heightPixels*0.73);

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


    public void SetPropertiesCustomView()
    {
        CustomViewItem custom1 = new CustomViewItem(this);
        CustomViewItem custom2 = new CustomViewItem(this);
        CustomViewItem custom3 = new CustomViewItem(this);
        CustomViewItem custom4 = new CustomViewItem(this);
        CustomViewItem custom5 = new CustomViewItem(this);
        CustomViewItem custom6 = new CustomViewItem(this);
        CustomViewItem custom7 = new CustomViewItem(this);
        CustomViewItem custom8 = new CustomViewItem(this);
        CustomViewItem custom9 = new CustomViewItem(this);
        CustomViewItem custom10 = new CustomViewItem(this);

        if(num_type == 1)
        {
            SetSettingCustomItem("","vocab 1",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 2",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 3",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 4",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 5",custom5,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 6",custom6,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 7",custom7,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 8",custom8,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 9",custom9,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 10",custom10,getResources().getDrawable(R.drawable.tip_item_icon));
            //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",1);
                    startActivity(intent);
                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",2);
                    startActivity(intent);
                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",3);
                    startActivity(intent);
                }
            });
            custom4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",4);
                    startActivity(intent);
                }
            });
            custom5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",5);
                    startActivity(intent);
                }
            });
            custom6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",6);
                    startActivity(intent);
                }
            });
            custom7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",7);
                    startActivity(intent);
                }
            });
            custom8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",8);
                    startActivity(intent);
                }
            });
            custom9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",9);
                    startActivity(intent);
                }
            });
            custom10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Write","Write");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",10);
                    startActivity(intent);
                }
            });


        }
        if(num_type == 3)
        {


            SetSettingCustomItem("","vocab 1",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 2",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 3",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 4",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 5",custom5,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab6",custom6,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 7",custom7,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 8",custom8,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 9",custom9,getResources().getDrawable(R.drawable.tip_item_icon));
            SetSettingCustomItem("","vocab 10",custom10,getResources().getDrawable(R.drawable.tip_item_icon));
            //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",1);
                    startActivity(intent);
                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",2);
                    startActivity(intent);
                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",3);
                    startActivity(intent);
                }
            });
            custom4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",4);
                    startActivity(intent);
                }
            });
            custom5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",5);
                    startActivity(intent);
                }
            });
            custom6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",6);
                    startActivity(intent);
                }
            });
            custom7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",7);
                    startActivity(intent);
                }
            });
            custom8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",8);
                    startActivity(intent);
                }
            });
            custom9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",9);
                    startActivity(intent);
                }
            });
            custom10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Vocab.this, SimpleTextActivity.class);
                    intent.putExtra("Speak","Speak");
                    intent.putExtra("Vocab","Vocab");
                    intent.putExtra("number",10);
                    startActivity(intent);
                }
            });

        }


        lin.addView(custom1);
        lin.addView(custom2);
        lin.addView(custom3);
        lin.addView(custom4);
        lin.addView(custom5);
        lin.addView(custom6);
        lin.addView(custom7);
        lin.addView(custom8);
        lin.addView(custom9);
        lin.addView(custom10);










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

    public void SetSettingCustomItem(String Body, String title, CustomViewItem custom, Drawable icon,Drawable icon1)
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
        img_icon.setBackground(icon);


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
