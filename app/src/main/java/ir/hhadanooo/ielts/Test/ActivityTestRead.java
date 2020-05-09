package ir.hhadanooo.ielts.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
    ImageView img_body;
    TextView tv1_about_icon,tv2_about_icon;

    ImageView img_back;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_read);
        getSupportActionBar().hide();
        init();
        SetPropertiesRelBody();
        SetPropertiesMainPage();
        SetPropertiesTabLayout();
    }

    public void init()
    {
        rel_body = findViewById(R.id.activity_test_read_rel_body);
        img_body = findViewById(R.id.activity_test_read_img_body);
        

        tv1_about_icon = findViewById(R.id.activity_test_read_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_test_read_tv2_about_icon);

        img_back = findViewById(R.id.activity_test_read_actionbar_img_icon_back);

        lin_tab = findViewById(R.id.activity_test_read_lin_tab);

        tabLayout =  findViewById(R.id.activity_test_read_tab_layout);
        viewPager = findViewById(R.id.activity_test_read_view_pager);
    }

    public void SetPropertiesRelBody() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        tv1_about_icon.setText("Test 1");
        tv2_about_icon.setText("Reading");

        img_body.setBackground(getResources().getDrawable(R.drawable.tip_icon));


        rel_body.getLayoutParams().height = (int) (dm.heightPixels * 0.16);

        tv1_about_icon.setTextSize((int) (dm.widthPixels * 0.017));
        tv2_about_icon.setTextSize((int) (dm.widthPixels * 0.01));

        tv1_about_icon.setTextColor(Color.BLACK);

        img_body.getLayoutParams().width = (int) (dm.widthPixels * 0.15);
        img_body.getLayoutParams().height = (int) (dm.widthPixels * 0.15);


        img_back.getLayoutParams().width = (int) (dm.widthPixels * .1);
        img_back.getLayoutParams().height = (int) (dm.widthPixels * .1);
    }





    public void SetPropertiesMainPage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        lin_tab.getLayoutParams().width = (int) (dm.widthPixels * .90);
        lin_tab.getLayoutParams().height = (int) (dm.heightPixels * 0.78);
    }

    public void SetPropertiesTabLayout() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager(),dm.widthPixels,dm.heightPixels,"raminhacker"));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(Color.parseColor("#8A7D7D"),Color.parseColor("#000000"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#275D98"));
    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        int Width,Height;
        String intent;
        public SectionPagerAdapter(FragmentManager fm,int Width,int Height,String intent) {

            super(fm);
            this.Width = Width;
            this.Height = Height;
            this.intent = intent;

        }

        @Override
        public Fragment getItem(int position) {

            return new SlideFragmentTestReading().newSlide(Width,Height,intent);
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
