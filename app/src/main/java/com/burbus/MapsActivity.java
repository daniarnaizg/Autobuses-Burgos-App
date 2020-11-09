package com.burbus;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;

import com.android.volley.RequestQueue;
import com.burbus.model.Linea;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashSet;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    HashSet<List<String>> marcadores;
    HashSet<List<String>> posVehiculos;
    RequestQueue mRequestQueue;
    Linea linea;
    String rutaUrl;
    Integer numParadas;
    Integer numVehiculos;

    private FrameLayout adContainerView;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });
        adContainerView = findViewById(R.id.ad_view_map_container);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.mapa_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            linea = (Linea) intent.getSerializableExtra("data");

            Bundle extras = getIntent().getExtras();

            marcadores = (HashSet<List<String>>) extras.getSerializable("coords");
            numParadas = extras.getInt("numParadas");

            posVehiculos = (HashSet<List<String>>) extras.getSerializable("vehiculos");
            numVehiculos = extras.getInt("numVehiculos");

            String idLInea = linea.getId();
            rutaUrl = String.format("https://bus-burgos-rest-2.herokuapp.com/rutas/%s", idLInea);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Burgos = new LatLng(42.343990, -3.696906);

        for (List<String> coords : marcadores) {
            double lat = Double.parseDouble(coords.get(0));
            double lon = Double.parseDouble(coords.get(1));
            String nombre = coords.get(2);

            LatLng position = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(position).title(nombre).icon(BitmapDescriptorFactory.fromResource(R.drawable.stop_marker)));
        }

        for (List<String> coords : posVehiculos) {
            double lat = Double.parseDouble(coords.get(0));
            double lon = Double.parseDouble(coords.get(1));

            LatLng position = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(position).title("AUTOBUS").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_marker_mio)));
        }

        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(Burgos , 14.0f) );
    }
}
