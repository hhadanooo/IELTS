package ir.hhadanooo.ielts.Challenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ir.hhadanooo.ielts.Challenge.CustomSlide.CustomSlideChallenge;
import ir.hhadanooo.ielts.Quiz.AnimationSliderQuiz.CubeOutRotationTransformation;
import ir.hhadanooo.ielts.R;

public class ChallengeActivity extends AppCompatActivity {

    ImageView iv_arrowBack_chlng , iv_ic_logoPage_chlng ;
    TextView tv_TitleLogo_chlng , tv_PathLogo_chlng ;
    List<View> viewForCustom = new ArrayList<>();
    ViewPager ViewPager_Challenge;
    DisplayMetrics dm;
    ViewPagerAdapterChlng viewPagerAdapterChlng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        Objects.requireNonNull(getSupportActionBar()).hide();
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        initActionBar();

        makeViewForSlider();
        ViewPager_Challenge = findViewById(R.id.ViewPager_Challenge);
        ViewPager_Challenge.getLayoutParams().width = (int) (dm.widthPixels*.93);

        //DepthTransformation depthTransformation = new DepthTransformation();
        //CubeOutDepthTransformation cube = new CubeOutDepthTransformation();
        CubeOutRotationTransformation cube = new CubeOutRotationTransformation();
        //FanTransformation fan = new FanTransformation();
        ViewPager_Challenge.setPageTransformer(true, cube);

        viewPagerAdapterChlng = new ViewPagerAdapterChlng();
        ViewPager_Challenge.setAdapter(viewPagerAdapterChlng);
        //ViewPager_Challenge.addOnPageChangeListener(viewPagerPageChangeListener);




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

    }

    public void makeViewForSlider(){
        for (int i = 0 ; i < 10 ; i++){
            CustomSlideChallenge cvq = new CustomSlideChallenge(ChallengeActivity.this
                    , dm );
            viewForCustom.add(cvq);
        }
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

   /* ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

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
    };*/

}
