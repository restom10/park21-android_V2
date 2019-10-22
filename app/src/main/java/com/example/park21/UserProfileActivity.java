package com.example.park21;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.park21.models.Parqueadero;
import com.example.park21.models.Usuario;
import com.example.park21.viewmodels.UserProfileActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private Button verFamilia;
    private Button verCarros;
    private UserProfileActivityViewModel userViewModel;
    private RecyclerViewAdapter mAdapter;
    private EditText nombre;
    private EditText telefono;
    private EditText genero;
    private EditText edad;
    private EditText cedula;
    private EditText correo;
    private CircleImageView mImage;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFab = findViewById(R.id.UserEdit);
        verFamilia = findViewById(R.id.buttonFamilia);
        verCarros = findViewById(R.id.buttonVerCarros);
        userViewModel = ViewModelProviders.of(this).get(UserProfileActivityViewModel.class);
        userViewModel.init();

        mImage = (CircleImageView) findViewById(R.id.image);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        nombre.setEnabled(false);
        telefono = (EditText) findViewById(R.id.editTextTelefono);
        telefono.setEnabled(false);
        cedula = (EditText) findViewById(R.id.editTextCedula);
        cedula.setEnabled(false);
        correo = (EditText) findViewById(R.id.editTextCorreo);
        correo.setEnabled(false);
        edad = (EditText) findViewById(R.id.editTextEdad);
        edad.setEnabled(false);
        genero = (EditText) findViewById(R.id.editTextGenero);
        genero.setEnabled(false);

        nombre.setText(userViewModel.getUsuario().getValue().getNombre());
        telefono.setText(userViewModel.getUsuario().getValue().getTelefono());
        cedula.setText(userViewModel.getUsuario().getValue().getCedula());
        correo.setText(userViewModel.getUsuario().getValue().getCorreo());
        edad.setText(userViewModel.getUsuario().getValue().getEdad());
        genero.setText(userViewModel.getUsuario().getValue().getGenero());

        verFamilia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(UserProfileActivity.this,
                        FamilyActivity.class);
                startActivity(myIntent);
            }
        });
        verCarros.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(UserProfileActivity.this,
                        VerCarrosActivity.class);
                startActivity(myIntent);
            }
        });
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genero.setEnabled(true);
                edad.setEnabled(true);
                correo.setEnabled(true);
                cedula.setEnabled(true);
                telefono.setEnabled(true);
                nombre.setEnabled(true);
            }
        });



    }

    /** Called when the user taps the Save button */
    public void editInfo(View view) {

        nombre = (EditText) findViewById(R.id.editTextNombre);
        telefono = (EditText) findViewById(R.id.editTextTelefono);
        cedula = (EditText) findViewById(R.id.editTextCedula);
        correo = (EditText) findViewById(R.id.editTextCorreo);
        edad = (EditText) findViewById(R.id.editTextEdad);
        genero = (EditText) findViewById(R.id.editTextGenero);
        String nombreM = nombre.getText().toString();
        String telefonoM = nombre.getText().toString();
        String cedulaM = nombre.getText().toString();
        String correoM = nombre.getText().toString();
        String edadM = nombre.getText().toString();
        String generoM = nombre.getText().toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
