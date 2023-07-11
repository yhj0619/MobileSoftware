package ddwu.mobile.week07.myviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView myView = new MyView(this);
        setContentView(myView);
    }
    public void onClick(View v) {
//        MyView myview = findViewById(R.id.myView);
//        myview.setColor(Color.RED);
//        myview.invalidate();
    }

    class MyView extends View{
        public MyView(Context context){
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Toast.makeText(MainActivity.this,"Click!",Toast.LENGTH_SHORT).show();
            return super.onTouchEvent(event);
        }
        
    }
}