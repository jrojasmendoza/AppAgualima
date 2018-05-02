package com.adhoc.awt02.appagualima;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class mnRegistroActividades extends Fragment {

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        getActivity().setTitle("Registro de Actividades");
        Toast.makeText(getActivity(), "Hola soy un Toast 1", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "Hola soy un Toast 2", Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fgt_registro_tareas,container,false);

    }
}

