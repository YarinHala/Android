package yarinhala.com.shenkar.mastermindsafeedition;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  MusicManager musicManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        Button levels_btn = findViewById(R.id.start_game);
        Button scores_btn = findViewById(R.id.scores_table);
        Button instructions_btn = findViewById(R.id.instructions);
        Button options_btn = findViewById(R.id.options);
        Button exit_btn = findViewById(R.id.exit);

        musicManager = MusicManager.getMusicManager(this);
        musicManager.startMusic();


        levels_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicManager.buttonClick();
                startActivity(new Intent(MainActivity.this, Levels.class));
            }
        });

        scores_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicManager.buttonClick();
                //startActivity(new Intent(MainActivity.this, Scores.class));
            }
        });

        instructions_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicManager.buttonClick();
                startActivity(new Intent(MainActivity.this, Instructions.class));
            }
        });

        options_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicManager.buttonClick();
                startActivity(new Intent(MainActivity.this, Options.class));
            }
        });

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicManager.buttonClick();
                musicManager.stopMusic();

                finish();
                System.exit(0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //backgroundsong.stop();
        musicManager.buttonClick();
        musicManager.stopMusic();
        finish();
        System.exit(0);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MSG-ON-MainActivity","onPause");
            musicManager.stopMusic();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MSG-ON-MainActivity","onResume");
        musicManager.startMusic();
    }

}