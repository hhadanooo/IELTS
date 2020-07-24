package ir.yottahouse.EnjoyIELTS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.navigation.NavigationView;

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
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import ir.yottahouse.EnjoyIELTS.About.ActivityAbout;
import ir.yottahouse.EnjoyIELTS.Challenge.ChallengeActivity;
import ir.yottahouse.EnjoyIELTS.CustomView.CustomViewItem;
import ir.yottahouse.EnjoyIELTS.DialogChlng.DialogChlngShow;
import ir.yottahouse.EnjoyIELTS.TestAndPracticeMenu.ActivityTestAndPracticeMenu;
import tourguide.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView menuNav;
    DisplayMetrics dm;
    ImageView iv_cover_home;
    LinearLayout lin_list_item;

    boolean showMenu = true;
    boolean check_zip = false;

    TextView tv1_about_icon,tv2_about_icon;

    RelativeLayout rel_body;

    boolean IELTSZip = false;

    SharedPreferences newDayPerf;
    int dPassed = 0;
    int mPassed = 0;
    int yPassed = 0;
    private ProgressDialog pDialog;
    ProgressDialog progressDialog_unzip;
    public static final int progress_bar_type = 0;

    int update_code= 0;

    // File url to download
    private static String file_url = "https://bit.ly/3e13a0r";
    //private static String file_url = "https://irsv.upmusics.com/Tracks/Songs/Masih%20ft%20Arash%20AP%20%E2%80%93%20Goli128(UpMusic).mp3";
    private static String check_update_url = "http://hrwanheda.ir/update/index.php";
    private static String update_url = "http://hrwanheda.ir/update/index.php";
    String nameFile = "ielts.zip";
    RequestQueue requestQueue;
    boolean connected = false;
    public static SharedPreferences publicSpf;
    public static int solveQuiz = 0;
    public static SharedPreferences deleteItem;
    public static SharedPreferences spf;
    TourGuide mtg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog_unzip = new ProgressDialog(this);
        getSupportActionBar().hide();
        publicSpf = getSharedPreferences("numberQuiz",MODE_PRIVATE);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        deleteItem = getSharedPreferences("delete" , MODE_PRIVATE);
        spf = getSharedPreferences("spf" , MODE_PRIVATE);

        newDayPerf = getSharedPreferences("newDayPerf" , MODE_PRIVATE);
        IELTSZip = newDayPerf.getBoolean("IELTSZip" , false);
        update_code = newDayPerf.getInt("update_code" , 0);
        dPassed = newDayPerf.getInt("dPassed" , 0);
        mPassed = newDayPerf.getInt("mPassed" , 0);
        yPassed = newDayPerf.getInt("yPassed" , 0);




        downData();



       /* File ZipFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ielts.zip");
        File TargetFile = new File(getFilesDir().getAbsolutePath());

        try {
            unzip(ZipFile,TargetFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
*/

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


        Glide.with(this).load(R.drawable.logo).into(iv_cover_home);


        //btn on MainActivity
        SetPropertiesCustomView();


        //newDay();




    }


    public void downData(){

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //oast.makeText(this, "Internet Access!"+update_code, Toast.LENGTH_SHORT).show();

            connected = true;
            if (!IELTSZip){
                new DownloadFileFromURL().execute(file_url);
                //Toast.makeText(this, "Download!", Toast.LENGTH_SHORT).show();

            }else {
                newDay();
                StringRequest s = new StringRequest(Request.Method.GET, check_update_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (Integer.parseInt(response) > update_code){
                            newDayPerf.edit().putInt("update_code" , Integer.parseInt(response)).apply();
                           Toast.makeText(MainActivity.this, "The app needs updating. please wait!", Toast.LENGTH_SHORT).show();
                            update_data();

                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"The update link is broken. Please log in again!",Toast.LENGTH_LONG).show();
                    }
                });
                requestQueue.add(s);
            }
        } else{
            connected = false;
           Toast.makeText(this, "no Internet Access!", Toast.LENGTH_SHORT).show();
           //finish();
            if(IELTSZip){

                newDay();
            }
        }


    }

    @SuppressLint("CommitPrefEdits")
    public static void addIdRemovePage(int id){
        MainActivity.deleteItem.edit().putInt("page"+id , id+1).apply();
    }

    private void update_data(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("ramin1333131", "update_data: ");
            }
        });
        //Toast.makeText(this,"",Toast.LENGTH_LONG).show();

        file_url = "http://hrwanheda.ir/ielts-update.zip";
        nameFile = "ielts-update.zip";
        new DownloadFileFromURL().execute(file_url);

    }

    public void SetPropertiesCustomView()
    {



        CustomViewItem custom1 = new CustomViewItem(this,"","","",1,"","",true,"");
        CustomViewItem custom2 = new CustomViewItem(this,"","","",1,"","",true,"");
        CustomViewItem custom3 = new CustomViewItem(this,"","","",1,"","",true,"");
        CustomViewItem custom4 = new CustomViewItem(this,"","","",1,"","",true,"");
        CustomViewItem custom5 = new CustomViewItem(this,"","","",1,"","",true,"");

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










        custom1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom4.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));
        custom5.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_list_item));




        lin_list_item.addView(custom1);
        lin_list_item.addView(custom2);
        lin_list_item.addView(custom3);
        lin_list_item.addView(custom4);
        lin_list_item.addView(custom5);



    }

    @SuppressLint("CommitPrefEdits")
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
           // Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();


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
                ChallengeActivity.solveQuiz = 0;
                publicSpf.edit().putInt("numQuizSolve",solveQuiz).apply();
                deleteItem.edit().clear().apply();
                spf.edit().remove("todayS").apply();
                Log.i("asfdas" , ""+deleteItem.getAll().toString());

            }else if (day <= days && mound > mounds && years >= yearss) {
                newDayPerf.edit().putInt("dPassed" , day).apply();
                newDayPerf.edit().putInt("mPassed" , mound).apply();
                newDayPerf.edit().putInt("yPassed" , years).apply();
                setTodayQuiz();
               // Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                ChallengeActivity.solveQuiz = 0;
                publicSpf.edit().putInt("numQuizSolve",solveQuiz).apply();
                deleteItem.edit().clear().apply();
                spf.edit().remove("todayS").apply();


            }else if (day <= days && mound <= mounds && years > yearss) {
                newDayPerf.edit().putInt("dPassed" , day).apply();
                newDayPerf.edit().putInt("mPassed" , mound).apply();
                newDayPerf.edit().putInt("yPassed" , years).apply();
                setTodayQuiz();
               // Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                ChallengeActivity.solveQuiz = 0;
                publicSpf.edit().putInt("numQuizSolve",solveQuiz).apply();
                deleteItem.edit().clear().apply();
                spf.edit().remove("todayS").apply();

            }else {
                //Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
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
        File pushe = new File(getFilesDir().
                getAbsolutePath()+"/ielts/challenge/allquiz");
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 1; i <= pushe.listFiles().length; ++i) number.add(i);
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

            Log.i("Striiiin" , ""+text);
            try {
                File gpxfile = new File(pathToday+"quiz"+(i+1)+"/quiz.txt");
                FileWriter writer = new FileWriter(gpxfile);
                //writer.write(number.get(i)+"\n"+text);
                writer.write(text+"");
                writer.flush();
                writer.close();
                //Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
            } catch (Exception e) {  Log.i("raminaadsa" , ""+e.getMessage());}
            try {
                File gpxfile1 = new File(pathToday+"quiz"+(i+1)+"/answer.txt");
                FileWriter writer1 = new FileWriter(gpxfile1);
                writer1.write(String.valueOf(answer));
                writer1.flush();
                writer1.close();
                //Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
            } catch (Exception e) { Log.i("raminaadsa" , ""+e.getMessage()); }
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
        Glide.with(this).load(R.drawable.arrowmore).into(img_icon);
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

        Glide.with(this).load(R.drawable.menu_icon).into(img_icon);
        //img_icon.setBackground(getResources().getDrawable(R.drawable.menu_icon));

        menuNav = findViewById(R.id.nav_view);

        drawerLayout = findViewById(R.id.drawer_layout);


        //set OnClick and size for navigation view
        menuNav.setNavigationItemSelectedListener(this);
        menuNav.getLayoutParams().width = (int) (dm.widthPixels*.5);
        menuNav.setItemIconTintList(null);
        //Glide.with(this).load(R.drawable.logo).into();
        //Toast.makeText(this, ""+menuNav.getMenu().getItem(0).setIcon(), Toast.LENGTH_SHORT).show();

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
            startActivity(new Intent(MainActivity.this , ActivityAbout.class));
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


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    /**
     * Background Async Task to download file
     * */
    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Bar Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         * */
        @Override
        protected String doInBackground(String... f_url) {
            pDialog.setCancelable(false);
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream
                OutputStream output = new FileOutputStream(getFilesDir().
                        getAbsolutePath()
                        + "/"+nameFile);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                //Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            //Log.i("pDialog" , "ramin :"+pDialog.getProgress());
            if (pDialog.getProgress() == 100){
                // dismiss the dialog after the file was downloaded
                dismissDialog(progress_bar_type);
                //Toast.makeText(MainActivity.this, "Downloaded", Toast.LENGTH_SHORT).show();
                if(!IELTSZip)
                {
                    IELTSZip = true;

                    newDayPerf.edit().putBoolean("IELTSZip" , true ).apply();
                    final File ZipFile = new File(getFilesDir().
                            getAbsolutePath()
                            + "/"+nameFile);
                    final File TargetFile = new File(getFilesDir().getAbsolutePath());


                    progressDialog_unzip.setMessage("loading database.please wait.... ");
                    progressDialog_unzip.setCancelable(false);
                    progressDialog_unzip.show();

                   check_zip = false;
                   Thread thread = new Thread(new Runnable() {
                       @Override
                       public void run() {
                           try {
                               //Log.i("raminfdsfdsfds", "start");
                               unzip(ZipFile,TargetFile);
                               //Log.i("raminfdsfdsfds", "stop");
                               //Log.i("ramin" , "done!");

                           } catch (IOException e) {
                               //Log.i("ramin" , "err");
                               check_zip = false;
                               e.printStackTrace();
                           }
                       }
                   });
                   thread.start();

                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           progressDialog_unzip.dismiss();
                           newDay();
                       }
                   },10000);


                    //

                    //deleteRecursive(ZipFile);


                }else {

                    newDayPerf.edit().putBoolean("IELTSZip" , true ).apply();
                    File ZipFile = new File(getFilesDir().
                            getAbsolutePath()
                            + "/"+nameFile);
                    File TargetFile = new File(getFilesDir().getAbsolutePath());
                    try {
                        unzip(ZipFile,TargetFile);
                       // Log.i("ramin" , "done!");
                    } catch (IOException e) {
                      //  Log.i("ramin" , "err");
                        e.printStackTrace();

                    }

                    UpdateFile();
                    deleteRecursive(ZipFile);
                    File folder_update = new File(getFilesDir().getAbsolutePath() +"/ielts-update");
                    deleteRecursive(folder_update);
                }


            }else {
                Toast.makeText(MainActivity.this, "no Internet Access!", Toast.LENGTH_SHORT).show();
                ((ActivityManager) Objects.requireNonNull(getSystemService(ACTIVITY_SERVICE)))
                        .clearApplicationUserData();
                deleteCache(MainActivity.this);
                finish();
            }



        }

    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public void deleteRecursive(File fileOrDirectory) {

        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }

        fileOrDirectory.delete();
    }



    public boolean UpdateFile()
    {
        //START READING


        // ielts reading test academic
        File file_update_reading_test_academic = new File(getFilesDir().getAbsolutePath() + "/ielts-update/reading/test/academic");

        File[] list_file_update_reading_test_academic = file_update_reading_test_academic.listFiles();

        for(File f:list_file_update_reading_test_academic)
        {

            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/");
        }



        // ielts reading test general

        File file_update_reading_test_general = new File(getFilesDir().getAbsolutePath() + "/ielts-update/reading/test/general");

        File[] list_file_update_reading_test_general = file_update_reading_test_general.listFiles();

        for(File f:list_file_update_reading_test_general)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/reading/test/general");
        }


        //ielts reading tips
        File file_update_reading_tips = new File(getFilesDir().getAbsolutePath() + "/ielts-update/reading/tips");

        File[] list_file_update_reading_tips = file_update_reading_tips.listFiles();

        for(File f:list_file_update_reading_tips)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/reading/tips");
        }



        //reading practice easy
        File file_update_reading_practice_easy = new File(getFilesDir().getAbsolutePath() + "/ielts-update/reading/practice/easy");

        File[] list_file_update_reading_practice_easy = file_update_reading_practice_easy.listFiles();

        for(File f:list_file_update_reading_practice_easy)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/reading/practice/easy");
        }

        //reading practice normal
        File file_update_reading_practice_normal = new File(getFilesDir().getAbsolutePath() + "/ielts-update/reading/practice/normal");

        File[] list_file_update_reading_practice_normal = file_update_reading_practice_normal.listFiles();

        for(File f:list_file_update_reading_practice_normal)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/reading/practice/normal");
        }

        //reading practice hard
        File file_update_reading_practice_hard = new File(getFilesDir().getAbsolutePath() + "/ielts-update/reading/practice/hard");

        File[] list_file_update_reading_practice_hard = file_update_reading_practice_hard.listFiles();

        for(File f:list_file_update_reading_practice_hard)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/reading/practice/hard");
        }


        //END READING


        //START WRITING



        // ielts writing test academic
        File file_update_writing_test_academic = new File(getFilesDir().getAbsolutePath() + "/ielts-update/writing/test/academic");

        File[] list_file_update_writing_test_academic = file_update_writing_test_academic.listFiles();

        for(File f:list_file_update_writing_test_academic)
        {

            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/writing/test/academic/");
        }



        // ielts writing test general

        File file_update_writing_test_general = new File(getFilesDir().getAbsolutePath() + "/ielts-update/writing/test/general");

        File[] list_file_update_writing_test_general = file_update_writing_test_general.listFiles();

        for(File f:list_file_update_writing_test_general)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/writing/test/general");
        }


        //ielts writing tips
        File file_update_writing_tips = new File(getFilesDir().getAbsolutePath() + "/ielts-update/writing/tips");

        File[] list_file_update_writing_tips = file_update_writing_tips.listFiles();

        for(File f:list_file_update_writing_tips)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/writing/tips");
        }


        //ielts writing vocab
        File file_update_writing_vocab = new File(getFilesDir().getAbsolutePath() + "/ielts-update/writing/vocab");

        File[] list_file_update_writing_vocab = file_update_writing_vocab.listFiles();

        for(File f:list_file_update_writing_vocab)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/writing/vocab");
        }


        //END WRITING


        //START SPEAKING

        //ielts speaking test
        File file_update_speaking_test = new File(getFilesDir().getAbsolutePath() + "/ielts-update/speaking/test");

        File[] list_file_update_speaking_test = file_update_speaking_test.listFiles();

        for(File f:list_file_update_speaking_test)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/speaking/test");
        }

        //ielts speaking tips
        File file_update_speaking_tips = new File(getFilesDir().getAbsolutePath() + "/ielts-update/speaking/tips");

        File[] list_file_update_speaking_tips = file_update_speaking_tips.listFiles();

        for(File f:list_file_update_speaking_tips)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/speaking/tips");
        }

        //ielts speaking vocab
        File file_update_speaking_vocab = new File(getFilesDir().getAbsolutePath() + "/ielts-update/speaking/vocab");

        File[] list_file_update_speaking_vocab = file_update_speaking_vocab.listFiles();

        for(File f:list_file_update_speaking_vocab)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/speaking/vocab");
        }

        //END SPEAKING

        //START LISTENING


        //ielts listening test
        File file_update_listening_test = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/test");

        File[] list_file_update_listening_test = file_update_listening_test.listFiles();

        for(File f:list_file_update_listening_test)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/test");
        }

        //ielts listening tips
        File file_update_listening_tips = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/tips");

        File[] list_file_update_listening_tips = file_update_listening_tips.listFiles();

        for(File f:list_file_update_listening_tips)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/tips");
        }


        //listening practice typea easy
        File file_update_listening_practice_typea_easy = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/practice/typea/easy");

        File[] list_file_update_listening_practice_typea_easy = file_update_listening_practice_typea_easy.listFiles();

        for(File f:list_file_update_listening_practice_typea_easy)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/practice/typea/easy");
        }


        //listening practice typea normal
        File file_update_listening_practice_typea_normal = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/practice/typea/normal");

        File[] list_file_update_listening_practice_typea_normal = file_update_listening_practice_typea_normal.listFiles();

        for(File f:list_file_update_listening_practice_typea_normal)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/practice/typea/normal");
        }

        //listening practice typea hard
        File file_update_listening_practice_typea_hard = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/practice/typea/hard");

        File[] list_file_update_listening_practice_typea_hard = file_update_listening_practice_typea_hard.listFiles();

        for(File f:list_file_update_listening_practice_typea_hard)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/practice/typea/hard");
        }



        //listening practice typeb easy
        File file_update_listening_practice_typeb_easy = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/practice/typeb/easy");

        File[] list_file_update_listening_practice_typeb_easy = file_update_listening_practice_typeb_easy.listFiles();

        for(File f:list_file_update_listening_practice_typeb_easy)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/practice/typeb/easy");
        }


        //listening practice typeb normal
        File file_update_listening_practice_typeb_normal = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/practice/typeb/normal");

        File[] list_file_update_listening_practice_typeb_normal = file_update_listening_practice_typeb_normal.listFiles();

        for(File f:list_file_update_listening_practice_typeb_normal)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/practice/typeb/normal");
        }

        //listening practice typeb hard
        File file_update_listening_practice_typeb_hard = new File(getFilesDir().getAbsolutePath() + "/ielts-update/listening/practice/typeb/hard");

        File[] list_file_update_listening_practice_typeb_hard = file_update_listening_practice_typeb_hard.listFiles();

        for(File f:list_file_update_listening_practice_typeb_hard)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/listening/practice/typeb/hard");
        }


        //END LISTENING


        //START CHALLENGE


        //challenge allquiz
        File file_update_challenge_allquiz = new File(getFilesDir().getAbsolutePath() + "/ielts-update/challenge/allquiz");

        File[] list_file_update_challenge_allquiz = file_update_challenge_allquiz.listFiles();

        for(File f:list_file_update_challenge_allquiz)
        {
            copyFileOrDirectory(f.getAbsolutePath(),getFilesDir().getAbsolutePath() + "/ielts/challenge/allquiz");
        }

        //END CHALLENGE










        return true;
    }

    public static void copyFileOrDirectory(String srcDir, String dstDir) {

        try {
            File src = new File(srcDir);
            File dst = new File(dstDir, src.getName());

            if (src.isDirectory()) {

                String files[] = src.list();
                int filesLength = files.length;
                for (int i = 0; i < filesLength; i++) {
                    String src1 = (new File(src, files[i]).getPath());
                    String dst1 = dst.getPath();
                    copyFileOrDirectory(src1, dst1);

                }
            } else {
                copyFile(src, dst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.getParentFile().exists())
            destFile.getParentFile().mkdirs();

        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }
}



