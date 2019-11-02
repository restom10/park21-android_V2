package com.example.park21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.park21.models.Carro;
import com.example.park21.viewmodels.CarrosActivityViewModel;

public class VerCarrosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CarrosRecyclerViewAdapter mAdapter;
    private CarrosActivityViewModel carrosActivityViewModel;
    private ProgressBar mProgressBar;

    private Carro carro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carros);
        mRecyclerView = findViewById(R.id.recycler_view_carros);
        mProgressBar = findViewById(R.id.progress_bar_carro);
        carrosActivityViewModel = ViewModelProviders.of(this).get(CarrosActivityViewModel.class);

        carrosActivityViewModel.init();

        carrosActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(carrosActivityViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });

        initRecyclerView();
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }

    private void initRecyclerView(){

        mAdapter = new CarrosRecyclerViewAdapter(this, carrosActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
