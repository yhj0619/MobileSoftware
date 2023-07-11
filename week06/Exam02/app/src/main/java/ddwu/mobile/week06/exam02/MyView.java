package ddwu.mobile.week06.exam02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyView extends View {

    Random random = new Random();

    int x,y,r;
    float clickX, clickY;
    int drawing = 0;
    int color;

    public void setX() { this.x = x; }
    public float getX() { return x; }
    public void setY() { this.y = y; }
    public float getY() { return y; }
    public void setR() { this.r = r; }
    public int getR() { return r; }


    public float getClickX() {        return clickX;    }

    public void setClickX(float clickX) {        this.clickX = clickX;    }

    public float getClickY() {        return clickY;    }

    public void setClickY(float clickY) {        this.clickY = clickY;    }

    public int getDrawing() {        return drawing;    }

    public void setDrawing(int drawing) {        this.drawing = drawing;    }

    public int getColor() {        return color;    }

    public void setColor(int color) {        this.color = color;    }


    public MyView(Context context) {
        super(context);
        drawing = 1;
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        drawing = 1;
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        drawing = 1;
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        drawing = 1;
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        if (getDrawing() == 0) {
            r = (random.nextInt(3) + 1) * 100;

            Paint Pnt = new Paint();
            Pnt.setColor(getColor());

            canvas.drawCircle(getClickX(),getClickY(),r,Pnt);
        }
    }

// 1번
//    public boolean onTouchEvent(MotionEvent event){
//        super.onTouchEvent(event);
//        if(event.getAction() == MotionEvent.ACTION_DOWN){
//            x=(int)event.getX();
//            y=(int)event.getY();
//
//            invalidate();
//            return true;
//
//        }
//        return false;
//    }
}
