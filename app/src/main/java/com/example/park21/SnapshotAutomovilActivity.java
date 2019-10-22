package com.example.park21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SnapshotAutomovilActivity extends AppCompatActivity {

    FloatingActionButton llamar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snapshot_automovil);
        llamar = (FloatingActionButton) findViewById(R.id.buttonLlamarSeguridad);
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                //TODO get el numero de seguridad en un viewmodel
                intent.setData(Uri.parse("tel:3002776623"));
                startActivity(intent);
            }
        });
    }
}
