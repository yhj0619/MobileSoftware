package ddwu.mobile.week06.eventtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);//텍스트뷰 찾아오기
        //text_view는 전역변수임.

//        MyTouch myTouch = new MyTouch();  //체크 기능 이벤트핸들러, 클래스의 객체 만들기
//
//        textView.setOnTouchListener(myTouch);//이제 이 둘을 연결, touch 기능을 연결하고싶음
                    //touch에 myTouch 와 연결!!!
//         MyLongClick myLongClick = new MyLongClick(); //mylongclick객체 생성
         //2.4번 textView.setOnLongClickListener(longClickListener); //touch리스너에 muToy

         //2.5번 longClickListner자리에 이걸 넣기!!
         textView.setOnLongClickListener(new View.OnLongClickListener(){
             @Override
             public boolean onLongClick(View v) {

                Toast.makeText(MainActivity.this,"LONG_CLICK!!!", Toast.LENGTH_LONG).show();
                //myTouch가 this가 되기에, 클래스 이름을 명시적으로 지정하면 됨!
                textView.setText("long click!!!");// touch
                return true;
             }
        });

    }

    //class MyLongClick implements  View.OnLongClickListener{ // 인터페이스 구현하기 위해
//    View.OnLongClickListener longClickListener = new View.OnLongClickListener(){
//// 2.4 방법임 인터페이스에선 객체 못만듦, 하지만 방법이 하나 있다. new로 메소드 내용물 채워넣을 수 있게됨.
//      //   내용물이 채워져있으까 longClickListener 쓸 수 있음
//        //객체를 채워넣는 과정임
//        //longClickListener은 ㅖ{안의 내용들을 의미.
//
//        @Override
//        public boolean onLongClick(View v) {
//
//            Toast.makeText(MainActivity.this,"LONG_CLICK!!!", Toast.LENGTH_LONG).show();
//            return false;
//        }
//    }; // 변수선언인 값넣는거랑 동일하므로 ; 표기

//    class MyTouch implements View.OnTouchListener{  //터치 기능 class
//        @Override
//        public boolean onTouch(View view, MotionEvent motionEvent){//터치 시 행위
//
//            Toast.makeText(MainActivity.this,"Touch!!",Toast.LENGTH_SHORT).show();
//
//            return false;
//        }
//    }
}