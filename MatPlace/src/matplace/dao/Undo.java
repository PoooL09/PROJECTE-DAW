package matplace.dao;

import matplace.model.*;

import java.util.ArrayList;

public class Undo {

    public String[] separate(String dato, String characterSplitLv1) {

        String[] chopped = dato.split(characterSplitLv1);

        return chopped;
    }

    // int id, String nombre, String apellidos, String DNI, String telefono, String mail
    public Cliente creatorCliente(String[] dato) {
        Cliente cliente = new Cliente(Integer.parseInt(dato[0]), dato[1], dato[2], dato[3], dato[4], dato[5]);
        return cliente;
    }

    // int id, String nombre, String apellidos, String DNI, String telefono, String mail
    public Conserje creatorConserje(String[] dato) {
        Conserje conserje = new Conserje(Integer.parseInt(dato[0]), dato[1], dato[2], dato[3], dato[4], dato[5]);
        return conserje;
    }

    // String EAN, String nombre, String descripcion, int cantidad, int cantidad_disponible
    public Material creatorMaterial(String[] dato) {
        Material material = new Material(dato[0], dato[1], dato[2], Integer.parseInt(dato[3]), Integer.parseInt(dato[4]));
        return material;
    }

    // String nombre, String apellidos, String telefono, String mail
    public Persona creatorPersona(String[] dato) {
        Persona persona = new Persona(dato[0], dato[1], dato[2], dato[3]);
        return persona;
    }

    public ArrayList<Persona> arrayPersona(String dato, String charactherSplitLv2, String charatherSplitLv3) {

        String[] abc = separate(dato, charactherSplitLv2);
        ArrayList<Persona> personas = null;

        for (String x : abc) {
            Persona persona = creatorPersona(separate(x, charatherSplitLv3));
            personas.add(persona);
        }

        return personas;
    }

    // ArrayList<Persona> miembrosSala,Cliente responsable, Conserje conserje, Material material, Date dataInici, Date dataFinal
    public Reserva creatorReserva(String[] dato, String charactherSplitLv2, String charatherSplitLv3) {
        Reserva reserva = new Reserva(arrayPersona(dato[0], charactherSplitLv2, charatherSplitLv3), creatorCliente(separate(dato[0], charactherSplitLv2)), dato[0], dato[0], dato[0], dato[0]);
        return reserva;
    }


    // int ID, String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas

}
