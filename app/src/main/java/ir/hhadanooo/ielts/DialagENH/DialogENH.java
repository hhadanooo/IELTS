package ir.hhadanooo.ielts.DialagENH;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ir.hhadanooo.ielts.R;

public class DialogENH {


    Context context;
    DisplayMetrics dm;
    Dialog dialog;
    ImageView iv_e_dialogENH , iv_n_dialogENH , iv_h_dialogENH;
    TextView tv_title_dialogENH;


    public DialogENH(final Context context, DisplayMetrics dm , final String intent){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_dialog_e_n_h);
        Objects.requireNonNull(dialog.getWindow()).setLayout((int) (dm.widthPixels*.8)
                , ViewGroup.LayoutParams.WRAP_CONTENT );
        tv_title_dialogENH = dialog.findViewById(R.id.tv_title_dialogENH);
        iv_e_dialogENH = dialog.findViewById(R.id.iv_e_dialogENH);
        iv_n_dialogENH = dialog.findViewById(R.id.iv_n_dialogENH);
        iv_h_dialogENH = dialog.findViewById(R.id.iv_h_dialogENH);

        tv_title_dialogENH.setTextSize((int) (dm.widthPixels*0.02));

        iv_e_dialogENH.getLayoutParams().width = (int) (dm.widthPixels*0.2);
        iv_e_dialogENH.getLayoutParams().height = (int) (dm.widthPixels*0.07);

        iv_n_dialogENH.getLayoutParams().width = (int) (dm.widthPixels*0.2);
        iv_n_dialogENH.getLayoutParams().height = (int) (dm.widthPixels*0.07);

        iv_h_dialogENH.getLayoutParams().width = (int) (dm.widthPixels*0.2);
        iv_h_dialogENH.getLayoutParams().height = (int) (dm.widthPixels*0.07);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        iv_e_dialogENH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent.equals("type1")){
                    Toast.makeText(context, "type1Activity easy", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(DialogAGShow.this , ));
                }else if (intent.equals("type2")){
                    Toast.makeText(context, "type2Activity easy", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(DialogAGShow.this , ));
                }
            }
        });

        iv_n_dialogENH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent.equals("type1")){
                    Toast.makeText(context, "type1Activity normal", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(DialogAGShow.this , ));
                }else if (intent.equals("type2")){
                    Toast.makeText(context, "type2Activity normal", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(DialogAGShow.this , ));
                }
            }
        });

        iv_h_dialogENH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent.equals("type1")){
                    Toast.makeText(context, "type1Activity hard", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(DialogAGShow.this , ));
                }else if (intent.equals("type2")){
                    Toast.makeText(context, "type2Activity hard", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(DialogAGShow.this , ));
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
