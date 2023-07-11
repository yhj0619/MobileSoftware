package ddwu.mobile.week09.listviewtest;

import java.util.ArrayList;

public class DataManager {

    ArrayList<String> subjectList;

    public DataManager(){
        subjectList = new ArrayList<>();
        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍");

    }
    public ArrayList<String> getSubjectList(){
        return subjectList;
    }
    public void addData(String newSubject){
        subjectList.add(newSubject);
    }
    public void removeData(int idx){
        subjectList.remove(idx);
    }

    public String getSubject(int idx){ //몇번째 항목인지 찾은 다음에 arrayList는 get()이용!!!!
        return subjectList.get(idx) + " 과목입니다";
        //원본데이터에서 해당하는 위치 항목인 과목명을 가져오기!!
    }

}
