package ddwucom.mobile.test14.exam02;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList = null; //reference 변수임! 내용없는.
    FoodDBHelper dbHelper; //데이터베이스 관리 클래스 (2/1)은 이 방식
    FoodDBManager foodDBManager; //데이터베이스 관리 클래스 (2/2)은 이 방식

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList<Food>(); //빈 공간을 갖고있음

//        dbHelper = new FoodDBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null);
//
//        while(cursor.moveToNext()) {
//            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
//            String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
//            String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
//            foodList.add ( new Food (id, food, nation) );
//        }
//
//        cursor.close();
//        dbHelper.close();
//이 부분들은 onCreate에 추가되어있으므로 MainActivity가 실행되는 onCreate일때만 실행됨.

        adapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);
        foodDBManager = new FoodDBManager(this);
        //db관리는 foodDBManager가 함.
    }

    @Override
    protected void onResume() {
        super.onResume();
 //       readAllFoods();
        foodList.clear();//기존에 내용이 있으면 모든 내용을 다시 가져오는게 되므로 기존 내용을 비우고 addAll해야함
        foodList.addAll(foodDBManager.getAllFood()); //foodList는 REF변수이기에 기존에 가리키고 있는 변수에 추가해라!
        adapter.notifyDataSetChanged(); //화면의 내용을 갱신!!!!
    }

    //이 부분은 FoodDBManager로 갔기에, 필요 없어짐
    //이 class에서만 사용될것이기에 private
//    private void readAllFoods(){ //이 함수 호출할 때마다 db에 접근해서 data읽어와서 foodList만들고 close!!
//        foodList.clear();
//        dbHelper = new FoodDBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + FoodDBHelper.TABLE_NAME, null);
//
//        while(cursor.moveToNext()) {
//            long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
//            String food = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
//            String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
//            foodList.add ( new Food (id, food, nation) );
//        }
//
//        cursor.close();
//        dbHelper.close();
//    }

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
        } //이 부분은 수행 안됨! 안만들어놨기에.
    }
}
