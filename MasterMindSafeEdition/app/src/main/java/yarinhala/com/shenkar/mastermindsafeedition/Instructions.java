package yarinhala.com.shenkar.mastermindsafeedition;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.security.Key;

public class Instructions extends AppCompatActivity {

    private  MusicManager musicManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_instructions);

        musicManager = MusicManager.getMusicManager(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent(this,MainActivity.class);
        finishAffinity();
        startActivity(mIntent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MSG-ON-Instructions","onPause");
            musicManager.stopMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MSG-ON-Instructions","onResume");
        musicManager.startMusic();
    }



}

