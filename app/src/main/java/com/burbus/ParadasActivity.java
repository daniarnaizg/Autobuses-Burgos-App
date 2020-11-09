package com.burbus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.burbus.adapter.ParadasAdapter;
import com.burbus.model.Linea;
import com.burbus.model.Parada;
import com.burbus.network.GetDataService;
import com.burbus.network.RetrofitClientInstance;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParadasActivity extends AppCompatActivity implements ParadasAdapter.SelectedParada {

    TextView tvLinea;
    TextView tvId;
    private ParadasAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    Toolbar toolbar;
    Boolean sentido;
    Linea linea;
    Call<List<Parada>> call_temp;

    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paradas);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });
        adContainerView = findViewById(R.id.ad_view_container);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.paradas_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        tvLinea = findViewById(R.id.selectedLinea);
        tvId = findViewById(R.id.selectedId);
        toolbar = findViewById(R.id.toolbar);

        Intent intent = getIntent();

        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/TradeGothicLTPro-Bold.ttf");

        if (intent.getExtras() != null) {
            linea = (Linea) intent.getSerializableExtra("data");
            Bundle extras = getIntent().getExtras();
            sentido = extras.getBoolean("sentido");

            String id = linea.getId();

            String colorLinea = linea.getColor(id);
            toolbar.setBackgroundColor(Color.parseColor(colorLinea));

            if (id.equals("38")) {
                tvId.setText("3B");
            } else {
                tvId.setText(id);
            }
            tvId.setTypeface(type);

            String nombreIda = linea.getNombreIda();
            String nombreVuelta = linea.getNombreVuelta();


            progressDialog = new ProgressDialog(ParadasActivity.this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setMessage("Cargando paradas...");
            progressDialog.show();

            /*Create handle for the RetrofitInstance interface*/
            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

            if (sentido) {
                call_temp = service.getParadasSentido(id, "1");
                if (nombreVuelta == null) {
                    tvLinea.setText(String.format("%s", nombreIda));
                } else {
                    tvLinea.setText(String.format("%s — %s", nombreIda, nombreVuelta));
                }
            } else {
                call_temp = service.getParadasSentido(id, "2");
                if (nombreVuelta == null) {
                    tvLinea.setText(String.format("%s", nombreIda));
                } else {
                    tvLinea.setText(String.format("%s — %s", nombreVuelta, nombreIda));
                }
            }
            tvLinea.setTypeface(type);

            Call<List<Parada>> call = call_temp;
            call.enqueue(new Callback<List<Parada>>() {

                @Override
                public void onResponse(Call<List<Parada>> call, Response<List<Parada>> response) {
                    progressDialog.dismiss();

                    List<Parada> cleanParadas = removeDuplicates(response.body());

                    generateDataList(cleanParadas);
                }

                @Override
                public void onFailure(Call<List<Parada>> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(ParadasActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
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

    private List<Parada> removeDuplicates(List<Parada> list) {
        List<Parada> distinctParadas = new ArrayList();
        List<String> nombres = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            Parada parada = list.remove(0);
            String nombre = parada.getNombre();
            if (!nombres.contains(nombre)) {
                distinctParadas.add(parada);
                nombres.add(nombre);
            }
        }
        list.clear();
        list.addAll(distinctParadas);
        return list;
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Parada> paradasList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new ParadasAdapter(paradasList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ParadasActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void selectedParada(Parada parada) {
        startActivity(new Intent(ParadasActivity.this, SelectedParadaActivity.class).putExtra("data", parada));
    }

    public void cambiarSentido(View view) {
        Intent intent = new Intent(ParadasActivity.this, ParadasActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", linea);
        bundle.putBoolean("sentido", !sentido);
        intent.putExtras(bundle);
        startActivity(intent);
        ParadasActivity.this.finish();
    }
}
