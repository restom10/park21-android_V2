package com.example.park21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.park21.viewmodels.MainActivityParqueaderoViewModel;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class IngresarParqueaderoActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    String TAG = "GenerateQRCode";
    ImageView qrImage;
    Button generar;
    Button irAParquear;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    String inputValue;
    String parqEscogido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_parqueadero);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        parqEscogido = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        irAParquear = (Button) findViewById(R.id.buttonSeguiraParquear);
        irAParquear.setEnabled(false);
        qrImage = (ImageView) findViewById(R.id.QR_Image);
        generar = (Button) findViewById(R.id.buttonGenerarQr);
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
                irAParquear.setEnabled(true);
            }
        });

        irAParquear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(IngresarParqueaderoActivity.this,
                        ParqueandoActivity.class);
                myIntent.putExtra(EXTRA_MESSAGE,parqEscogido);
                startActivity(myIntent);
            }
        });

    }
}
