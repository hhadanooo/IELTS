package ir.hhadanooo.ielts.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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
    TextView tv_timer;

    ImageView img_timer,img_see_answer;
    int num;

    long time;
    int num_tab;

    WebView webView;


    String TextAnswer1,TextAnswer2,TextAnswer3;


    public static SlideFragmentTestReading newSlide(int Width,int Height,String intent,int num,int num_tab,String TextAnswer1,String TextAnswer2,String TextAnswer3){
        SlideFragmentTestReading fragment = new SlideFragmentTestReading();
        Bundle args = new Bundle();
        args.putInt("Width",Width);
        args.putInt("Height",Height);
        args.putString("Intent",intent);
        args.putInt("num",num);
        args.putInt("num_tab",num_tab);


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

                    //tab 1 academic
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/test"+num + "/passage1.html");
                    webView.loadUrl("file:///" + file_html);

                }else if(num_tab == 2)
                {
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/test"+num + "/passage2.html");
                    webView.loadUrl("file:///" + file_html);
                    //tab 2 academic

                }else if(num_tab == 3) {
                    //tab 3 academic
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/test"+num + "/passage3.html");
                    webView.loadUrl("file:///" + file_html);
                }

            }
        }else if(intent.contains("General"))
        {
            if(num != 0)
            {
                if(num_tab == 1)
                {

                    //tab 1 general
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/general/test"+num + "/passage1.html");
                    webView.loadUrl("file:///" + file_html);

                }else if(num_tab == 2)
                {
                    //tab 2 general
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/general/test"+num + "/passage2.html");
                    webView.loadUrl("file:///" + file_html);


                }else if(num_tab == 3)
                {
                    //tab 3 general
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/test"+num + "/passage3.html");
                    webView.loadUrl("file:///" + file_html);
                }
            }
        }
    }





    public void init()
    {
        webView = rootview.findViewById(R.id.layout_fragment_webview);
        webView.getSettings().setJavaScriptEnabled(true);


        rel_text_and_question = rootview.findViewById(R.id.layout_fragment_rel_text_question);

        img_see_answer = rootview.findViewById(R.id.layout_ftagment_img_see_answer);
        img_timer = rootview.findViewById(R.id.layout_fragment_img_timer);

        tv_timer = rootview.findViewById(R.id.layout_fragment_tv_timer);


        rel_text_and_question.getLayoutParams().width = (int) (Width*.90);
        rel_text_and_question.getLayoutParams().height = (int)(Height*0.61);




        img_timer.getLayoutParams().width = (int) (Width*0.1);
        img_timer.getLayoutParams().height = (int) (Width*0.1);

        img_see_answer.getLayoutParams().width = (int) (Width*0.295);
        img_see_answer.getLayoutParams().height = (int) (Height*0.045);



    }
    public void SetPropertiesRelBody() {
        rel_text_and_question.getLayoutParams().width = (int) (Width*.90);
        rel_text_and_question.getLayoutParams().height = (int)(Height*0.61);


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
