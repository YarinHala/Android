package yarinhala.com.shenkar.androidclassexlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView screen;
    private String resultStr,numberStr,signStr;
    private double firstNum;
    private double secondNum;
    private double result;
    private boolean signCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        screen = findViewById(R.id.resultText);
        numberStr = "";
        signStr = "";
        resultStr ="";
        firstNum = 0;
        secondNum = 0;
        result = 0;
        signCounter = false;
    }

    public void ButtonOnClick(View view){
        Button button = (Button)view;
        if(button.getText().toString().equals("0") == true && numberStr.length() == 0){
            screen.setText("0");
            return;
        }
        if(button.getText().toString().equals("0") == false && screen.getText().toString().equals("0") == true){
            screen.setText("");
        }
        numberStr +=button.getText().toString();
        screen.setText(numberStr);
        firstNum = Double.parseDouble(numberStr);
    }

    public void onClickSigns(View view){
        Button button = (Button)view;
        signStr = button.getText().toString();
        screen.setText(signStr);
        if(signCounter == false) {
            signCounter = true;

            if (result == 0 && resultStr.equals("") == true) {
                secondNum = firstNum;
            } else {
                secondNum = result;
                result = 0;
                resultStr = "";
            }
            firstNum = 0;
            numberStr = "";
        }

    }

    public void onClickClear(View view){
        screen.setText("");
        numberStr = "";
        signStr = "";
        resultStr ="";
        firstNum = 0;
        secondNum = 0;
        result = 0;
        signCounter = false;
    }

    public void calculator(){


        if(signStr.equals("+") == true){
            result = secondNum + firstNum;
        }
        if(signStr.equals("-")){
            result = secondNum - firstNum;
        }
        if(signStr.equals("/")){
            result = secondNum / firstNum;
        }
        if(signStr.equals("*")){
            result = secondNum * firstNum;
        }
        resultStr = String.valueOf(result);
        screen.setText(resultStr);
        signStr= "";
        secondNum = 0;
        firstNum = 0;
        signCounter = false;

    }



}
