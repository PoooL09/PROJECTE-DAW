/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.model;

/**
 *
 * @author pg_po
 */
public class Cliente extends Persona {

    private static int incrementoID;

    public Cliente() {
        super.setID(incrementoID);
        incrementoID++;
    }

    public Cliente(String nombre, String apellidos, String DNI, String telefono, String mail) {
        super(nombre, apellidos, DNI, telefono, mail, incrementoID);
        incrementoID++;
    }

    public static int getIncrementoID() {
        return incrementoID;
    }

    public static void setIncrementoID(int incrementoID) {
        Cliente.incrementoID = incrementoID;
    }

}
