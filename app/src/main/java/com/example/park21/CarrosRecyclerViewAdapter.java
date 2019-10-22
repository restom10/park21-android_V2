package com.example.park21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.park21.models.Carro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CarrosRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final String TAG = "CarrosRecyclerViewAdapter";

    private List<Carro> mNicePlaces = new ArrayList<>();
    private Context mContext;

    public CarrosRecyclerViewAdapter(Context context, List<Carro> nicePlaces) {
        mNicePlaces = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listcarro, viewGroup, false);
        CarrosRecyclerViewAdapter.ViewHolder vh = new CarrosRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        // Set the placa of the 'Carro'
        ((CarrosRecyclerViewAdapter.ViewHolder)viewHolder).placa.setText(mNicePlaces.get(i).getPlaca());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), mNicePlaces.get(i).getPlaca(), Toast.LENGTH_SHORT).show();
            }
        });

        ((ViewHolder) viewHolder).botonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Vas a borrar a "+mNicePlaces.get(i).getPlaca(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        
        private TextView placa;
        private FloatingActionButton botonDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placa = itemView.findViewById(R.id.placas);
            botonDelete = itemView.findViewById(R.id.borrarCarro);
        }
    }
}
