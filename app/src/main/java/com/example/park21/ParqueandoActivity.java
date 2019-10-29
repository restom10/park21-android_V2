package com.example.park21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ParqueandoActivity extends AppCompatActivity {

    private CardView pagar, verCarro, salir, llegar;
    private String parqEscogido;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parqueando);
        Intent intent = getIntent();
        parqEscogido = intent.getStringExtra(IngresarParqueaderoActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.textViewParqueaderoActual);
        textView.setText(parqEscogido);

        pagar = (CardView) findViewById(R.id.pagarParq);
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ParqueandoActivity.this,
                        PagarParqActivity.class);
                startActivity(myIntent);
            }
        });

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
