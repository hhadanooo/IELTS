package ir.yottahouse.EnjoyIELTS.Quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.Quiz.AnimationSliderQuiz.CubeOutRotationTransformation;
import ir.yottahouse.EnjoyIELTS.Quiz.CustomViewQuiz.CustomViewQuiz;
import ir.yottahouse.EnjoyIELTS.R;

public class QuizActivity extends AppCompatActivity {

    ViewPager ViewPager_Quiz;
    ViewPagerAdapter viewPagerAdapter;
    SeekBar progressbar_Quiz;
    int prog_size;
    List<View> viewForCustom = new ArrayList<>();

    DisplayMetrics dm;
    ImageView iv_arrowBack_Quiz , iv_help_Quiz;

    int[] layouts = {R.drawable.q1  , R.drawable.q2
            , R.drawable.q3 , R.drawable.q4, R.drawable.q5 , R.drawable.q6 , R.drawable.q7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Objects.requireNonNull(getSupportActionBar()).hide();
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        makeViewForSlider();
        ViewPager_Quiz = findViewById(R.id.ViewPager_Quiz);
        progressbar_Quiz = findViewById(R.id.progressbar_Quiz);
        iv_arrowBack_Quiz = findViewById(R.id.iv_arrowBack_Quiz);
        iv_help_Quiz = findViewById(R.id.iv_help_Quiz);

        //DepthTransformation depthTransformation = new DepthTransformation();
        //CubeOutDepthTransformation cube = new CubeOutDepthTransformation();
        CubeOutRotationTransformation cube = new CubeOutRotationTransformation();
        //FanTransformation fan = new FanTransformation();
        ViewPager_Quiz.setPageTransformer(true, cube);

        ViewPager_Quiz.getLayoutParams().width = (int) (dm.widthPixels*.9);
        ViewPager_Quiz.getLayoutParams().height = (int) (dm.heightPixels*.7);

        iv_arrowBack_Quiz.getLayoutParams().width = (int) (dm.widthPixels*.08);
        iv_arrowBack_Quiz.getLayoutParams().height = (int) (dm.widthPixels*.08);

        iv_help_Quiz.getLayoutParams().width = (int) (dm.widthPixels*.08);
        iv_help_Quiz.getLayoutParams().height = (int) (dm.widthPixels*.08);


        viewPagerAdapter = new ViewPagerAdapter();
        ViewPager_Quiz.setAdapter(viewPagerAdapter);
        ViewPager_Quiz.addOnPageChangeListener(viewPagerPageChangeListener);


        prog_size = (100/(viewForCustom.size()-1));



    }

    public void makeViewForSlider(){
        for (int i = 0 ; i < 10 ; i++){
            CustomViewQuiz cvq = new CustomViewQuiz(QuizActivity.this , dm , 3 ,
                    "whats your name ?",
                    "hhadanooo" ,
                    "matiooo" ,
                    "ramin");
            viewForCustom.add(cvq);
        }
    }


    public class ViewPagerAdapter extends PagerAdapter {

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

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            progressbar_Quiz.setProgress((position)*prog_size);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

}
