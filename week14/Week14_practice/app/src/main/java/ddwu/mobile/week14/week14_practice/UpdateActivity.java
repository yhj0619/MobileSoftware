package ddwu.mobile.week14.week14_practice;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Food food;

    EditText etFood;
    EditText etNation;

    FoodDBManager foodDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        food = (Food) getIntent().getSerializableExtra("food");

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        etFood.setText(food.getFood());
        etNation.setText(food.getNation());
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                food.setFood(etFood.getText().toString());
                food.setNation(etNation.getText().toString());

                if(foodDBManager.modifyFood(food)){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food",food);
                    setResult(RESULT_OK,resultIntent);
                    //절대 startActivity하면 안됨!!!
                }   else{
                   setResult(RESULT_CANCELED);
                }

                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);  
                break;
        }
        finish(); //  finish하면 액티비티가 종료되면서 밑에 있는 MainActivity가 뜨는것임.

    }
}