package com.example.activity_5;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;
    private TextView resultadoTexto;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout cuadrado = findViewById(R.id.cuadrado);
        resultadoTexto = findViewById(R.id.resultadoTexto);

        cuadrado.setClickable(true);
        cuadrado.setFocusable(true);

        gestureDetector = new GestureDetector(this, new GestureListener());

        cuadrado.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Procesar el evento táctil con GestureDetector
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                // Si no es manejado por GestureDetector, llamar a performClick() para accesibilidad
                return v.performClick();
            }
        });

        cuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            resultadoTexto.setText("Touched!");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            resultadoTexto.setText("Scrolled!");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            resultadoTexto.setText("Flick!");
            return true;
        }
    }
}