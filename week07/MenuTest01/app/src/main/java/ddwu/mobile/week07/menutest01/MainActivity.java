package ddwu.mobile.week07.menutest01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item03:
                Toast.makeText(this,"짜장면 맛있어요!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item04:
                Toast.makeText(this,"짬뽕 맛있어요!",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    public void onMenuClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.item05:
                Toast.makeText(this,"김치찌개 맛있어요!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item06:
                Toast.makeText(this,"순두부찌개 맛있어요!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}