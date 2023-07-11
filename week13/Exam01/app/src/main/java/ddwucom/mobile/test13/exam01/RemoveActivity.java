package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveActivity extends AppCompatActivity {

    FoodDBHelper myDbHelper;
    EditText etFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        myDbHelper = new FoodDBHelper(this);

        Intent intent = getIntent();

        etFood = findViewById(R.id.etRemoveFood);
    }

    public void onClick(View v){
        SQLiteDatabase db = null;
        switch (v.getId()){
            case R.id.btnRemoveFood:
                db = myDbHelper.getWritableDatabase();

                String whereClause = "food=?";
                String[] whereArgs = new String[]{etFood.getText().toString()};

                db.delete(FoodDBHelper.TABLE_NAME,whereClause,whereArgs);
                myDbHelper.close();

                setResult(RESULT_OK);
                break;
            case R.id.btnRemoveCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
