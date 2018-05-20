package yarinhala.com.shenkar.androidclassexlist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DateDoa {

    @Query("SELECT * FROM PickenDate order by difference")
    List<PickenDate> getAllDates();

    @Query("DELETE FROM PickenDate")
    void  deleteAll();

    @Insert
    void insertAllDate(PickenDate... dates);
}
