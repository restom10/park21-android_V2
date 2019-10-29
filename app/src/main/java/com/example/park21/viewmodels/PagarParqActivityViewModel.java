package com.example.park21.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.park21.models.Usuario;
import com.example.park21.repositories.Repository;

public class PagarParqActivityViewModel extends ViewModel {
    private MutableLiveData<Usuario> usuario;
    private Repository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(usuario != null){
            return;
        }
        mRepo = Repository.getInstance();
        usuario = mRepo.getUsuario();
    }

    public LiveData<Usuario> getUsuario(){
        return usuario;
    }


    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
