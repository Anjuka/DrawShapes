package com.example.drawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

import static android.content.ContentValues.TAG;

public class CustomViewTest extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    private Rect rect = new Rect();
    float touchX;
    float touchY;
    int type;

    public CustomViewTest(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomViewTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
        
    }

    public CustomViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private  void init(AttributeSet attrs, int defStyle) {

        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (type == 1) {
            canvas.drawCircle(touchX, touchY, 50, paint);
        } else if( type ==2) {
            canvas.drawPath(path, paint);
        }
    }

    public void drawShapes(int type){

        this.type = type;
        touchX = 500;
        touchY = 250;
        invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

         touchX = event.getX();
         touchY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                rect.bottom = (int) touchX;
                rect.top = (int) touchX;
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        invalidate();
        return true;

    }

    /*public void getType( String ty){
        this.type =ty ;
        Log.d("", "getType:  " + type);
    }

    public void drawShape(float x, float y) {

        this.touchX = x;
        this.touchY = y;
    }*/
}
