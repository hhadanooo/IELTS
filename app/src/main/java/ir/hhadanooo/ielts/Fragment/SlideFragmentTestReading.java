package ir.hhadanooo.ielts.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
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


    public static SlideFragmentTestReading newSlide(int Width,int Height,String intent,int num,int num_tab){
        SlideFragmentTestReading fragment = new SlideFragmentTestReading();
        Bundle args = new Bundle();
        args.putInt("Width",Width);
        args.putInt("Height",Height);
        args.putString("Intent",intent);
        args.putInt("num",num);
        args.putInt("num_tab",num_tab);
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_fragment_tabs_test_reading, container, false);

        init();
        SetPropertiesRelBody();


        CheckIntnet();

        time = 2400000;
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
                    tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            " rhoncus eltricies lacus     TAB 1");
                    tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
                }else if(num_tab == 2)
                {
                    tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            " rhoncus eltricies lacus     TAB 2");
                    tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
                }else if(num_tab == 3)
                {
                    tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            " rhoncus eltricies lacus    TAB 3");
                    tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
                }

            }
        }else if(intent.contains("General"))
        {
            if(num != 0)
            {
                if(num_tab == 1)
                {
                    tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            " rhoncus eltricies lacus     TAB 1");
                    tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
                }else if(num_tab == 2)
                {
                    tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            " rhoncus eltricies lacus     TAB 2");
                    tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
                }else if(num_tab == 3)
                {
                    tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            "rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                    tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                            " rhoncus eltricies lacus    TAB 3");
                    tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
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

                }else if(num_tab == 2)
                {

                }else if(num_tab == 3)
                {

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
