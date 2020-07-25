package ir.yottahouse.EnjoyIELTS.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.CustomView.CustomViewItem;
import ir.yottahouse.EnjoyIELTS.R;
import ir.yottahouse.EnjoyIELTS.Test.ActivityTestRead;
import ir.yottahouse.EnjoyIELTS.Test.ActivityTestWrite;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;



public class SlideFragmentTestReading extends Fragment {

    View rootview;
    int Width;
    int Height;
    String intent;

    RelativeLayout rel_text_and_question;
    Chronometer tv_timer;

    ImageView img_timer,img_see_answer;
    EditText et_note;
    int num;

    long time;
    int num_tab;

    WebView webView;
    @SuppressLint("StaticFieldLeak")
    public static TourGuide mtg;
    SharedPreferences showHelppp1;
    boolean showHelp = false;
    public static boolean isShow = false;


    String TextAnswer1,TextAnswer2,TextAnswer3,Filename1,Filename2,Filename3;

    Handler handler_timer;
    runnable_timer runnable_timer;
    boolean check_chronometer = false;
    boolean check = false;


    public static SlideFragmentTestReading newSlide(int Width,int Height,String intent,int num,int num_tab,String TextAnswer1,String TextAnswer2,String TextAnswer3,String filename1,String filename2,String filename3){
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

        args.putString("filename1",filename1);
        args.putString("filename2",filename2);
        args.putString("filename3",filename3);


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

        showHelppp1 = Objects.requireNonNull(getContext()).getSharedPreferences("show" , getContext().MODE_PRIVATE);
        showHelp = showHelppp1.getBoolean("helper" , false);
        TextAnswer1 = args.getString("TextAnswer1");
        TextAnswer2 = args.getString("TextAnswer2");
        TextAnswer3 = args.getString("TextAnswer3");

        Filename1 = args.getString("filename1");
        Filename2 = args.getString("filename2");
        Filename3 = args.getString("filename3");





    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_fragment_tabs_test_reading, container, false);

        init();
        SetPropertiesRelBody();





        handler_timer = new Handler();
        runnable_timer = new runnable_timer();

        CheckIntnet();




        

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

                    if(!ActivityTestRead.CheckStartHandler1)
                    {
                        ActivityTestRead.CheckStartHandler1 = true;
                        //handler_timer.postDelayed(runnable_timer,1);
                    }
                    //tab 1 academic
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/" + Filename1+ "/passage1.html");
                    webView.loadUrl("file:///" + file_html);

