package ddwucom.mobile.test14.exam02_sample02;

import android.content.DialogInterface;
import android.content.Intent;
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
    ArrayList<Food> foodList = null;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodDBManager = new FoodDBManager(this);

        foodList = foodDBManager.getFoodList();         // foodList 원본을 FoodDBManager 가 직접 관리 foodDBManager의 fooList 와 연결

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("food", food);
                startActivityForResult(intent, UPDATE_CODE);
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
                            public void onClick(DialogInterface dialog, int which) {
                                if (foodDBManager.removeFood(foodList.get(pos).get_id())) {
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    foodDBManager.getAllFood();     // foodList 를 foodDBManager 가 갖고 있으므로 새로 읽기 작업만 수행
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        foodDBManager.getAllFood();         // foodList 를 foodDBManager 가 갖고 있으므로 새로 읽기 작업만 수행
        adapter.notifyDataSetChanged();
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }


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
