package yarinhala.com.shenkar.mastermindsafeedition;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MusicManager extends AppCompatActivity {
    private static MusicManager musicManager = null;
    private   MediaPlayer backgroundsong;
    private   MediaPlayer buttonEffect;
    private   int musicIsMute;
    private int effectIsMute;

    public MusicManager(){
    }

    protected MusicManager(AppCompatActivity ap){
        backgroundsong = MediaPlayer.create(ap,R.raw.launchapp);
        backgroundsong.setLooping(true);
        backgroundsong.start();
        buttonEffect = MediaPlayer.create(ap, R.raw.buttoneffect);
        musicIsMute=0;
        effectIsMute=0;
    }

    public static MusicManager getMusicManager(AppCompatActivity ap){
        if(musicManager == null){
            musicManager = new MusicManager(ap);
            return musicManager;
        }
        return musicManager;
    }

    public void stopMusic(){
        Log.d("MSG","status_show:stopMusic -" +musicIsMute);

        if(musicIsMute == 0)
            backgroundsong.pause();
        Log.d("MSG","status_show:stopping music");

    }


    public void startMusic(){
        Log.d("MSG","status_show:startMusic -" +musicIsMute);

        if(musicIsMute == 0)
            backgroundsong.start();
        Log.d("MSG","status_show:starting music");
    }


    public void stopEffect(){
        Log.d("MSG","status_show:stopEffect -" +effectIsMute);

        if(effectIsMute == 0)
            buttonEffect.pause();
        Log.d("MSG","status_show:stopping effect");

    }


    public void startEffect(){
        Log.d("MSG","status_show:startEffect -" +effectIsMute);

        if(effectIsMute == 0)
            buttonEffect.start();
        Log.d("MSG","status_show:starting effect");
    }


    public void buttonClick(){
        if(effectIsMute == 0)
             buttonEffect.start();
    }


    public int getIsMute(){
        return musicIsMute;
    }

    public int getIsEffect(){
        return effectIsMute;
    }



    public void changeMusicStatus(int status){
        Log.d("MSG","status_show " +status);

        if(status == 0){
            Log.d("MSG","status_show:going to start effect");
            musicIsMute = 0;
            musicManager.startMusic();

        }else {
            Log.d("MSG","status_show:going to stop effect");
            musicManager.stopMusic();
            musicIsMute = 1;

        }


    }


    public void changeEffectStatus(int status) {
        Log.d("MSG", "status_show " + status);

        if (status == 0) {
            Log.d("MSG", "status_show:going to start effect");
            effectIsMute = 0;
            musicManager.startEffect();

        } else {
            Log.d("MSG", "status_show:going to stop effect");
            musicManager.stopEffect();
            effectIsMute = 1;

        }
    }




}
