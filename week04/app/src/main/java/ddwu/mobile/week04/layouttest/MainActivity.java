package ddwu.mobile.week04.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setBackgroundColor(Color.LTGRAY);

        TextView text = new TextView(this);
        text.setText("TextView");
        text.getGravity(Gravity.CENTER);
        text.setTextColor(Color.RED);
        text.setTextSize(20);

        linear.addView(text);

        setContentView(linear);


    }

    public void onClick (View v) {
        LinearLayout layout = findViewById(R.id.layout);

        switch (layout.getOrientation()){
            case LinearLayout.HORIZONTAL:
                layout.setOrientation(LinearLayout.vertical);
                braek;

            case LinearLayout.VERTICAL:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
        }

        layout.setOrientation(LinearLayout.HORIZONTAL);
    }

}