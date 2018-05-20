package yarinhala.com.shenkar.androidclassexlist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.List;

public class CreateDate extends AppCompatActivity{

    private static final String TAG = CreateDate.class.getSimpleName();
    private Button btn;
    private Button btn2;
    private EditText name;
    private int arrange = 0,difference = 0;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;
    private EditText dateLabel;
    private  List<PickenDate> dates;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_date);

        final Calendar cal  = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH)+1;
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        dateLabel = findViewById(R.id.editTextDate);
        dateLabel.setText(day_x + "/" +month_x+"/"+year_x+"");
        name = findViewById(R.id.editName);
        name.setText("Insert Your Name");
        showDialogOnClick();


    }

    public void showDialogOnClick(){
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.addToDataBaseBth);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arrange = (year_x*10000) + (month_x*100) + day_x;

                Calendar cal2  = Calendar.getInstance();
                int currentYear = cal2.get(Calendar.YEAR);
                int currentMonth = cal2.get(Calendar.MONTH) + 1;
                int currentDay = cal2.get(Calendar.DAY_OF_MONTH);

                difference = (currentYear*10000) + (currentMonth*100) + currentDay;
                Log.d(TAG, Integer.toString(difference) +"-"+  Integer.toString(arrange));

                difference = arrange - difference;
                if(difference < 0){difference = arrange;}
                Log.d(TAG, Integer.toString(difference));


                BirthdayActivity.db.dateDao().insertAllDate(new PickenDate(name.getText().toString(),dateLabel.getText().toString(),arrange,difference));
                startActivity(new Intent(CreateDate.this,BirthdayActivity.class));
            }
        });
    }




    @Override
    protected Dialog onCreateDialog(int id){

        if(id == DIALOG_ID){
            return new DatePickerDialog(this,dpickerLister,year_x,month_x,day_x);
        }
        else {
            return null;
        }
    }

    private  DatePickerDialog.OnDateSetListener dpickerLister=new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;

            dateLabel.setText(dayOfMonth + "/" +month+"/"+year+"");
            //name = findViewById(R.id.editName);


        }
    };


}



