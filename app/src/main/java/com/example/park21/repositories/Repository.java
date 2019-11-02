package com.example.park21.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.park21.models.Carro;
import com.example.park21.models.Familia;
import com.example.park21.models.Parqueadero;
import com.example.park21.models.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Singleton pattern
 */
public class Repository {

    private static Repository instance;
    private ArrayList<Parqueadero> dataSetParqueaderos = new ArrayList<>();
    private Usuario usuario;
    private Familia familia;

    FirebaseFirestore db = FirebaseFirestore.getInstance();







    public static Repository getInstance(){
        if(instance == null){
            instance = new Repository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Parqueadero>> getNicePlaces(){
        setNicePlaces();
        MutableLiveData<List<Parqueadero>> data = new MutableLiveData<>();
        data.setValue(dataSetParqueaderos);
        return data;
    }

    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Carro>> getCarros(){
        Carro carro1 = new Carro("abc 123");
        Carro carro2 = new Carro("trt 456");
        List<Carro> listaFamilia = new ArrayList<>();
        listaFamilia.add(carro1);
        listaFamilia.add(carro2);

        MutableLiveData<List<Carro>> data = new MutableLiveData<>();
        data.setValue(listaFamilia);
        return data;
    }

    // Pretend to get data from a webservice or online source
    public MutableLiveData<Usuario> getUsuario(){

        DocumentReference docRef = db.collection("Usuarios").document("JFAdU6Eniy30ckgIKOyW");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        MutableLiveData<Usuario> data = new MutableLiveData<>();
        data.setValue(usuario);
        return data;

    }

    // Pretend to get data from a webservice or online source
    public MutableLiveData<Familia> getFamilia(){
        Usuario usuario1;
        Usuario usuario2;
        usuario1 = new Usuario("Martha Diaz","5454654654","25651156","soalal@pepo.com","54","Femenino", "https://i.redd.it/tpsnoz5bzo501.jpg");
        usuario2 = new Usuario("Mauro Diaz","54654651","2956515","smaurk@pepo.com","25","Masculino", "https://i.redd.it/j6myfqglup501.jpg");
        List<Usuario> listaFamilia = new ArrayList<>();
        listaFamilia.add(usuario1);
        listaFamilia.add(usuario2);
        listaFamilia.add(usuario);
        familia = new Familia(listaFamilia, "Padre");
        MutableLiveData<Familia> data = new MutableLiveData<>();
        data.setValue(familia);
        return data;
    }

    private void setNicePlaces(){
        dataSetParqueaderos.add(
                new Parqueadero("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Unicentro",
                        "",
                        "65",
                        "",
                        "4.723271",
                        "-74.062304"
                )
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Hayuelos",
                        "",
                        "54",
                        "",
                        "4.723271",
                        "-74.062304")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Plaza Claro",
                        "",
                        "84",
                        "",
                        "4.723271",
                        "-74.062304")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/j6myfqglup501.jpg",
                        "Santafe",
                        "",
                        "78",
                        "",
                        "4.723271",
                        "-74.062304")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Cedritos",
                        "",
                        "45",
                        "",
                        "4.723271",
                        "-74.062304")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/k98uzl68eh501.jpg",
                        "Colina",
                        "",
                        "51",
                        "",
                        "4.723271",
                        "-74.062304")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "San Rafael",
                        "",
                        "900",
                        "",
                        "4.723271",
                        "-74.062304")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/obx4zydshg601.jpg",
                        "Centro Mayor",
                        "",
                        "500",
                        "",
                        "4.723271",
                        "-74.062304")
        );
    }
}
