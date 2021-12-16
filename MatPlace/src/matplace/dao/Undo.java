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

    public ArrayList<Cliente> yourClientes(String dato, String characterSplitLv1) {
        String[] clientesString = separate(dato, "\n");
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (String x : clientesString) {
            clientes.add(creatorCliente(separate(x, characterSplitLv1)));
        }
        return clientes;
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

    public ArrayList<Conserje> yourConserjes(String dato, String characterSplitLv1) {
        String[] conserjesString = separate(dato, "\n");
        ArrayList<Conserje> conserjes = new ArrayList<>();
        for (String x : conserjesString) {
            conserjes.add(creatorConserje(separate(x, characterSplitLv1)));
        }
        return conserjes;
    }

    public Material yourMaterial(String dato, int id, String characterSplitLv1) {

        // material no tiene id int sino k es ean String
        /*
        Material material = creatorMaterial(separate(dato, characterSplitLv1));
        return material;
        */

        String[] materialString = separate(dato, "\n");

        for (String x : materialString) {
            Material material = creatorMaterial(separate(x, characterSplitLv1));
            if (id == material.getEAN()) {
                return material;
            }
        }

        return null;
    }

    public ArrayList<Material> yourMaterials(String dato, String characterSplitLv1) {
        String[] materialsString = separate(dato, "\n");
        ArrayList<Material> materials = new ArrayList<>();
        for (String x : materialsString) {
            materials.add(creatorMaterial(separate(x, characterSplitLv1)));
        }
        return materials;
    }


    public Reserva yourReserva(String dato, int id, String characterSplitLv1, String characterSplitLv2, String characterSplitLv3) {
        /*
        Reserva reserva = creatorReserva(separate(dato, characterSplitLv1), characterSplitLv2, characterSplitLv3);
        return reserva;
         */

        String[] materialString = separate(dato, "\n");

        for (String x : materialString) {
            Reserva reserva = creatorReserva(separate(x, characterSplitLv1), characterSplitLv2, characterSplitLv3);
            if (id == reserva.getID()) {
                return reserva;
            }
        }

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

    public ArrayList<Sala> yourSalas(String dato, String characterSplitLv1, String characterSplitLv2, String characterSplitLv3, String characterSplitLv4, String characterSplitLv5) {
        String[] salasString = separate(dato, "\n");
        ArrayList<Sala> salas = new ArrayList<>();
        for (String x : salasString) {
            salas.add(creatorSala(separate(x, characterSplitLv1), characterSplitLv2, characterSplitLv3, characterSplitLv4, characterSplitLv5));
        }
        return salas;
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
        Material material = new Material(Integer.parseInt(dato[0]), dato[1], dato[2], Integer.parseInt(dato[3]));
        return material;
    }

    // String nombre, String apellidos, String telefono, String mail
    public Persona creatorPersona(String[] dato) {
        Persona persona = new Persona(dato[0], dato[1], dato[2], dato[3]);
        return persona;
    }

    public ArrayList<Persona> arrayPersona(String dato, String charactherSplitLv2, String charatherSplitLv3) {

        String[] abc = separate(dato, charactherSplitLv2);
        ArrayList<Persona> personas = new ArrayList<>();

        for (String x : abc) {
            Persona persona = creatorPersona(separate(x, charatherSplitLv3));
            personas.add(persona);
        }

        return personas;
    }

    // ArrayList<Persona> miembrosSala,Cliente responsable, Conserje conserje, Material material, Date dataInici, Date dataFinal
    public Reserva creatorReserva(String[] dato, String charactherSplitLv2, String charatherSplitLv3) {
        Reserva reserva = new Reserva(Integer.parseInt(dato[0]),
                arrayPersona(dato[1], charactherSplitLv2, charatherSplitLv3),
                creatorCliente(separate(dato[2], charactherSplitLv2)),
                creatorConserje(separate(dato[3], charactherSplitLv2)),
                creatorMaterial(separate(dato[4], charactherSplitLv2)),
                takeDate(dato[5]),
                takeDate(dato[6]));
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
        ArrayList<Reserva> reservas = new ArrayList<>();

        for (String x : abc) {
            Reserva reserva = creatorReserva(separate(x, charatherSplitLv3), charatherSplitLv4, charatherSplitLv5);
            reservas.add(reserva);
        }

        return reservas;
    }

    // int ID, String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas

    public Sala creatorSala(String[] dato, String charactherSplitLv2, String charatherSplitLv3, String charatherSplitLv4, String charatherSplitLv5) {

        Sala sala = null;

        if (dato[4].equals("")) {
            sala = new Sala(Integer.parseInt(dato[0]),
                    dato[1],
                    dato[2],
                    Integer.parseInt(dato[3]),
                    new ArrayList<>());
        } else {
             sala = new Sala(Integer.parseInt(dato[0]),
                    dato[1],
                    dato[2],
                    Integer.parseInt(dato[3]),
                    arrayReserva(dato[4], charactherSplitLv2, charatherSplitLv3, charatherSplitLv4, charatherSplitLv5));
        }

        return sala;
    }


}
