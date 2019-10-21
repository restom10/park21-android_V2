package com.example.park21.viewmodels;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.park21.models.Parqueadero;
import com.example.park21.repositories.Repository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivityParqueaderoViewModel extends ViewModel {

    private MutableLiveData<List<Parqueadero>> mNicePlaces;
    private Repository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNicePlaces != null){
            return;
        }
        mRepo = Repository.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public void addNewValue(final Parqueadero nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Parqueadero> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(nicePlace);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<Parqueadero>> getNicePlaces(){
        return mNicePlaces;
    }

    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }

    public Boolean checkInternet(){
        Boolean f=false;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection)
                    (new URL("http://clients3.google.com/generate_204")
                            .openConnection());
            urlConnection.setRequestProperty("User-Agent", "Android");
            urlConnection.setRequestProperty("Connection", "close");
            urlConnection.setConnectTimeout(1500);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 204 &&
                    urlConnection.getContentLength() == 0) {
                Log.d("Network Checker", "Successfully connected to internet");
                f=true;
                return true;
            }
        } catch (IOException e) {
            Log.e("Network Checker", "Error checking internet connection", e);
            f = false;
            return false;
        }
        return f;
    }
}
