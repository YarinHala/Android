package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Options extends AppCompatActivity {

    private  MusicManager musicManager;
    private  int musicStatus = 0;
    private Switch music;
    private Switch effect;
    private Switch time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        musicManager = MusicManager.getMusicManager(this);

        music = findViewById(R.id.musicSwitch);
        effect = findViewById(R.id.effectSwitch);
        time = findViewById(R.id.onTimeSwitch);


        if(musicManager.getIsMute() == 0){
            music.setChecked(true);
        }else{
            music.setChecked(false);
        }



        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    musicStatus = 0;
                }else{

                    musicStatus = 1;
                }
                musicManager.muteMusic(musicStatus);
            }
        });


        effect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent(this,MainActivity.class);
        finishAffinity();
        startActivity(mIntent);

    }

}
