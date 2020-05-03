package ir.hhadanooo.ielts.TestAndPracticeMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.R;

public class ActivityTestAndPracticeMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_and_practice_menu);




    }
    public void SetPropertiesCustomView()
    {
        CustomViewItem custom = new CustomViewItem(this);
        //init all view custom view
        TextView tv_title = custom.getTv_title();
        TextView tv_body = custom.getTv_body();
        ImageView img_icon = custom.getImg_icon();

        RelativeLayout relativeLayout = custom.getrel();


        //Give value to view
        custom.SetTextTvTitle("Listening");
        custom.SetTextTvBody("Learn more about the Speaking test and practice your skills!");
        custom.SetIcon(getResources().getDrawable(R.drawable.testimageicon_customview));


        // set width and height icon custom view
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        img_icon.getLayoutParams().width = (int)(dm.widthPixels*0.15);
        img_icon.getLayoutParams().height = (int)(dm.widthPixels*0.15);


        //set width and height layout custom view
        relativeLayout.getLayoutParams().width = (int)(dm.widthPixels*0.95);


        //set maxwidth tv body
        tv_body.setMaxWidth((int) (dm.widthPixels * 0.65));



        //set margin
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 20, 0, 0);
        custom.setLayoutParams(params);


        //set text size tv body,tv title
        tv_body.setTextSize((int) (dm.widthPixels * 0.013));
        tv_title.setTextSize((int) (dm.widthPixels * 0.018));

    }
}
