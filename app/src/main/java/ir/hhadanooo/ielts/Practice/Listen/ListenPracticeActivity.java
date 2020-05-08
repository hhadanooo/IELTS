package ir.hhadanooo.ielts.Practice.Listen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Objects;

import ir.hhadanooo.ielts.R;

public class ListenPracticeActivity extends AppCompatActivity {


    DisplayMetrics dm;
    LinearLayout lay_PracticeL , lay_box_playerPL;
    RelativeLayout lay_playerPL;
    ImageView iv_repeat_playerPL , iv_play_playerPL , iv_next_playerPL , iv_ic_org_playerPL
            , iv_shareAnswer_playerPL , iv_seeAnswer_playerPL;
    View view_space_playerPL , view_space_button_see_share;
    EditText et_PracticeL , et_PracticeLResult;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_practice);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        lay_PracticeL = findViewById(R.id.lay_PracticeL);
        lay_box_playerPL = findViewById(R.id.lay_box_playerPL);
        lay_playerPL = findViewById(R.id.lay_playerPL);
        iv_repeat_playerPL = findViewById(R.id.iv_repeat_playerPL);
        iv_play_playerPL = findViewById(R.id.iv_play_playerPL);
        iv_next_playerPL = findViewById(R.id.iv_next_playerPL);
        view_space_playerPL = findViewById(R.id.view_space_playerPL);
        iv_ic_org_playerPL = findViewById(R.id.iv_ic_org_playerPL);
        et_PracticeL = findViewById(R.id.et_PracticeL);
        et_PracticeLResult = findViewById(R.id.et_PracticeLResult);
        iv_shareAnswer_playerPL = findViewById(R.id.iv_shareAnswer_playerPL);
        iv_seeAnswer_playerPL = findViewById(R.id.iv_seeAnswer_playerPL);
        view_space_button_see_share = findViewById(R.id.view_space_button_see_share);


        lay_PracticeL.getLayoutParams().width = (int) (dm.widthPixels*.9);


        lay_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.8);
        lay_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.275);


        lay_box_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.23);


        //iv_repeat_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        iv_repeat_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //iv_play_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        iv_play_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //iv_next_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.18);
        iv_next_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.15);

        //view_space_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        view_space_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.16);

        iv_ic_org_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.21);
        iv_ic_org_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.21);

        et_PracticeL.getLayoutParams().width = (int) (dm.widthPixels*.75);
        et_PracticeL.getLayoutParams().height = (int) (dm.widthPixels*.75);
        et_PracticeLResult.getLayoutParams().width = (int) (dm.widthPixels*.75);
        et_PracticeLResult.getLayoutParams().height = (int) (dm.widthPixels*.75);

        iv_shareAnswer_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_shareAnswer_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.08);

        iv_seeAnswer_playerPL.getLayoutParams().width = (int) (dm.widthPixels*.25);
        iv_seeAnswer_playerPL.getLayoutParams().height = (int) (dm.widthPixels*.08);

        view_space_button_see_share.getLayoutParams().width = (int) (dm.widthPixels*.2);

        et_PracticeL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (et_PracticeL.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }
                return false;

            }
        });
        et_PracticeLResult.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (et_PracticeLResult.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }
                return false;

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

}
