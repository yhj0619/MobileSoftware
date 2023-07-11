package ddwu.mobile.week05.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    int x,y,r;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void set_x(int x) { this.x = x; }
    public int get_x() { return x; }
    public void set_y(int y) { this.y = y; }
    public int get_y() { return y; }
    public void set_r(int r) { this.r = r; }
    public int get_r() { return r; }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);

        Paint Pnt = new Paint();
        Pnt.setColor(Color.CYAN);

        canvas.drawCircle(get_x(), get_y(), get_r(), Pnt);
    }
}
