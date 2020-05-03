package ir.hhadanooo.ielts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.rom4ek.arcnavigationview.ArcNavigationView;
import java.util.Objects;
import ir.hhadanooo.ielts.TestAndPracticeMenu.ActivityTestAndPracticeMenu;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button btnListen , btnSpeak , btnRead , btnWrite;
    DrawerLayout drawerLayout;
    ArcNavigationView menuNav;
    ViewPager viewPager_home;
    DisplayMetrics dm;
    TextView[] dots;
    LinearLayout dotsLayout;
    MyViewPagerAdapter myViewPagerAdapter;
    Handler handler = new Handler();
    int[] layouts = {R.drawable.slide1  , R.drawable.slide2
            , R.drawable.slide3 , R.drawable.slide4, R.drawable.slide5};

    boolean showMenu = true;

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
        btnListen = findViewById(R.id.btnListen);
        btnSpeak = findViewById(R.id.btnSpeak);
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        viewPager_home = findViewById(R.id.viewPager_home);
        dotsLayout = findViewById(R.id.layoutDots);




        //slider
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager_home.setAdapter(myViewPagerAdapter);
        viewPager_home.addOnPageChangeListener(viewPagerPageChangeListener);




        //dots
        addBottomDots(0);
        handler.postDelayed(new timer_dots() , 5000);




        //btn on MainActivity

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Listen","listen");
                startActivity(intent);
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Speak","speak");
                startActivity(intent);
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Read","read");
                startActivity(intent);
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Write","write");
                startActivity(intent);
            }
        });






    }



    public void menuShower(){


        //custom ActionBar
        Objects.requireNonNull(this.getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        ImageView iv_menu = view.findViewById(R.id.iv_menu);
        TextView title_action = view.findViewById(R.id.title_action);
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




    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };



    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.GRAY);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.BLACK);
    }


    public class MyViewPagerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView slide = new ImageView(MainActivity.this);
            slide.setImageResource(layouts[position]);
            slide.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(slide);

            return slide;

        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }



    public class timer_dots implements Runnable{
        @Override
        public void run() {

            if (viewPager_home.getCurrentItem() <= 3){
                viewPager_home.setCurrentItem(viewPager_home.getCurrentItem()+1);
            }else {
                viewPager_home.setCurrentItem(0);
            }


            handler.postDelayed(this , 5000);

        }
    }



}
