package ir.hhadanooo.ielts.WelcomePage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import ir.hhadanooo.ielts.MainActivity;
import ir.hhadanooo.ielts.R;
import ir.hhadanooo.ielts.TestAndPracticeArrowBack.ActivityTestAndPracticeArrowBack;

public class Activity_Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__welcome);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        ImageView logo_welcome =findViewById(R.id.logo_welcome);
        logo_welcome.getLayoutParams().width = (int)(dm.widthPixels*0.6);
        logo_welcome.getLayoutParams().height = (int)(dm.widthPixels*0.6);
        Glide.with(this).load(R.drawable.logo).into(logo_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Activity_Welcome.this , MainActivity.class));
                finish();
            }
        } , 2500);
    }
}
