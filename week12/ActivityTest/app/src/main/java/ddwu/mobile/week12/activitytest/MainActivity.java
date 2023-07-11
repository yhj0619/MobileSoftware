package ddwu.mobile.week12.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int SUB_ACTIVITY_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
//                DataClass dataClass  =new DataClass();
//
//                //Intent를 띄워 편지 쓰는 것
//               Intent intent = new Intent(this, SubActivity.class);
//
//                //Extras를 이용하여 자료 저장
//                ////변수이름은 subject이고 값은 mobile software인 값을 intent에 집어넣기!!
//                //intent.putExtra("subject","mobile software");
////                intent.putExtra("time",3);
////                intent.putExtra("dataClass",dataClass);
//                //액티비티가 안드로이드 운영체제 전달해서 SubActivity 띄워짐
//                //startActivity(intent);
//                startActivityForResult(intent,SUB_ACTIVITY_CODE);

                //묵시적 호출

                //웹주소로 이동
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                //지정한 번호로 전화 기능 실행
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:012-3456-7890"));
                startActivity(intent);
                break;
        }
    }

    //이거 다 SubActivityrequestCode = SUB_ACTIVITY_CODE
    //resultCode는 RESULT_OK or RESULT_CANCELED  중에 설정되어 있는 값이 들어옴
    //resultIntent값이 Intent data임 없을 수도 있음!!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        switch(requestCode){ //요청했던 코드에 해당하는 결과인지 확인
            case SUB_ACTIVITY_CODE: //resultCode의 값에 따라!
                if(resultCode == RESULT_OK){
                    String resultData = data.getStringExtra("result_data");
                    Toast.makeText(this,"Result: " + resultData, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}