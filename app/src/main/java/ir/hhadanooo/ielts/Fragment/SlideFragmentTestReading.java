package ir.hhadanooo.ielts.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import ir.hhadanooo.ielts.R;


public class SlideFragmentTestReading extends Fragment {

    View rootview;
    int Width;
    int Height;
    String intent;

    RelativeLayout rel_text_and_question;
    TextView tv_text,tv_question_count,tv_question,tv_timer;

    ImageView img_timer,img_see_answer;
    int num;

    long time;
    int num_tab;


    String TextQuestion1,TextQuestion2,TextQuestion3,Question1,Question2,Question3,TextAnswer1,TextAnswer2,TextAnswer3;


    public static SlideFragmentTestReading newSlide(int Width,int Height,String intent,int num,int num_tab,String TextQuestion1,String TextQuestion2,String TextQuestion3,String Question1,String Question2,String Question3,String TextAnswer1,String TextAnswer2,String TextAnswer3){
        SlideFragmentTestReading fragment = new SlideFragmentTestReading();
        Bundle args = new Bundle();
        args.putInt("Width",Width);
        args.putInt("Height",Height);
        args.putString("Intent",intent);
        args.putInt("num",num);
        args.putInt("num_tab",num_tab);
        args.putString("TextQuestion1",TextQuestion1);
        args.putString("TextQuestion2",TextQuestion2);
        args.putString("TextQuestion3",TextQuestion3);

        args.putString("Question1",Question1);
        args.putString("Question2",Question2);
        args.putString("Question3",Question3);

        args.putString("TextAnswer1",TextAnswer1);
        args.putString("TextAnswer2",TextAnswer2);
        args.putString("TextAnswer3",TextAnswer3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args == null) return;
        Width = args.getInt("Width");
        Height = args.getInt("Height");
        intent = args.getString("Intent");
        num  = args.getInt("num");
        num_tab = args.getInt("num_tab");

        TextQuestion1 = args.getString("TextQuestion1");
        TextQuestion2 = args.getString("TextQuestion2");
        TextQuestion3 = args.getString("TextQuestion3");

        Question1 = args.getString("Question1");
        Question2 = args.getString("Question2");
        Question3 = args.getString("Question3");

        TextAnswer1 = args.getString("TextAnswer1");
        TextAnswer2 = args.getString("TextAnswer2");
        TextAnswer3 = args.getString("TextAnswer3");



    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_fragment_tabs_test_reading, container, false);

        init();
        SetPropertiesRelBody();


        CheckIntnet();

        time = 3600000;
        Timer(tv_timer);
        

        return rootview;
    }

    public void CheckIntnet()
    {
        if(intent.contains("Academic"))
        {
            if(num != 0)
            {
                if(num_tab == 1)
                {

                    tv_text.setText(TextQuestion1);
                    tv_question.setText(Question1);




                }else if(num_tab == 2)
                {

                    tv_text.setText(TextQuestion2);
                    tv_question.setText(Question2);


                }else if(num_tab == 3) {
                    tv_text.setText(TextQuestion3);
                    tv_question.setText(Question3);

                }

            }
        }else if(intent.contains("General"))
        {
            if(num != 0)
            {
                if(num_tab == 1)
                {

                    tv_text.setText(TextQuestion1);
                    tv_question.setText(Question1);

                }else if(num_tab == 2)
                {
                    tv_text.setText(TextQuestion2);
                    tv_question.setText(Question2);


                }else if(num_tab == 3)
                {
                    tv_text.setText(TextQuestion3);
                    tv_question.setText(Question3);

                }
            }
        }
    }





    public void init()
    {
        rel_text_and_question = rootview.findViewById(R.id.layout_fragment_rel_text_question);
        tv_text = rootview.findViewById(R.id.layout_fragment_tv_text);
        tv_question_count = rootview.findViewById(R.id.layout_fragment_tv_question_count);
        tv_question = rootview.findViewById(R.id.layout_fragment_tv_question);
        img_see_answer = rootview.findViewById(R.id.layout_ftagment_img_see_answer);
        img_timer = rootview.findViewById(R.id.layout_fragment_img_timer);

        tv_timer = rootview.findViewById(R.id.layout_fragment_tv_timer);


        rel_text_and_question.getLayoutParams().width = (int) (Width*.90);
        rel_text_and_question.getLayoutParams().height = (int)(Height*0.61);




        tv_text.setMaxWidth((int) (Width * 0.80));

        tv_text.setTextSize((int) (Width * 0.014));
        tv_question.setTextSize((int) (Width * 0.014));
        tv_text.setTextSize((int) (Width * 0.014));

        img_timer.getLayoutParams().width = (int) (Width*0.1);
        img_timer.getLayoutParams().height = (int) (Width*0.1);

        img_see_answer.getLayoutParams().width = (int) (Width*0.295);
        img_see_answer.getLayoutParams().height = (int) (Height*0.045);



    }
    public void SetPropertiesRelBody() {
        rel_text_and_question.getLayoutParams().width = (int) (Width*.90);
        rel_text_and_question.getLayoutParams().height = (int)(Height*0.61);



        tv_text.setMaxWidth((int) (Width * 0.80));

        tv_text.setTextSize((int) (Width * 0.014));
        tv_question.setTextSize((int) (Width * 0.014));
        tv_text.setTextSize((int) (Width * 0.014));

        img_timer.getLayoutParams().width = (int) (Width*0.1);
        img_timer.getLayoutParams().height = (int) (Width*0.1);

        img_see_answer.setBackground(getContext().getDrawable(R.drawable.seeanswer_icon1));

        img_see_answer.getLayoutParams().width = (int) (Width*0.295);
        img_see_answer.getLayoutParams().height = (int) (Width*0.085);


        img_see_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_tab == 1)
                {
                    Toast.makeText(getContext(),""+TextAnswer1,Toast.LENGTH_LONG).show();
                }else if(num_tab == 2)
                {
                    Toast.makeText(getContext(),""+TextAnswer2,Toast.LENGTH_LONG).show();
                }else if(num_tab == 3)
                {
                    Toast.makeText(getContext(),""+TextAnswer3,Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void Timer(final TextView tv_timer)
    {

        new CountDownTimer(time,1000) {
            @Override
            public void onTick(long l) {
                time = l;
                int minute =(int) time / 60000;
                int second = (int) time % 60000 / 1000;
                String timestring = "" + minute;
                timestring += ":";
                if(second < 10) timestring += "0";
                timestring += second;
                tv_timer.setText(timestring);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }


}
