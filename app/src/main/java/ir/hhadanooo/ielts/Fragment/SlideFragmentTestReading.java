package ir.hhadanooo.ielts.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ir.hhadanooo.ielts.R;


public class SlideFragmentTestReading extends Fragment {

    View rootview;
    int Width;
    int Height;
    String intent;

    RelativeLayout rel_text_and_question;
    TextView tv_text,tv_question_count,tv_question;

    ImageView img_timer,img_see_answer;
    int num;


    public static SlideFragmentTestReading newSlide(int Width,int Height,String intent,int num){
        SlideFragmentTestReading fragment = new SlideFragmentTestReading();
        Bundle args = new Bundle();
        args.putInt("Width",Width);
        args.putInt("Height",Height);
        args.putString("Intent",intent);
        args.putInt("num",num);
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_fragment_tabs_test_reading, container, false);

        init();
        SetPropertiesRelBody();

        CheckIntnet();


        return rootview;
    }

    public void CheckIntnet()
    {

        if(intent.contains("Academic"))
        {
            if(num != 0)
            {
                tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                        " rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                        " rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                        " rhoncus eltricies lacus");
                tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting academic " + num);
            }
        }else if(intent.contains("General"))
        {
            if(num != 0)
            {
                tv_text.setText("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                        " rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                tv_text.append("Morbi blandit cursus risus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                        " rhoncus est pellentesque ellit ullamcorper. velit euismod in pellentesque massa placerat duis ultricies lacus");
                tv_text.append("Morbi blandit sus at ultrices mi tempus imperdiet. id velit ut tortor pretium viverra suspendisse. Vestibulum " +
                        " rhoncus eltricies lacus");
                tv_question.setText("1- Cons of the commuting \n \n2- Cons of the commuting general "+ num);
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
        img_see_answer.getLayoutParams().height = (int) (Height*0.045);

    }


}
