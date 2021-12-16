/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.model;

import matplace.dao.ServiceID;

/**
 *
 * @author pg_po
 */
public class Cliente extends Persona {
    
    private String DNI;
    private int ID;
    private static int incrementoID;

    public Cliente() {
        this.ID = incrementoID;
        incrementoID++;
        new ServiceID().setIDFile();
    }

    public Cliente(int ID, String nombre, String apellidos, String telefono, String mail, String DNI) {
        super(nombre, apellidos, telefono, mail);
        this.DNI = DNI;
        this.ID = ID;
    }

    public Cliente(String nombre, String apellidos, String DNI, String telefono, String mail) {
        super(nombre, apellidos, telefono, mail);
        incrementoID++;
        this.ID = incrementoID;
        this.DNI = DNI;
        new ServiceID().setIDFile();
    }

    @Override
    public String toString() {
        return "ID:" + ID +
                " " + this.getNombre() + " " + this.getApellidos() +
                " DNI:" + this.getDNI();
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public static int getIncrementoID() {
        return incrementoID;
    }

    public static void setIncrementoID(int incrementoID) {
        Cliente.incrementoID = incrementoID;
    }




}
