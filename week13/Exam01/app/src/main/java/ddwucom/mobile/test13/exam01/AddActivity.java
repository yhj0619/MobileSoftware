package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    FoodDBHelper myDbHelper;
    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        myDbHelper = new FoodDBHelper(this);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);

        Intent intent = getIntent();

        //String data = intent.getStringExtra("db");
    }
    public void onClick(View v){
        SQLiteDatabase db = null;
        switch (v.getId()){

            case R.id.btnAddFood:
                db = myDbHelper.getWritableDatabase();
                ContentValues row = new ContentValues();

                row.put(FoodDBHelper.COL_FOOD,etFood.getText().toString());
                row.put(FoodDBHelper.COL_NATION,etNation.getText().toString());

                db.insert(FoodDBHelper.TABLE_NAME,null,row);
                myDbHelper.close();

                setResult(RESULT_OK);
                break;
            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
