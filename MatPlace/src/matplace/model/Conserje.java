/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.model;

import matplace.dao.ServiceID;

/**
 * @author pg_po
 */
public class Conserje extends Persona {

    private String DNI;
    private int ID;
    private static int incrementoID;

    public Conserje(int ID, String nombre, String apellidos, String telefono, String mail, String DNI) {
        super(nombre, apellidos, telefono, mail);
        this.DNI = DNI;
        this.ID = ID;
    }

    public Conserje(String nombre, String apellidos, String DNI, String telefono, String mail) {
        super(nombre, apellidos, telefono, mail);
        incrementoID++;
        this.ID = incrementoID;
        this.DNI = DNI;
        new ServiceID().setIDFile();
    }

    public Conserje() {
        this.ID = incrementoID;
        incrementoID++;
        new ServiceID().setIDFile();
    }

    @Override
    public String toString() {
        return "ID:" + ID + " " + this.getNombre() +" " + this.getApellidos() + " DNI:" + DNI ;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Conserje DNI(String DNI) {
        setDNI(DNI);
        return this;
    }

    public static int getIncrementoID() {
        return incrementoID;
    }

    public static void setIncrementoID(int incrementoID) {
        Conserje.incrementoID = incrementoID;
    }


}
