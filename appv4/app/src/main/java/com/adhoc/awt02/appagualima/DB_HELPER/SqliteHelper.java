package com.adhoc.awt02.appagualima.DB_HELPER;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.adhoc.awt02.appagualima.Utilidades.Utilidades;
import com.adhoc.awt02.appagualima.mnRegistroTrabajador;

public class SqliteHelper extends SQLiteOpenHelper {



    final  String crearTbUser = "create table usuarios (id integer primary key autoincrement, codigo text," +
            "estadoregistro integer, idemp integer, usuario text, clave text)";

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(crearTbUser);
        db.execSQL(Utilidades.CREAR_TABLA_TRABAJADOR);

        db.execSQL("insert into usuarios values(1,'00001',1,1,'admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS trabajador");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);

    }


    public Cursor Logeo (String usu, String pass){
        Log.d("Tag","Hola");

        Cursor  micursor = null;
        micursor = this.getReadableDatabase().query("usuarios", new String[]{"id", "codigo",
                        "estadoregistro","idemp", "usuario", "clave"},
                "usuario like '"+usu+"'and clave like '"+pass+"'",
                null, null,null,null);

        return micursor;
    }




}
