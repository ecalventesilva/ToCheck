package com.example.tocheck;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mapa;
    private final LatLng malaga = new LatLng(36.7201600, -4.4203400);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(false);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(malaga, 15));
        mapa.addMarker(new MarkerOptions()
                .position(malaga)
                .title("X")
                .snippet("Oficina")
                .icon(BitmapDescriptorFactory
                .fromResource(android.R.drawable.ic_menu_compass))
                .anchor(0.5f, 0.5f));
        mapa.setOnMapClickListener(this);
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
                mapa.setMyLocationEnabled(true);
                mapa.getUiSettings().setCompassEnabled(true);
        }
    }

    public void moveCamera(View view) {
        mapa.moveCamera(CameraUpdateFactory.newLatLng(malaga));
    }

    public void animateCamera(View view) {
        mapa.animateCamera(CameraUpdateFactory.newLatLng(malaga));
    }

    public void addMarker(View view) {
        mapa.addMarker(new MarkerOptions().position(
                mapa.getCameraPosition().target));
    }

    @Override
    public void onMapClick(LatLng puntoPulsado) {
        mapa.addMarker(new MarkerOptions().position(puntoPulsado)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }
}
