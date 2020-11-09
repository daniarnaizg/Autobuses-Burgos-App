package com.burbus.network;

import com.burbus.model.Espera;
import com.burbus.model.Linea;
import com.burbus.model.Parada;
import com.burbus.model.Ruta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("/rutas/{idRuta}")
    Call<List<Ruta>> getAllRutas(@Path(value="idRuta") String idRuta);

    @GET("/lineas")
    Call<List<Linea>> getAllLineas();

    @GET("/paradas/{idRuta}")
    Call<List<Parada>> getAllParadas(@Path(value="idRuta") String idRuta);

    @GET("/paradas/{idRuta}?")
    Call<List<Parada>> getParadasSentido(@Path(value="idRuta") String idRuta,
                                     @Query("sentido") String sentido);

    @GET("/paradas/{idRuta}/{idParada}")
    Call<Espera> getEspera(@Path(value="idRuta") String idRuta, @Path(value="idParada") String idParada);

    @GET("/vehiculos/{idRuta}")
    Call<List<Parada>> getAllVehiculos(@Path(value="idRuta") String idRuta);

}
