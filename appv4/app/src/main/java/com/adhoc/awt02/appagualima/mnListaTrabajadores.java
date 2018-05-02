package com.adhoc.awt02.appagualima;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.adhoc.awt02.appagualima.Adaptadores.TrabajadorAdapter;
import com.adhoc.awt02.appagualima.Adaptadores.TrabajadorAdapterRecycler;
import com.adhoc.awt02.appagualima.DB_HELPER.SqliteHelper;
import com.adhoc.awt02.appagualima.entidades.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class mnListaTrabajadores extends Fragment {

    ArrayList<Trabajador> listaTrabajadores;
    RecyclerView recyclerTrabajadores;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Listado de Trabajdores");

        listaTrabajadores = new ArrayList<>();
        recyclerTrabajadores = view.findViewById(R.id.lstTrbajadores);
        final TrabajadorAdapterRecycler adapter = new TrabajadorAdapterRecycler(listaTrabajadores);
        recyclerTrabajadores.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarListaTrabajadores();


        recyclerTrabajadores.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mnRegistroTrabajador fr=new mnRegistroTrabajador();
                fr.setArguments(savedInstanceState);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_menu,fr)
                        .addToBackStack(null)
                        .commit();



            }
        });

    }



    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fgt_lista_trabajadores,container,false);



        return  view;
    }

    private void llenarListaTrabajadores() {

        final SqliteHelper helper = new SqliteHelper(getContext().getApplicationContext(),
                "BD",  null,1);

        SQLiteDatabase bd = helper.getReadableDatabase();

        Cursor cursor = bd.rawQuery("SELECT dni , nombre  , apepater , apemater " +
                "FROM trabajador", null);

        List<Trabajador> miLista = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {

                String dni = cursor.getString(0);
                String nombre = cursor.getString(1);
                String apepat = cursor.getString(2);
                String apemat = cursor.getString(3);

                listaTrabajadores.add(new Trabajador(dni , nombre , apepat,apemat));
            }while (cursor.moveToNext());
        }
        cursor.close();
        bd.close();

    }



}
