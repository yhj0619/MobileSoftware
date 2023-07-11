package ddwucom.mobile.week11.exam01;

import android.widget.ListView;

import java.util.ArrayList;

public class FoodManager {

    ListView listView;
    private ArrayList<Food> foodList;

    public FoodManager(){
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
    }
    public ArrayList<Food> getSubjectList() {
        return foodList;
    }

    public Food getClick(int idx){return foodList.get(idx);}

    //    추가
    public void addData(String newFood, String newCountry) {  foodList.add(new Food(newFood,newCountry));  }

    //    삭제
    public void removeData(int idx) {
        foodList.remove(idx);
    }
}

