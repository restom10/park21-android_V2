package com.example.park21.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.park21.models.Familia;
import com.example.park21.models.Parqueadero;
import com.example.park21.models.Usuario;
import com.example.park21.repositories.Repository;

import java.util.List;

public class FamiliaActivityViewModel extends ViewModel {

    private MutableLiveData<Familia> mNicePlaces;
    private Repository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNicePlaces != null){
            return;
        }
        mRepo = Repository.getInstance();
        mNicePlaces = mRepo.getFamilia();
    }

    public LiveData<Familia> getNicePlaces(){
        return mNicePlaces;
    }


    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
