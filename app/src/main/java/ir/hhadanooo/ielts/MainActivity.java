package ir.hhadanooo.ielts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.rom4ek.arcnavigationview.ArcNavigationView;

import java.util.Locale;
import java.util.Objects;

import ir.hhadanooo.ielts.AboutTheTest.ActivityAboutTheTest;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.HelpPageStartTest.HelpStartTestActivity;
import ir.hhadanooo.ielts.Quiz.QuizActivity;
import ir.hhadanooo.ielts.TestAndPracticeMenu.ActivityTestAndPracticeMenu;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    DrawerLayout drawerLayout;
    ArcNavigationView menuNav;
    DisplayMetrics dm;
    ImageView iv_cover_home;
    LinearLayout lin_list_item;

    boolean showMenu = true;

    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //responsive
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);



        //show menu
        if (showMenu){
            menuShower();
        }



        //init
        lin_list_item = findViewById(R.id.main_activity_lin_list_item);
        iv_cover_home = findViewById(R.id.iv_cover_home);


        iv_cover_home.getLayoutParams().width = (int) (dm.widthPixels*.375);
        iv_cover_home.getLayoutParams().height = (int) (dm.heightPixels*.15);

        tv1 = findViewById(R.id.activity_main_tv_1);
        tv2 = findViewById(R.id.activity_main_tv_2);

        tv1.setText("ENJOY IELTS");
        tv2.setText("Improve Your Skills");

        tv1.setTextSize((int) (dm.widthPixels * 0.020));
        tv2.setTextSize((int) (dm.widthPixels * 0.014));

        tv1.setTextColor(Color.BLACK);

        Typeface tf = Typeface.createFromAsset(getAssets(), "Lucida.ttf");
        tv2.setTypeface(tf);


        

        //btn on MainActivity
        SetPropertiesCustomView();





    }

    public void SetPropertiesCustomView()
    {



        CustomViewItem custom1 = new CustomViewItem(this);
        CustomViewItem custom2 = new CustomViewItem(this);
        CustomViewItem custom3 = new CustomViewItem(this);
        CustomViewItem custom4 = new CustomViewItem(this);
        CustomViewItem custom5 = new CustomViewItem(this);

        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do ","Reading",custom1,getResources().getDrawable(R.drawable.reading_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Writing",custom2,getResources().getDrawable(R.drawable.writing_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Speaking",custom3,getResources().getDrawable(R.drawable.speaking_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Listening",custom4,getResources().getDrawable(R.drawable.listening_icon));
        SetSettingCustomItem("Lorem ipsum dolor sit amet consectetur adipiscing elit, sed do","Chalenge",custom5,getResources().getDrawable(R.drawable.chalenge_icon));


        custom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Read","read");
                startActivity(intent);
            }
        });
        custom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Write","write");
                startActivity(intent);
            }
        });
        custom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Speak","speak");
                startActivity(intent);
            }
        });
        custom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Listen","listen");
                startActivity(intent);
            }
        });
        custom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        lin_list_item.addView(custom1);
        lin_list_item.addView(custom2);
        lin_list_item.addView(custom3);
        lin_list_item.addView(custom4);
        lin_list_item.addView(custom5);



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
        custom.SetIcon(getResources().getDrawable(R.drawable.arrowmore));
        img_icon1.setBackground(icon2);


        // set width and height icon custom view
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon.getLayoutParams().width = (int)(dm.widthPixels*0.12);
        img_icon.getLayoutParams().height = (int)(dm.heightPixels*0.07);

        img_icon1.getLayoutParams().width = (int)(dm.widthPixels*0.12);
        img_icon1.getLayoutParams().height = (int)(dm.heightPixels*0.07);


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



    public void menuShower(){


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

        //init
        menuNav = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        //set OnClick and size for navigation view
        menuNav.setNavigationItemSelectedListener(this);
        menuNav.getLayoutParams().width = (int) (dm.widthPixels*.3);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.btnHomeNav){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.btnListenNav){
            Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Listen","listen");
            startActivity(intent);
        }else if (item.getItemId() == R.id.btnSpeakNav){
            Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Speak","speak");
            startActivity(intent);
        }else if (item.getItemId() == R.id.btnReadNav){
            Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Read","read");
            startActivity(intent);
        }else if (item.getItemId() == R.id.btnWriteNav){
            Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
            intent.putExtra("Write","write");
            startActivity(intent);
        }else if (item.getItemId() == R.id.btnWebSIteNav){

        }
        else if (item.getItemId() == R.id.btnRatingNav){

        }
        else if (item.getItemId() == R.id.btnAboutNav){

        }

        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }





}
