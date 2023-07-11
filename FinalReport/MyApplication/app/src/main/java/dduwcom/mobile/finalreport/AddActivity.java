package dduwcom.mobile.finalreport;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etDirector;
    EditText etActor;
    TextView etReleaseDate;
    EditText etStory;
    ImageView imageView;
    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.et_movieTitle);
        etDirector = findViewById(R.id.et_director);
        etActor = findViewById(R.id.et_actor);
        etReleaseDate = (TextView)findViewById(R.id.et_releaseDate);
        etStory = findViewById(R.id.et_story);
        imageView = (ImageView) findViewById(R.id.add_image);

        movieDBManager = new MovieDBManager(this);

    }
    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            etReleaseDate.setText(String.format("%d년%d월%d일", year,month,dayOfMonth));
        }
    };


    public void OnButtonClick(View v)
    {
        new DatePickerDialog(this,dateSetListener,2022,6,24).show();
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_add:
                boolean result = movieDBManager.addNewMovie(
                        new Movie(etTitle.getText().toString(),etDirector.getText().toString(),etActor.getText().toString(),etReleaseDate.getText().toString(),etStory.getText().toString(),imageView.getId()));

                if(etTitle.getText().toString().equals("")||etDirector.getText().toString().equals("")||etActor.getText().toString().equals("")||etReleaseDate.getText().toString().equals("")||etStory.getText().toString().equals("")){
                    Toast.makeText(this,"빈칸을 모두 입력하시오.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("movie", etTitle.getText().toString() );
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                break;
            case R.id.btn_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
