package ir.hhadanooo.ielts.Practice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.DialagENH.DialogENH;
import ir.hhadanooo.ielts.R;

public class Activity_Practice extends AppCompatActivity {

    RelativeLayout rel_body,rel_list_item;
    ImageView img_body;
    LinearLayout lin;
    String Type = "";
    int num_type = 0;
    DisplayMetrics dm;

    TextView tv1_about_icon,tv2_about_icon;

    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__practice);

        getSupportActionBar().hide();
        init();
        CheckIntent();


    }
    public void init()
    {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        rel_body = findViewById(R.id.activity_practice_rel_body);
        rel_list_item = findViewById(R.id.activity_practice_rel_list_item);
        img_body = findViewById(R.id.activity_practice_img_body);
        lin = findViewById(R.id.activity_practice_lin_list_item);

        tv1_about_icon = findViewById(R.id.activity_practice_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_practice_tv2_about_icon);

        img_back = findViewById(R.id.activity_practice_actionbar_img_icon_back);





    }


    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Listen") != null)
        {
            Type = "Listen";
            num_type = 1;

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
            tv1_about_icon.setText("Practice");
            tv2_about_icon.setText("Listening");

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
        if(num_type == 1)
        {
            Log.i("Raminhacker1234", "1: ");
            if(getIntent().getExtras().getString("Easy") != null)
            {
                Log.i("Raminhacker1234", "2: ");
                if(getIntent().getExtras().getString("Type1") != null)
                {
                    Log.i("Raminhacker1234", "3: ");

                    CustomViewItem custom1 = new CustomViewItem(this);
                    CustomViewItem custom2 = new CustomViewItem(this);
                    CustomViewItem custom3 = new CustomViewItem(this);
                    CustomViewItem custom4 = new CustomViewItem(this);
                    CustomViewItem custom5 = new CustomViewItem(this);


                    SetSettingCustomItem("","type a easy",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a easy",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a easy",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a easy",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a easy",custom5,getResources().getDrawable(R.drawable.tip_item_icon));

                    //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


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


                }else if(getIntent().getExtras().getString("Type2") != null)
                {

                    CustomViewItem custom1 = new CustomViewItem(this);
                    CustomViewItem custom2 = new CustomViewItem(this);
                    CustomViewItem custom3 = new CustomViewItem(this);
                    CustomViewItem custom4 = new CustomViewItem(this);
                    CustomViewItem custom5 = new CustomViewItem(this);


                    SetSettingCustomItem("","type b easy",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b easy",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b easy",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b easy",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b easy",custom5,getResources().getDrawable(R.drawable.tip_item_icon));

                    //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


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

                }
            }else  if(getIntent().getExtras().getString("Normal") != null)
            {
                if(getIntent().getExtras().getString("Type1") != null)
                {

                    CustomViewItem custom1 = new CustomViewItem(this);
                    CustomViewItem custom2 = new CustomViewItem(this);
                    CustomViewItem custom3 = new CustomViewItem(this);
                    CustomViewItem custom4 = new CustomViewItem(this);
                    CustomViewItem custom5 = new CustomViewItem(this);



                    SetSettingCustomItem("","type a normal",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a normal",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a normal",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a normal",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a normal",custom5,getResources().getDrawable(R.drawable.tip_item_icon));

                    //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


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
                }else if(getIntent().getExtras().getString("Type2") != null)
                {
                    CustomViewItem custom1 = new CustomViewItem(this);
                    CustomViewItem custom2 = new CustomViewItem(this);
                    CustomViewItem custom3 = new CustomViewItem(this);
                    CustomViewItem custom4 = new CustomViewItem(this);
                    CustomViewItem custom5 = new CustomViewItem(this);



                    SetSettingCustomItem("","type b normal",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b normal",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b normal",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b normal",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b normal",custom5,getResources().getDrawable(R.drawable.tip_item_icon));

                    //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


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
                }
            }else if(getIntent().getExtras().getString("Hard") != null)
            {
                if(getIntent().getExtras().getString("Type1") != null)
                {

                    CustomViewItem custom1 = new CustomViewItem(this);
                    CustomViewItem custom2 = new CustomViewItem(this);
                    CustomViewItem custom3 = new CustomViewItem(this);
                    CustomViewItem custom4 = new CustomViewItem(this);
                    CustomViewItem custom5 = new CustomViewItem(this);



                    SetSettingCustomItem("","type a hard",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a hard",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a hard",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a hard",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type a hard",custom5,getResources().getDrawable(R.drawable.tip_item_icon));

                    //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


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
                }else if(getIntent().getExtras().getString("Type2") != null)
                {
                    CustomViewItem custom1 = new CustomViewItem(this);
                    CustomViewItem custom2 = new CustomViewItem(this);
                    CustomViewItem custom3 = new CustomViewItem(this);
                    CustomViewItem custom4 = new CustomViewItem(this);
                    CustomViewItem custom5 = new CustomViewItem(this);



                    SetSettingCustomItem("","type b hard",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b hard",custom2,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b hard",custom3,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b hard",custom4,getResources().getDrawable(R.drawable.tip_item_icon));
                    SetSettingCustomItem("","type b hard",custom5,getResources().getDrawable(R.drawable.tip_item_icon));

                    //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


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
                }
            }else {
                CustomViewItem custom1 = new CustomViewItem(this);
                CustomViewItem custom2 = new CustomViewItem(this);



                SetSettingCustomItem("","type a",custom1,getResources().getDrawable(R.drawable.tip_item_icon));
                SetSettingCustomItem("","type b",custom2,getResources().getDrawable(R.drawable.tip_item_icon));

                //SetSettingCustomItem("","How i can Go to office ...",custom4,getResources().getDrawable(R.drawable.gif_icon),getResources().getDrawable(R.drawable.tip_item_gift_icon));


                custom1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);
                        DialogENH dialogENH = new DialogENH(Activity_Practice.this,dm,"Type1");
                        dialogENH.show();
                    }
                });
                custom2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);
                        DialogENH dialogENH = new DialogENH(Activity_Practice.this,dm,"Type2");
                        dialogENH.show();
                    }
                });

                lin.addView(custom1);
                lin.addView(custom2);
            }


        }




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
