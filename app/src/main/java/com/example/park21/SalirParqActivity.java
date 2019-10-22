package com.example.park21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class SalirParqActivity extends AppCompatActivity {
    String TAG = "GenerateQRCode";
    ImageView qrImage;
    Button generar;
    Button irAMain;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    String inputValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salir_parq);

        irAMain = (Button) findViewById(R.id.buttonSeguiraMain);
        irAMain.setEnabled(false);
        qrImage = (ImageView) findViewById(R.id.QR_Image_Salir);
        generar = (Button) findViewById(R.id.buttonGenerarQrSalir);
        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue = "Prueba TODO";
                if (inputValue.length() > 0) {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerDimension = width < height ? width : height;
                    smallerDimension = smallerDimension * 3 / 4;

                    qrgEncoder = new QRGEncoder(
                            inputValue, null,
                            QRGContents.Type.TEXT,
                            smallerDimension);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();
                        qrImage.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        Log.v(TAG, e.toString());
                    }
                }
                irAMain.setEnabled(true);
            }
        });

        irAMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(SalirParqActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
