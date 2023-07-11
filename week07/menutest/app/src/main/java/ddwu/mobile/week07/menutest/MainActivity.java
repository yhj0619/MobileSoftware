package ddwu.mobile.week07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] checkItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
        //customView 만들면 생략가능함
        //activity에다가 메뉴 만드는 기능 맡길땐 무조건 필요

        checkItem=new boolean[2]; //해당 정보 기록하는 배열
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //원랜 이거임       MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_main,menu);//객체.inflator

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item01:
                Toast.makeText(this,"첫 번째 항목",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textView:
                getMenuInflater().inflate(R.menu.menu_main,menu);
                //context메뉴룰 만들게 되면
                // R.menu.main_menu의 설계도를 빈 공간인 menu에 넣음
                break;

        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item01:
                Toast.makeText(this,"Context!!!",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }



    public void onMenuClick(MenuItem item ) {
       switch (item.getItemId()){
           case R.id.radio01:
               item.setChecked(true);
               break;
           case R.id.radio02:
               item.setChecked(true);
               break;
       }
    }

    public void onCheckClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.check01:
                if(item.isChecked()){
                    checkItem[0] = false;  //체그 된 상태 보관하는 것.
                    item.setChecked(false); //check된 상탠지 체크하고 체크 풀기.

                } else {
                    checkItem[0] = true;
                    item.setChecked(true);  //아닐경우엔 체크 해주기
                }
                break;
            case R.id.check02:
                if(item.isChecked()){
                    checkItem[1] = false;  //체크 된 상태
                    item.setChecked(false); //check된 상탠지 체크하고 체크 풀기.
                } else {
                    checkItem[1] = true; 
                    item.setChecked(true);  //아닐경우엔 체크 해주기
                }
                break;
        }
    }
}