package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

public class PopUp extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.75), (int) (height * 0.75));


    }

    protected void whereToContinue(View view) {
        /*
        int level = Integer.parseInt(view.getTag().toString());

        if(level < 6 && level > 0){
            Intent intent = new Intent(this,Game.class);
            intent.putExtra(LEVEL_VALUE,level);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, Game.class);
            intent.putExtra(LEVEL_VALUE, 1);
            startActivity(intent);
        }
        */
    }

}



