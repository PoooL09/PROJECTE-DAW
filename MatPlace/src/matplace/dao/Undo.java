package matplace.dao;

import matplace.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Undo {

    public Cliente yourClient(String dato, int id, String characterSplitLv1) {

        String[] clientesString = separate(dato, "\n");

        for (String x : clientesString) {
            Cliente cliente = creatorCliente(separate(x, characterSplitLv1));
            if (id == cliente.getID()) {
                return cliente;
            }
        }

        return null;
    }

    public Conserje yourConserje(String dato, int id, String characterSplitLv1) {

        String[] conserjeString = separate(dato, "\n");

        for (String x : conserjeString) {
            Conserje conserje = creatorConserje(separate(x, characterSplitLv1));
            if (id == conserje.getID()) {
                return conserje;
            }
        }

        return null;
    }

    public Material yourMaterial(String dato, int id, String characterSplitLv1) {

        // material no tiene id int sino k es ean String
        /*
        Material material = creatorMaterial(separate(dato, characterSplitLv1));
        return material;
        */
        return null;
    }

    public Reserva yourReserva(String dato, int id, String characterSplitLv1, String characterSplitLv2, String characterSplitLv3) {
        /*
        Reserva reserva = creatorReserva(separate(dato, characterSplitLv1), characterSplitLv2, characterSplitLv3);
        return reserva;
         */
        return null;
    }

    public Sala yourSala(String dato, int id, String characterSplitLv1, String characterSplitLv2, String characterSplitLv3, String characterSplitLv4, String characterSplitLv5) {

        String[] salaString = separate(dato, "\n");

        for (String x : salaString) {
            Sala sala = creatorSala(separate(x, characterSplitLv1), characterSplitLv2, characterSplitLv3, characterSplitLv4, characterSplitLv5);
            if (id == sala.getID()) {
                return sala;
            }
        }

        return null;
    }


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
        Reserva reserva = new Reserva(arrayPersona(dato[0], charactherSplitLv2, charatherSplitLv3),
                creatorCliente(separate(dato[1], charactherSplitLv2)),
                creatorConserje(separate(dato[2], charactherSplitLv2)),
                creatorMaterial(separate(dato[3], charactherSplitLv2)),
                takeDate(dato[4]),
                takeDate(dato[5]));
        return reserva;
    }

    public Date takeDate(String dato) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        //Date date = formatter.parse(dato);
        Date thedate = null;
        try {
            thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(dato);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return thedate;
    }


    public ArrayList<Reserva> arrayReserva(String dato, String charactherSplitLv2, String charatherSplitLv3, String charatherSplitLv4, String charatherSplitLv5) {

        String[] abc = separate(dato, charactherSplitLv2);
        ArrayList<Reserva> reservas = null;

        for (String x : abc) {
            Reserva reserva = creatorReserva(separate(x, charatherSplitLv3), charatherSplitLv4, charatherSplitLv5);
            reservas.add(reserva);
        }

        return reservas;
    }

    // int ID, String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas

    public Sala creatorSala(String[] dato, String charactherSplitLv2, String charatherSplitLv3, String charatherSplitLv4, String charatherSplitLv5) {

        Sala sala = new Sala(Integer.parseInt(dato[0]),
                dato[1],
                dato[2],
                Integer.parseInt(dato[3]),
                arrayReserva(dato[4], charactherSplitLv2, charatherSplitLv3, charatherSplitLv4, charatherSplitLv5));

        return sala;
    }


}
