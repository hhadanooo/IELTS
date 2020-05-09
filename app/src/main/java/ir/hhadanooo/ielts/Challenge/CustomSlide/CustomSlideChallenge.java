package ir.hhadanooo.ielts.Challenge.CustomSlide;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import ir.hhadanooo.ielts.R;

public class CustomSlideChallenge extends LinearLayout {

    ImageView iv_result_A_chlng,iv_result_B_chlng , iv_result_C_chlng ,iv_result_D_chlng , iv_next_chlng;
    TextView tv_todayScore_chlng
            , tv_totalScore_chlng , tv_question_chlng , tv_result_A_chlng ,
            tv_result_B_chlng , tv_result_C_chlng , tv_result_D_chlng;

    View view_center_score_chlng , view_center_AB_chlng ,view_center_CD_chlng
            , view_center_AB_CD_chlng;

    LinearLayout lay_chlng;
    ScrollView lay_tv_question_chlng;
    private View rootView;
    public CustomSlideChallenge(Context context , DisplayMetrics dm) {
        super(context);

        rootView = inflate(context , R.layout.custom_slide_challenge , this);
        lay_chlng = findViewById(R.id.lay_chlng);
        tv_todayScore_chlng = rootView.findViewById(R.id.tv_todayScore_chlng);
        tv_totalScore_chlng = rootView.findViewById(R.id.tv_totalScore_chlng);
        view_center_score_chlng = rootView.findViewById(R.id.view_center_score_chlng);
        lay_tv_question_chlng = rootView.findViewById(R.id.lay_tv_question_chlng);
        tv_question_chlng = rootView.findViewById(R.id.tv_question_chlng);
        iv_result_A_chlng = rootView.findViewById(R.id.iv_result_A_chlng);
        tv_result_A_chlng = rootView.findViewById(R.id.tv_result_A_chlng);
        view_center_AB_chlng = rootView.findViewById(R.id.view_center_AB_chlng);
        iv_result_B_chlng = rootView.findViewById(R.id.iv_result_B_chlng);
        tv_result_B_chlng = rootView.findViewById(R.id.tv_result_B_chlng);
        iv_result_C_chlng = rootView.findViewById(R.id.iv_result_C_chlng);
        tv_result_C_chlng = rootView.findViewById(R.id.tv_result_C_chlng);
        view_center_CD_chlng = rootView.findViewById(R.id.view_center_CD_chlng);
        iv_result_D_chlng = rootView.findViewById(R.id.iv_result_D_chlng);
        tv_result_D_chlng = rootView.findViewById(R.id.tv_result_D_chlng);
        view_center_AB_CD_chlng = rootView.findViewById(R.id.view_center_AB_CD_chlng);
        iv_next_chlng = rootView.findViewById(R.id.iv_next_chlng);


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
}



