/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.model;

import java.util.ArrayList;

/**
 *
 * @author pg_po
 */
public class Sala {

    private final int ID;
    private static int incrementoID = 1;
    private String nombre;
    private String descripcion;
    private int capacidad;
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Sala() {
        ID = incrementoID;
        incrementoID++;
    }

    public Sala(String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.reservas = reservas;
        ID = incrementoID;
        incrementoID++;
    }

    public Sala(int ID, String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.reservas = reservas;
    }

    //public void afegir(Reserva reserva) {
    //  reservas.add(reserva);
    //}

    public int getID() {
        return this.ID;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    

}
