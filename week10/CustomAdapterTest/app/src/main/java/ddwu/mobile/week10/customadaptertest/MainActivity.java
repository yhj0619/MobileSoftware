package ddwu.mobile.week10.customadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyData> myDataList;
    private MyAdapter myAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataList = new ArrayList<MyData>();

        myDataList.add(new MyData(1,"홍길동","012345"));
        myDataList.add(new MyData(2,"전우치","123456"));
        myDataList.add(new MyData(3,"일지매","234567"));

        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view,myDataList);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(myAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,myDataList.get(position).getName(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}