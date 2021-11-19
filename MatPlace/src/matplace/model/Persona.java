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
public abstract class Persona {

    private String nombre;
    private String apellidos;
    // private String DNI;
    private String telefono;
    private String mail;
    //private int ID;

    public Persona(String nombre, String apellidos, String telefono, String mail) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        //this.DNI = DNI;
        this.telefono = telefono;
        this.mail = mail;
        //this.ID = ID;
    }

    public Persona() {
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
}
