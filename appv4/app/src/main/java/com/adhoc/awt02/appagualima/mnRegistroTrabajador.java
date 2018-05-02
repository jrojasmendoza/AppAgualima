package com.adhoc.awt02.appagualima;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import com.adhoc.awt02.appagualima.DB_HELPER.SqliteHelper;
import com.adhoc.awt02.appagualima.Utilidades.Utilidades;

public class mnRegistroTrabajador extends Fragment {
    EditText dni, nombre, apepat, apemat, fecnac, tpddoc;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Registro de Trabajador");




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_registro_trabajadores,container,false);

        dni  = (EditText) view.findViewById(R.id.txtDni);
        nombre  = (EditText) view.findViewById(R.id.txtNonbre);
        apepat  = (EditText) view.findViewById(R.id.txtApePat);
        apemat  = (EditText) view.findViewById(R.id.txtApeMat);
        tpddoc  = (EditText) view.findViewById(R.id.txtTipodoc);
        fecnac = (EditText) view.findViewById(R.id.txtFechanac);


        fecnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.txtFechanac:
                        mostrarDialogoFecha();
                        break;
                }
            }
        });

        Button btnRegistrar = (Button)  view.findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m = validar(dni.getText().toString(),nombre.getText().toString(),apemat.getText().toString(),
                        apepat.getText().toString(),tpddoc.getText().toString(),
                        fecnac.getText().toString());

                if(m.length()>2){
                    Toast.makeText(getActivity().getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                }else {

                    try {
                        registrarTrabajador();
                    } catch (SQLException e){
                        Toast.makeText(getActivity(), "DNI duplicado",
                                Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }
            }
        });





        return view;

    }



    private void registrarTrabajador() {
        Utilidades ut = new Utilidades();

        SqliteHelper cnn = new SqliteHelper(getContext(), "BD",  null,1);

        SQLiteDatabase db = cnn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ut.C_DNI,dni.getText().toString());
        values.put(ut.C_NOMBRE,nombre.getText().toString());
        values.put(ut.C_APELLIDO_PATERNO,apepat.getText().toString());
        values.put(ut.C_APELLIDO_MATERNO,apemat.getText().toString());
        values.put(ut.C_FECHA_NACIMIENTO,fecnac.getText().toString());
        values.put(ut.C_TIPO_DOCUMENTO,tpddoc.getText().toString());

        Long c  = db.insert(ut.TABLA_TRABAJADOR,null,values);

        if (c>1) {
            Toast.makeText(getActivity().getApplicationContext(), "El trabajador " + nombre.getText().toString()
                    + " fue registrado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "El documneto de indentidad ya está registrado", Toast.LENGTH_SHORT).show();
        }
    }


    /*Metodos para las fechas*/
    private void mostrarDialogoFecha() {
        DatePickerFragment newFragment =
                DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                final String selectedDate = year + " - " + dosDigitos(month+1) + " - " + dosDigitos(day);
                fecnac.setText(selectedDate);
                    }
                });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }


    private String dosDigitos(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

    private String validar(String dni, String nombre, String apat,
                           String amat, String tdoc, String fch){

       String mensaje="";

       if(dni.length()<1){
           mensaje="Completar DNI";
           
           return  mensaje;
       }
        if(nombre.length()<1){
            mensaje="Completar el nombre";
            return  mensaje;
        }

        if(apat.length()<1){
            mensaje="Completar apellido paterno";
            return  mensaje;
        }
        if(amat.length()<1){
            mensaje="Completar apellido materno";
            return  mensaje;
        }

        if(tdoc.length()<1){
            mensaje="Seleccionar el documento";
            return  mensaje;
        }

        if(fch.length()<1){
            mensaje="Completar la fecha de nacimiento";
            return  mensaje;
        }


        return  mensaje;
    }



}
