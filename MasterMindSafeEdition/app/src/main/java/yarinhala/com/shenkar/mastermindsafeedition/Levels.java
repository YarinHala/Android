package yarinhala.com.shenkar.mastermindsafeedition;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Levels extends AppCompatActivity{
    final static String LEVEL_VALUE = "yarinhala.com.shenkar.mastermindsafeedition.LEVEL_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
    }


    protected void whichLevelClicked(View view){
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
    }
}
