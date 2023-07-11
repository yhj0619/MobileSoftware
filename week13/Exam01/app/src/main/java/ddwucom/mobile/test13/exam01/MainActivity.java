package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {
        SQLiteDatabase db = null;
        switch (v.getId()) {
            case R.id.btnSelect:
                db = myDbHelper.getReadableDatabase();
                String[] columns = null; //다 가져올거니까 null//new String[] {FoodDBHelper.COL_ID,FoodDBHelper.COL_FOOD,FoodDBHelper.COL_NATION};
                String selection = null; // 조건 없으니까 null
                String[] selectArgs = null;

                //db.query()의 매개변수는 사실 다 null해도 됨.
                Cursor cursor =
                        db.query(FoodDBHelper.TABLE_NAME, columns, selection, selectArgs, null, null, null, null);

                ArrayList<Food> foodList = new ArrayList<>();

                while (cursor.moveToNext()) {
                    long _id = cursor.getLong(cursor.getColumnIndex(FoodDBHelper.COL_ID));
                    String foodName = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
                    String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
                    Food food = new Food(_id, foodName, nation);
                    foodList.add(food);
                } //foodlist 완성~!!

                cursor.close();
                myDbHelper.close();

                String result = "";
                for (Food newFood : foodList) {
                    result += newFood.toString() + "\n";
                }

                tvDisplay.setText(result);
                break;
            case R.id.btnAdd:
//                db = myDbHelper.getWritableDatabase();

//                ContentValues row = new ContentValues();
//                row.put(FoodDBHelper.COL_FOOD,"갈비탕");
//                row.put(FoodDBHelper.COL_NATION,"한국");
//                db.insert(FoodDBHelper.TABLE_NAME,null,row);
//                myDbHelper.close();
                //액티비티 띄우는 코드. 위 작업은 AddActivity에서
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(this, UpdateActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnRemove:
                Intent intent3 = new Intent(this, RemoveActivity.class);
                startActivity(intent3);
                break;
        }

        myDbHelper.close();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == ADD_REQ_CODE) {
//            switch (resultCode) {
//                case RESULT_OK:
//                    String foodName = data.getStringExtra("foodName");
//                    String nation = data.getStringExtra("nation");
//                    Food food = new Food(foodName,nation);
//                    break;
//                case RESULT_CANCELED:
//                    break;
//            }
//        } else if (requestCode == UPDATE_REQ_CODE) {
//            switch (resultCode) {
//                case RESULT_OK:
//                    break;
//                case RESULT_CANCELED:
//                    break;
//            }
//        } else if (requestCode == REMOVE_REQ_CODE) {
//            switch (resultCode) {
//                case RESULT_OK:
//                    break;
//                case RESULT_CANCELED:
//                    break;
//            }
//        }
//    }
}