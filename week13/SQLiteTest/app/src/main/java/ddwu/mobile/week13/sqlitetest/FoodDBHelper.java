package ddwu.mobile.week13.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class FoodDBHelper extends SQLiteOpenHelper {
    final static String TAG = "FoodDBHelper";
    final static String DB_NAME = "foods.db";
    public final static String TABLE_NAME = "food_table";
    public final static String COL_ID = "_id";
    public final static String COL_FOOD = "food";
    public final static String COL_NATION = "nation";

    public FoodDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + "integer primary key autoincrement, " +
                COL_FOOD + "TEXT, " + COL_NATION + " TEXT)";
        Log.d(TAG,sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
