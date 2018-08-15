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

    protected MusicManager(){
    }

    protected MusicManager(AppCompatActivity ap){
        backgroundsong = MediaPlayer.create(ap,R.raw.launchapp);
        backgroundsong.setLooping(true);
        backgroundsong.start();
        buttonEffect = MediaPlayer.create(ap, R.raw.buttoneffect);
        musicIsMute=0;

    }

    public static MusicManager getMusicManager(AppCompatActivity ap){
        if(musicManager == null){
            musicManager = new MusicManager(ap);
            return musicManager;
        }
        return musicManager;
    }

    public void stopMusic(){
        if(musicIsMute == 0)
            if(backgroundsong.isPlaying()){
                    backgroundsong.stop();
            }
    }

    public void pauseMusic(){
        if(musicIsMute == 0)
            if(backgroundsong.isPlaying()){
                    backgroundsong.pause();
            }

    }

    public void startMusic(){
        if(musicIsMute == 0)
            if(!backgroundsong.isPlaying()){
                backgroundsong.start();
                Log.d("MSG","starting music");

            }

    }

    public void buttonClick(){
        if(musicIsMute == 0)
             buttonEffect.start();
    }

    public void muteMusic(int status){
        Log.d("MSG","status" +status);

        if(status == 0){

            musicIsMute = 0;
            musicManager.startMusic();

        }else {
            musicManager.stopMusic();
            musicIsMute = 1;

        }


    }

    public int getIsMute(){
        return musicIsMute;
    }


}
