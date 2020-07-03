package ir.yottahouse.EnjoyIELTS.Quiz.CustomViewQuiz;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.yottahouse.EnjoyIELTS.R;


public class CustomViewQuiz extends LinearLayout {


    private View rootView;
    private Context context;
    private RelativeLayout layAnswer1 , layAnswer2 , layAnswer3;
    private TextView tv_Answer1 , tv_Answer2 , tv_Answer3 , tv_question;
    private ImageView submit_Answer;
    private DisplayMetrics dm;
    private String text_question , text_answer1 , text_answer2 , text_answer3;
    private int num_answer;
    private boolean answer1IsSelect = false;
    private boolean answer2IsSelect = false;
    private boolean answer3IsSelect = false;



    public CustomViewQuiz(Context context , DisplayMetrics dm , int num_answer,
                          String text_question , String text_answer1 , String text_answer2 , String text_answer3) {
        super(context);
        this.context = context;
        this.dm = dm;
        this.num_answer = num_answer;
        this.text_question = text_question;
        this.text_answer1 = text_answer1;
        this.text_answer2 = text_answer2;
        this.text_answer3 = text_answer3;

        init();
    }


    private void init() {

        rootView = inflate(context , R.layout.custom_layout_quiz , this);
        layAnswer1 = rootView.findViewById(R.id.layAnswer1);
        layAnswer2 = rootView.findViewById(R.id.layAnswer2);
        layAnswer3 = rootView.findViewById(R.id.layAnswer3);
        tv_Answer1 = rootView.findViewById(R.id.tv_Answer1);
        tv_Answer2 = rootView.findViewById(R.id.tv_Answer2);
        tv_Answer3 = rootView.findViewById(R.id.tv_Answer3);
        tv_question = rootView.findViewById(R.id.tv_question);
        submit_Answer = rootView.findViewById(R.id.submit_Answer);

        submit_Answer.getLayoutParams().height = (int) (dm.widthPixels*.08);
        submit_Answer.getLayoutParams().width = (int) (dm.widthPixels*.08);

        layAnswer1.getLayoutParams().height = (int) (dm.widthPixels*.15);
        layAnswer1.getLayoutParams().width = (int) (dm.widthPixels*.6);

        layAnswer2.getLayoutParams().height = (int) (dm.widthPixels*.15);
        layAnswer2.getLayoutParams().width = (int) (dm.widthPixels*.6);

        layAnswer3.getLayoutParams().height = (int) (dm.widthPixels*.15);
        layAnswer3.getLayoutParams().width = (int) (dm.widthPixels*.6);

        if (num_answer == 2){
            tv_question.setText(text_question);
            tv_Answer1.setText(text_answer1);
            tv_Answer2.setText(text_answer2);
            layAnswer3.setVisibility(GONE);

        }else if (num_answer == 3){
            tv_question.setText(text_question);
            tv_Answer1.setText(text_answer1);
            tv_Answer2.setText(text_answer2);
            tv_Answer3.setText(text_answer3);

        }

        layAnswer1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer1IsSelect){
                    answer1IsSelect = true;
                    layAnswer1.setBackgroundResource(R.drawable.btn_quiz_true);
                }else {
                    answer1IsSelect = false;
                    layAnswer1.setBackgroundResource(R.drawable.btn_quiz_false);
                }
            }
        });
        layAnswer2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer2IsSelect){
                    answer2IsSelect = true;
                    layAnswer2.setBackgroundResource(R.drawable.btn_quiz_true);
                }else {
                    answer2IsSelect = false;
                    layAnswer2.setBackgroundResource(R.drawable.btn_quiz_false);
                }
            }
        });
        layAnswer3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer3IsSelect){
                    answer3IsSelect = true;
                    layAnswer3.setBackgroundResource(R.drawable.btn_quiz_true);
                }else {
                    answer3IsSelect = false;
                    layAnswer3.setBackgroundResource(R.drawable.btn_quiz_false);
                }
            }
        });

        submit_Answer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
