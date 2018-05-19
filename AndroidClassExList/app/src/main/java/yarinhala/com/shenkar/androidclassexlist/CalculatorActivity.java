package yarinhala.com.shenkar.androidclassexlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView screen;
    private String resultStr,numberStr,signStr,tempSignStr;
    private double firstNum;
    private double secondNum;
    private double result;
    private boolean signCounter,numOneSet,numTwoSet;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        screen = findViewById(R.id.resultText);
        numberStr = "";
        signStr = "";
        resultStr ="";
        tempSignStr="";
        firstNum = 0;
        secondNum = 0;
        result = 0;
        signCounter = false;
        numOneSet = false;
        numTwoSet = false;

    }

    public void ButtonOnClick(View view){
        button = (Button)view;

        if(button.getText().toString().equals("0")  && numberStr.length() == 0){
            screen.setText("0");
            return;
        }

        if(!(button.getText().toString().equals("0")) && screen.getText().toString().equals("0") ){
            screen.setText("");
        }

        if(button.getText().toString().equals(".") && (screen.getText().toString().equals("0") || screen.getText().toString().equals("") ) ){
            numberStr ="0";
        }

        numberStr +=button.getText().toString();
        screen.setText(numberStr);
        firstNum = Double.parseDouble(numberStr);
        numOneSet = true;
    }

    public void onClickSigns(View view){
        button = (Button)view;
        signStr = button.getText().toString();
        screen.setText(signStr);

        if(!signCounter) {
            signCounter = true;
            secondNum = firstNum;
            numTwoSet = true;
            numOneSet = false;
            numberStr = "";
            tempSignStr = signStr;
        }

        if(numTwoSet && numOneSet && signCounter){
            if(tempSignStr.compareTo(signStr) != 0){
                signStr = tempSignStr;
            }
            onCalculator(null);
            signStr = button.getText().toString();
            tempSignStr = signStr;
            signCounter = true;
            secondNum = firstNum;
            numberStr ="";
            numTwoSet = true;
            numOneSet = false;
        }
    }

    public void onClickClear(View view){
        screen.setText("");
        numberStr = "";
        signStr = "";
        tempSignStr ="";
        resultStr ="";
        firstNum = 0;
        secondNum = 0;
        result = 0;
        signCounter = false;
        numTwoSet = false;
        numOneSet = false;

    }

    public void onCalculator(View view){


        if(signStr.equals("+")){
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
        firstNum = result;
        numberStr = resultStr;
        signCounter = false;
        numTwoSet = false;
        numOneSet = true;

    }



}
