package com.adhoc.awt02.appagualima.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adhoc.awt02.appagualima.R;
import com.adhoc.awt02.appagualima.entidades.Trabajador;

import java.util.List;

public class TrabajadorAdapter extends ArrayAdapter {
    List<Trabajador> miLista;


    public TrabajadorAdapter(Context context, List<Trabajador> lista) {
        super(context, R.layout.item_trabajadores, lista);
        miLista = lista;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View view = convertView;

        if(view==null ){
            view=inflater.inflate(R.layout.item_trabajadores, null);
        }

        TextView lblDni = (TextView) view.findViewById(R.id.lblDni_item);
        TextView lblNombre = (TextView) view.findViewById(R.id.lblNombre_item);
        TextView lblApepat = (TextView) view.findViewById(R.id.lblApepat_item);
        TextView lblApemat = (TextView) view.findViewById(R.id.lblApemat_item);


        lblDni.setText(miLista.get(position).getDni());
        lblNombre.setText(miLista.get(position).getNombre());
        lblApepat.setText(miLista.get(position).getApepater());
        lblApemat.setText(miLista.get(position).getApemater());

        return view;
    }
}
