package yarinhala.com.shenkar.androidclassexlist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import java.util.List;

public class CreateDate extends AppCompatActivity{

    private Button btn;
    private Button btn2;
    private EditText name;
    int year_x,month_x,day_x;
    int sum;
    static final int DIALOG_ID = 0;
    private EditText dateLabel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_date);

        final Calendar cal  = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);


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
                BirthdayActivity.db.dateDao().insertAllDate(new PickenDate(name.getText().toString(),dateLabel.getText().toString()));
                List<PickenDate> dates;
                //db.dateDao().deleteAll();

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
            sum = 1;

            dateLabel = findViewById(R.id.editTextDate);
            dateLabel.setText(dayOfMonth + "/" +month+"/"+year+"");
            name = findViewById(R.id.editName);


        }
    };


}



