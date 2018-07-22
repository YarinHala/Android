package yarinhala.com.shenkar.mastermindsafeedition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    public void onStartGame(final View view) {
        startActivity(new Intent(MainActivity.this,Game.class));
    }

}
