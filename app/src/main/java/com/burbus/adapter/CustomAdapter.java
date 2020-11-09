package com.burbus.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.burbus.R;
import com.burbus.model.Linea;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomAdapterVh> {

    private List<Linea> lineaList;
    //    private List<Linea> getLineaListFiltered;
    private Context context;
    private SelectedLinea selectedLinea;

    public CustomAdapter(List<Linea> lineaList, SelectedLinea selectedLinea) {
        this.lineaList = lineaList;
//        this.getLineaListFiltered = lineaList;
        this.selectedLinea = selectedLinea;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new CustomAdapterVh(LayoutInflater.from(context).inflate(R.layout.linea_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomAdapterVh holder, int position) {

        String id = lineaList.get(position).getId();

        String colorLinea = lineaList.get(position).getColor(id);
        try {
            holder.linea_row.setBackgroundColor(Color.parseColor(colorLinea));
        } catch (IllegalArgumentException e) {
            holder.linea_row.setBackgroundColor(Color.parseColor("#B345606D"));
        }

        String nombreIda = lineaList.get(position).getNombreIda();
        String nombreVuelta = lineaList.get(position).getNombreVuelta();

        if (id.equals("38")) {
            holder.tvId.setText("Línea 3B");
        } else {
            holder.tvId.setText(String.format("Línea %s                                                                       ", id));
        }

        if (nombreVuelta == null) {
            holder.tvNombre.setText(String.format("%s", nombreIda));
        } else {
            holder.tvNombre.setText(String.format("%s  —  %s", nombreIda, nombreVuelta));
        }

    }

    @Override
    public int getItemCount() {
        return lineaList.size();
    }

    public interface SelectedLinea {
        void selectedLinea(Linea linea);
    }

    public class CustomAdapterVh extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvNombre;
        LinearLayout linea_row;

        public CustomAdapterVh(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.id);
            tvNombre = itemView.findViewById(R.id.title);
            linea_row = itemView.findViewById(R.id.lineaLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedLinea.selectedLinea(lineaList.get(getAdapterPosition()));
                }
            });
        }
    }


}
