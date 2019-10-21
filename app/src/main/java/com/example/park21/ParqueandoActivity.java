package com.example.park21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ParqueandoActivity extends AppCompatActivity {

    CardView pagar, verCarro, salir, llegar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parqueando);

        pagar = (CardView) findViewById(R.id.pagarParq);
        verCarro = (CardView) findViewById(R.id.verCarro);
        salir = (CardView) findViewById(R.id.salirParq);
        llegar = (CardView) findViewById(R.id.llegarCarro);

    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.pagarParq:
                Intent a = new Intent(ParqueandoActivity.this,UserProfileActivity.class);
                startActivity(a);
                break;
            case R.id.verCarro:
                break;
            case R.id.salirParq:
                break;
            case R.id.llegarCarro:
                break;

        }

    }
}
