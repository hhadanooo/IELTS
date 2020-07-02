package ir.hhadanooo.ielts.Practice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import ir.hhadanooo.ielts.Challenge.ChallengeActivity;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.R;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class Activity_practice_read extends AppCompatActivity {
    RelativeLayout rel_body,rel_main_page,rel_title_main_page ,layMgt;

    TextView tv_title_main_page,tv_count;

    RelativeLayout rel_text;
    TextView tv_text;

    ImageView img_see_answer;

    ImageView img_timer;
    TextView tv_timer;
    long time;

    List<String> list_word_in_text,list_num_word_in_text;

    boolean CheckClickAnswer = false;
    List<String> list_answer = new ArrayList<>();

    TourGuide mtg;
    TourGuide mtg1;
    SharedPreferences showHelppp2;
    boolean showHelp = false;
    boolean showHelp1 = false;
    boolean isShow = false;
    boolean isShow1 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_read);
        getSupportActionBar().hide();

        showHelppp2 = getSharedPreferences("show" ,MODE_PRIVATE);
        showHelp = showHelppp2.getBoolean("rel_text" , false);
        showHelp1 = showHelppp2.getBoolean("img_see_answer" , false);


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

            String TextTitle = "";
            String TextAllWord = "";
            String TextAnswer = "";
            File f = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/easy");
            File[]files = f.listFiles();
            Random random = new Random();
            int num_rand = random.nextInt(files.length);

            File file_title_main_page = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/easy/easy"+(num_rand+1)+"/TextTitleMainPage.txt");

            try {

                InputStream inputStream = new FileInputStream(file_title_main_page);
                String text = "";
                byte[] bytes = new byte[8192];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextTitle = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            File file_all_word = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/easy/easy"+(num_rand+1)+"/TextAllWord.txt");

            try {

                InputStream inputStream = new FileInputStream(file_all_word);
                String text = "";
                byte[] bytes = new byte[8192];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextAllWord = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            File file_text_answer = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/easy/easy"+(num_rand+1)+"/TextAnswer.txt");

            try {

                InputStream inputStream = new FileInputStream(file_text_answer);
                String text = "";
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextAnswer = text;
            } catch (IOException e) {

                e.printStackTrace();
            }



            String[] split = TextAnswer.split("@");


            for(int i = 0;i<split.length;i++)
            {
                list_answer.add(split[i]);

            }







            tv_title_main_page.setText(TextTitle);
           tv_text.setText(TextAllWord);
        }else if(getIntent().getExtras().getString("Normal") != null) {

            tv_count.setVisibility(View.INVISIBLE);


            String TextTitle = "";
            String TextAllWord = "";
            String TextAnswer = "";
            File f = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/normal");
            File[]files = f.listFiles();
            Random random = new Random();
            int num_rand = random.nextInt(files.length);
            Toast.makeText(this,files.length+"",Toast.LENGTH_LONG).show();
            File file_title_main_page = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/normal/normal"+(num_rand+1)+"/TextTitleMainPage.txt");

            try {

                InputStream inputStream = new FileInputStream(file_title_main_page);
                String text = "";
                byte[] bytes = new byte[8192];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextTitle = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            File file_all_word = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/normal/normal"+(num_rand+1)+"/TextAllWord.txt");

            try {

                InputStream inputStream = new FileInputStream(file_all_word);
                String text = "";
                byte[] bytes = new byte[8192];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextAllWord = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            File file_text_answer = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/normal/normal"+(num_rand+1)+"/TextAnswer.txt");

            try {

                InputStream inputStream = new FileInputStream(file_text_answer);
                String text = "";
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextAnswer = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            String[] split = TextAnswer.split("@");
            for(int i = 0;i<split.length;i++)
            {
                list_answer.add(split[i]);
            }

            tv_title_main_page.setText(TextTitle);
            tv_text.setText(TextAllWord);

        }else if(getIntent().getExtras().getString("Hard") != null)
        {
            tv_count.setVisibility(View.INVISIBLE);

            String TextTitle = "";
            String TextAllWord = "";
            String TextAnswer = "";
            File f = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/hard");
            File[]files = f.listFiles();
            Random random = new Random();
            int num_rand = random.nextInt(files.length);
            Toast.makeText(this,files.length+"",Toast.LENGTH_LONG).show();
            File file_title_main_page = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/hard/hard"+(num_rand+1)+"/TextTitleMainPage.txt");


            try {

                InputStream inputStream = new FileInputStream(file_title_main_page);
                String text = "";
                byte[] bytes = new byte[8192];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextTitle = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            File file_all_word = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/hard/hard"+(num_rand+1)+"/TextAllWord.txt");

            try {

                InputStream inputStream = new FileInputStream(file_all_word);
                String text = "";
                byte[] bytes = new byte[8192];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextAllWord = text;
            } catch (IOException e) {

                e.printStackTrace();
            }


            File file_text_answer = new File(getFilesDir().getAbsolutePath() + "/ielts/reading/practice/hard/hard"+(num_rand+1)+"/TextAnswer.txt");

            try {

                InputStream inputStream = new FileInputStream(file_text_answer);
                String text = "";
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                for(byte b:bytes)
                {
                    text+= (char) b;
                }
                TextAnswer = text;
            } catch (IOException e) {

                e.printStackTrace();
            }

            String[] split = TextAnswer.split("@");
            for(int i = 0;i<split.length;i++)
            {
                list_answer.add(split[i]);

            }



            tv_title_main_page.setText(TextTitle);
            tv_text.setText(TextAllWord);

        }
    }

    public void init()
    {
        rel_body = findViewById(R.id.activity_practice_read_rel_body);
        layMgt = findViewById(R.id.layMgt);


        rel_main_page = findViewById(R.id.activity_practice_read_rel_main_page);
        rel_title_main_page = findViewById(R.id.activty_practice_read_rel_title);



        tv_title_main_page = findViewById(R.id.activity_practice_read_tv_title_main_page);
        tv_count = findViewById(R.id.activity_practice_read_tv_count);

        rel_text =findViewById(R.id.activty_practice_read_rel_text);
        tv_text = findViewById(R.id.activity_practice_read_tv_text);

        img_see_answer = findViewById(R.id.activity_practice_read_img_see_answer);

        img_timer = findViewById(R.id.activity_practice_read_img_timer);
        tv_timer = findViewById(R.id.activity_practice_read_tv_timer);

        if (!showHelp){
            layMgt.setVisibility(View.VISIBLE);
            isShow = true;
            mtg = TourGuide.init(this).with(TourGuide.Technique.CLICK);
            mtg.setPointer(new Pointer())
                    .setToolTip( new ToolTip()
                            .setDescription("Try to find the answers in the text")
                            .setBackgroundColor(Color.parseColor("#bcd9f9"))
                            .setShadow(true).setGravity(Gravity.TOP ))
                    .setOverlay(new Overlay()) ;
            mtg.playOn(rel_text) ;
            showHelppp2.edit().putBoolean("rel_text" , true).apply();
            showHelp = true;
        }
        layMgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(ChallengeActivity.this, "asdas", Toast.LENGTH_SHORT).show();
                if (isShow){
                    mtg.cleanUp();
                    isShow = false;
                    if (!showHelp1){
                        isShow1 = true;
                        mtg1 = TourGuide.init(Activity_practice_read.this).with(TourGuide.Technique.CLICK);
                        mtg1.setPointer(new Pointer())
                                .setToolTip( new ToolTip()
                                        .setDescription("Number of answers")
                                        .setBackgroundColor(Color.parseColor("#bcd9f9"))
                                        .setShadow(true).setGravity(Gravity.TOP ))
                                .setOverlay(new Overlay()) ;
                        mtg1.playOn(tv_count) ;
                        showHelppp2.edit().putBoolean("img_see_answer" , true).apply();
                        showHelp1 = true;
                    }
                }else if (isShow1){

                    mtg1.cleanUp();
                    isShow1 = false;
                    layMgt.setVisibility(View.GONE);
                }

            }
        });



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

        tv_text.setText(tv_text.getText().toString(), TextView.BufferType.SPANNABLE);
        img_see_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String text = tv_text.getText().toString();
                int from = 0;
                Spannable str = (Spannable) tv_text.getText();



                boolean check_answer = false;
                for (int i = 0;i<list_word_in_text.size();i++)
                {
                    check_answer = false;
                    for(int j = 0;j<list_answer.size();j++)
                    {
                        if(list_word_in_text.get(i).equals(list_answer.get(j)))
                        {
                            check_answer = true;
                            break;
                        }
                    }
                    if(!check_answer)
                    {
                        String[] split = list_num_word_in_text.get(i).split("@");
                        int start = Integer.valueOf(split[0]);
                        int end = Integer.valueOf(split[1]);
                        str.setSpan(new ForegroundColorSpan(Color.WHITE), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        str.setSpan(new BackgroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }

                CheckClickAnswer = true;
                for(int i = 0;i<list_answer.size();i++)
                {
                    from =0;
                    while (true)
                    {

                        int index = text.indexOf(list_answer.get(i),from);
                        if(index == -1) break;
                        int num = (index + list_answer.get(i).length()) + 1;
                        String ch = String.valueOf(text.charAt(num));

                        /*
                        if(ch.contains(" "))
                        {
                            Log.i("raminmaleki54523w", "ramin"+ch);

                        }else {
                            str.setSpan(new ForegroundColorSpan(Color.WHITE), index, index + list_answer.get(i).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            str.setSpan(new BackgroundColorSpan(Color.GREEN), index, index + list_answer.get(i).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                        }

                         */


                        str.setSpan(new ForegroundColorSpan(Color.WHITE), index, index + list_answer.get(i).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        str.setSpan(new BackgroundColorSpan(Color.GREEN), index, index + list_answer.get(i).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                        from = index+1;
                    }


                }


            }
        });


        CustomViewItem.progressDialog.dismiss();

        if(getIntent().getExtras().getString("Easy") == null) tv_count.setVisibility(View.INVISIBLE);
        tv_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int count_word_easy = list_answer.size();
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN && !CheckClickAnswer) {

                    int mOffset = tv_text.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());




                    boolean check = false;
                    for(int i = 0;i<list_num_word_in_text.size();i++)
                    {

                        String s = list_num_word_in_text.get(i);


                        Log.i("raminmaleki54523w", ""+s);
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
                                tv_count.setText(String.format("%d/%d",list_word_in_text.size(),count_word_easy));
                            }
                            check = true;
                            break;
                        }
                    }
                    if(!check)
                    {
                        String text = findWordForRightHanded(tv_text.getText().toString(), mOffset);
                        Log.i("raminmaleki54523w", ""+text);
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



                            if(getIntent().getExtras().getString("Easy") != null)
                            {
                                if(list_word_in_text.size() <count_word_easy)
                                {
                                    list_num_word_in_text.add(""+start+"@"+end);
                                    list_word_in_text.add(text);
                                    SetColorStartHighlight(tv_text,tv_text.getText().toString(),list_word_in_text,Color.WHITE,mOffset);

                                    tv_count.setText(String.format("%d/%d",list_word_in_text.size(),count_word_easy));
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
