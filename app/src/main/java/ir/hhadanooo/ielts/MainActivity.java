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

import ir.hhadanooo.ielts.HelpPageStartTest.HelpStartTestActivity;
import ir.hhadanooo.ielts.Quiz.QuizActivity;
import ir.hhadanooo.ielts.TestAndPracticeMenu.ActivityTestAndPracticeMenu;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button btnListen , btnSpeak , btnRead , btnWrite;
    DrawerLayout drawerLayout;
    ArcNavigationView menuNav;
    DisplayMetrics dm;
    ImageView iv_cover_home;

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
        iv_cover_home = findViewById(R.id.iv_cover_home);


        iv_cover_home.getLayoutParams().width = (int) (dm.widthPixels*.375);
        iv_cover_home.getLayoutParams().height = (int) (dm.widthPixels*.5);




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
