package yarinhala.com.shenkar.mastermindsafeedition;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

public class Timer extends AppCompatActivity {

    private static Timer timerManager = null;
    private Boolean timerIsOn;

    protected Timer(){
        timerIsOn = false;
    }

    public static Timer getTimerManager(){
        if(timerManager == null){
            timerManager = new Timer();
            return timerManager;
        }
        return timerManager;
    }

    public void setIsOnTimer(boolean isOn){
        timerIsOn = isOn;
    }

    public boolean getIsOnTimer(){
       return timerIsOn;
    }


}
