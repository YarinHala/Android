package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.graphics.Color;
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
    final static String SCORE = "yarinhala.com.shenkar.mastermindsafeedition.SCORE";
    final static String WIN_OR_LOSE = "yarinhala.com.shenkar.mastermindsafeedition.WIN_OR_LOSE";



    private int number_picketed;
    private TextView textView_picketed;
    private String number_str;
    private Button button;
    private TextView[] result = new TextView[4];
    private TextView[] tempGuess = new TextView[4];
    private int[] pinsStatus = new int[3];
    private Boolean[] gameStatus = new Boolean[36];
    private int currentSlotPlayed;
    private int levelNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        int level_num = intent.getIntExtra(Levels.LEVEL_VALUE,1);

        number_picketed = 0;
        number_str = "";
        currentSlotPlayed = 0;
        Random r = new Random();
        result[0] = findViewById(R.id.r0);
        result[1] = findViewById(R.id.r1);
        result[2] = findViewById(R.id.r2);
        result[3] = findViewById(R.id.r3);
        findViewById(R.id.d0).setBackgroundColor(Color.BLACK);
        levelNumber = level_num;
        for (int i = 0 ;i < 4 ; i++){
            result[i].setText(Integer.toString(r.nextInt(10)));
            /*need to hide safe code setVisibility(View.INVISIBLE);*/
        }

        for (int i = 0 ; i < gameStatus.length ; i ++){
            gameStatus[i] = false;
        }
        clearAllArrowsBackground(level_num);
    }

    public void ButtonOnClick(View view){
        button = (Button)view;
        number_str = button.getText().toString();
        number_picketed = Integer.parseInt(number_str);
        clearAllButtonsBackground();
        view.setBackgroundColor(Color.BLACK);
    }

    public void clearAllButtonsBackground(){
        findViewById(R.id.d0).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d1).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d2).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d3).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d4).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d5).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d6).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d7).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d8).setBackgroundColor(0xff5b5b5b);
        findViewById(R.id.d9).setBackgroundColor(0xff5b5b5b);
    }

    public void clearAllArrowsBackground(int whichLevelPicked){
        findViewById(R.id.check_result1).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result2).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result3).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result4).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result5).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result6).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result7).setVisibility(View.INVISIBLE);
        findViewById(R.id.check_result8).setVisibility(View.INVISIBLE);

        if(whichLevelPicked > 1){
            findViewById(R.id.Guess_8).setVisibility(View.INVISIBLE);
        }
        if(whichLevelPicked > 2){
            findViewById(R.id.Guess_7).setVisibility(View.INVISIBLE);
        }
        if(whichLevelPicked > 3){
            findViewById(R.id.Guess_6).setVisibility(View.INVISIBLE);
        }
        if(whichLevelPicked > 4){
            findViewById(R.id.Guess_5).setVisibility(View.INVISIBLE);
        }
    }

    public void GuessOnClick(View view){
        textView_picketed = (TextView)view;
        textView_picketed.setText(Integer.toString(number_picketed));
        int id = Integer.parseInt(textView_picketed.getTag().toString());
        gameStatus[id] = true;
        int i = currentSlotPlayed;

        if(gameStatus[i] == true && gameStatus[i+1] == true && gameStatus[i+2] == true && gameStatus[i+3] == true ){
            currentSlotPlayed+=4;
            Log.d("MSG","currentSlotPlayed: " + currentSlotPlayed);

            setVisibleOfArrow(currentSlotPlayed);
        }
    }

    public void setVisibleOfArrow(int currentSlots){
        switch (currentSlots) {
            case (4):
                findViewById(R.id.check_result0).setVisibility(View.VISIBLE);
                break;
            case (8):
                findViewById(R.id.check_result1).setVisibility(View.VISIBLE);
                break;
            case (12):
                findViewById(R.id.check_result2).setVisibility(View.VISIBLE);
                break;
            case (16):
                findViewById(R.id.check_result3).setVisibility(View.VISIBLE);
                break;
            case (20):
                findViewById(R.id.check_result4).setVisibility(View.VISIBLE);
                break;
            case (24):
                findViewById(R.id.check_result5).setVisibility(View.VISIBLE);
                break;
            case (28):
                findViewById(R.id.check_result6).setVisibility(View.VISIBLE);
                break;
            case (32):
                findViewById(R.id.check_result7).setVisibility(View.VISIBLE);
                break;
            case (36):
                findViewById(R.id.check_result8).setVisibility(View.VISIBLE);
                break;

        }
    }

    public void CheckResult( View v ) {
        int if_win = 0;
        switch (v.getId()) {
            case (R.id.check_result0):
                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g0s0),findViewById(R.id.g0s1),
                                findViewById(R.id.g0s2),findViewById(R.id.g0s3)
                        ),
                        findViewById(R.id.g0pin0),findViewById(R.id.g0pin1),
                        findViewById(R.id.g0pin2),findViewById(R.id.g0pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g1s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g1s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g1s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g1s3).setVisibility(View.VISIBLE);
                break;
            case (R.id.check_result1):
                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g1s0),findViewById(R.id.g1s1),
                                findViewById(R.id.g1s2),findViewById(R.id.g1s3)
                        ),
                        findViewById(R.id.g1pin0),findViewById(R.id.g1pin1),
                        findViewById(R.id.g1pin2),findViewById(R.id.g1pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g2s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g2s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g2s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g2s3).setVisibility(View.VISIBLE);
                break;
            case (R.id.check_result2):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g2s0),findViewById(R.id.g2s1),
                                findViewById(R.id.g2s2),findViewById(R.id.g2s3)
                        ),
                        findViewById(R.id.g2pin0),findViewById(R.id.g2pin1),
                        findViewById(R.id.g2pin2),findViewById(R.id.g2pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g3s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g3s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g3s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g3s3).setVisibility(View.VISIBLE);
                break;
            case (R.id.check_result3):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g3s0),findViewById(R.id.g3s1),
                                findViewById(R.id.g3s2),findViewById(R.id.g3s3)
                        ),
                        findViewById(R.id.g3pin0),findViewById(R.id.g3pin1),
                        findViewById(R.id.g3pin2),findViewById(R.id.g3pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g4s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g4s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g4s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g4s3).setVisibility(View.VISIBLE);
                checkLevelContinuation();
                break;
            case (R.id.check_result4):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g4s0),findViewById(R.id.g4s1),
                                findViewById(R.id.g4s2),findViewById(R.id.g4s3)
                        ),
                        findViewById(R.id.g4pin0),findViewById(R.id.g4pin1),
                        findViewById(R.id.g4pin2),findViewById(R.id.g4pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g5s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g5s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g5s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g5s3).setVisibility(View.VISIBLE);
                checkLevelContinuation();
                break;
            case (R.id.check_result5):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g5s0),findViewById(R.id.g5s1),
                                findViewById(R.id.g5s2),findViewById(R.id.g5s3)
                        ),
                        findViewById(R.id.g5pin0),findViewById(R.id.g5pin1),
                        findViewById(R.id.g5pin2),findViewById(R.id.g5pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g6s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g6s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g6s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g6s3).setVisibility(View.VISIBLE);
                checkLevelContinuation();
                break;
            case (R.id.check_result6):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g6s0),findViewById(R.id.g6s1),
                                findViewById(R.id.g6s2),findViewById(R.id.g6s3)
                        ),
                        findViewById(R.id.g6pin0),findViewById(R.id.g6pin1),
                        findViewById(R.id.g6pin2),findViewById(R.id.g6pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g7s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g7s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g7s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g7s3).setVisibility(View.VISIBLE);
                checkLevelContinuation();
                break;
            case (R.id.check_result7):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g7s0),findViewById(R.id.g7s1),
                                findViewById(R.id.g7s2),findViewById(R.id.g7s3)
                        ),
                        findViewById(R.id.g7pin0),findViewById(R.id.g7pin1),
                        findViewById(R.id.g7pin2),findViewById(R.id.g7pin3)

                );
                v.setVisibility(View.INVISIBLE);
                findViewById(R.id.g8s0).setVisibility(View.VISIBLE);
                findViewById(R.id.g8s1).setVisibility(View.VISIBLE);
                findViewById(R.id.g8s2).setVisibility(View.VISIBLE);
                findViewById(R.id.g8s3).setVisibility(View.VISIBLE);
                checkLevelContinuation();
                break;
            case (R.id.check_result8):

                if_win = setResultOnPins(
                        checkResultWithParams(
                                findViewById(R.id.g8s0),findViewById(R.id.g8s1),
                                findViewById(R.id.g8s2),findViewById(R.id.g8s3)
                        ),
                        findViewById(R.id.g8pin0),findViewById(R.id.g8pin1),
                        findViewById(R.id.g8pin2),findViewById(R.id.g8pin3)
                );
                v.setVisibility(View.INVISIBLE);

                break;

        }
        if(if_win == 1){
            win_game();
        }
        else{
            lose_game();
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


        if(result_pins[0] == 4){
            return 1;
        }

        return 0;
    }

    /*if reach to lvl limit end game*/
    public void checkLevelContinuation(){

        if(levelNumber > 0){}

    }



    public void win_game(){
        showResult();
        int score =1;
        String string = "you win";
        Intent intent = new Intent();
        intent.putExtra(SCORE,score);
        intent.putExtra(WIN_OR_LOSE,string);
        startActivity(intent);
    }

    public void lose_game(){
        showResult();
        int score =1;
        String string = "you lose";
        Intent intent = new Intent();
        intent.putExtra(SCORE,score);
        intent.putExtra(WIN_OR_LOSE,string);
        startActivity(intent);

    }

    public  void showResult(){
        findViewById(R.id.r0).setVisibility(View.VISIBLE);
        findViewById(R.id.r1).setVisibility(View.VISIBLE);
        findViewById(R.id.r2).setVisibility(View.VISIBLE);
        findViewById(R.id.r3).setVisibility(View.VISIBLE);
    }




}

