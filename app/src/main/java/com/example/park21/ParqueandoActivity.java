package com.example.park21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ParqueandoActivity extends AppCompatActivity {

    CardView pagar, verCarro, salir, llegar;
    String parqEscogido;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parqueando);
        Intent intent = getIntent();
        parqEscogido = intent.getStringExtra(IngresarParqueaderoActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.textViewParqueaderoActual);
        textView.setText(parqEscogido);

        pagar = (CardView) findViewById(R.id.pagarParq);

        verCarro = (CardView) findViewById(R.id.verCarro);
        verCarro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ParqueandoActivity.this,
                        SnapshotAutomovilActivity.class);
                startActivity(myIntent);
            }
        });
        salir = (CardView) findViewById(R.id.salirParq);
        salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(ParqueandoActivity.this,
                        SalirParqActivity.class);
                startActivity(myIntent);
            }
        });
        llegar = (CardView) findViewById(R.id.llegarCarro);


    }

}
