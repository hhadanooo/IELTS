package ir.hhadanooo.ielts.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import ir.hhadanooo.ielts.Fragment.SlideFragmentTestReading;
import ir.hhadanooo.ielts.R;

public class ActivityTestRead extends AppCompatActivity {
    RelativeLayout rel_body;
    LinearLayout lin_tab;

    TabLayout tabLayout;
    ViewPager viewPager;
    int tab_num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_read);
        getSupportActionBar().hide();
        init();

        CheckIntent();
        SetPropertiesRelBody();
        SetPropertiesMainPage();
        SetPropertiesTabLayout();


    }

    public void CheckIntent()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        if(getIntent().getExtras().getString("Academic") != null)
        {
           if(getIntent().getExtras().getInt("Number") != 0)
           {
               viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager(),dm.widthPixels,dm.heightPixels,"Academic", getIntent().getExtras().getInt("Number")));
               tabLayout.setupWithViewPager(viewPager);
           }
        }else if(getIntent().getExtras().get("General") != null)
        {
            if(getIntent().getExtras().getInt("Number") != 0)
            {
                viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager(),dm.widthPixels,dm.heightPixels,"General", getIntent().getExtras().getInt("Number")));
                tabLayout.setupWithViewPager(viewPager);
            }
        }
    }

    private void initActionBar() {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        ImageView iv_arrowBack_SimpleText = findViewById(R.id.Activity_test_read_iv_arrowBack_SimpleText);
        ImageView iv_ic_logoPage_SimpleText = findViewById(R.id.Activity_test_read_iv_ic_logoPage_SimpleText);
        TextView tv_TitleLogo_SimpleText = findViewById(R.id.Activity_test_read_tv_TitleLogo_SimpleText);
        TextView tv_PathLogo_SimpleText = findViewById(R.id.Activity_test_read_tv_PathLogo_SimpleText);

        iv_arrowBack_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        tv_TitleLogo_SimpleText.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_SimpleText.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_SimpleText.setText("Test1");
        tv_PathLogo_SimpleText.setText("Reading");

        iv_arrowBack_SimpleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void init()
    {
        rel_body = findViewById(R.id.activity_test_read_rel_body);


        lin_tab = findViewById(R.id.activity_test_read_lin_tab);

        tabLayout =  findViewById(R.id.activity_test_read_tab_layout);
        viewPager = findViewById(R.id.activity_test_read_view_pager);

        initActionBar();
    }

    public void SetPropertiesRelBody() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);




    }





    public void SetPropertiesMainPage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        lin_tab.getLayoutParams().width = (int) (dm.widthPixels * .90);
        lin_tab.getLayoutParams().height = (int) (dm.heightPixels * 0.75);
    }

    public void SetPropertiesTabLayout() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        tabLayout.setTabTextColors(Color.parseColor("#8A7D7D"),Color.parseColor("#000000"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#275D98"));
    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        int Width,Height;
        String intent;
        int num;
        public SectionPagerAdapter(FragmentManager fm,int Width,int Height,String intent,int num) {

            super(fm);
            this.Width = Width;
            this.Height = Height;
            this.intent = intent;
            this.num = num;

        }

        @Override
        public Fragment getItem(int position) {

            tab_num++;
            return new SlideFragmentTestReading().newSlide(Width,Height,intent,num,tab_num);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "passage 1";
                case 1:
                    return "passage 2";
                default:
                    return "passage 3";
            }
        }
    }

}
