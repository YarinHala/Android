package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    MediaPlayer beckgroundsong;
    MediaPlayer buttonEffect;
    AudioManager amanger;
    int currentvol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        amanger = (AudioManager)getSystemService(AUDIO_SERVICE);

        beckgroundsong = MediaPlayer.create(this,R.raw.launchapp);
        beckgroundsong.setLooping(true);
        beckgroundsong.start();

        buttonEffect=MediaPlayer.create(this,R.raw.buttoneffect);
    }

    public void onStartGame(final View view) {
        startActivity(new Intent(MainActivity.this,Game.class));
    }

}
