package ddwu.mobile.week05.customviewtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    MyView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);

    }

    public void onClick(View v) {
        myView.set_x(random.nextInt(500));
        myView.set_y(random.nextInt(800));
        myView.set_r((random.nextInt(3) + 1) * 100);
        myView.invalidate();
    }
}