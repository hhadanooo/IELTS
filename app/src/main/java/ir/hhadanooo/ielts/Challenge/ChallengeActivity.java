package ir.hhadanooo.ielts.Challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Objects;

import ir.hhadanooo.ielts.R;

public class ChallengeActivity extends AppCompatActivity {

    ImageView iv_arrowBack_chlng , iv_ic_logoPage_chlng , iv_result_A_chlng
            ,iv_result_B_chlng , iv_result_C_chlng ,iv_result_D_chlng , iv_next_chlng;
    TextView tv_TitleLogo_chlng , tv_PathLogo_chlng  , tv_todayScore_chlng
            , tv_totalScore_chlng , tv_question_chlng , tv_result_A_chlng ,
            tv_result_B_chlng , tv_result_C_chlng , tv_result_D_chlng;
    View view_center_score_chlng , view_center_AB_chlng ,view_center_CD_chlng
            , view_center_AB_CD_chlng;
    DisplayMetrics dm;
    LinearLayout lay_chlng;
    ScrollView lay_tv_question_chlng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        Objects.requireNonNull(getSupportActionBar()).hide();
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        initActionBar();

        lay_chlng = findViewById(R.id.lay_chlng);
        tv_todayScore_chlng = findViewById(R.id.tv_todayScore_chlng);
        tv_totalScore_chlng = findViewById(R.id.tv_totalScore_chlng);
        view_center_score_chlng = findViewById(R.id.view_center_score_chlng);
        lay_tv_question_chlng = findViewById(R.id.lay_tv_question_chlng);
        tv_question_chlng = findViewById(R.id.tv_question_chlng);
        iv_result_A_chlng = findViewById(R.id.iv_result_A_chlng);
        tv_result_A_chlng = findViewById(R.id.tv_result_A_chlng);
        view_center_AB_chlng = findViewById(R.id.view_center_AB_chlng);
        iv_result_B_chlng = findViewById(R.id.iv_result_B_chlng);
        tv_result_B_chlng = findViewById(R.id.tv_result_B_chlng);
        iv_result_C_chlng = findViewById(R.id.iv_result_C_chlng);
        tv_result_C_chlng = findViewById(R.id.tv_result_C_chlng);
        view_center_CD_chlng = findViewById(R.id.view_center_CD_chlng);
        iv_result_D_chlng = findViewById(R.id.iv_result_D_chlng);
        tv_result_D_chlng = findViewById(R.id.tv_result_D_chlng);
        view_center_AB_CD_chlng = findViewById(R.id.view_center_AB_CD_chlng);
        iv_next_chlng = findViewById(R.id.iv_next_chlng);


        lay_chlng.getLayoutParams().width = (int) (dm.widthPixels*.93);

        tv_todayScore_chlng.setTextSize((int) (dm.widthPixels*.014));

        tv_totalScore_chlng.setTextSize((int) (dm.widthPixels*.014));

        view_center_score_chlng.getLayoutParams().width = (int) (dm.widthPixels*.15);
        view_center_score_chlng.getLayoutParams().height = (int) (dm.widthPixels*.01);

        lay_tv_question_chlng.getLayoutParams().width = (int) (dm.widthPixels*.75);
        lay_tv_question_chlng.getLayoutParams().height = (int) (dm.widthPixels*.55);

        tv_question_chlng.setTextSize((int) (dm.widthPixels*.016));

        iv_result_A_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_A_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);

        tv_result_A_chlng.setTextSize((int) (dm.widthPixels*.03));

        view_center_AB_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        view_center_AB_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_result_B_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_B_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);

        tv_result_B_chlng.setTextSize((int) (dm.widthPixels*.03));

        iv_result_C_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_C_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);

        tv_result_C_chlng.setTextSize((int) (dm.widthPixels*.03));

        view_center_CD_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        view_center_CD_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_result_D_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_D_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);

        tv_result_D_chlng.setTextSize((int) (dm.widthPixels*.03));

        view_center_AB_CD_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        view_center_AB_CD_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_next_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_next_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);



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
}
