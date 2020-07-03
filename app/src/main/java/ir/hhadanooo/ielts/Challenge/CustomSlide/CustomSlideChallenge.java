package ir.hhadanooo.ielts.Challenge.CustomSlide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Arrays;

import ir.hhadanooo.ielts.Challenge.ChallengeActivity;
import ir.hhadanooo.ielts.MainActivity;
import ir.hhadanooo.ielts.R;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class CustomSlideChallenge extends LinearLayout {

    ImageView iv_result_A_chlng,iv_result_B_chlng  ,iv_Tick_check_chlng , iv_result_C_chlng ,iv_result_D_chlng , iv_next_chlng;
    TextView tv_todayScore_chlng;
    TextView tv_totalScore_chlng;
    TextView tv_question_chlng;
    TextView tv_result_A_chlng;
    TextView tv_result_B_chlng;
    TextView tv_result_C_chlng;
    TextView tv_result_D_chlng;

    View view_center_score_chlng , view_center_AB_chlng ,view_center_CD_chlng
            , view_center_AB_CD_chlng;

    LinearLayout lay_chlng , layA , layB , layC , layD , layResultABCD;
    ScrollView lay_tv_question_chlng;
    private View rootView;

    int idView;


    boolean selectA = false;
    boolean selectB = false;
    boolean selectC = false;
    boolean selectD = false;
    boolean showHelp = false;
    boolean accessSelect = true;
    boolean[] arrayTf ;
    Context context;
    Activity activity;
    int numTrue;
    int numSel = 0;
    int numAns = 0;
    TourGuide mtg;
    RelativeLayout layMgt;

    @SuppressLint("SetTextI18n")
    public CustomSlideChallenge(final Activity activity , DisplayMetrics dm , final int id
            , String question , boolean[] arrayTF  , final int numTrue , final int numAns) {
        super(activity);
        this.arrayTf = arrayTF;
        this.idView = id;
        this.numTrue = numTrue;
        this.numAns = numAns;
        rootView = inflate(activity , R.layout.custom_slide_challenge , this);
        lay_chlng = findViewById(R.id.lay_chlng);
        layMgt = findViewById(R.id.layMgt);
        layResultABCD = rootView.findViewById(R.id.layResultABCD);
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
        iv_Tick_check_chlng = rootView.findViewById(R.id.iv_Tick_check_chlng);
        layA = rootView.findViewById(R.id.layA);
        layB = rootView.findViewById(R.id.layB);
        layC = rootView.findViewById(R.id.layC);
        layD = rootView.findViewById(R.id.layD);

        if (numAns == 2){
            layC.setVisibility(GONE);
            layD.setVisibility(GONE);
            view_center_CD_chlng.setVisibility(GONE);
            view_center_AB_CD_chlng.setVisibility(GONE);
        }else if (numAns == 3){
            layD.setVisibility(GONE);
            view_center_CD_chlng.setVisibility(GONE);
        }


        lay_chlng.getLayoutParams().width = (int) (dm.widthPixels*.93);


        tv_todayScore_chlng.setTextSize((int) (dm.widthPixels*.014));

        tv_totalScore_chlng.setTextSize((int) (dm.widthPixels*.014));

        tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
        tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);

        view_center_score_chlng.getLayoutParams().width = (int) (dm.widthPixels*.15);
        view_center_score_chlng.getLayoutParams().height = (int) (dm.widthPixels*.01);

        lay_tv_question_chlng.getLayoutParams().width = (int) (dm.widthPixels*.75);
        lay_tv_question_chlng.getLayoutParams().height = (int) (dm.widthPixels*.48);

        tv_question_chlng.setTextSize((int) (dm.widthPixels*.016));
        tv_question_chlng.setText(question);

        iv_result_A_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_A_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);

        Glide.with(this).load(R.drawable.tick_result_icon).into(iv_result_A_chlng);

        tv_result_A_chlng.setTextSize((int) (dm.widthPixels*.03));

        view_center_AB_chlng.getLayoutParams().width = (int) (dm.widthPixels*.05);
        view_center_AB_chlng.getLayoutParams().height = (int) (dm.widthPixels*.05);

        iv_result_B_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_B_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);
        Glide.with(this).load(R.drawable.tick_result_icon).into(iv_result_B_chlng);

        tv_result_B_chlng.setTextSize((int) (dm.widthPixels*.03));

        iv_result_C_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_C_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);
        Glide.with(this).load(R.drawable.tick_result_icon).into(iv_result_C_chlng);

        tv_result_C_chlng.setTextSize((int) (dm.widthPixels*.03));

        view_center_CD_chlng.getLayoutParams().width = (int) (dm.widthPixels*.05);
        view_center_CD_chlng.getLayoutParams().height = (int) (dm.widthPixels*.05);

        iv_result_D_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_result_D_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);
        Glide.with(this).load(R.drawable.tick_result_icon).into(iv_result_D_chlng);

        tv_result_D_chlng.setTextSize((int) (dm.widthPixels*.03));

        view_center_AB_CD_chlng.getLayoutParams().width = (int) (dm.widthPixels*.05);
        view_center_AB_CD_chlng.getLayoutParams().height = (int) (dm.widthPixels*.05);

        iv_next_chlng.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_next_chlng.getLayoutParams().height = (int) (dm.widthPixels*.1);
        Glide.with(this).load(R.drawable.next_arrow_icon).into(iv_next_chlng);

        iv_Tick_check_chlng.getLayoutParams().width = (int) (dm.widthPixels*.12);
        iv_Tick_check_chlng.getLayoutParams().height = (int) (dm.widthPixels*.12);
        iv_Tick_check_chlng.setEnabled(false);


        iv_result_A_chlng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numSel < numTrue){
                    if (accessSelect){
                        if (selectA){
                            iv_Tick_check_chlng.setEnabled(false);
                            selectA = false;
                            numSel--;
                            layA .setBackgroundResource(R.drawable.unselect_bg);
                        }else {
                            iv_Tick_check_chlng.setEnabled(true);
                            selectA = true;
                            numSel++;
                            layA .setBackgroundResource(R.drawable.select_bg);
                        }
                    }

                }else {
                    if (selectA){
                        iv_Tick_check_chlng.setEnabled(false);
                        selectA = false;
                        numSel--;
                        layA .setBackgroundResource(R.drawable.unselect_bg);
                    }
                }


                Log.i("numt" , numSel+" a "+numTrue );

            }
        });
        iv_result_B_chlng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numSel < numTrue){
                    if (accessSelect){
                        if (selectB){
                            iv_Tick_check_chlng.setEnabled(false);
                            selectB = false;
                            numSel--;
                            layB .setBackgroundResource(R.drawable.unselect_bg);
                        }else {
                            iv_Tick_check_chlng.setEnabled(true);
                            selectB = true;
                            numSel++;
                            layB .setBackgroundResource(R.drawable.select_bg);
                        }
                    }

                }else {
                    if (selectB){
                        iv_Tick_check_chlng.setEnabled(false);
                        selectB = false;
                        numSel--;
                        layB .setBackgroundResource(R.drawable.unselect_bg);
                    }
                }


                Log.i("numt" , numSel+" a "+numTrue );


            }
        });
        iv_result_C_chlng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numSel < numTrue){
                    if (accessSelect){
                        if (selectC){
                            iv_Tick_check_chlng.setEnabled(false);
                            selectC = false;
                            numSel--;
                            layC .setBackgroundResource(R.drawable.unselect_bg);
                        }else {
                            iv_Tick_check_chlng.setEnabled(true);
                            selectC = true;
                            numSel++;
                            layC .setBackgroundResource(R.drawable.select_bg);
                        }
                    }

                }else {
                    if (selectC){
                        iv_Tick_check_chlng.setEnabled(false);
                        selectC = false;
                        numSel--;
                        layC .setBackgroundResource(R.drawable.unselect_bg);
                    }
                }
                Log.i("numt" , numSel+" a "+numTrue );

            }
        });
        iv_result_D_chlng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numSel < numTrue){
                    if (accessSelect){
                        if (selectD){
                            iv_Tick_check_chlng.setEnabled(false);
                            selectD = false;
                            numSel--;
                            layD .setBackgroundResource(R.drawable.unselect_bg);
                        }else {
                            iv_Tick_check_chlng.setEnabled(true);
                            selectD = true;
                            numSel++;
                            layD .setBackgroundResource(R.drawable.select_bg);
                        }
                    }

                }else {
                    if (selectD){
                        iv_Tick_check_chlng.setEnabled(false);
                        selectD = false;
                        numSel--;
                        layD .setBackgroundResource(R.drawable.unselect_bg);
                    }
                }
                Log.i("numt" , numSel+" a "+numTrue );
            }
        });

        iv_Tick_check_chlng.setOnClickListener(new OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                iv_Tick_check_chlng.setEnabled(false);
                Log.i("tAndta" , "arr : "+ Arrays.toString(arrayTf) +
                        "\n A : "+selectA+
                        "\n B : "+selectB+
                        "\n C : "+selectC+
                        "\n D : "+selectD);
                accessSelect = false;
                if (arrayTf[0]){
                    layA .setBackgroundResource(R.drawable.true_bg);
                    if (selectA){
                        ChallengeActivity.plusTodayScore(1);
                        ChallengeActivity.plusTotalScore(1);
                        tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                        tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);

                        //Log.i("tAndt" , "A"+todayS+"A"+totalS);
                    }
                }else{
                    layA .setBackgroundResource(R.drawable.false_bg);
                    tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                    tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);
                }
                if (arrayTf[1]){
                    layB .setBackgroundResource(R.drawable.true_bg);
                    if (selectB){
                        ChallengeActivity.plusTodayScore(1);
                        ChallengeActivity.plusTotalScore(1);
                        tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                        tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);

                        //Log.i("tAndt" , "A"+todayS+"A"+totalS);
                    }
                }else {
                    layB .setBackgroundResource(R.drawable.false_bg);
                    tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                    tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);
                }
                if (arrayTf[2]){
                    if (selectC){
                        ChallengeActivity.plusTodayScore(1);
                        ChallengeActivity.plusTotalScore(1);
                        tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                        tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);

                        //Log.i("tAndt" , "A"+todayS+"A"+totalS);
                    }
                    layC .setBackgroundResource(R.drawable.true_bg);
                }else{
                    layC .setBackgroundResource(R.drawable.false_bg);
                    tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                    tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);
                }
                if (arrayTf[3]){
                    if (selectD){
                        ChallengeActivity.plusTodayScore(1);
                        ChallengeActivity.plusTotalScore(1);
                        tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                        tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);

                        //Log.i("tAndt" , "A"+todayS+"A"+totalS);
                    }
                    layD .setBackgroundResource(R.drawable.true_bg);
                }else {
                    layD .setBackgroundResource(R.drawable.false_bg);
                    tv_todayScore_chlng.setText("Today Score: "+ChallengeActivity.todayS);
                    tv_totalScore_chlng.setText("Total Score: "+ChallengeActivity.totalS);
                }

                /*Toast.makeText(context, "Today"+ChallengeActivity.todayS+
                        "Total"+ChallengeActivity.totalS, Toast.LENGTH_SHORT).show();*/
                MainActivity.addIdRemovePage(id);
                ChallengeActivity.Solve();


            }
        });




        iv_next_chlng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ChallengeActivity.next_page_viewPager();
            }
        });


    }
    public LinearLayout iv(){
        return layResultABCD;
    }
    public RelativeLayout rl(){
        return layMgt;
    }

    public ImageView iv1(){
        return iv_Tick_check_chlng;
    }

    public ImageView iv2(){
        return iv_next_chlng;
    }

}



