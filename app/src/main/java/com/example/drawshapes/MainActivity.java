package com.example.drawshapes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    CustomViewTest ivRoom;
    CustomViewTest customViewTest;
    Button btnCir;
    Button btnLine;
    Button btnRect;
    Button btnSqure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivRoom = findViewById(R.id.image_view_control_area);
        btnCir = findViewById(R.id.btnCir);
        btnLine = findViewById(R.id.btnRect);
        btnSqure = findViewById(R.id.btnSqer);

        customViewTest = new CustomViewTest(this);

        btnCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivRoom.drawShapes(1);
                ivRoom.invalidate();

            }
        });

        btnLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivRoom.drawShapes(2);
                ivRoom.invalidate();

            }
        });

        btnRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivRoom.drawShapes(3);
                ivRoom.invalidate();

            }
        });

        btnSqure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivRoom.drawShapes(4);
                ivRoom.invalidate();

            }
        });

    }


}
