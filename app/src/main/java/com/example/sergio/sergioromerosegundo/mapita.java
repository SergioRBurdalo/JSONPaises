package com.example.sergio.sergioromerosegundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapita extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener  {

    // GOOGLE MAPS
    private GoogleMap mapa;
    private LatLng libreriaCoord;
    private MarkerOptions marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapita);
    }

    // METODOS DE GOOGLE MAPS

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapa = googleMap;
        mapa.setMapType(googleMap.MAP_TYPE_NORMAL);  //Tipo de mapa Satelite
        /**
         * MAP_TYPE_NORMAL: Basic map.
         * MAP_TYPE_SATELLITE: Satellite imagery.
         * MAP_TYPE_HYBRID: Satellite imagery with roads and labels.
         * MAP_TYPE_TERRAIN: Topographic data.
         * MAP_TYPE_NONE: No base map tiles.*/
        mapa.getUiSettings().setZoomControlsEnabled(true);  //Botones zoom mapa

        // Pongo Marcador en las coordenadas de la Libreria
        libreriaCoord = new LatLng(40.4800448, -3.3721068);
        marcador = new MarkerOptions().title("Libreria Re-Read")
                .position(libreriaCoord);
        marcador.draggable(true);
        mapa.addMarker(marcador);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(libreriaCoord, 17));
        mapa.setOnMarkerDragListener(this);

    }

    @Override
    public void onMarkerDragStart(Marker marker) {
    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}
