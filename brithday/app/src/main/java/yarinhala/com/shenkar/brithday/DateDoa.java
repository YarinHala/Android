package yarinhala.com.shenkar.brithday;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DateDoa {

    @Query("SELECT * FROM PickenDate")
    List<PickenDate> getAllDates();

    @Insert
    void insertAllDate(PickenDate... dates);
}
