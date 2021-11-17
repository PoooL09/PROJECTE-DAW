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

    public Sala(String nombre) {
        this.nombre = nombre;
        ID = incrementoID;
        incrementoID++;
    }

    //public void afegir(Reserva reserva) {
    //  reservas.add(reserva);
    //}
    public void afegeixReserva() {

    }

    public void anulaReserva() {

    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getIncrementoID() {
        return incrementoID;
    }

    public static void setIncrementoID(int incrementoID) {
        Sala.incrementoID = incrementoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
