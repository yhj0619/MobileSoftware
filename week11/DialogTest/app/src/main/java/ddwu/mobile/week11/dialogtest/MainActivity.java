package ddwu.mobile.week11.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity {

    int selectedItem = 0;
    boolean[] selectedItems = {false, false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        final ConstraintLayout orderLayout =
                (ConstraintLayout)View.inflate(this, R.layout.order_layout,null);

        switch (v.getId()){
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("대화상자 제목")
                      //  .setMessage("대화상자 메시지")
//                        .setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this,foods[which],Toast.LENGTH_SHORT).show();
//                            }
//                        })
                        //라디오버튼
//                        .setSingleChoiceItems(R.array.foods, selectedItem, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                selectedItem = which;
//                            }
//                        })
                      //체크박스
                        .setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                selectedItems[which] = isChecked;
                            }
                        })
                        .setView(orderLayout)
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setCancelable(false)
                        .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                            첫예제   Toast.makeText(MainActivity.this,"확인!!!",Toast.LENGTH_SHORT).show();
//                                //this만 하면 context 자리에 onClickListener이 들어오기에 MainActivity.this로 해줘야함
//
//                           라디오버튼 예제 세줄     String[] foods = getResources().getStringArray(R.array.foods);
//                                String food = foods[selectedItem];
//                                Toast.makeText(MainActivity.this, food, Toast.LENGTH_SHORT).show();

//                          체크박스 예제
                                  String[] foods = getResources().getStringArray(R.array.foods);
                                String result = "";
                                for(int idx = 0; idx < foods.length; idx++){
                                    if(selectedItems[idx]){
                                        result += foods[idx]+ " ";
                                    }
                                }
                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                                EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                                String product = etProduct.getText().toString();
                                Toast.makeText(MainActivity.this, product, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("대기버튼",null)
                        .setNegativeButton("취소버튼", null)
                        .show();
                break;

        }
    }
}