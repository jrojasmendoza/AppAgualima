package com.adhoc.awt02.appagualima.entidades;

public class Trabajador {

    public  int id;
    public String  dni;
    public String  nombre;
    public String  apepater;
    public String  apemater;
    public String fechanac;
    public Integer tpdd;

    public Trabajador(int id, String dni, String nombre,
                      String apepater, String apemater, String fechanac, Integer tpdd) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apepater = apepater;
        this.apemater = apemater;
        this.fechanac = fechanac;
        this.tpdd = tpdd;
    }


    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apepater, String apemater) {
        this.dni = dni;
        this.nombre = nombre;
        this.apepater = apepater;
        this.apemater = apemater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepater() {
        return apepater;
    }

    public void setApepater(String apepater) {
        this.apepater = apepater;
    }

    public String getApemater() {
        return apemater;
    }

    public void setApemater(String apemater) {
        this.apemater = apemater;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getTpdd() {
        return tpdd;
    }

    public void setTpdd(Integer tpdd) {
        this.tpdd = tpdd;
    }
}
