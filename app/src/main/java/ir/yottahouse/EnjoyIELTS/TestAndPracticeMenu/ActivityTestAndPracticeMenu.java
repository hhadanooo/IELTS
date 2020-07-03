package ir.yottahouse.EnjoyIELTS.TestAndPracticeMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

import ir.yottahouse.EnjoyIELTS.About.ActivityAbout;
import ir.yottahouse.EnjoyIELTS.CustomView.CustomViewItem;
import ir.yottahouse.EnjoyIELTS.DialagENH.DialogENH;
import ir.yottahouse.EnjoyIELTS.DialogAG.DialogAGShow;
import ir.yottahouse.EnjoyIELTS.DialogChlng.DialogChlngShow;
import ir.yottahouse.EnjoyIELTS.MainActivity;
import ir.yottahouse.EnjoyIELTS.Practice.Activity_Practice;
import ir.yottahouse.EnjoyIELTS.R;
import ir.yottahouse.EnjoyIELTS.Test.Activity_test;
import ir.yottahouse.EnjoyIELTS.Tips.ActivityTips;
import ir.yottahouse.EnjoyIELTS.Vocab.Activity_Vocab;

public class ActivityTestAndPracticeMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    RelativeLayout rel_body,rel_list_item;
    ImageView img_body;
    LinearLayout lin;
    String Type = "";
    int num_type = 0;

    DrawerLayout drawerLayout;
    NavigationView menuNav;
    DisplayMetrics dm;


    TextView tv1_about_icon,tv2_about_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_and_practice_menu);



        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        getSupportActionBar().hide();
        init();
        CheckIntent();

        menuShower();


    }
    public void deleteRecursive(File fileOrDirectory) {

        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }

        fileOrDirectory.delete();
    }

    public void init()
    {
        rel_body = findViewById(R.id.activity_test_menu_rel_body);
        rel_list_item = findViewById(R.id.activity_test_menu_rel_list_item);
        img_body = findViewById(R.id.activity_test_menu_img_body);
        lin = findViewById(R.id.activity_test_menu_lin_list_item);

        tv1_about_icon = findViewById(R.id.activity_test_menu_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_test_menu_tv2_about_icon);

    }

    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Listen") != null)
        {
            Type = "Listen";
            num_type = 1;

            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if(getIntent().getExtras().getString("Speak") != null)
        {
            Type = "Speak";
            num_type = 2;

            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if(getIntent().getExtras().getString("Read") != null)
        {
            Type = "Read";
            num_type = 3;

            SetPropertiesRelBody();
            SetPropertiesCustomView();
        }else if (getIntent().getExtras().getString("Write") != null)
        {
            Type = "Write";
            num_type = 4;
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
            tv1_about_icon.setText("LISTENING");
            tv2_about_icon.setText("ENJOY IELTS");
            //img_body.setBackground(getResources().getDrawable(R.drawable.listening_icon));
            Glide.with(this).load(R.drawable.listening_icon).into(img_body);
        }else if(num_type == 2)
        {
            tv1_about_icon.setText("SPEAKING");
            tv2_about_icon.setText("ENJOY IELTS");
            //img_body.setBackground(getResources().getDrawable(R.drawable.speaking_icon));
            Glide.with(this).load(R.drawable.speaking_icon).into(img_body);
        }else if(num_type == 3)
        {
            tv1_about_icon.setText("READING");
            tv2_about_icon.setText("ENJOY IELTS");
            //img_body.setBackground(getResources().getDrawable(R.drawable.reading_icon));
            Glide.with(this).load(R.drawable.reading_icon).into(img_body);
        }else if(num_type == 4)
        {
            tv1_about_icon.setText("WRITING");
            tv2_about_icon.setText("ENJOY IELTS");
            //img_body.setBackground(getResources().getDrawable(R.drawable.writing_icon));
            Glide.with(this).load(R.drawable.writing_icon).into(img_body);
        }

        img_body.getLayoutParams().width = (int) (dm.widthPixels*.25);
        img_body.getLayoutParams().height = (int) (dm.widthPixels*.25);

        rel_body.getLayoutParams().height = (int)(dm.heightPixels*0.27);
        rel_list_item.getLayoutParams().height = (int) (dm.heightPixels*0.73);

        tv1_about_icon.setTextSize((int) (dm.widthPixels * 0.020));
        tv2_about_icon.setTextSize((int) (dm.widthPixels * 0.0125));

        tv1_about_icon.setTextColor(Color.BLACK);

        Typeface tf = Typeface.createFromAsset(getAssets(), "Lucida.ttf");
        tv2_about_icon.setTypeface(tf);

    }



    public void SetPropertiesCustomView()
    {

        if(num_type == 4 || num_type == 2)
        {
            CustomViewItem custom1 = new CustomViewItem(this,"","","",1,"","",true,"");
            CustomViewItem custom2 = new CustomViewItem(this,"","","",1,"","",true,"");
            CustomViewItem custom3 = new CustomViewItem(this,"","","",1,"","",true,"");

            SetSettingCustomItem("","Test",custom1,getResources().getDrawable(R.drawable.test_menue));
            SetSettingCustomItem("","Tips",custom2,getResources().getDrawable(R.drawable.tip_icon));
            SetSettingCustomItem("","Lexical Resources and Topics",custom3,getResources().getDrawable(R.drawable.vocab));

            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(num_type == 4)
                    {
                        DialogAGShow dialogAGShow = new DialogAGShow(ActivityTestAndPracticeMenu.this,dm,"Write");
                        dialogAGShow.show();
                    }else {
                        Intent intent  = new Intent(ActivityTestAndPracticeMenu.this, Activity_test.class);
                        intent.putExtra(Type, Type);
                        startActivity(intent);
                    }
                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent  = new Intent(ActivityTestAndPracticeMenu.this,ActivityTips.class);
                    intent.putExtra(Type, Type);
                    startActivity(intent);
                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent  = new Intent(ActivityTestAndPracticeMenu.this, Activity_Vocab.class);
                    intent.putExtra(Type, Type);
                    startActivity(intent);
                }
            });

            custom1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
            custom2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
            custom3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));


            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);
        }
        if(num_type == 3 || num_type == 1)
        {
            CustomViewItem custom1 = new CustomViewItem(this,"","","",1,"","",true,"");
            CustomViewItem custom2 = new CustomViewItem(this,"","","",1,"","",true,"");
            CustomViewItem custom3 = new CustomViewItem(this,"","","",1,"","",true,"");

            SetSettingCustomItem("","Test",custom1,getResources().getDrawable(R.drawable.test_menue));
            SetSettingCustomItem("","Tips",custom2,getResources().getDrawable(R.drawable.tip_icon));
            SetSettingCustomItem("","Practice",custom3,getResources().getDrawable(R.drawable.practice_icon));


            custom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(num_type == 3)
                    {
                        DialogAGShow dialogAGShow = new DialogAGShow(ActivityTestAndPracticeMenu.this,dm,"Read");
                        dialogAGShow.show();
                    }else {
                        Intent intent  = new Intent(ActivityTestAndPracticeMenu.this, Activity_test.class);
                        intent.putExtra(Type, Type);
                        startActivity(intent);
                    }


                }
            });
            custom2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent  = new Intent(ActivityTestAndPracticeMenu.this,ActivityTips.class);
                    intent.putExtra(Type, Type);
                    startActivity(intent);
                }
            });
            custom3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(num_type == 1)
                    {
                        Intent intent  = new Intent(ActivityTestAndPracticeMenu.this, Activity_Practice.class);
                        intent.putExtra(Type, Type);
                        startActivity(intent);
                    }else {
                        Log.i("raminhacker234234", "fd");
                        DialogENH enh = new DialogENH(ActivityTestAndPracticeMenu.this,dm,"ReadPractice");
                        enh.show();


                    }

                }
            });



            custom1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
            custom2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
            custom3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));


            lin.addView(custom1);
            lin.addView(custom2);
            lin.addView(custom3);
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
        Glide.with(this).load(R.drawable.arrowmore).into(img_icon);
        Glide.with(this).load(icon1).into(img_icon1);
        //custom.SetIcon(getResources().getDrawable(R.drawable.arrowmore));
        //img_icon1.setBackground(icon1);


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


    public void menuShower(){


        /*
        //custom ActionBar
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        Objects.requireNonNull(this.getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        ImageView iv_menu = view.findViewById(R.id.iv_menu);
        TextView title_action = view.findViewById(R.id.title_action);
        title_action.setText("");
        title_action.setTextSize((int) (dm.widthPixels*.02));
        iv_menu.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_menu.getLayoutParams().height = (int) (dm.widthPixels*.1);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

         */

        //init
        ImageView img_icon = findViewById(R.id.activity_test_menu_actionbar_img_icon_menu);

        Glide.with(this).load(R.drawable.menu_icon).into(img_icon);
        //img_icon.setBackground(getResources().getDrawable(R.drawable.menu_icon));

        menuNav = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.activity_test_menu_drawer_layout);


        //set OnClick and size for navigation view
        menuNav.setNavigationItemSelectedListener(this);
        menuNav.getLayoutParams().width = (int) (dm.widthPixels*.5);
        menuNav.setItemIconTintList(null);

        final MenuItem mi = menuNav.getMenu().getItem(0);
        Glide.with(this).asBitmap().load(R.drawable.home_menu_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi1 = menuNav.getMenu().getItem(1);
        Glide.with(this).asBitmap().load(R.drawable.reading_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi1.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi2 = menuNav.getMenu().getItem(2);
        Glide.with(this).asBitmap().load(R.drawable.writing_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi2.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi3 = menuNav.getMenu().getItem(3);
        Glide.with(this).asBitmap().load(R.drawable.speaking_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi3.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi4 = menuNav.getMenu().getItem(4);
        Glide.with(this).asBitmap().load(R.drawable.listening_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi4.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi5 = menuNav.getMenu().getItem(5);
        Glide.with(this).asBitmap().load(R.drawable.challenge_menu_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi5.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi6 = menuNav.getMenu().getItem(6);
        Glide.with(this).asBitmap().load(R.drawable.web_menu_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi6.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi7 = menuNav.getMenu().getItem(7);
        Glide.with(this).asBitmap().load(R.drawable.rate_menu_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi7.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });

        final MenuItem mi8 = menuNav.getMenu().getItem(8);
        Glide.with(this).asBitmap().load(R.drawable.about_menu_icon).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                mi8.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });


        if (num_type == 1){
            menuNav.getMenu().getItem(4).setEnabled(false);
        }else if (num_type == 2){
            menuNav.getMenu().getItem(3).setEnabled(false);
        }else if (num_type == 4){
            menuNav.getMenu().getItem(2).setEnabled(false);
        }else if (num_type == 3){
            menuNav.getMenu().getItem(1).setEnabled(false);
        }



        img_icon.getLayoutParams().width = (int) (dm.widthPixels*.1);
        img_icon.getLayoutParams().height = (int) (dm.widthPixels*.1);
        img_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.btnHomeNav){
            drawerLayout.closeDrawer(GravityCompat.START);
            onBackPressed();
            finish();
        }else if (item.getItemId() == R.id.btnListenNav){
            Intent intent = new Intent(ActivityTestAndPracticeMenu.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Listen","listen");
            startActivity(intent);
            finish();
        }else if (item.getItemId() == R.id.btnSpeakNav){
            Intent intent = new Intent(ActivityTestAndPracticeMenu.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Speak","speak");
            startActivity(intent);
            finish();
        }else if (item.getItemId() == R.id.btnReadNav){
            Intent intent = new Intent(ActivityTestAndPracticeMenu.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Read","read");
            startActivity(intent);
            finish();
        }else if (item.getItemId() == R.id.btnWriteNav){
            Intent intent = new Intent(ActivityTestAndPracticeMenu.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Write","write");
            startActivity(intent);
            finish();
        }else if (item.getItemId() == R.id.btnWebSIteNav){

            String url = "http://www.gooogle.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if (item.getItemId() == R.id.btnRatingNav){

        }else if (item.getItemId() == R.id.btnAboutNav){
            startActivity(new Intent(ActivityTestAndPracticeMenu.this , ActivityAbout.class));
        }else if (item.getItemId() == R.id.btnChallengeNav){
            DialogChlngShow dialogChlngShow = new DialogChlngShow(ActivityTestAndPracticeMenu.this,dm,"");
            dialogChlngShow.show();
        }

        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }


}
