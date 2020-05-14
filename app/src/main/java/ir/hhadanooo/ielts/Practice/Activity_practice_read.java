package ir.hhadanooo.ielts.Practice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.hhadanooo.ielts.R;

public class Activity_practice_read extends AppCompatActivity {
    RelativeLayout rel_body,rel_main_page,rel_title_main_page;

    TextView tv_title_main_page,tv_count;

    RelativeLayout rel_text;
    TextView tv_text;

    ImageView img_see_answer;

    ImageView img_timer;
    TextView tv_timer;
    long time;

    List<String> list_word_in_text,list_num_word_in_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_read);
        getSupportActionBar().hide();
        init();
        CheckIntent();
        SetPropertiesRelBody();
        SetPropertiesMainPage();
        initActionBar();

        list_word_in_text = new ArrayList<>();
        list_num_word_in_text = new ArrayList<>();

        time = 3600000;
        Timer(tv_timer);

    }

    private void initActionBar() {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        ImageView iv_arrowBack_SimpleText = findViewById(R.id.Activity_practice_read_iv_arrowBack_SimpleText);
        ImageView iv_ic_logoPage_SimpleText = findViewById(R.id.Activity_practice_read_iv_ic_logoPage_SimpleText);
        TextView tv_TitleLogo_SimpleText = findViewById(R.id.Activity_practice_read_tv_TitleLogo_SimpleText);
        TextView tv_PathLogo_SimpleText = findViewById(R.id.Activity_practice_read_tv_PathLogo_SimpleText);

        iv_arrowBack_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_arrowBack_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        iv_ic_logoPage_SimpleText.getLayoutParams().width = (int) (dm.widthPixels*.1);
        iv_ic_logoPage_SimpleText.getLayoutParams().height = (int) (dm.widthPixels*.1);

        tv_TitleLogo_SimpleText.setTextSize((int) (dm.widthPixels*.025));

        tv_PathLogo_SimpleText.setTextSize((int) (dm.widthPixels*.012));

        tv_TitleLogo_SimpleText.setText("practice1");
        tv_PathLogo_SimpleText.setText("Reading");

        iv_arrowBack_SimpleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    public void CheckIntent()
    {
        if(getIntent().getExtras().getString("Easy") != null)
        {
            tv_title_main_page.setText("Find any World/Words that show 'Age'");
           tv_text.setText("ramin1 ramin10 ramin3 ramin1 ramin5 ramin6 ramin7 ramin1 ramin9 ramin10 ramin11 ramin12 ramin13 ramin14 ramin15 ramin16 ramin17 ramin18 ramin20");
        }else if(getIntent().getExtras().getString("Normal") != null) {

            tv_count.setVisibility(View.INVISIBLE);
            tv_title_main_page.setText("Find any World/Words that show 'Age'");
            tv_text.setText("hassan ramin hhadanooo matiooo hassan1 ramin1 hhadanooo1 matiooo1 hassan2 ramin2 hhadanooo2 matioo2o hassan3 ramin3 hhadanooo3 matiooo3 hassan4 ramin4 hhadanooo4 matiooo4");

        }else if(getIntent().getExtras().getString("Hard") != null)
        {
            tv_count.setVisibility(View.INVISIBLE);
            tv_title_main_page.setText("Find any World/Words that show 'Age'");
            tv_text.setText("hassan ramin hhadanooo matiooo hassan1 ramin1 hhadanooo1 matiooo1 hassan2 ramin2 hhadanooo2 matioo2o hassan3 ramin3 hhadanooo3 matiooo3 hassan4 ramin4 hhadanooo4 matiooo4");


        }
    }

    public void init()
    {
        rel_body = findViewById(R.id.activity_practice_read_rel_body);


        rel_main_page = findViewById(R.id.activity_practice_read_rel_main_page);
        rel_title_main_page = findViewById(R.id.activty_practice_read_rel_title);



        tv_title_main_page = findViewById(R.id.activity_practice_read_tv_title_main_page);
        tv_count = findViewById(R.id.activity_practice_read_tv_count);

        rel_text =findViewById(R.id.activty_practice_read_rel_text);
        tv_text = findViewById(R.id.activity_practice_read_tv_text);

        img_see_answer = findViewById(R.id.activity_practice_read_img_see_answer);

        img_timer = findViewById(R.id.activity_practice_read_img_timer);
        tv_timer = findViewById(R.id.activity_practice_read_tv_timer);


    }

    public void SetPropertiesRelBody()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


    }
    @SuppressLint("ClickableViewAccessibility")
    public void SetPropertiesMainPage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        rel_main_page.getLayoutParams().width = (int) (dm.widthPixels * .90);
        //rel_main_page.getLayoutParams().height = (int) (dm.heightPixels * 0.75);

        rel_title_main_page.getLayoutParams().width = (int) (dm.widthPixels * .80);
        rel_title_main_page.getLayoutParams().height = (int) (dm.widthPixels * 0.23);


        rel_text.getLayoutParams().width = (int) (dm.widthPixels * .80);
        rel_text.getLayoutParams().height = (int) (dm.widthPixels * 0.65);

        tv_title_main_page.setMaxWidth((int) (dm.widthPixels * 0.75));

        tv_title_main_page.setTextColor(Color.BLACK);
        tv_title_main_page.setTextSize((int) (dm.widthPixels * 0.012));

        tv_title_main_page.setTextColor(Color.WHITE);



        tv_text.setMaxWidth((int) (dm.widthPixels * 0.80));
        tv_text.setTextSize((int) (dm.widthPixels * 0.016));

        tv_text.setTextColor(Color.BLACK);


        img_see_answer.getLayoutParams().width = (int) (dm.widthPixels * 0.29);
        img_see_answer.getLayoutParams().height = (int) (dm.widthPixels * 0.085);

        img_see_answer.setBackground(getDrawable(R.drawable.seeanswer_icon1));

        tv_count.setTextSize((int) (dm.widthPixels * 0.022));

        img_timer.getLayoutParams().width = (int) (dm.widthPixels * 0.08);
        img_timer.getLayoutParams().height = (int) (dm.widthPixels * 0.08);


        img_see_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = "";
                for (String s:list_word_in_text)
                {
                    ss += s + "\n";
                }
                Toast.makeText(Activity_practice_read.this,ss,Toast.LENGTH_LONG).show();
            }
        });

        tv_text.setText(tv_text.getText().toString(), TextView.BufferType.SPANNABLE);
        if(getIntent().getExtras().getString("Easy") == null) tv_count.setVisibility(View.INVISIBLE);
        tv_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    int mOffset = tv_text.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());




                    boolean check = false;
                    for(int i = 0;i<list_num_word_in_text.size();i++)
                    {

                        String s = list_num_word_in_text.get(i);


                        String[] array = s.split("@");
                        int start =Integer.valueOf(array[0]);
                        int end =Integer.valueOf(array[1]);

                        if(mOffset > start && mOffset < end)
                        {


                            list_num_word_in_text.remove(i);
                            list_word_in_text.remove(i);
                            SetColorEndHighlight(tv_text,start,end);
                            if(getIntent().getExtras().getString("Easy") != null)
                            {
                                tv_count.setText(String.format("%d/4",list_word_in_text.size()));
                            }
                            check = true;
                            break;
                        }
                    }
                    if(!check)
                    {
                        String text = findWordForRightHanded(tv_text.getText().toString(), mOffset);

                        text = text.replace(" " , "");


                        int start = 0;
                        int end = 0;
                        int from = 0;
                        while (true)
                        {
                            start = tv_text.getText().toString().indexOf(text,from);
                            end = start+text.length();
                            if(mOffset > start && mOffset<end)
                            {
                                break;
                            }
                            if(start == -1) break;
                            from = start+1;
                        }

                        if(start != -1){

                            if(list_word_in_text.size() <4)
                            {

                            }

                            if(getIntent().getExtras().getString("Easy") != null)
                            {
                                if(list_word_in_text.size() <4)
                                {
                                    list_num_word_in_text.add(""+start+"@"+end);
                                    list_word_in_text.add(text);
                                    SetColorStartHighlight(tv_text,tv_text.getText().toString(),list_word_in_text,Color.WHITE,mOffset);

                                    tv_count.setText(String.format("%d/4",list_word_in_text.size()));
                                }
                            }else {
                                list_num_word_in_text.add(""+start+"@"+end);
                                list_word_in_text.add(text);
                                SetColorStartHighlight(tv_text,tv_text.getText().toString(),list_word_in_text,Color.WHITE,mOffset);

                            }
                        }

                    }

                }
                return false;
            }
        });

    }



    private String findWordForRightHanded(String str, int offset) { // when you touch ' ', this method returns left word.
        if (str.length() == offset) {
            offset--; // without this code, you will get exception when touching end of the text
        }

        if (str.charAt(offset) == ' ') {
            offset--;
        }
        int startIndex = offset;
        int endIndex = offset;

        try {
            while (str.charAt(startIndex) != ' ' && str.charAt(startIndex) != '\n') {
                startIndex--;
            }
        } catch (StringIndexOutOfBoundsException e) {
            startIndex = 0;
        }

        try {
            while (str.charAt(endIndex) != ' ' && str.charAt(endIndex) != '\n') {
                endIndex++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            endIndex = str.length();
        }

        // without this code, you will get 'here!' instead of 'here'
        // if you use only english, just check whether this is alphabet,
        // but 'I' use korean, so i use below algorithm to get clean word.
        char last = str.charAt(endIndex - 1);
        if (last == ',' || last == '.' ||
                last == '!' || last == '?' ||
                last == ':' || last == ';') {
            endIndex--;
        }

        return str.substring(startIndex, endIndex);
    }

    private void SetColorStartHighlight(TextView view, String fulltext, List<String> list, int color,int offset) {
        Spannable str = (Spannable) view.getText();
        for (int zz = 0;zz<list.size();zz++)
        {
            int index = fulltext.indexOf(list.get(zz));
            if(offset > index && offset<list.get(zz).length()+index)
            {
                str.setSpan(new ForegroundColorSpan(color), index, index + list.get(zz).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                str.setSpan(new BackgroundColorSpan(Color.BLUE), index, index + list.get(zz).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            }else {
                while (index >= 0) {
                    index = fulltext.indexOf(list.get(zz), index + 1);
                    if(index > -1)
                    {
                        if(offset > index && offset<list.get(zz).length()+index)
                        {
                            str.setSpan(new ForegroundColorSpan(color), index, index + list.get(zz).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            str.setSpan(new BackgroundColorSpan(Color.BLUE), index, index + list.get(zz).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }
            }
        }
    }

    private void SetColorEndHighlight(TextView view,int start,int end)
    {
        Spannable str = (Spannable) view.getText();
        str.setSpan(new ForegroundColorSpan(Color.BLACK), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new BackgroundColorSpan(Color.parseColor("#DAE3E4")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
