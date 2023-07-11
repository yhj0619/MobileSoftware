package dduwcom.mobile.finalreport;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.Serializable;

public class Movie implements Serializable {
    private long _id;
    private String title;
    private String director;
    private String actor;
    private String releaseDate;
    private String story;
    int resId;

    public Movie(long _id, String title, String director, String actor, String releaseDate, String story) {
        this._id = _id;
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.releaseDate = releaseDate;
        this.story = story;
    }

    public Movie(String title, String director, String actor, String releaseDate, String story, int resId) {
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.releaseDate = releaseDate;
        this.story = story;
        this.resId = resId;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
