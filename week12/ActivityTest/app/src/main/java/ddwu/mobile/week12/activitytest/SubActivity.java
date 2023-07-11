package ddwu.mobile.week12.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub); //화면 만들어주기

        //getIntent()임.
        //메인 엑티비티에 intent를 만들고, startActivity하면 intent가 os에 전달됨.
        //os는 SubActivity 띄움 -> intent를 전달하는 것.
        //전달받은 intent를 꺼내는 메소드가 getIntent임.
        //이 intent는 subject이름의 변수를 전달받아 getStringExtra로 꺼냄!
        Intent intent = getIntent();

        String data = intent.getStringExtra("subject");
//        int time = intent.getIntExtra("time",2);
//        DataClass dataClass = (DataClass) intent.getSerializableExtra("dataClass");

        textView = findViewById(R.id.textView);
        textView.setText(data);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.sub_button_ok:
                Intent resultIntent = new Intent(); //빈 intent()를 만드는 것, 결과를 담기 위한 용도임
                resultIntent.putExtra("result data","SubActivity returns data");//결과로 사용될 데이터 저장
                setResult(RESULT_OK,resultIntent);//sub의 결과를 설정하는 것.
                break;
            case R.id.sub_button_cancel:
                setResult(RESULT_CANCELED);//결과가 필요없을 땐
                break;
        }
        finish(); //activity가 사라지는 순간. activity가 닫혀지는 순간 mainActivity로~
         // 결과를 받게 되면 mainActivity의 onActivityResult로 자동호출된다.
    }
}
