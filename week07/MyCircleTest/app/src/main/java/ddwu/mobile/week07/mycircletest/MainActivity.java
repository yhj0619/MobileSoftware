package ddwu.mobile.week07.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   // private
    MyCircle myCircle;
    boolean[] checkItem;
    int radius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        myCircle = findViewById(R.id.myCircle);
        registerForContextMenu(myCircle);

        checkItem = new boolean[3];

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.bigger:
                radius = myCircle.getRadius();
                radius += 10;
                myCircle.setRadius(radius);
                myCircle.invalidate();
                break;
            case R.id.smaller:
                radius = myCircle.getRadius();
                radius -= 10;
                myCircle.setRadius(radius);
                myCircle.invalidate();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.myCircle:
                menu.setHeaderTitle("Change Color");
                getMenuInflater().inflate(R.menu.menu2,menu);
                //context메뉴를 만들게 되면
                //R.menu.menu2의 설계도를 빈 공간인 menu에 넣음
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.red:
                myCircle.setColor(Color.RED);
                break;
            case R.id.green:
                myCircle.setColor(Color.GREEN);
                break;
            case R.id.blue:
                myCircle.setColor(Color.BLUE);
                break;
        }
        return true;
    }

//    이건 radio 버튼일 때 check확인
//    public void onMenuClick(MenuItem item ) {
//        switch (item.getItemId()){
//            case R.id.radio01:
//                item.setChecked(true);
//                break;
//            case R.id.radio02:
//                item.setChecked(true);
//                break;
//        }
//    }

    public void onMenuClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.red:
                if(item.isChecked()){
                    checkItem[0] = false;//체크 된 상태 보관하는 것
                    item.setChecked(false); //체크된 상탠지 확인하고 체크 풀기
                } else{
                    checkItem[0] = true;
                    item.setChecked(true); //아닐 경우엔 체크 해주기
                }
                break;
            case R.id.blue:
                if(item.isChecked()){
                    checkItem[1] = false;  //체크 된 상태
                    item.setChecked(false); //체크된 상탠지 확인하고 체크 풀기
                } else{
                    checkItem[1] = true; // 아닐경우엔 체크 해주기
                    item.setChecked(true);
                }
                break;
            case R.id.green:
                if(item.isChecked()){
                    checkItem[2] = false;
                    item.setChecked(false);
                } else{
                    checkItem[2] = true;
                    item.setChecked(true);
                }
                break;
        }
    }
}
