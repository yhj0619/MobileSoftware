package ddwucom.mobile.week11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    FoodManager foodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodManager = new FoodManager();
        foodList = foodManager.getSubjectList();

        listView = findViewById(R.id.listView);

        // DataManager 적용해 볼 것
//        foodList = new ArrayList<Food>();
//        foodList.add(new Food("김치찌개", "한국"));
//        foodList.add(new Food("된장찌개", "한국"));
//        foodList.add(new Food("훠궈", "중국"));
//        foodList.add(new Food("딤섬", "중국"));
//        foodList.add(new Food("초밥", "일본"));
//        foodList.add(new Food("오코노미야키", "일본"));

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override                                                      // 몇번째를 클릭했는지 position에
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final int pos = position;
                String foodName = foodList.get(position).getFood();
                //다이얼로그 생성 코드
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(foodName + " 을(를) 삭제하시겠습니까?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //리스트 뷰를 지우면 됨! 지우는건 원본데이터를 지우는것,
                                //foodList인 원본데이터 지우고 화면에 반영하는 것은 notified하면 됨
                                foodManager.removeData(pos);
                                adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
                return false;
            }
        });
    }


    public void onClick(View v) {
        final ConstraintLayout orderLayout =
                (ConstraintLayout)View.inflate(this, R.layout.order_layout,null);

        switch (v.getId()){
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("음식 추가")
                        .setView(orderLayout)
                        .setCancelable(false)
                        .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText etFoodName = orderLayout.findViewById(R.id.etFoodName);
                                EditText etCountry = orderLayout.findViewById(R.id.etCountry);
                                String foodName = etFoodName.getText().toString();
                                String country = etCountry.getText().toString();

                                //추가하는 코드 작성
                                foodManager.addData(foodName, country);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

                break;

        }
    }


}
