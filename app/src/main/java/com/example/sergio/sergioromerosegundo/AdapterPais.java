package com.example.sergio.sergioromerosegundo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sergio on 21/02/2018.
 */

public class AdapterPais extends BaseAdapter {

    Context context;
    ArrayList<Paises> listaDatos;

    public AdapterPais(Context applicationContext, ArrayList<Paises> listaPaises) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        LayoutInflater inflate =LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.item_pais, null);

        TextView tvNIngles, tvNCastellano,tvClave,tvCapital,tvContinente,tvPoblacion,tvLatitud,tvLongitud,tvFrontera;
        tvNIngles = vista.findViewById(R.id.tvNIngles);
        tvNCastellano = vista.findViewById(R.id.tvNCastellano);
        tvClave = vista.findViewById(R.id.tvClave);
        tvCapital = vista.findViewById(R.id.tvCapital);
        tvContinente = vista.findViewById(R.id.tvContinente);
        tvPoblacion = vista.findViewById(R.id.tvPoblacion);
        tvLatitud = vista.findViewById(R.id.tvLatitud);
        tvLongitud = vista.findViewById(R.id.tvLongitud);
        tvFrontera = vista.findViewById(R.id.tvFrontera);



        // IMPRIMO LOS VALORES DEL ARRAY LIST

        tvNIngles.setText(tvNIngles.getText().toString()+" "+listaDatos.get(i).getNombreIn());
        tvNCastellano.setText(tvNCastellano.getText().toString()+" "+listaDatos.get(i).getNombreEs());
        tvClave.setText(tvClave.getText().toString()+" "+listaDatos.get(i).getClave());
        tvCapital.setText(tvCapital.getText().toString()+" "+listaDatos.get(i).getCapital());
        tvContinente.setText(tvContinente.getText().toString()+" "+listaDatos.get(i).getContinente());
        tvPoblacion.setText(tvPoblacion.getText().toString()+" "+listaDatos.get(i).getPoblacion());
        tvLatitud.setText(tvLatitud.getText().toString()+" "+listaDatos.get(i).getLatitud());
        tvLongitud.setText(tvLongitud.getText().toString()+" "+listaDatos.get(i).getLongitud());
        tvFrontera.setText(tvFrontera.getText().toString()+" "+listaDatos.get(i).getPaisFront());

        return vista;
    }
}
