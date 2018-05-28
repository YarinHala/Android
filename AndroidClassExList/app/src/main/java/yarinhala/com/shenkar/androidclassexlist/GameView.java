package yarinhala.com.shenkar.androidclassexlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameView extends android.view.View {

    int maxX;
    int maxY;
    private CircleBall ball;
    private Box box;
    private Box tempBox;

    private ArrayList<CircleBall> ballList = new ArrayList<>();


    public GameView(Context context) {
        super(context);

        this.setOnClickListener(previewListener);

        box = new Box();
        //tempBox = new Box();

        for(int i = 0 ; i < 10 ; i++) {

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            Random r = new Random();
            int i1 = r.nextInt(10 - 2)+2;

            ball = new CircleBall(color);
            ball.setCord(0, 0, 0);
            ball.setSpeed(i1, i1);
            ballList.add(ball);
        }
    }



    private OnClickListener previewListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Iterator itr = ballList.iterator();
            Random r = new Random();
            int i1 = r.nextInt(100 - 50) +50;
            while (itr.hasNext()){
                CircleBall ball = (CircleBall)itr.next();
                if(ball.getRadius() == 0){
                    Random r2 = new Random();
                    int i2 = r2.nextInt(800 - 200)+200;
                    Random r3 = new Random();
                    int i3 = r3.nextInt(800 - 200)+200;
                    ball.setCord(0, i3, i1);
                    //ball.setRadius(i1);
                    return;
                }
            }

        }
    };



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        box.draw(canvas);
        //tempBox.draw(canvas);
        Iterator itr = ballList.iterator();

        while (itr.hasNext()){
            CircleBall ball = (CircleBall)itr.next();
            ball.draw(canvas);
        }
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        maxX = w;
        maxY = h;
        box.setMax(maxX,maxY);
        //tempBox.setTempMax(maxX,maxY);

        Iterator itr = ballList.iterator();

        while (itr.hasNext()){
            CircleBall ball = (CircleBall)itr.next();
            ball.setMax(maxX,maxY);
        }
    }

}