package com.adhoc.awt02.appagualima.Utilidades;

public class Utilidades {

    //Capos tabla trabajador
    public static final String TABLA_TRABAJADOR = "trabajador";
    public static final String C_ID = "id";
    public static final String C_DNI = "dni";
    public static final String C_NOMBRE = "nombre";
    public static final String C_APELLIDO_PATERNO = "apepater";
    public static final String C_APELLIDO_MATERNO = "apemater";
    public static final String C_FECHA_NACIMIENTO = "fechanac";
    public static final String C_TIPO_DOCUMENTO = "tpdd";

    public static  final String  CREAR_TABLA_TRABAJADOR ="CREATE TABLE "+TABLA_TRABAJADOR +
            " ( "+C_ID+" integer primary key autoincrement, "+C_DNI+" TEXT UNIQUE, " +
            C_NOMBRE+" TEXT,  "+C_APELLIDO_PATERNO+" TEXT, "+C_APELLIDO_MATERNO+" TEXT, " +
            C_FECHA_NACIMIENTO+" TEXT , "+C_TIPO_DOCUMENTO+" TEXT )";

}
