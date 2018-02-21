package com.example.sergio.sergioromerosegundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    ListView lvDatosPaises;

    //FRAGMENT
    private SupportMapFragment fragmentMap;



    private static final String URL = "https://restcountries.eu/rest/v2/all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDatosPaises = findViewById(R.id.lvDatosPaises);

        // FRAGMENT + GOOGLE MAPS
        fragmentMap = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMap);
        fragmentMap.getMapAsync((OnMapReadyCallback) this);

        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                ArrayList<Paises> listaPaises = new ArrayList<Paises>();

                try {
                    JSONObject jsonObjectPrinci = new JSONObject(response.toString(0));

                    JSONArray JSONList = jsonObjectPrinci.getJSONArray("name");

                    //Creamos los JSONArrays
                    //Recorremos el primer JSONArray

                    for (int i = 0; i < JSONList.length(); i++) {
                        String nIngles = jsonObjectPrinci.getString("name");
                        /*String nCastellano = JSONList.getJSONObject(i).getJSONObject("main").getString("pressure");
                        String clave = JSONList.getJSONObject(i).getJSONObject("main").getString("humidity");
                        String capital = JSONList.getJSONObject(i).getJSONObject("clouds").getString("all");
                        String continente = JSONList.getJSONObject(i).getJSONObject("main").getString("temp");
                        String poblacion = JSONList.getJSONObject(i).getJSONObject("main").getString("pressure");
                        String latitud = JSONList.getJSONObject(i).getJSONObject("main").getString("humidity");
                        String longitud = JSONList.getJSONObject(i).getJSONObject("clouds").getString("all");
                        String fronteras = JSONList.getJSONObject(i).getJSONObject("clouds").getString("all");*/


                        Paises registro = new Paises(nIngles);

                        listaPaises.add(registro);
                    }
                    AdapterPais adaptador = new AdapterPais(getApplicationContext(), listaPaises);
                    lvDatosPaises.setAdapter(adaptador);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

                request.add(jsonArrayRequest);


        lvDatosPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Paises obj = (Paises) adapterView.getItemAtPosition(i);

                Intent paso = new Intent(getApplicationContext(), mapita.class);
                paso.putExtra("objeto", (Serializable)obj);
                startActivity(paso);
            }
        });
    }


}


