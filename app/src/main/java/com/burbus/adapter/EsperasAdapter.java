package com.burbus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.burbus.R;
import com.burbus.model.Espera;

import java.util.List;

public class EsperasAdapter extends RecyclerView.Adapter<EsperasAdapter.EsperasAdpterVh> {

    private Espera esperaList;
    private List<String> listaEstimaciones;
    private Context context;
    private SelectedEspera selectedEspera;

    public EsperasAdapter(List<String> listaEstimaciones, EsperasAdapter.SelectedEspera selectedEspera) {
        this.listaEstimaciones = listaEstimaciones;
        this.selectedEspera = selectedEspera;
    }

    @NonNull
    @Override
    public EsperasAdapter.EsperasAdpterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new EsperasAdapter.EsperasAdpterVh(LayoutInflater.from(context).inflate(R.layout.espera_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull EsperasAdapter.EsperasAdpterVh holder, int position) {

        String estimacion = listaEstimaciones.get(position);

        // Hacemos esto por si hay mas puntos en el nombre:
        String idLinea = estimacion.split("\\.")[0];
        String[] resto = estimacion.split("\\d+\\.");
        String nombreYtiempo = "";
        for (String s : resto) {
            if (!s.equals(idLinea)) nombreYtiempo += s;
        }

        String nombreLinea = nombreYtiempo.split(": ")[0];

        String tiempoCompleto = nombreYtiempo.split(": ")[1];
        String minutos = tiempoCompleto.split(" ")[0];
        Integer minutosInt = Integer.parseInt(minutos) + 1;


        String minutosFinal = minutosInt.toString();

        holder.tvIdLinea.setText(idLinea);
        holder.tvEstimaciones.setText(nombreLinea);
        holder.tvMinutos.setText(String.format("%s min", minutosFinal));
    }

    @Override
    public int getItemCount() {
        return listaEstimaciones.size();
    }

    public interface SelectedEspera {
        void selectedEspera(Espera espera);
    }

    public class EsperasAdpterVh extends RecyclerView.ViewHolder {

        TextView tvEstimaciones;
        TextView tvIdLinea;
        TextView tvMinutos;

        public EsperasAdpterVh(@NonNull View itemView) {
            super(itemView);

            tvEstimaciones = itemView.findViewById(R.id.title);
            tvIdLinea = itemView.findViewById(R.id.idLinea);
            tvMinutos = itemView.findViewById(R.id.minutos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedEspera.selectedEspera(esperaList);
                }
            });
        }
    }

}
