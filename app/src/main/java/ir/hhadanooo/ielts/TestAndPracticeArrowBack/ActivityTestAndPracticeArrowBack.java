package ir.hhadanooo.ielts.TestAndPracticeArrowBack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.DialogChlng.DialogChlngShow;
import ir.hhadanooo.ielts.MainActivity;
import ir.hhadanooo.ielts.R;
import ir.hhadanooo.ielts.TestAndPracticeMenu.ActivityTestAndPracticeMenu;

public class ActivityTestAndPracticeArrowBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_and_practice_arrow_back);
        getSupportActionBar().hide();
        LinearLayout lin = findViewById(R.id.lin);
        CustomViewItem custom1 = new CustomViewItem(this,"","","",1,"","",true,"");
        CustomViewItem custom2 = new CustomViewItem(this,"","","",2,"","",true,"");
        CustomViewItem custom3 = new CustomViewItem(this,"","","",3,"","",true,"");
        CustomViewItem custom4 = new CustomViewItem(this,"","","",4,"","",true,"");
        CustomViewItem custom5 = new CustomViewItem(this,"","","",5,"","",true,"");

        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do ","Reading",custom1,getResources().getDrawable(R.drawable.reading_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Writing",custom2,getResources().getDrawable(R.drawable.writing_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Speaking",custom3,getResources().getDrawable(R.drawable.speaking_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Listening",custom4,getResources().getDrawable(R.drawable.listening_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Chalenge",custom5,getResources().getDrawable(R.drawable.chalenge_icon));

        final DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        custom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTestAndPracticeArrowBack.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Read","read");
                startActivity(intent);
            }
        });
        custom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTestAndPracticeArrowBack.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Write","write");
                startActivity(intent);
            }
        });
        custom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTestAndPracticeArrowBack.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Speak","speak");
                startActivity(intent);
            }
        });
        custom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTestAndPracticeArrowBack.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Listen","listen");
                startActivity(intent);
            }
        });
        custom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogChlngShow dialogChlngShow = new DialogChlngShow(ActivityTestAndPracticeArrowBack.this,dm,"");
                dialogChlngShow.show();
            }
        });


        custom1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom4.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom5.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));




        lin.addView(custom1);
        lin.addView(custom2);
        lin.addView(custom3);
        lin.addView(custom4);
        lin.addView(custom5);
    }
    public void SetSettingCustomItem(String Body, String title, CustomViewItem custom, Drawable icon2)
    {


        //init all view custom view
        TextView tv_title = custom.getTv_title();
        TextView tv_body = custom.getTv_body();
        ImageView img_icon = custom.getImg_icon();
        ImageView img_icon1 = custom.getImg_icon1();

        RelativeLayout relativeLayout = custom.getrel();


        //Give value to view
        custom.SetTextTvTitle(title);
        custom.SetTextTvBody(Body);

        Glide.with(this).load(R.drawable.logo).into(img_icon);
        Glide.with(this).load(icon2).into(img_icon1);
        //custom.SetIcon(getResources().getDrawable(R.drawable.arrowmore));
        //img_icon1.setBackground(icon2);


        // set width and height icon custom view
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon.getLayoutParams().width = (int)(dm.widthPixels*0.12);
        img_icon.getLayoutParams().height = (int)(dm.widthPixels*0.12);

        img_icon1.getLayoutParams().width = (int)(dm.widthPixels*0.12);
        img_icon1.getLayoutParams().height = (int)(dm.widthPixels*0.12);


        //set width and height layout custom view
        relativeLayout.getLayoutParams().width = (int)(dm.widthPixels*0.95);


        //set maxwidth tv body
        tv_body.setMaxWidth((int) (dm.widthPixels * 0.58));


        //set margin
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, (int) (dm.heightPixels * 0.02), 0, 0);
        custom.setLayoutParams(params);


        //set text size tv body,tv title
        tv_body.setTextSize((int) (dm.widthPixels * 0.012));
        tv_title.setTextSize((int) (dm.widthPixels * 0.016));
        tv_title.setTextColor(Color.BLACK);




        /*
        //set center veritcal tv title
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tv_title.getLayoutParams();
        lp.addRule(RelativeLayout.CENTER_VERTICAL);
        tv_title.setLayoutParams(lp);

         */
    }


}
