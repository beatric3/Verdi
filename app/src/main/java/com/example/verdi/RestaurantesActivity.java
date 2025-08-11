package com.example.verdi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class RestaurantesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private final int LOCATION_REQUEST_CODE = 101;
    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            return;
        }

        mMap.setMyLocationEnabled(true);

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                currentLocation = location;

                LatLng userLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLng, 15f));

                adicionarRestaurantesMockados(location);
            }
        });
    }

    private void adicionarRestaurantesMockados(Location userLocation) {
        // Restaurantes fictícios baseados na localização do usuário
        LatLng[] restaurantes = {
                new LatLng(userLocation.getLatitude() + 0.001, userLocation.getLongitude() + 0.001),
                new LatLng(userLocation.getLatitude() - 0.0012, userLocation.getLongitude() + 0.0008),
                new LatLng(userLocation.getLatitude() + 0.0015, userLocation.getLongitude() - 0.0009)
        };

        String[] nomes = {
                "Restaurante Veggie",
                "Sabor Natural",
                "Green Garden"
        };

        for (int i = 0; i < restaurantes.length; i++) {
            float[] results = new float[1];
            Location.distanceBetween(
                    userLocation.getLatitude(), userLocation.getLongitude(),
                    restaurantes[i].latitude, restaurantes[i].longitude,
                    results
            );

            int distanciaMetros = (int) results[0];

            mMap.addMarker(new MarkerOptions()
                    .position(restaurantes[i])
                    .title(nomes[i])
                    .snippet("Aprox. " + distanciaMetros + "m de distância"));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_REQUEST_CODE &&
                grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onMapReady(mMap);
        }
    }
}
