package com.alvin.mapping;

//10120078 - Alvin Izza Rohman - IF2
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map5Fragment extends Fragment {

    private MapView mapView;
    private GoogleMap googleMap;

    private static final LatLng[] FAVORITE_LOCATIONS = {
            new LatLng(-6.878513964084878, 107.61310370717),   // lokasi 1
            new LatLng(-6.878866824060992, 107.61261008976501),   // lokasi 2
            new LatLng(-6.88135069296891, 107.60769334415082),   // lokasi 3
            new LatLng(-6.884696049582251, 107.61358027391461),   // lokasi 4
            new LatLng(-6.883061045406562, 107.61494685941011)    // lokasi 5
    };

    private static final String[] LOCATION_NAMES = {
            "Jatinangor House, Cisitu Dago",   // Nama tempat 1
            "Ayam Crisbar Cisitu",       // Nama tempat 2
            "Warung Juljol",     // Nama tempat 3
            "Ayam Geprek Pangeran",   // Nama tempat 4
            "Nasi Padang Bahagia"        // Nama tempat 5
    };

    public Map5Fragment() {
        // Diperlukan konstruktor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map5, container, false);

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync(googleMap -> {
            this.googleMap = googleMap;
            // Set tipe peta
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            // Tambahkan pin dan label untuk setiap lokasi
            for (int i = 0; i < FAVORITE_LOCATIONS.length; i++) {
                LatLng location = FAVORITE_LOCATIONS[i];
                String name = LOCATION_NAMES[i];
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(location)
                        .title(name);
                Marker marker = googleMap.addMarker(markerOptions);
                marker.showInfoWindow();
            }

            // Atur tampilan kamera peta ke lokasi pertama
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FAVORITE_LOCATIONS[0], 13));
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}

