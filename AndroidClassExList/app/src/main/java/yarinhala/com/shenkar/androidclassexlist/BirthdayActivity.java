package yarinhala.com.shenkar.androidclassexlist;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;


public class BirthdayActivity  extends AppCompatActivity  {

    private static final String TAG = BirthdayActivity.class.getSimpleName();
    FloatingActionButton fab,fab2;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    static AppDataBase db;
    static List<PickenDate> dates;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_birthday);
            //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);
            recyclerView = findViewById(R.id.recycler_view);

            db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"prodaction").allowMainThreadQueries().build();

            dates = BirthdayActivity.db.dateDao().getAllDates();
            db.dateDao().deleteAll();

            Log.d(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            for (PickenDate tempDates :dates) {
                db.dateDao().insertAllDate(tempDates);
                Log.d(TAG, tempDates.getDate() +" - "+ Integer.toString( tempDates.getDifference()));
                Log.d(TAG, "----------------------------");
            }
            Log.d(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new DateAdapter(db.dateDao().getAllDates());
            recyclerView.setAdapter(adapter);

            fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BirthdayActivity.this,CreateDate.class));
                }
            });

            fab2 = findViewById(R.id.fab2);
            fab2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.dateDao().deleteAll();
                    startActivity(new Intent(BirthdayActivity.this,BirthdayActivity.class));
                }
            });
        }
}



