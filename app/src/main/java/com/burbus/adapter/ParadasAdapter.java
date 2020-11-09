package com.burbus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.burbus.R;
import com.burbus.model.Parada;

import java.util.List;

public class ParadasAdapter extends RecyclerView.Adapter<ParadasAdapter.ParadasAdapterVh> {

    private List<Parada> paradaList;
    private Context context;
    private SelectedParada selectedParada;

    public ParadasAdapter(List<Parada> paradaList, SelectedParada selectedParada) {
        this.paradaList = paradaList;
        this.selectedParada = selectedParada;
    }

    @NonNull
    @Override
    public ParadasAdapter.ParadasAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new ParadasAdapter.ParadasAdapterVh(LayoutInflater.from(context).inflate(R.layout.parada_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ParadasAdapter.ParadasAdapterVh holder, int position) {

        String id = paradaList.get(position).getId();
        String nombre = paradaList.get(position).getNombre();
        String lat = paradaList.get(position).getLat();
        String lon = paradaList.get(position).getLon();
        String sentido = paradaList.get(position).getSentido();

        holder.tvNombre.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return paradaList.size();
    }

    public interface SelectedParada {
        void selectedParada(Parada parada);
    }

    public class ParadasAdapterVh extends RecyclerView.ViewHolder {

        TextView tvNombre;

        public ParadasAdapterVh(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedParada.selectedParada(paradaList.get(getAdapterPosition()));
                }
            });
        }
    }
}
