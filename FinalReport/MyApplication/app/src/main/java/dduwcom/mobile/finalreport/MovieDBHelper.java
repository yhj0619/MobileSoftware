package dduwcom.mobile.finalreport;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MovieDBHelper";

    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_ACTOR = "actor";
    public final static String COL_RELEASEDATE = "releaseDate";
    public final static String COL_STORY = "story";
    public final static String COL_IMAGE = "imageView";

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_DIRECTOR + " TEXT, " + COL_ACTOR + " TEXT, " + COL_RELEASEDATE + " TEXT, "+ COL_STORY + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        insertSample(db);       // 샘플이 필요할 경우 추가
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertSample(SQLiteDatabase db) {
        db.execSQL("insert into " + TABLE_NAME + " values (null, '해리 포터와 마법사의 돌', '크리스 콜럼버스', '다니엘 래드클리프 & 루퍼트 그린트 & 엠마 왓슨', '2001.12.14','해리 포터 시리즈 1편');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '범죄도시2', '이상용', '마동석 & 손석구', '2022.05.18','1000만관객!!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '어벤져스:엔드게임', '안소니 루소 외 1', '로버트 다우니 주니어 & 크리스 에반스 & ..', '2019.04.24','돌아온 어벤져스!!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '트와일라잇', '캐서린 하드윅', '크리스틴 스튜어트,로버트 패틴슨', '2018.12.12','뱀파이어로맨스??!!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '하울의 움직이는 성', '미야자키 하야오', '바이쇼 지에코 & 기무라 타쿠야', '2004.12.23','스튜디오 지브리의 대표작!!');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '기생충', '봉준호', '송강호 이선균 조여정 등', '2019.05.30','상류층과 하류층의 만남을 다룬 대한민국의 블랙 코미디!');");
    }
}

