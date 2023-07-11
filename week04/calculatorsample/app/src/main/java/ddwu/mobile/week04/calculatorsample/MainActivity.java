package ddwu.mobile.week04.calculatorsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    int num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etDisplay);
    }


    public void onClick(View v){
        String displayNum = editText.getText().toString();
        int sum = 0;

        switch (v.getId()){
            case R.id.btn_1:
                displayNum += "1";
                editText.setText(displayNum);
                break;

            case R.id.btn_2:
                displayNum += "2";
                editText.setText(displayNum);
                break;

            case R.id.btn_plus:
                num1 = Integer.parseInt(displayNum);

                displayNum = "";
                editText.setText(displayNum);
                break;

            case R.id.btn_equal:
                num2 = Integer.parseInt(displayNum);

                sum = num1 + num2;
                String strSum = Integer.toString(sum);
                editText.setText(strSum);
                break;
        }
    }
}