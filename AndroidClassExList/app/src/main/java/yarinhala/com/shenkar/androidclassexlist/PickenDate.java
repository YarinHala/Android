package yarinhala.com.shenkar.androidclassexlist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class PickenDate {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "arrange")
    private int arrange;

    @ColumnInfo(name = "difference")
    private int difference;

    public PickenDate(String name, String date,int arrange,int difference) {
        this.name = name;
        this.date = date;
        this.arrange = arrange;
        this.difference = difference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrange() {
        return arrange;
    }

    public void setArrange(int arrange) {
        this.arrange = arrange;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }
}

