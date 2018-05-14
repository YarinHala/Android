package yarinhala.com.shenkar.androidclassexlist;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;


public class BirthdayActivity  extends AppCompatActivity  {

        FloatingActionButton fab;
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        static AppDataBase db;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_birthday);
            //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);
            recyclerView = findViewById(R.id.recycler_view);


            db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"prodaction").allowMainThreadQueries().build();

            List<PickenDate> dates =  db.dateDao().getAllDates();

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new DateAdapter(dates);
            recyclerView.setAdapter(adapter);

            fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BirthdayActivity.this,CreateDate.class));
                }
            });


        }
}



