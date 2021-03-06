package com.burbus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.burbus.adapter.EsperasAdapter;
import com.burbus.model.Espera;
import com.burbus.model.Parada;
import com.burbus.network.GetDataService;
import com.burbus.network.RetrofitClientInstance;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectedParadaActivity extends AppCompatActivity implements EsperasAdapter.SelectedEspera {

    TextView tvParada;
    Parada selectedParada;
    private EsperasAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    Toolbar toolbar;

    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_parada);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });
        adContainerView = findViewById(R.id.ad_view_container);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.tiempo_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        tvParada = findViewById(R.id.selectedParada);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/TradeGothicLTPro-Bold.ttf");

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            selectedParada = (Parada) intent.getSerializableExtra("data");

            String id = selectedParada.getId();
            String linea = selectedParada.getLinea();
            String nombre = selectedParada.getNombre();
            tvParada.setText(nombre);
            tvParada.setTypeface(type);

            progressDialog = new ProgressDialog(SelectedParadaActivity.this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setMessage("Cargando parada...");
            progressDialog.show();

            /*Create handle for the RetrofitInstance interface*/
            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

            Call<Espera> call = service.getEspera(linea, id);
            call.enqueue(new Callback<Espera>() {

                @Override
                public void onResponse(Call<Espera> call, Response<Espera> response) {
                    progressDialog.dismiss();

                    generateDataList(response.body().getEstimaciones());
                }

                @Override
                public void onFailure(Call<Espera> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(SelectedParadaActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
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

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<String> esperaList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new EsperasAdapter(esperaList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SelectedParadaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void selectedEspera(Espera espera) {
//        startActivity(new Intent(SelectedParadaActivity.this, SelectedParadaActivity.class).putExtra("data", "espera"));
    }
}
