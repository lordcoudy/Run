package com.programm.lordcoudy.run;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lordcoudy on 22.12.2017.
 */



public class MyDraw extends View {

    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.person = new Person(BitmapFactory.decodeResource(getResources(), R.drawable.sprites));
    }

    Person person;

    @Override
    protected void onDraw(Canvas canvas) {
        person.draw(canvas);
        person.move();
        invalidate();
    }

}


