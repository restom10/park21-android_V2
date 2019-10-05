package com.example.park21.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.park21.models.Parqueadero;
import com.example.park21.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class ParqueaderoRepository {

    private static ParqueaderoRepository instance;
    private ArrayList<Parqueadero> dataSetParqueaderos = new ArrayList<>();
    private Usuario usuario;

    public static ParqueaderoRepository getInstance(){
        if(instance == null){
            instance = new ParqueaderoRepository();
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
    public MutableLiveData<Usuario> getUsuario(){
        usuario = new Usuario("Pepo Diaz","1136555582","1654651","skrrsk@pepo.com","52","Masculino");
        MutableLiveData<Usuario> data = new MutableLiveData<>();
        data.setValue(usuario);
        return data;
    }

    private void setNicePlaces(){
        dataSetParqueaderos.add(
                new Parqueadero("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Unicentro",
                        "",
                        "65",
                        ""
                )
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Hayuelos",
                        "",
                        "54",
                        "")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Plaza Claro",
                        "",
                        "84",
                        "")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/j6myfqglup501.jpg",
                        "Santafe",
                        "",
                        "78",
                        "")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Cedritos",
                        "",
                        "45",
                        "")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/k98uzl68eh501.jpg",
                        "Colina",
                        "",
                        "51",
                        "")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "San Rafael",
                        "",
                        "900",
                        "")
        );
        dataSetParqueaderos.add(
                new Parqueadero("https://i.redd.it/obx4zydshg601.jpg",
                        "Centro Mayor",
                        "",
                        "500",
                        "")
        );
    }
}
