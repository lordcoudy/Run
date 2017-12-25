package com.programm.lordcoudy.run;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


/**
 * Created by lordcoudy on 22.12.2017.
 */

public class Person implements SensorEventListener{
    private float x, y, vx;
    private int h,w;
    final float threshold = 2;

    Bitmap pic;

    Person(Bitmap pic) {
        this.vx = 0;
        this.x = 400;
        this.y = 400;
        this.pic = pic;
        this.h = pic.getHeight() / 2;
        this.w = pic.getWidth() / 8;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        if(sensorEvent.values[0] < threshold){
            vx = 1;
        }
        else if (sensorEvent.values[0] > -threshold){
            vx = -1;
        }
        else{
            vx = 0;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    boolean connected;

    Paint paint = new Paint();
    int nFrame = 0;
    void draw(Canvas canvas){
        if(!connected){
            MainActivity.sm.registerListener(this, MainActivity.acsel, SensorManager.SENSOR_DELAY_NORMAL);
            connected = true;
        }
        Rect to = new Rect((int) x - w / 2, (int)y - h / 2, (int)x + w / 2, (int)y + h / 2);
        Rect frame = new Rect(nFrame*w, 0, nFrame*w+w, h);
        nFrame++;
        nFrame%=8;
        canvas.drawBitmap(pic, frame, to, paint);
    }

    public void move(){
        x += vx;
    }





}
