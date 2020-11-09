package com.burbus;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.burbus.model.Linea;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectedLineaActivity extends AppCompatActivity {

    Linea selectedLinea;

    TextView tvLinea;
    TextView tvId;
    TextView tvNombreIda;
    TextView tvNombreVuelta;

    TextView tvLaborablesIda;
    TextView tvLaborablesVuelta;
    TextView tvSabadosIda;
    TextView tvSabadosVuelta;
    TextView tvDomingosIda;
    TextView tvDomingosVuelta;
    TextView tvNocturnosIda;
    TextView tvNocturnosVuelta;

    FloatingActionButton fab;
    FloatingActionButton fab2;

    Toolbar toolbar;

    String img_url;
    ImageView imageView;

    HashSet<List<String>> marcadores;
    HashSet<List<String>> posVehiculos;
    RequestQueue mRequestQueue;
    Integer numParadas;
    Integer numVehiculos;
    String rutaUrl;
    String vehiculosUrl;

    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_linea);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });
        adContainerView = findViewById(R.id.ad_view_map_container);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.linea_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        toolbar = findViewById(R.id.toolbar);

        fab = findViewById(R.id.floating_action_button);
        fab2 = findViewById(R.id.floating_action_button2);

        tvLinea = findViewById(R.id.selectedLinea);
        tvId = findViewById(R.id.selectedId);
        tvNombreIda = findViewById(R.id.ida);
        tvNombreVuelta = findViewById(R.id.vuelta);

        imageView = findViewById(R.id.image_ruta);

        tvLaborablesIda = findViewById(R.id.laborablesIda);
        tvLaborablesVuelta = findViewById(R.id.laborablesVuelta);
        tvSabadosIda = findViewById(R.id.sabadosIda);
        tvSabadosVuelta = findViewById(R.id.sabadosVuelta);
        tvDomingosIda = findViewById(R.id.domingosIda);
        tvDomingosVuelta = findViewById(R.id.domingosVuelta);
        tvNocturnosIda = findViewById(R.id.nocturnoIda);
        tvNocturnosVuelta = findViewById(R.id.nocturnoVuelta);

        Intent intent = getIntent();

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/TradeGothicLTPro-Bold.ttf");

        if (intent.getExtras() != null) {
            selectedLinea = (Linea) intent.getSerializableExtra("data");
            String id = selectedLinea.getId();
            if (id.equals("38")) {
                tvId.setText("3B");
            } else {
                tvId.setText(id);
            }
            tvId.setTypeface(type);

            String colorLinea = selectedLinea.getColor(id);
            toolbar.setBackgroundColor(Color.parseColor(colorLinea));

            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorLinea)));
            fab2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorLinea)));

            String nombre = selectedLinea.getNombre();
            tvLinea.setText(nombre);
            tvLinea.setTypeface(type);

            String nombreIda = selectedLinea.getNombreIda();
            tvNombreIda.setText(String.format("HORARIOS DESDE %s", nombreIda.toUpperCase()));

            String nombreVuelta = selectedLinea.getNombreVuelta();
            if(nombreVuelta != null)
                tvNombreVuelta.setText(String.format("HORARIOS DESDE %s", nombreVuelta.toUpperCase()));

            setHorarios(id);

            rutaUrl = String.format("https://bus-burgos-rest-2.herokuapp.com/paradas/%s", id);
            vehiculosUrl = String.format("https://bus-burgos-rest-2.herokuapp.com/vehiculos/%s", id);
            getdataParadas(rutaUrl);
            getdataVehiculos(vehiculosUrl);

            try {
                int res_id = getResources().getIdentifier("mapa_"+id, "drawable", getPackageName());
                Log.e("RES IDDDDDDDDDDDD", getString(res_id));
                imageView.setImageResource(res_id);
            } catch (RuntimeException e){
//                img_url = "https://www.gameroshost.com/infi_bs/mapa_" + id + ".jpg";
                img_url = "https://raw.githubusercontent.com/dag0035/images/master/mapas_final/mapa_" + id + ".png";
                Picasso.with(this).load(img_url).resize(1500, 0).into(imageView);
            }

        }
    }

    boolean isTestDevice() {
        return Boolean.parseBoolean(Settings.System.getString(getContentResolver(), "firebase.test.lab"));
    }

    private void loadBanner() {
        // Create an ad request. Check your logcat output for the hashed device ID
        // to get test ads on a physical device, e.g.,
        // "Use AdRequest.Builder.addTestDevice("ABCDE0123") to get test ads on this
        // device."
//        AdRequest adRequest =
//                new AdRequest.Builder().addTestDevice("7A422591EBFF35BEEC25044F0A373091")
//                        .build();
        AdRequest adRequest =
                new AdRequest.Builder().build();

        AdSize adSize = getAdSize();
        // Step 4 - Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);

        // Step 5 - Start loading the ad in the background.
//        if(!isTestDevice())
            adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }

    private void setHorarios(String id) {
        String horariosLaborablesIda = selectedLinea.getHorarioLaboralIda(id);
        tvLaborablesIda.setText(horariosLaborablesIda);

        String horariosLaborablesVuelta = selectedLinea.getHorarioLaboralVuelta(id);
        tvLaborablesVuelta.setText(horariosLaborablesVuelta);

        String horariosSabadosIda = selectedLinea.getHorarioSabadosIda(id);
        tvSabadosIda.setText(horariosSabadosIda);

        String horariosSabadosVuelta = selectedLinea.getHorarioSabadosVuelta(id);
        tvSabadosVuelta.setText(horariosSabadosVuelta);

        String horariosDomingosIda = selectedLinea.getHorarioDomingosIda(id);
        tvDomingosIda.setText(horariosDomingosIda);

        String horariosDomingosVuelta = selectedLinea.getHorarioDomingosVuelta(id);
        tvDomingosVuelta.setText(horariosDomingosVuelta);

        String horariosNocturnosIda = selectedLinea.getHorarioNocturnosIda(id);
        tvNocturnosIda.setText(horariosNocturnosIda);

        String horariosNocturnosVuelta = selectedLinea.getHorarioNocturnosVuelta(id);
        tvNocturnosVuelta.setText(horariosNocturnosVuelta);
    }

    public void verParadas(View view) {
        Intent intent = new Intent(this, ParadasActivity.class);
        intent.putExtra("data", selectedLinea);
        intent.putExtra("sentido", new Boolean(Boolean.TRUE));
        SelectedLineaActivity.this.startActivity(intent);
    }

    public void verMapa(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("data", selectedLinea);
        intent.putExtra("coords", (Serializable) marcadores);
        intent.putExtra("numParadas", numParadas);
        intent.putExtra("vehiculos", (Serializable) posVehiculos);
        intent.putExtra("numVehiculos", numVehiculos);
        SelectedLineaActivity.this.startActivity(intent);
    }

    public void getdataParadas(String rutaUrl) {
        marcadores = new HashSet<>();
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
//                    Log.e("LENGTH", String.valueOf(jsonArray.length()));

                    numParadas = jsonArray.length();

                    for (int i = 0; i < numParadas; i++) {
                        List<String> coord_par = new ArrayList<>();
                        String lat = jsonArray.getJSONObject(i).getString("lat");
                        String lon = jsonArray.getJSONObject(i).getString("lon");
                        String nombre = jsonArray.getJSONObject(i).getString("nombre");

                        coord_par.add(lat);
                        coord_par.add(lon);
                        coord_par.add(nombre);

                        marcadores.add(coord_par);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        Response.ErrorListener response_error_listener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, rutaUrl, response_listener, response_error_listener);
        getRequestQueue().add(stringRequest);
    }

    public void getdataVehiculos(String rutaUrl) {
        posVehiculos = new HashSet<>();
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", response);
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    numVehiculos = jsonArray.length();

                    for (int i = 0; i < numVehiculos; i++) {
                        List<String> coord_par = new ArrayList<>();
                        String lat = jsonArray.getJSONObject(i).getString("lat");
                        String lon = jsonArray.getJSONObject(i).getString("lon");

                        coord_par.add(lat);
                        coord_par.add(lon);

                        posVehiculos.add(coord_par);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        Response.ErrorListener response_error_listener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, rutaUrl, response_listener, response_error_listener);
        getRequestQueue().add(stringRequest);
    }


    public RequestQueue getRequestQueue() {
        //requestQueue is used to stack your request and handles your cache.
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

}
