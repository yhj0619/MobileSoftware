package ddwu.mobile.week07.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {

    private Paint myPaint;
    private int x;
    private int y;
    private int r = 100;

    int radius = 0;
    int color;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    

    public MyCircle(Context context) {
        super(context);
        myPaint = new Paint();
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint();
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        myPaint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        myPaint.setColor(Color.RED);

        x = getWidth() / 2;
        y = getHeight() / 2;
        r= getRadius();
        canvas.drawCircle(x, y, r, myPaint);
    }
}
