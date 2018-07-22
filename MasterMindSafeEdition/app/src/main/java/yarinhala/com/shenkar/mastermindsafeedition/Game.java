package yarinhala.com.shenkar.mastermindsafeedition;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    private int number_picketed;
    private TextView textView_picketed;
    private String number_str;
    private Button button;
    private TextView[] result = new TextView[4];
    private TextView[] tempGuess = new TextView[4];
    private int[] pinsStatus = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
        number_picketed = 0;
        number_str = "";

        Random r = new Random();
        result[0] = findViewById(R.id.r0);
        result[1] = findViewById(R.id.r1);
        result[2] = findViewById(R.id.r2);
        result[3] = findViewById(R.id.r3);

        for (int i = 0 ;i < 4 ; i++){
            result[i].setText(Integer.toString(r.nextInt(10)));
            /*need to hide safe code setVisibility(View.INVISIBLE);*/
        }


    }

    public void ButtonOnClick(View view){
        button = (Button)view;
        number_str = button.getText().toString();
        number_picketed = Integer.parseInt(number_str);
    }

    public void GuessOnClick(View view){
        textView_picketed = (TextView)view;
        textView_picketed.setText(Integer.toString(number_picketed));
    }


    public void CheckResult( View v ) {
        switch (v.getId()) {
            case (R.id.check_result0):
                setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g0s0),findViewById(R.id.g0s1),
                                findViewById(R.id.g0s2),findViewById(R.id.g0s3)


                        ),
                        findViewById(R.id.g0pin0),findViewById(R.id.g0pin1),
                        findViewById(R.id.g0pin2),findViewById(R.id.g0pin3)

                );
                v.setVisibility(View.INVISIBLE);
                break;
            case (R.id.check_result1):

                setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g1s0),findViewById(R.id.g1s1),
                                findViewById(R.id.g1s2),findViewById(R.id.g1s3)
                        ),
                        findViewById(R.id.g1pin0),findViewById(R.id.g1pin1),
                        findViewById(R.id.g1pin2),findViewById(R.id.g1pin3)

                );
                v.setVisibility(View.INVISIBLE);
                break;
            case (R.id.check_result2):

                setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g2s0),findViewById(R.id.g2s1),
                                findViewById(R.id.g2s2),findViewById(R.id.g2s3)
                        ),
                        findViewById(R.id.g2pin0),findViewById(R.id.g1pin1),
                        findViewById(R.id.g2pin2),findViewById(R.id.g2pin3)

                );
                v.setVisibility(View.INVISIBLE);
                break;

        }
    }

    public int[] checkResultWithParams(View v0,View v1 ,View v2 , View v3){
        tempGuess[0] = (TextView)v0;
        tempGuess[1] = (TextView)v1;
        tempGuess[2] = (TextView)v2;
        tempGuess[3] = (TextView)v3;

        v0.setOnClickListener(null);
        v1.setOnClickListener(null);
        v2.setOnClickListener(null);
        v3.setOnClickListener(null);


        // Total number of pins in the answer.
        int pins = 0;

        // Number of black pins in the answer.
        int white = 0;

        // Number of times each color appears in the code and the guess.
        int[] codeColorCount = new int[10];
        int[] guessColorCount = new int[10];

        for (int i = 0; i < result.length; i++) {
            int c = Integer.parseInt(result[i].getText().toString());
            int g = Integer.parseInt(tempGuess[i].getText().toString());
            ++ codeColorCount[c];
            ++ guessColorCount[g];
            if (c == g) {
                ++ white;
            }
        }

        for (int i = 0; i < 10; i++) {
            pins += Math.min(codeColorCount[i], guessColorCount[i]);
        }
        Log.d("MSG","/******************************************/");
        Log.d("MSG","code: "+ result.toString());
        Log.d("MSG","white: " + Integer.toString(white));
        Log.d("MSG","black: "+ Integer.toString(+ pins - white));
        Log.d("MSG","mistake "+Integer.toString(result.length - pins));
        Log.d("MSG","/******************************************/");

        pinsStatus[0] = white;
        pinsStatus[1] = pins - white;
        pinsStatus[2] = result.length - pins;

       return pinsStatus;
    }

    public int setResultOnPins(int[] result_pins,View v0,View v1 ,View v2 , View v3){

        ImageView[] pin_img = new ImageView[4];
        pin_img[0] =  (ImageView)v0;
        pin_img[1] =  (ImageView)v1;
        pin_img[2] =  (ImageView)v2;
        pin_img[3] =  (ImageView)v3;

        Log.d("MSG","/******************************************/");

        int i = 0;
        for(int j = 0 ; i < result_pins.length ; j++) {
            while (result_pins[j] > 0) {

                if(j == 0) {
                    pin_img[i].setImageResource(R.drawable.signal_true);
                    Log.d("status","signal_true");
                }
                if(j == 1) {
                    pin_img[i].setImageResource(R.drawable.signal_exist);
                    Log.d("status","signal_exist");
                }
                if(j == 2) {
                    pin_img[i].setImageResource(R.drawable.signal_false);
                    Log.d("status","signal_false");
                }
                i++;
                --result_pins[j];
            }

        }
        Log.d("MSG","/******************************************/");




        return 1;
    }
}
