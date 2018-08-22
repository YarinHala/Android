package yarinhala.com.shenkar.mastermindsafeedition;


import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Levels extends AppCompatActivity{
    final static String LEVEL_VALUE = "yarinhala.com.shenkar.mastermindsafeedition.LEVEL_VALUE";

    private  MusicManager musicManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_levels);
        musicManager = MusicManager.getMusicManager(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        musicManager.buttonClick();
        Intent mIntent = new Intent(this,MainActivity.class);
        finishAffinity();
        startActivity(mIntent);

    }


    protected void whichLevelClicked(View view){
        int level = Integer.parseInt(view.getTag().toString());
        musicManager.buttonClick();
        Intent intent = new Intent(this,Game.class);
        intent.putExtra(LEVEL_VALUE,level);
        startActivity(intent);
    }



    @Override
    protected void onPause() {
        super.onPause();
            musicManager.stopMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        musicManager.startMusic();

    }
}
