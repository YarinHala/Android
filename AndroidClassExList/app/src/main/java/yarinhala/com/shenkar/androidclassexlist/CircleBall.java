package yarinhala.com.shenkar.androidclassexlist;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class CircleBall {


    private int leftTopX;
    private int leftTopY;
    private int radius;
    private Paint paint;
    private RectF bounds;
    private int speedX;
    private int speedY;
    private int maxX,maxY;
    boolean isChange = false;

    public CircleBall(int color){
        paint = new Paint();
        paint.setColor(color);
        bounds = new RectF();

    }

    public void setCord(int x,int y,int radius){
        this.leftTopX = x;
        this.leftTopY = y;
        this.radius = radius;
        bounds.set(leftTopX,leftTopY,leftTopX+(this.radius*2),leftTopY+(this.radius*2));

    }

    public void setSpeed(int speedX,int speedY){
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public  void setMax(int max_x,int max_y){
        this.maxX = max_x;
        this.maxY = max_y;
    }

    public void draw(Canvas canvas){
        canvas.drawOval(bounds,paint);
        update();
    }


    public int getRadius(){
        return this.radius;
    }
    public void setRadius(int rad){
        this.radius = rad;
    }

    public void update(){

        isChange = false;

        if(leftTopX + (2* radius) > maxX || leftTopX < 0 ){
            speedX = speedX * -1;
        }
        if(leftTopY + (radius *2) > maxY || leftTopY < 0){
            speedY = speedY * -1;
        }


        //bounds.set(max_x/2-100,max_y/2-1,max_x/2+100,max_y/2+1);


        if(leftTopX + (2* radius) > maxX/2-100 || leftTopX + (2* radius) > maxX/2+100  ){
            if(leftTopY + (2* radius) > maxY/2-100 && leftTopY + (2* radius) < maxY/2+100) {
                speedY = speedY * -1;
            }
        }

        if(leftTopY + (2* radius) > maxY/2-100  ||  leftTopY + (2* radius) > maxY/2+100 ){
            if(leftTopX + (2* radius) > maxX/2-100 && leftTopX + (2* radius) < maxX/2+100) {
                speedX = speedX * -1;
            }
        }













        leftTopX = leftTopX + speedX;
        leftTopY = leftTopY + speedY;

        bounds.set(leftTopX,leftTopY,leftTopX+(radius*2),leftTopY+(radius*2));
    }

}
