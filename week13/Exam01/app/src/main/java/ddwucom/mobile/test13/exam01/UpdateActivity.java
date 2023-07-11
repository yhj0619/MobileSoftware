package ddwucom.mobile.test13.exam01;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    FoodDBHelper myDbHelper;
    EditText etId;
    EditText etUpdateFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();

        myDbHelper = new FoodDBHelper(this);

        etId = findViewById(R.id.etUpdateId);
        etUpdateFood = findViewById(R.id.etUpdateFood);
    }
    public void onClick(View v){
        SQLiteDatabase db = null;
        switch (v.getId()){
            case R.id.btnUpdateFood:
                db = myDbHelper.getWritableDatabase();
                ContentValues row = new ContentValues();

                row.put(FoodDBHelper.COL_FOOD,etUpdateFood.getText().toString());
                String whereClause = "_id=?";
                String[] whereArgs = new String[]{etId.getText().toString()};

                db.update(FoodDBHelper.TABLE_NAME,row,whereClause,whereArgs);

                myDbHelper.close();

                setResult(RESULT_OK);
                break;
            case R.id.btnUpdateCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
