package yarinhala.com.shenkar.mastermindsafeedition;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Levels extends AppCompatActivity{
    final static String LEVEL_VALUE = "yarinhala.com.shenkar.mastermindsafeedition.LEVEL_VALUE";
    private MediaPlayer buttonEffect = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_levels);
        buttonEffect = MediaPlayer.create(this, R.raw.buttoneffect);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent(this,MainActivity.class);
        finishAffinity();
        startActivity(mIntent);

    }


    protected void whichLevelClicked(View view){
        int level = Integer.parseInt(view.getTag().toString());
        buttonEffect.start();
        Intent intent = new Intent(this,Game.class);
        intent.putExtra(LEVEL_VALUE,level);
        startActivity(intent);
    }
}
