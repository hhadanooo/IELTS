package ir.hhadanooo.ielts.DialogChlng;

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
import android.widget.Toast;

import java.util.Objects;

import ir.hhadanooo.ielts.DialogAG.DialogAGShow;
import ir.hhadanooo.ielts.R;

public class DialogChlngShow {
    Context context;
    DisplayMetrics dm;
    Dialog dialog;
    ImageView iv_start_dialogChlng;
    TextView tv_title_dialogChlng , tv_msg_dialogChlng;

    public DialogChlngShow(final Context context, DisplayMetrics dm , final String intent){

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog_chlng);
        Objects.requireNonNull(dialog.getWindow()).setLayout((int) (dm.widthPixels*.8)
                , ViewGroup.LayoutParams.WRAP_CONTENT );
        tv_title_dialogChlng = dialog.findViewById(R.id.tv_title_dialogChlng);
        tv_msg_dialogChlng = dialog.findViewById(R.id.tv_msg_dialogChlng);
        iv_start_dialogChlng = dialog.findViewById(R.id.iv_start_dialogChlng);

        tv_title_dialogChlng.setTextSize((int) (dm.widthPixels*0.025));
        tv_title_dialogChlng.setText("Complete The Steps and Test Yourself ");

        tv_msg_dialogChlng.setTextSize((int) (dm.widthPixels*0.012));
        tv_msg_dialogChlng.setText("Are You Ready");

        iv_start_dialogChlng.getLayoutParams().width = (int) (dm.widthPixels*0.27);
        iv_start_dialogChlng.getLayoutParams().height = (int) (dm.widthPixels*0.1);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        iv_start_dialogChlng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //context.startActivity(new Intent(DialogChlngShow.this , ));
                Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
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
