package dduwcom.mobile.finalreport;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MovieDBManager {

    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;
    ArrayList movieList;
    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    //    DB의 모든 movie 반환
    public ArrayList<Movie> getAllMovie() {
        movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor. getColumnIndexOrThrow(MovieDBHelper.COL_ID));
            String title = cursor.getString(cursor. getColumnIndexOrThrow(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor. getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String actor = cursor.getString(cursor. getColumnIndexOrThrow(MovieDBHelper.COL_ACTOR));
            String releaseDate = cursor.getString(cursor. getColumnIndexOrThrow(MovieDBHelper.COL_RELEASEDATE));
            String story = cursor.getString(cursor. getColumnIndexOrThrow(MovieDBHelper.COL_STORY));


            movieList.add ( new Movie (id, title, director, actor, releaseDate, story) );
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    //    DB 에 새로운 movie 추가
    public boolean addNewMovie(Movie newMovie) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_TITLE, newMovie.getTitle());
        value.put(MovieDBHelper.COL_DIRECTOR, newMovie.getDirector());
        value.put(MovieDBHelper.COL_ACTOR, newMovie.getActor());
        value.put(MovieDBHelper.COL_RELEASEDATE, newMovie.getReleaseDate());
        value.put(MovieDBHelper.COL_STORY, newMovie.getStory());
//        value.put(MovieDBHelper.COL_IMAGE, R.mipmap.avengers);
        //      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    //    _id 를 기준으로 movie 의 EditText 내용 변경
    public boolean modifyMovie(Movie movie) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_TITLE, movie.getTitle());
        row.put(MovieDBHelper.COL_DIRECTOR, movie.getDirector());
        row.put(MovieDBHelper.COL_ACTOR, movie.getActor());
        row.put(MovieDBHelper.COL_RELEASEDATE, movie.getReleaseDate());
        row.put(MovieDBHelper.COL_STORY, movie.getStory());
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };
        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    _id 를 기준으로 DB에서 movie 삭제
    public boolean removeMovie(long id) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    영화 제목으로 DB 검색
    public ArrayList<Movie> getMovieByTitle(String Title) {

        return null;
    }

    //    개봉일로 DB 검색
    public ArrayList<Movie> getMovieByReleaseDate(String releaseDate) {
        return null;
    }

    //    id 로 DB 검색
    public Movie getMovieById(long id) {

        return  null;
    }

    //    close 수행
    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
