package ir.yottahouse.EnjoyIELTS.CustomView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * A custom EditText that draws lines between each line of text that is displayed.
 */
@SuppressLint("AppCompatCustomView")
public class CustomEditText extends EditText {
    private Rect mRect;
    private Paint mPaint;
    private boolean showLines = true;
    int height;

    // we need this constructor for LayoutInflater
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#5A5454"));


    }


    @Override
    protected void onDraw(Canvas canvas) {

        int height = canvas.getHeight();
        int curHeight = 0;
        int baseline = getLineBounds(0, mRect);
        int n = 0;
        if(showLines) {
            for (curHeight = baseline + 3; n <=40; curHeight += getLineHeight()) {
                if(n == 40)
                {
                    break;
                }
                canvas.drawLine(mRect.left, curHeight, mRect.right, curHeight, mPaint);
                n++;
            }
        }


        super.onDraw(canvas);
    }
}
