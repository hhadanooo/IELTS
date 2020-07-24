package ir.yottahouse.EnjoyIELTS.DialogChlng;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.Challenge.ChallengeActivity;
import ir.yottahouse.EnjoyIELTS.CustomView.CustomViewItem;
import ir.yottahouse.EnjoyIELTS.R;

import static android.content.Context.MODE_PRIVATE;

public class DialogChlngShow {
    Context context;
    DisplayMetrics dm;
    Dialog dialog;
    ImageView iv_start_dialogChlng;
    TextView tv_title_dialogChlng , tv_msg_dialogChlng ,tv_numQuiz_dialogChlng;
    SharedPreferences publicSpf;

    int solveQuiz = 0;

    @SuppressLint("SetTextI18n")
    public DialogChlngShow(final Context context, DisplayMetrics dm , final String intent){

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog_chlng);
        Objects.requireNonNull(dialog.getWindow()).setLayout((int) (dm.widthPixels*.9)
                , ViewGroup.LayoutParams.WRAP_CONTENT );
        tv_title_dialogChlng = dialog.findViewById(R.id.tv_title_dialogChlng);
        tv_msg_dialogChlng = dialog.findViewById(R.id.tv_msg_dialogChlng);
        iv_start_dialogChlng = dialog.findViewById(R.id.iv_start_dialogChlng);
        tv_numQuiz_dialogChlng = dialog.findViewById(R.id.tv_numQuiz_dialogChlng);
        Glide.with(context).load(R.drawable.buttondiachlng).into(iv_start_dialogChlng);

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fg.ttf");

        tv_title_dialogChlng.setTypeface(font);
        tv_msg_dialogChlng.setTypeface(font);
        tv_numQuiz_dialogChlng.setTypeface(font);

        tv_title_dialogChlng.setTextSize((int) (dm.widthPixels*0.012));
        tv_title_dialogChlng.setText("Complete the steps and test yourself ");

        tv_msg_dialogChlng.setTextSize((int) (dm.widthPixels*0.018));

        tv_numQuiz_dialogChlng.setTextSize((int) (dm.widthPixels*0.018));
        publicSpf = context.getSharedPreferences("numberQuiz" , MODE_PRIVATE);
        solveQuiz = publicSpf.getInt("numQuizSolve" , 0);
        int numQuizSolve = 10-solveQuiz;
        if (numQuizSolve == 0){
            tv_numQuiz_dialogChlng.setText("("+numQuizSolve+"/10)");
            tv_msg_dialogChlng.setText("Not question for answer today!");
            Glide.with(context).load(R.drawable.buttondiachlngfalse).into(iv_start_dialogChlng);
            iv_start_dialogChlng.setEnabled(false);
        }else{
            tv_numQuiz_dialogChlng.setText("("+numQuizSolve+"/10)");
            tv_msg_dialogChlng.setText("Are you ready ?");
        }



        iv_start_dialogChlng.getLayoutParams().width = (int) (dm.widthPixels*0.45);
        iv_start_dialogChlng.getLayoutParams().height = (int) (dm.widthPixels*0.16);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        iv_start_dialogChlng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //context.startActivity(new Intent(DialogChlngShow.this , ));
                //Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
                dismiss();
                context.startActivity(new Intent(context, ChallengeActivity.class));
                CustomViewItem.progressDialog = new ProgressDialog(context);
                CustomViewItem.progressDialog.setMessage("     Loading Page...     ");
                CustomViewItem.progressDialog.show();
            }
        });

    }

    public void show(){
        dialog.show();
    }

    public void dismiss(){
        dialog.dismiss();
    }


}
