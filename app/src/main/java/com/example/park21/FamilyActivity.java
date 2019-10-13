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

import com.example.park21.models.Familia;
import com.example.park21.viewmodels.FamiliaActivityViewModel;

public class FamilyActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FamilyRecyclerViewAdapter mAdapter;
    private FamiliaActivityViewModel familiaActivityViewModel;
    private ProgressBar mProgressBar;

    private Familia mFamilia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        mRecyclerView = findViewById(R.id.recycler_view_family);
        mProgressBar = findViewById(R.id.progress_bar_family);
        familiaActivityViewModel = ViewModelProviders.of(this).get(FamiliaActivityViewModel.class);

        familiaActivityViewModel.init();

        familiaActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(familiaActivityViewModel.getNicePlaces().getValue().getUsuarios().size()-1);
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

        mAdapter = new FamilyRecyclerViewAdapter(this, familiaActivityViewModel.getNicePlaces().getValue().getUsuarios());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