                    if (!showHelp){
                        isShow =true;
                        mtg = TourGuide.init(Objects.requireNonNull(getActivity())).with(TourGuide.Technique.HORIZONTAL_LEFT);
                        mtg.setPointer(new Pointer())
                                .setToolTip( new ToolTip()
                                        .setDescription("Question box (Scroll to see more content)")
                                        .setTextColor(Color.parseColor("#212122"))
                                        .setBackgroundColor(Color.parseColor("#bcd9f9"))
                                        .setShadow(true).setGravity(Gravity.TOP ))
                                .setOverlay(new Overlay()) ;
                        mtg.playOn(rel_text_and_question) ;
                        showHelppp1.edit().putBoolean("helper" , true).apply();
                        showHelp = true;
                    }



                }else if(num_tab == 2)
                {
                    if(!ActivityTestRead.CheckStartHandler2)
                    {
                        ActivityTestRead.CheckStartHandler2 = true;
                        handler_timer.postDelayed(runnable_timer,1);
                    }
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/" + Filename2 + "/passage2.html");
                    webView.loadUrl("file:///" + file_html);
                    //tab 2 academic

                }else if(num_tab == 3) {
                    if(!ActivityTestRead.CheckStartHandler3)
                    {
                        ActivityTestRead.CheckStartHandler3 = true;
                        handler_timer.postDelayed(runnable_timer,1);
                    }
                    //tab 3 academic
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/"+Filename3 + "/passage3.html");
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
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/general/" + Filename1 + "/passage1.html");
                    webView.loadUrl("file:///" + file_html);

                }else if(num_tab == 2)
                {
                    //tab 2 general
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/general/" + Filename2 + "/passage2.html");
                    webView.loadUrl("file:///" + file_html);


                }else if(num_tab == 3)
                {
                    //tab 3 general
                    File file_html = new File(getContext().getFilesDir().getAbsolutePath() + "/ielts/reading/test/academic/" + Filename3 + "/passage3.html");
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
        et_note = rootview.findViewById(R.id.layout_fragment_edit_text_note);

        et_note.getLayoutParams().width = (int) (Width*.80);
        et_note.getLayoutParams().height = (int)(Height*0.15);

        rel_text_and_question.getLayoutParams().width = (int) (Width*.90);
        webView.getLayoutParams().width = (int) (Width*.90);
        rel_text_and_question.getLayoutParams().height = (int)(Height*0.46);
        webView.getLayoutParams().height = (int)(Height*0.45);




        img_timer.getLayoutParams().width = (int) (Width*0.1);
        img_timer.getLayoutParams().height = (int) (Width*0.1);

        img_see_answer.getLayoutParams().width = (int) (Width*0.295);
        img_see_answer.getLayoutParams().height = (int) (Height*0.045);

        time = 3600000;

        tv_timer.start();


        tv_timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(chronometer.getText().toString().equals("60:00") || check_chronometer)
                {
                    if(!check_chronometer) check_chronometer = true;
                    if(check)
                    {
                        Glide.with(getContext()).load(getContext().getDrawable(R.drawable.timer_icon)).into(img_timer);
                        check = false;
                    }else {
                        Glide.with(getContext()).load(getContext().getDrawable(R.drawable.timer_iconw)).into(img_timer);
                        check = true;
                    }
                }
            }
        });

        Glide.with(this).load(R.drawable.timer_icon).into(img_timer);




    }
    public void SetPropertiesRelBody() {

        img_timer.getLayoutParams().width = (int) (Width*0.1);
        img_timer.getLayoutParams().height = (int) (Width*0.1);

        //img_see_answer.setBackground(getContext().getDrawable(R.drawable.seeanswer_icon1));
        Glide.with(this).load(getContext().getDrawable(R.drawable.seeanswer_icon1)).into(img_see_answer);

        img_see_answer.getLayoutParams().width = (int) (Width*0.295);
        img_see_answer.getLayoutParams().height = (int) (Width*0.085);

        CustomViewItem.progressDialog.dismiss();

        img_see_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num_tab == 1)
                {

                    /*
                    Dialog dia = new Dialog(getContext());
                    dia.setContentView(R.layout.layout_dialog_audioscripts);
                    TextView tv_audioScripts = dia.findViewById(R.id.tv_audioScripts);

                    tv_audioScripts.getLayoutParams().width = (int) (Width*.8);
                    //tv_audioScripts.getLayoutParams().height = (int) (Height);
                    tv_audioScripts.setTextSize((int) (Width*.015));
                    tv_audioScripts.setText(TextAnswer1);
                    dia.show();

                     */
                    if(!ActivityTestRead.CheckAnswerTab1)
                    {
                        ActivityTestRead.CheckAnswerTab1 = true;
                        et_note.append(TextAnswer1);
                    }


                }else if(num_tab == 2)
                {
                    /*
                    Dialog dia = new Dialog(getContext());
                    dia.setContentView(R.layout.layout_dialog_audioscripts);
                    TextView tv_audioScripts = dia.findViewById(R.id.tv_audioScripts);

                    tv_audioScripts.getLayoutParams().width = (int) (Width*.8);
                    //tv_audioScripts.getLayoutParams().height = (int) (Height);
                    tv_audioScripts.setTextSize((int) (Width*.015));
                    tv_audioScripts.setText(TextAnswer2);
                    dia.show();

                     */
                    if(!ActivityTestRead.CheckAnswerTab2)
                    {
                        ActivityTestRead.CheckAnswerTab2 = true;
                        et_note.append(TextAnswer2);
                    }
                }else if(num_tab == 3)
                {
                    /*
                    Dialog dia = new Dialog(getContext());
                    dia.setContentView(R.layout.layout_dialog_audioscripts);
                    TextView tv_audioScripts = dia.findViewById(R.id.tv_audioScripts);

                    tv_audioScripts.getLayoutParams().width = (int) (Width*.8);
                    //tv_audioScripts.getLayoutParams().height = (int) (Height);
                    tv_audioScripts.setTextSize((int) (Width*.015));
                    tv_audioScripts.setText(TextAnswer3);
                    dia.show();

                     */
                    if(!ActivityTestRead.CheckAnswerTab3)
                    {
                        ActivityTestRead.CheckAnswerTab3 = true;
                        et_note.append(TextAnswer3);
                    }
                }
            }
        });



    }

    public class runnable_timer implements Runnable
    {

        @Override
        public void run() {
            if(ActivityTestRead.CheckStartTimer)
            {
                if(ActivityTestRead.CheckEndActivity)
                {
                    tv_timer.setText(ActivityTestRead.str_time);
                    if(ActivityTestRead.CheckImgTimer&&ActivityTestRead.CheckEndTimer)
                    {
                        Glide.with(getContext()).load(getContext().getDrawable(R.drawable.timer_icon)).into(img_timer);
                    }else if(ActivityTestRead.CheckEndTimer) {
                        Glide.with(getContext()).load(getContext().getDrawable(R.drawable.timer_iconw)).into(img_timer);
                    }
                }
            }


            if(ActivityTestRead.CheckEndActivity)
            {
                handler_timer.postDelayed(this,1000);
            }

        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);

    }
}
