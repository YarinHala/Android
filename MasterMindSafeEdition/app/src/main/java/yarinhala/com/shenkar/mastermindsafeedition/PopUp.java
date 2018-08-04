package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PopUp extends AppCompatActivity {
    final static String LEVEL_VALUE = "yarinhala.com.shenkar.mastermindsafeedition.LEVEL_VALUE";
    private int level,score,status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.75), (int) (height * 0.75));


        Intent intent = getIntent();
        status = intent.getIntExtra(Game.WIN_OR_LOSE,2);
        score = intent.getIntExtra(Game.SCORE,1);
        level = intent.getIntExtra(Game.SCORE,1);

        EditText statusView = findViewById(R.id.statusView);
        EditText scoreView = findViewById(R.id.scoreNumView);

        if(status == 0) {
            statusView.setText("Try Again");
        }else{
            statusView.setText("Congratulations!");
        }
        scoreView.setText(score);
    }

    public void backToMenuMain(){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void continueToNextLevel(){
        Intent intent = new Intent(this,Game.class);
        if(level == 5){backToMenuMain();}
        intent.putExtra(LEVEL_VALUE,level+1);
        startActivity(intent);
    }

}



