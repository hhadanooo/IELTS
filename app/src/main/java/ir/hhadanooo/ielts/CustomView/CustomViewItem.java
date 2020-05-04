package ir.hhadanooo.ielts.CustomView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ir.hhadanooo.ielts.R;


public class CustomViewItem extends RelativeLayout {

    TextView tv_title,tv_body;
    ImageView img_icon;
    RelativeLayout lin;

    View rootview;
    public CustomViewItem(Context context) {
        super(context);
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
        lin = rootview.findViewById(R.id.customviewitem_rel);


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
