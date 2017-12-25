package com.programm.lordcoudy.run;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private MyDraw myDraw;
    public static Sensor acsel;
    public static SensorManager sm;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        acsel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv = findViewById(R.id.textView);
        sm.registerListener(this, acsel, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tv.setText("v1: "+sensorEvent.values[0]+"\nv2:"+sensorEvent.values[1]+"\nv3: "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
