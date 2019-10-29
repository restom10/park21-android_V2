package com.example.park21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.park21.viewmodels.PagarParqActivityViewModel;

public class PagarParqActivity extends AppCompatActivity {

    private TextView numParq, ubicacionVehiculo, horaIngreso, descuento, valorPagra;
    private CardView registrarFactura, pagarPSE;
    private PagarParqActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar_parq);

        registrarFactura = (CardView) findViewById(R.id.registrarFactura);
        registrarFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(PagarParqActivity.this,
                        RegistrarFacturaActivity.class);
                startActivity(myIntent);
            }
        });

        viewModel = ViewModelProviders.of(this).get(PagarParqActivityViewModel.class);

        viewModel.init();

        pagarPSE = (CardView) findViewById(R.id.pagarParq);

        numParq = findViewById(R.id.parqueaderoNumero);
        numParq.setText("TODO");
        ubicacionVehiculo = findViewById(R.id.ubicacionVehiculo);
        ubicacionVehiculo.setText("TODO");
        horaIngreso = findViewById(R.id.horaIngreso);
        horaIngreso.setText("TODO");
        descuento = findViewById(R.id.descuento);
        descuento.setText("TODO");
        valorPagra = findViewById(R.id.valorParqueadero);
        valorPagra.setText("TODO");
    }
}
