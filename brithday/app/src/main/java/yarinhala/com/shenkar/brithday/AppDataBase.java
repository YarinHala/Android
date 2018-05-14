package yarinhala.com.shenkar.brithday;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {PickenDate.class}, version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase{

    public abstract  DateDoa dateDao();

}
