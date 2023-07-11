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

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Movie movie;

    EditText etTitle;
    EditText etDirector;
    EditText etActor;
    TextView etReleaseDate;
    EditText etStory;
    ImageView imageView;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        movie = (Movie) getIntent().getSerializableExtra("movie");

        etTitle = findViewById(R.id.et_movieTitle);
        etDirector = findViewById(R.id.et_director);
        etActor = findViewById(R.id.et_actor);
        etReleaseDate = (TextView) findViewById(R.id.et_releaseDate);
        etStory = findViewById(R.id.et_story);
        imageView = (ImageView) findViewById(R.id.update_image);

        etTitle.setText(movie.getTitle());
        etDirector.setText(movie.getDirector());
        etActor.setText(movie.getActor());
        etReleaseDate.setText(movie.getReleaseDate());
        etStory.setText(movie.getStory());

        if("해리 포터와 마법사의 돌".equals(etTitle.getText().toString()))
            imageView.setImageResource(R.mipmap.harrypotter);
        else if("범죄도시2".equals(etTitle.getText().toString()))
            imageView.setImageResource(R.mipmap.crimecity);
        else if("어벤져스:엔드게임".equals(etTitle.getText().toString()))
            imageView.setImageResource(R.mipmap.avengers);
        else if("트와일라잇".equals(etTitle.getText().toString()))
            imageView.setImageResource(R.mipmap.twilight);
        else if("하울의 움직이는 성".equals(etTitle.getText().toString()))
            imageView.setImageResource(R.mipmap.howl);
        else if("기생충".equals(etTitle.getText().toString()))
            imageView.setImageResource(R.mipmap.parasite);
        else
            imageView.setImageResource(R.mipmap.ic_launcher);

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


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                movie.setTitle(etTitle.getText().toString());
                movie.setDirector(etDirector.getText().toString());
                movie.setActor(etActor.getText().toString());
                movie.setReleaseDate(etReleaseDate.getText().toString());
                movie.setStory(etStory.getText().toString());
                movie.setResId(imageView.getId());
//                if (movieDBManager.modifyMovie(movie)) {
//                    Intent resultIntent = new Intent();
//                    resultIntent.putExtra("movie", movie);
//                    setResult(RESULT_OK, resultIntent);
//                } else {
//                    setResult(RESULT_CANCELED);
//                }

                if(etTitle.getText().toString().equals("")||etDirector.getText().toString().equals("")||etActor.getText().toString().equals("")||etReleaseDate.getText().toString().equals("")||etStory.getText().toString().equals("")){
                    Toast.makeText(this,"빈칸을 모두 입력하시오.",Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED);
                } else if (movieDBManager.modifyMovie(movie)) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("movie", movie);
                    setResult(RESULT_OK, resultIntent);
                } else {
                    setResult(RESULT_CANCELED);
                }


                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
