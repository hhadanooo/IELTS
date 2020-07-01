package ir.hhadanooo.ielts.DialogChlng;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ir.hhadanooo.ielts.Challenge.ChallengeActivity;
import ir.hhadanooo.ielts.CustomView.CustomViewItem;
import ir.hhadanooo.ielts.DialogAG.DialogAGShow;
import ir.hhadanooo.ielts.R;

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
        Objects.requireNonNull(dialog.getWindow()).setLayout((int) (dm.widthPixels*.8)
                , ViewGroup.LayoutParams.WRAP_CONTENT );
        tv_title_dialogChlng = dialog.findViewById(R.id.tv_title_dialogChlng);
        tv_msg_dialogChlng = dialog.findViewById(R.id.tv_msg_dialogChlng);
        iv_start_dialogChlng = dialog.findViewById(R.id.iv_start_dialogChlng);
        tv_numQuiz_dialogChlng = dialog.findViewById(R.id.tv_numQuiz_dialogChlng);

        tv_title_dialogChlng.setTextSize((int) (dm.widthPixels*0.025));
        tv_title_dialogChlng.setText("Complete The Steps and Test Yourself ");

        tv_msg_dialogChlng.setTextSize((int) (dm.widthPixels*0.012));

        tv_numQuiz_dialogChlng.setTextSize((int) (dm.widthPixels*0.012));
        publicSpf = context.getSharedPreferences("numberQuiz" , MODE_PRIVATE);
        solveQuiz = publicSpf.getInt("numQuizSolve" , 0);
        int numQuizSolve = 10-solveQuiz;
        if (numQuizSolve == 0){
            tv_numQuiz_dialogChlng.setText("("+numQuizSolve+"/10)");
            tv_msg_dialogChlng.setText("Not Question For Answer Today!");
            iv_start_dialogChlng.setEnabled(false);
        }else{
            tv_numQuiz_dialogChlng.setText("("+numQuizSolve+"/10)");
            tv_msg_dialogChlng.setText("Are You Ready ?");
        }



        iv_start_dialogChlng.getLayoutParams().width = (int) (dm.widthPixels*0.27);
        iv_start_dialogChlng.getLayoutParams().height = (int) (dm.widthPixels*0.1);


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
