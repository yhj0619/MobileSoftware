package ddwu.mobile.week09.adapterclicktest;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("사과");
        subjectList.add("딸기");
        subjectList.add("복숭아");
        subjectList.add("수박");
        subjectList.add("참외");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    public String getClick(int idx){return subjectList.get(idx);}

    //    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

    //    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

    public void modifyData(int idx, String str){ subjectList.set(idx,str); }


}
