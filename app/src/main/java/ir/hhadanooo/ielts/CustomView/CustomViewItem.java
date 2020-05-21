package ir.hhadanooo.ielts.CustomView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.hhadanooo.ielts.Practice.Activity_Practice;
import ir.hhadanooo.ielts.Practice.Listen.ListenPracticeActivity;
import ir.hhadanooo.ielts.Practice.Listen.ListenPracticeBActivity;
import ir.hhadanooo.ielts.R;
import ir.hhadanooo.ielts.SimpleText.SimpleTextActivity;
import ir.hhadanooo.ielts.Test.ActivityTestRead;
import ir.hhadanooo.ielts.Test.ActivityTestWrite;
import ir.hhadanooo.ielts.Test.Activity_test;
import ir.hhadanooo.ielts.Test.Listen.TestListenActivity;
import ir.hhadanooo.ielts.Tips.ActivityTips;
import ir.hhadanooo.ielts.Vocab.Activity_Vocab;


public class CustomViewItem extends RelativeLayout {

    TextView tv_title,tv_body;
    ImageView img_icon,img_icon1;
    RelativeLayout lin;

    View rootview;


    String page;
    String type;
    String type_test;
    int number;
    boolean Check_page;
    String type_listen;
    String level;
    public CustomViewItem(Context context,String page,String type,String type_test,int number,String type_listen,String level,boolean check_page) {
        super(context);
        this.page = page;
        this.type = type;
        this.type_test = type_test;
        this.number = number;
        this.type_listen = type_listen;
        this.level = level;
        this.Check_page = check_page;

        init(context);
    }

    public CustomViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomViewItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomViewItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context)
    {
        rootview = inflate(context, R.layout.layout_customview_item,this);
        tv_title = rootview.findViewById(R.id.customviewitem_tv_title);
        tv_body = rootview.findViewById(R.id.customviewitem_tv_body);
        img_icon = rootview.findViewById(R.id.customviewitem_img_icon);
        img_icon1 = rootview.findViewById(R.id.customviewitem_img_icon1);
        lin = rootview.findViewById(R.id.customviewitem_rel);

        if(!Check_page)
        {
            OnclickRel(context);
        }

    }

    public void OnclickRel(final Context context)
    {
        if(page.equals("Reading"))
        {
            if(type.equals("Test"))
            {
                if(type_test.equals("Academic"))
                {
                    lin.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, ActivityTestRead.class);
                            intent.putExtra("Academic","Academic");
                            intent.putExtra("Number",number);
                            context.startActivity(intent);
                        }
                    });
                }else  if(type_test.equals("General"))
                {
                    lin.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context,ActivityTestRead.class);
                            intent.putExtra("General","General");
                            intent.putExtra("Number",number);
                            Toast.makeText(context,"",Toast.LENGTH_LONG).show();
                            context.startActivity(intent);
                        }
                    });
                }
            }else  if(type.equals("Tips"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Read","Read");
                        intent.putExtra("Tip","Tip");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }else  if(type.equals("Practice"))
            {
                //not item
            }
        }else  if(page.equals("Writing"))
        {
            if(type.equals("Test"))
            {
                if(type_test.equals("Academic"))
                {
                    lin.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, ActivityTestWrite.class);
                            intent.putExtra("Write","Write");
                            intent.putExtra("Academic","Academic");
                            intent.putExtra("Number",number);
                            intent.putExtra("name",type_listen);
                            context.startActivity(intent);
                        }
                    });
                }else  if(type_test.equals("General"))
                {
                    lin.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context,ActivityTestWrite.class);
                            intent.putExtra("Write","Write");
                            intent.putExtra("General","General");
                            intent.putExtra("Number",number);
                            intent.putExtra("name",type_listen);
                            context.startActivity(intent);
                        }
                    });
                }
            }else  if(type.equals("Tips"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Write","Write");
                        intent.putExtra("Tip","Tip");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }else  if(type.equals("Vocab"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Write","Write");
                        intent.putExtra("Vocab","Vocab");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }
        }else  if(page.equals("Speaking"))
        {
            if(type.equals("Test"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Speak","Speak");
                        intent.putExtra("Test","Test");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }else  if(type.equals("Tips"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Speak","Speak");
                        intent.putExtra("Tip","Tip");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }else  if(type.equals("Vocab"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Speak","Speak");
                        intent.putExtra("Vocab","Vocab");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }
        }else  if(page.equals("Listening"))
        {
            if(type.equals("Test"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, TestListenActivity.class);
                        intent.putExtra("Number",number);
                        context.startActivity(intent);
                    }
                });
            }else  if(type.equals("Tips"))
            {
                lin.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SimpleTextActivity.class);
                        intent.putExtra("Listen","Listen");
                        intent.putExtra("Tip","Tip");
                        intent.putExtra("number",number);
                        context.startActivity(intent);
                    }
                });
            }else  if(type.equals("Practice"))
            {

                if(type_listen.equals("Typea"))
                {
                    if(level.equals("Easy"))
                    {
                        lin.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ListenPracticeActivity.class);
                                intent.putExtra("Type1","Type1");
                                intent.putExtra("Easy","Easy");
                                intent.putExtra("Number",number);
                                context.startActivity(intent);
                            }
                        });
                    }else if(level.equals("Normal"))
                    {
                        lin.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ListenPracticeActivity.class);
                                intent.putExtra("Type1","Type1");
                                intent.putExtra("Normal","Noraml");
                                intent.putExtra("Number",number);
                                context.startActivity(intent);
                            }
                        });
                    }else if(level.equals("Hard"))
                    {
                        lin.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ListenPracticeActivity.class);
                                intent.putExtra("Type1","Type1");
                                intent.putExtra("Hard","Hard");
                                intent.putExtra("Number",number);
                                context.startActivity(intent);
                            }
                        });
                    }
                }else if(type_listen.equals("Typeb"))
                {
                    if(level.equals("Easy"))
                    {
                        lin.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ListenPracticeBActivity.class);
                                intent.putExtra("Type2","Type2");
                                intent.putExtra("Easy","Easy");
                                intent.putExtra("Number",number);
                                context.startActivity(intent);
                            }
                        });
                    }else if(level.equals("Normal"))
                    {
                        lin.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ListenPracticeBActivity.class);
                                intent.putExtra("Type2","Type2");
                                intent.putExtra("Normal","Noraml");
                                intent.putExtra("Number",number);
                                context.startActivity(intent);
                            }
                        });
                    }else if(level.equals("Hard"))
                    {
                        lin.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ListenPracticeBActivity.class);
                                intent.putExtra("Type2","Type2");
                                intent.putExtra("Hard","Hard");
                                intent.putExtra("Number",number);
                                context.startActivity(intent);
                            }
                        });
                    }
                }



            }
        }
    }

    public ImageView getImg_icon1() {
        return img_icon1;
    }

    public RelativeLayout getrel() {
        return lin;
    }

    public void SetTextTvTitle(String Text)
    {
        tv_title.setText(Text);
    }
    public void SetTextTvBody(String Text)
    {
        tv_body.setText(Text);
    }
    public void SetIcon(Drawable icon)
    {
        img_icon.setBackground(icon);
    }

    public TextView getTv_title() {
        return tv_title;
    }

    public TextView getTv_body() {
        return tv_body;
    }

    public ImageView getImg_icon() {
        return img_icon;
    }


}
