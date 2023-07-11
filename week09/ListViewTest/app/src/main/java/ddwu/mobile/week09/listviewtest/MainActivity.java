package ddwu.mobile.week09.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();
        ArrayList<String> subjectList = dataManager.getSubjectList();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,subjectList);

        ListView listView = findViewById(R.id.listView);

        //연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(itemClickListener);


    }

    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                    Toast.makeText(MainActivity.this
                            , dataManager.getSubject(pos)
                            , Toast.LENGTH_SHORT).show();
                    dataManager.removeData(pos);//삭제
                    adapter.notifyDataSetChanged();//삭제한 결과를 notify 해주기
                }
            };
}