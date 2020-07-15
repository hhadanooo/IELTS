package ir.yottahouse.EnjoyIELTS.DialogAG;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import ir.yottahouse.EnjoyIELTS.R;
import ir.yottahouse.EnjoyIELTS.Test.Activity_test;

public class DialogAGShow {

    Context context;
    DisplayMetrics dm;
    Dialog dialog;
    ImageView iv_a_dialogAG , iv_g_dialogAG;
    TextView tv_title_dialogAG;


    public DialogAGShow(final Context context, DisplayMetrics dm , final String intent){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog_a_g);
        Objects.requireNonNull(dialog.getWindow()).setLayout((int) (dm.widthPixels*.8)
                ,ViewGroup.LayoutParams.WRAP_CONTENT );
        tv_title_dialogAG = dialog.findViewById(R.id.tv_title_dialogAG);
        iv_a_dialogAG = dialog.findViewById(R.id.iv_a_dialogAG);
        iv_g_dialogAG = dialog.findViewById(R.id.iv_g_dialogAG);
        Glide.with(context).load(R.drawable.btn_academic1).into(iv_a_dialogAG);
        Glide.with(context).load(R.drawable.btn_general1).into(iv_g_dialogAG);

        tv_title_dialogAG.setTextSize((int) (dm.widthPixels*0.02));

        iv_a_dialogAG.getLayoutParams().width = (int) (dm.widthPixels*0.27);
        iv_a_dialogAG.getLayoutParams().height = (int) (dm.widthPixels*0.085);

        iv_g_dialogAG.getLayoutParams().width = (int) (dm.widthPixels*0.27);
        iv_g_dialogAG.getLayoutParams().height = (int) (dm.widthPixels*0.085);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        iv_a_dialogAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent.equals("Read")){

                    Intent i = new Intent(context, Activity_test.class);
                    i.putExtra("Academic","academic");
                    i.putExtra("Read","read");
                    dialog.dismiss();
                    context.startActivity(i);
                }else if (intent.equals("Write")){
                    Intent i = new Intent(context, Activity_test.class);
                    i.putExtra("Academic","academic");
                    i.putExtra("Write","write");
                    dialog.dismiss();
                    context.startActivity(i);
                }
            }
        });

        iv_g_dialogAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent.equals("Read")){
                    Intent i = new Intent(context, Activity_test.class);
                    i.putExtra("General","general");
                    i.putExtra("Read","read");
                    dialog.dismiss();
                    context.startActivity(i);
                }else if (intent.equals("Write")){
                    Intent i = new Intent(context, Activity_test.class);
                    i.putExtra("General","general");
                    i.putExtra("Write","write");
                    dialog.dismiss();
                    context.startActivity(i);
                }
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
