package com.adhoc.awt02.appagualima.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adhoc.awt02.appagualima.R;
import com.adhoc.awt02.appagualima.entidades.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class TrabajadorAdapterRecycler extends
        RecyclerView.Adapter<TrabajadorAdapterRecycler.TrabajadorViewHolder> implements View.OnClickListener{

    ArrayList<Trabajador> listaTrabajadores;

    private  View.OnClickListener listener;

    public TrabajadorAdapterRecycler(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    @NonNull
    @Override
    public TrabajadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trabajadores,
                null,false  );
        view.setOnClickListener(this);
        return new TrabajadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrabajadorViewHolder holder, int position) {

        holder.lblDni.setText(listaTrabajadores.get(position).getDni());
        holder.lblNombre.setText(listaTrabajadores.get(position).getNombre());
        holder.lblApepat.setText(listaTrabajadores.get(position).getApepater());
        holder.lblApemat.setText(listaTrabajadores.get(position).getApemater());

    }

    @Override
    public int getItemCount() {


        return listaTrabajadores.size();
    }




    public  void  setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class TrabajadorViewHolder extends RecyclerView.ViewHolder {

        TextView lblDni ,lblNombre,lblApepat, lblApemat ;
        public TrabajadorViewHolder(View itemView) {

            super(itemView);

             lblDni = (TextView) itemView.findViewById(R.id.lblDni_item);
             lblNombre = (TextView) itemView.findViewById(R.id.lblNombre_item);
             lblApepat = (TextView) itemView.findViewById(R.id.lblApepat_item);
             lblApemat = (TextView) itemView.findViewById(R.id.lblApemat_item);



        }
    }
}
