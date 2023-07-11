package mobile.database.dbtest02;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AllContactsActivity extends AppCompatActivity {
	
	ListView lvContacts = null;
	ContactDBHelper helper;
	Cursor cursor;
//	SimpleCursorAdapter adapter;
	MyCursorAdapter myCursorAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_contacts);
		lvContacts = (ListView)findViewById(R.id.lvContacts);

		helper = new ContactDBHelper(this);

//		  SimpleCursorAdapter 객체 생성
		myCursorAdapter = new MyCursorAdapter(this, R.layout.listview_layout,null);

	    lvContacts.setAdapter(myCursorAdapter);

////		리스트 뷰 클릭 처리
//        lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//           return true;
//            }
//        });
//
////		리스트 뷰 롱클릭 처리
//		lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//			@Override
//			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
////				db 준비 writable 해서 읽어오고
////						밑의 코드가 확인을 눌렀을때 동작하도록
//
//				final SQLiteDatabase db = helper.getWritableDatabase();
//
//				final long dbId=id; // id 값 유지 시켜줘야함. 이 상수를 유지해서 다이아로그에서 사용. 상수로 보관해서 삭제확인버튼시 이 id값 사용하도록.
//
//				AlertDialog.Builder builder = new AlertDialog.Builder(AllContactsActivity.this);
//
//				builder.setTitle("delete")
//						.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
//							@Override
//							public void onClick(DialogInterface dialog, int which) {
//								String whereClause = "_id=?";
//								String[] whereArgs = new String[] {String.valueOf(dbId)};
//
//								db.delete(ContactDBHelper.TABLE_NAME,whereClause,whereArgs);
//							}
//						})
//						.setNegativeButton("삭제안함",null)
//						.show();
//
//
//
//				return true;
//			}
//		});
//
//
	}

	@Override
	protected void onResume() {
		super.onResume();
//        DB에서 데이터를 읽어와 Adapter에 설정
        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("select * from " + ContactDBHelper.TABLE_NAME, null);

        myCursorAdapter.changeCursor(cursor);
        helper.close();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
//        cursor 사용 종료
		if (cursor != null) cursor.close();
	}

}




