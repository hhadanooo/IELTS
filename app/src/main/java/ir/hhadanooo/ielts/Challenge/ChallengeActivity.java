package ir.hhadanooo.ielts.Challenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ir.hhadanooo.ielts.Challenge.CustomSlide.CustomSlideChallenge;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.MainActivity;
import ir.hhadanooo.ielts.Quiz.AnimationSliderQuiz.CubeOutRotationTransformation;
import ir.hhadanooo.ielts.R;

public class ChallengeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    ImageView iv_arrowBack_chlng , iv_ic_logoPage_chlng ;
    TextView tv_TitleLogo_chlng , tv_PathLogo_chlng ;
    List<View> viewForCustom = new ArrayList<>();
    List<CustomSlideChallenge> slideForCustom = new ArrayList<>();
    public static ViewPager ViewPager_Challenge;
    DisplayMetrics dm;
    static ViewPagerAdapterChlng viewPagerAdapterChlng;

    public static int todayS = 0;
    public static int totalS = 0;


    public static SharedPreferences spf;
    static SharedPreferences publicSpf;


    public static int solveQuiz = 0;

    int num_quiz = 10;
    int ans_quiz = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        Objects.requireNonNull(getSupportActionBar()).hide();
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        initActionBar();

        publicSpf = getSharedPreferences("numberQuiz" , MODE_PRIVATE);

        solveQuiz = publicSpf.getInt("numQuizSolve" , 0);
        spf = getSharedPreferences("spf" , MODE_PRIVATE);
        todayS = spf.getInt("todayS" , 0);
        totalS = spf.getInt("totalS" , 0);
        //Log.i("Striiiin" , "slm");




        makeViewForSlider();

        ViewPager_Challenge = findViewById(R.id.ViewPager_Challenge);
        ViewPager_Challenge.getLayoutParams().width = (int) (dm.widthPixels*.93);

        //DepthTransformation depthTransformation = new DepthTransformation();
        //CubeOutDepthTransformation cube = new CubeOutDepthTransformation();
        CubeOutRotationTransformation cube = new CubeOutRotationTransformation();
        //FanTransformation fan = new FanTransformation();
        ViewPager_Challenge.setPageTransformer(true, cube);

        viewPagerAdapterChlng = new ViewPagerAdapterChlng();
        viewPagerAdapterChlng.notifyDataSetChanged();
        ViewPager_Challenge.setAdapter(viewPagerAdapterChlng);
        //ViewPager_Challenge.addOnPageChangeListener(viewPagerPageChangeListener);


        ViewPager_Challenge.setOnPageChangeListener(this);

    }


    @SuppressLint("CommitPrefEdits")
    public static void Solve(){
        solveQuiz++;
        publicSpf.edit().putInt("numQuizSolve" , solveQuiz).apply();
    }


    @SuppressLint("CommitPrefEdits")
    public static void plusTodayScore(int add){
        todayS = todayS+add;
        spf.edit().putInt("todayS" , todayS).apply();

    }
    @SuppressLint("CommitPrefEdits")
    public static void plusTotalScore(int add){
        totalS = totalS+add;
        spf.edit().putInt("totalS" , totalS).apply();

    }

    public static void next_page_viewPager() {
        ViewPager_Challenge.setCurrentItem(ViewPager_Challenge.getCurrentItem()+1);
    }

    public void makeViewForSlider(){

        for (int i = 0 ; i < num_quiz ; i++){

            int page = MainActivity.deleteItem.getInt("page"+i , 0);
            if ( page > 0){
                ans_quiz++;
                if (ans_quiz == num_quiz){
                    Toast.makeText(this, "finish for today", Toast.LENGTH_SHORT).show();
                }
                Log.i("rttada" , ""+page);
                continue;
            }

            File file = new File(getFilesDir().
                    getAbsolutePath()+"/ielts/challenge/today/quiz"+(i+1)+"/quiz.txt");

            final StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    //text.append('\n');
                }
                br.close() ;
            }catch (IOException e) {
                e.printStackTrace();
            }
            //Log.i("Striiiin" , "0"+text);
            File file1 = new File(getFilesDir().
                    getAbsolutePath()+"/ielts/challenge/today/quiz"+(i+1)+"/answer.txt");

            boolean[] answers = new boolean[4];
            int lineNum = 0;
            int numTrue = 0;
            int numAns = 0;
            final StringBuilder answer = new StringBuilder();
            try {
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                String line;
                while ((line = br1.readLine()) != null) {
                    numAns++;
                    if (line.contains("f")){
                        answers[lineNum] = false;
                    }else if (line.contains("t")){
                        answers[lineNum] = true;
                        numTrue++;
                    }
                    lineNum++;
                    //answer.append(line);
                    //text.append('\n');
                }
                br1.close() ;
            }catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("Striiiin" , "1"+answer);

            CustomSlideChallenge cvq = new CustomSlideChallenge(ChallengeActivity.this
                    , dm , i ,String.valueOf(text) , answers , numTrue , numAns );
            Log.i("numAns" , "a "+numAns  );
            viewForCustom.add(cvq);
            slideForCustom.add(cvq);
        }
    }
    private void initActionBar() {

        iv_arrowBack_chlng = findViewById(R.id.iv_arrowBack_chlng);
        iv_ic_logoPage_chlng = findViewById(R.id.iv_ic_logoPage_chlng);
        tv_TitleLogo_chlng = findViewById(R.id.tv_TitleLogo_chlng);
        tv_PathLogo_chlng = findViewById(R.id.tv_PathLogo_chlng);



        iv_arrowBack_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);

        tv_TitleLogo_chlng.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_chlng.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_chlng.setText("Challenge");
        tv_PathLogo_chlng.setText("Challenge");

        iv_arrowBack_chlng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        CustomViewItem.progressDialog.dismiss();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onPageSelected(int position) {
        TextView tv_todayScore_chlng = viewForCustom.
                get(position).findViewById(R.id.tv_todayScore_chlng);
        TextView tv_totalScore_chlng = viewForCustom.
                get(position).findViewById(R.id.tv_totalScore_chlng);

        tv_todayScore_chlng.setText("Today Score: "+todayS);
        tv_totalScore_chlng.setText("Total Score: "+totalS);



    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public class ViewPagerAdapterChlng extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(viewForCustom.get(position));

            return viewForCustom.get(position);

        }

        @Override
        public int getCount() {
            return viewForCustom.size();
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



}
