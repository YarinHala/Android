package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Level;

public class PopUp extends AppCompatActivity {
    final static String LEVEL_VALUE = "yarinhala.com.shenkar.mastermindsafeedition.LEVEL_VALUE";
    private int level,score,status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.pop_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.75), (int) (height * 0.75));


        Intent intent = getIntent();
        status = intent.getIntExtra(Game.WIN_OR_LOSE,2);
        score = intent.getIntExtra(Game.SCORE,1);
        level = intent.getIntExtra(Game.LEVEL,1);

        TextView statusView = findViewById(R.id.statusView);
        TextView scoreView = findViewById(R.id.scoreView);

        if(status == 0) {
            statusView.setText("Try Again");
        }else{
           statusView.setText("Congratulations!");
        }
        scoreView.setText(Integer.toString(score));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent(this,MainActivity.class);
        finishAffinity();
        startActivity(mIntent);


    }

    public void backToMenuMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        Log.d("MSG","back to menu");
        startActivity(intent);
    }

    public void continueToNextLevel(View view){
        if(level >= 5 && status == 1){
            backToMenuMain(view);
        }
        else {
            Intent intent = new Intent(this, Game.class);
            if (level < 5) {
                ++level;
            }
            Log.d("MSG", "level number: " + Integer.toString(level));
            intent.putExtra(LEVEL_VALUE, level);
            startActivity(intent);
        }
    }

}



