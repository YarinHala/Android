package yarinhala.com.shenkar.androidclassexlist;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Box {


    private int leftTopX;
    private int leftTopY;
    private Paint paint;
    private RectF bounds;
    private int maxX;
    private int maxY;

    public Box(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        this.leftTopX = 500;
        this.leftTopY = 500;
        bounds = new RectF();


    }

    public void draw(Canvas canvas){
        canvas.drawRect(bounds,paint);

    }

    public void setMax(int max_x,int max_y){
        this.maxX = max_x;
        this.maxY = max_y;
        bounds.set(max_x/2-100,max_y/2-100,max_x,max_y);
    }

    public void setTempMax(int max_x,int max_y){

        bounds.set(max_x/2-100,max_y/2-1,max_x/2+100,max_y/2+1);
    }
}






