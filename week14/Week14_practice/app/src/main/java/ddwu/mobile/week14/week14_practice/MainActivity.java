package ddwu.mobile.week14.week14_practice;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList = null; //reference 변수임! 내용없는.
   // FoodDBHelper dbHelper; //데이터베이스 관리 클래스 (2/1)은 이 방식
    FoodDBManager foodDBManager; //데이터베이스 관리 클래스 (2/2)은 이 방식

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList(); //빈 공간을 갖고있음
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);
        foodDBManager = new FoodDBManager(this);
        //db관리는 foodDBManager가 함.


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                intent.putExtra("food",food);
                startActivityForResult(intent,UPDATE_CODE);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_message)
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            //확인 버튼 눌렀을 때 동작하는 listner부분
                            public void onClick(DialogInterface dialog, int which) {
                                //boolean result = foodDBManager.removeFood(foodList.get(pos).get_id());
                                //if(result)이렇게 해도됨.
                                //이 위치에 들어있는 food객체(=foodList.get(pos))에서 id값을 알아야하므로.
                                //removeFood를 수행함 -> 잘 수행되면 true 아니면 false
                                if(foodDBManager.removeFood(foodList.get(pos).get_id())){
                                    Toast.makeText(MainActivity.this, "삭제 완료",Toast.LENGTH_SHORT).show();
                                    foodList.clear();//기존에 내용이 있으면 모든 내용을 다시 가져오는게 되므로 기존 내용을 비우고 addAll해야함
                                    foodList.addAll(foodDBManager.getAllFood()); //foodList는 REF변수이기에 기존에 가리키고 있는 변수에 추가해라!
                                    adapter.notifyDataSetChanged(); //화면의 내용을 갱신!!!!
                                } else{
                                    Toast.makeText(MainActivity.this,"삭제 실패",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancle,null)
                        .setCancelable(false) //백버튼 외에 다른 버튼 눌러도 닫히지 않음. 확인/취소 눌러야만 끝!
                        .show();
                return true; //정상종료하면 끝!
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        foodList.clear();//기존에 내용이 있으면 모든 내용을 다시 가져오는게 되므로 기존 내용을 비우고 addAll해야함
        foodList.addAll(foodDBManager.getAllFood()); //foodList는 REF변수이기에 기존에 가리키고 있는 변수에 추가해라!
        adapter.notifyDataSetChanged(); //화면의 내용을 갱신!!!!
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }

    //startActivityForResult로 받아왔으므로 이 메소드가 자동으로 실행됨
    //requestCode = REQ_CODE이고 resultCode는 RESULT_OK|RESULT_CANCLE
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    String food = data.getStringExtra("food");
                    Toast.makeText(this, food + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
