package ddwucom.mobile.test13.exam01;

public class Food {
    private long _id;  //db 가져올땐 _id를 primary key로 여기기에 약속임!!
    private String food;
    private String nation;

    public Food(long _id, String food, String nation) {
        this._id = _id;
        this.food = food;
        this.nation = nation;
    }
    public Food(String food, String nation) {
        //this._id = _id;
        this.food = food;
        this.nation = nation;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
      return _id + ". " +
                food + " (" +
                nation +")";
    }
}
