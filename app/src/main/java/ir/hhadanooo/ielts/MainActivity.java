package ir.hhadanooo.ielts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Html;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import ir.hhadanooo.ielts.AboutTheTest.ActivityAboutTheTest;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.DialagENH.DialogENH;
import ir.hhadanooo.ielts.DialogChlng.DialogChlngShow;
import ir.hhadanooo.ielts.HelpPageStartTest.HelpStartTestActivity;
import ir.hhadanooo.ielts.Practice.Listen.ListenPracticeActivity;
import ir.hhadanooo.ielts.Practice.Listen.ListenPracticeBActivity;
import ir.hhadanooo.ielts.Quiz.QuizActivity;
import ir.hhadanooo.ielts.SimpleText.SimpleTextActivity;
import ir.hhadanooo.ielts.Test.Listen.TestListenActivity;
import ir.hhadanooo.ielts.TestAndPracticeMenu.ActivityTestAndPracticeMenu;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView menuNav;
    DisplayMetrics dm;
    ImageView iv_cover_home;
    LinearLayout lin_list_item;

    boolean showMenu = true;

    TextView tv1_about_icon,tv2_about_icon;

    RelativeLayout rel_body;

    SharedPreferences newDayPerf;
    int dPassed = 0;
    int mPassed = 0;
    int yPassed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        newDayPerf = getSharedPreferences("newDayPerf" , MODE_PRIVATE);
        dPassed = newDayPerf.getInt("dPassed" , 0);
        mPassed = newDayPerf.getInt("mPassed" , 0);
        yPassed = newDayPerf.getInt("yPassed" , 0);


        File ZipFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ielts.zip");
        File TargetFile = new File(getFilesDir().getAbsolutePath());

        try {
            unzip(ZipFile,TargetFile);
        } catch (IOException e) {
            e.printStackTrace();

        }


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


        iv_cover_home.getLayoutParams().width = (int) (dm.widthPixels*0.25);
        iv_cover_home.getLayoutParams().height = (int) (dm.widthPixels*0.25);

        rel_body = findViewById(R.id.actiivty_main_rel_body);

        tv1_about_icon = findViewById(R.id.activity_main_tv1_about_icon);
        tv2_about_icon = findViewById(R.id.activity_main_tv2_about_icon);



        tv1_about_icon.setText("ENJOY IELTS");
        tv2_about_icon.setText("Improve Your Skills");

        tv1_about_icon.setTextSize((int) (dm.widthPixels * 0.020));
        tv2_about_icon.setTextSize((int) (dm.widthPixels * 0.0125));

        tv1_about_icon.setTextColor(Color.BLACK);

        Typeface tf = Typeface.createFromAsset(getAssets(), "Lucida.ttf");
        tv2_about_icon.setTypeface(tf);


        lin_list_item.getLayoutParams().height = (int) (dm.heightPixels*0.73);
        rel_body.getLayoutParams().height = (int) (dm.heightPixels*0.27);




        //btn on MainActivity
        SetPropertiesCustomView();


        newDay();



    }

    public void SetPropertiesCustomView()
    {



        CustomViewItem custom1 = new CustomViewItem(this,"","","",1,"","",true);
        CustomViewItem custom2 = new CustomViewItem(this,"","","",1,"","",true);
        CustomViewItem custom3 = new CustomViewItem(this,"","","",1,"","",true);
        CustomViewItem custom4 = new CustomViewItem(this,"","","",1,"","",true);
        CustomViewItem custom5 = new CustomViewItem(this,"","","",1,"","",true);

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
                DialogChlngShow dialogChlngShow = new DialogChlngShow(MainActivity.this,dm,"");
                dialogChlngShow.show();
            }
        });


        lin_list_item.addView(custom1);
        lin_list_item.addView(custom2);
        lin_list_item.addView(custom3);
        lin_list_item.addView(custom4);
        lin_list_item.addView(custom5);



    }

    public void newDay(){
        Date date = new Date();
        CharSequence d  = DateFormat.format("d", date.getTime());
        CharSequence m  = DateFormat.format("M", date.getTime());
        CharSequence y  = DateFormat.format("y", date.getTime());

        int day = Integer.parseInt(String.valueOf(d));
        int mound = Integer.parseInt(String.valueOf(m));
        int years = Integer.parseInt(String.valueOf(y));

        if (dPassed == 0){
            newDayPerf.edit().putInt("dPassed" , day).apply();
            newDayPerf.edit().putInt("mPassed" , mound).apply();
            newDayPerf.edit().putInt("yPassed" , years).apply();
            setTodayQuiz();
            //Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();

        }else {
            int days = newDayPerf.getInt("dPassed" , 0);
            int mounds = newDayPerf.getInt("mPassed" , 0);
            int yearss = newDayPerf.getInt("yPassed" , 0);
            if (day > days && mound >= mounds && years >= yearss){
                newDayPerf.edit().putInt("dPassed" , day).apply();
                newDayPerf.edit().putInt("mPassed" , mound).apply();
                newDayPerf.edit().putInt("yPassed" , years).apply();
                //Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                setTodayQuiz();
            }else if (day <= days && mound > mounds && years >= yearss) {
                newDayPerf.edit().putInt("dPassed" , day).apply();
                newDayPerf.edit().putInt("mPassed" , mound).apply();
                newDayPerf.edit().putInt("yPassed" , years).apply();
                setTodayQuiz();
                //Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();

            }else if (day <= days && mound <= mounds && years > yearss) {
                newDayPerf.edit().putInt("dPassed" , day).apply();
                newDayPerf.edit().putInt("mPassed" , mound).apply();
                newDayPerf.edit().putInt("yPassed" , years).apply();
                setTodayQuiz();
                //Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();

            }

        }
        int days = newDayPerf.getInt("dPassed" , 0);
        int mounds = newDayPerf.getInt("mPassed" , 0);
        int yearss = newDayPerf.getInt("yPassed" , 0);

        Log.i("newdays" , "day : "+day+" mound : "+mound+" years : "+years+
                "\n days : "+days+" mounds : "+mounds+" yearss : "+yearss);
        Log.i("tiiime" , ""+d+"\n"+m+"\n"+y);
    }

    public void setTodayQuiz(){
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 1; i <= 20; ++i) number.add(i);
        Collections.shuffle(number);
        Log.i("randnum" , ""+number.subList(0 , 10));

        String pathAllQuiz = getFilesDir().
                getAbsolutePath()+"/ielts/challenge/allquiz";

        String pathToday = getFilesDir().
                getAbsolutePath()+"/ielts/challenge/today/";

        for (int i = 0; i < 10; ++i){

            File file = new File(pathAllQuiz+"/quiz"+number.get(i)+"/quiz.txt");
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close() ;
            }catch (IOException e) {
                e.printStackTrace();
            }

            File file1 = new File(pathAllQuiz+"/quiz"+number.get(i)+"/answer.txt");
            StringBuilder answer = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file1));
                String line;
                while ((line = br.readLine()) != null) {
                    answer.append(line+"\n");

                }
                br.close() ;
            }catch (IOException e) {
                e.printStackTrace();
            }

            //Log.i("Striiiin" , ""+text);
            try {
                File gpxfile = new File(pathToday+"quiz"+(i+1)+"/quiz.txt");
                FileWriter writer = new FileWriter(gpxfile);
                writer.write(number.get(i)+"\n"+text);
                writer.flush();
                writer.close();
                //Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
            } catch (Exception e) { }
            try {
                File gpxfile1 = new File(pathToday+"quiz"+(i+1)+"/answer.txt");
                FileWriter writer1 = new FileWriter(gpxfile1);
                writer1.write(String.valueOf(answer));
                writer1.flush();
                writer1.close();
                //Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
            } catch (Exception e) { }
        }

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
        ImageView img_icon = findViewById(R.id.actionbar_img_icon_menu);

        img_icon.setBackground(getResources().getDrawable(R.drawable.menu_icon));

        menuNav = findViewById(R.id.nav_view);

        drawerLayout = findViewById(R.id.drawer_layout);


        //set OnClick and size for navigation view
        menuNav.setNavigationItemSelectedListener(this);
        menuNav.getLayoutParams().width = (int) (dm.widthPixels*.5);
        menuNav.setItemIconTintList(null);
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

            String url = "http://www.gooogle.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if (item.getItemId() == R.id.btnRatingNav){

        }else if (item.getItemId() == R.id.btnAboutNav){

        }else if (item.getItemId() == R.id.btnChallengeNav){
            DialogChlngShow dialogChlngShow = new DialogChlngShow(MainActivity.this,dm,"");
            dialogChlngShow.show();
        }


        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

    public void unzip(File zipFile, File targetDirectory) throws IOException {
        ZipInputStream zis = new ZipInputStream(
                new BufferedInputStream(new FileInputStream(zipFile)));

        try {
            ZipEntry ze;
            int count;
            byte[] buffer = new byte[8192];
            while ((ze = zis.getNextEntry()) != null) {
                File file = new File(targetDirectory, ze.getName());
                File dir = ze.isDirectory() ? file : file.getParentFile();
                if (!dir.isDirectory() && !dir.mkdirs())
                    throw new FileNotFoundException("Failed to ensure directory: " +
                            dir.getAbsolutePath());
                if (ze.isDirectory())
                    continue;
                FileOutputStream fout = new FileOutputStream(file);
                try {
                    while ((count = zis.read(buffer)) != -1)
                        fout.write(buffer, 0, count);
                } finally {
                    fout.close();
                }
            /* if time should be restored as well
            long time = ze.getTime();
            if (time > 0)
                file.setLastModified(time);
            */
            }
        } finally {
            zis.close();
        }
    }
    public void writeFileOnInternalStorage(Context mcoContext, String sFileName, String sBody){
        File file = new File(mcoContext.getFilesDir(),"mydir");
        if(!file.exists()){
            file.mkdir();
        }

        try{
            File gpxfile = new File(file, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }





}
