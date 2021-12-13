package matplace.dao;

import java.util.ArrayList;

import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.model.Material;
import matplace.model.Persona;
import matplace.model.Reserva;
import matplace.model.Sala;

public class Format {
    
    private FileService fileService = FileService.getInstance();

    // revisar spliters characters
    public String takeData(Reserva reserva, String characterSplitLv1, String characterSplitLv2, String characterSplitLv3) {

        return takeDataPersona(reserva.getMiembrosSala(), characterSplitLv2, characterSplitLv3) + characterSplitLv1 +
        takeData(reserva.getResponsable(), characterSplitLv2) + characterSplitLv1 +
        takeData(reserva.getConserje(), characterSplitLv2) + characterSplitLv1 +
        takeData(reserva.getMaterial(), characterSplitLv2) + characterSplitLv1 +
        reserva.getDataInici() + characterSplitLv1 +
        reserva.getDataFinal();
    }


    public String takeDataPersona(ArrayList<Persona> dato, String characterSplitLv1, String characterSplitLv2) {

        String valor = "";

        for (Persona usuario : dato) {
            valor += takeData(usuario, characterSplitLv2) + characterSplitLv1;
        }

    return valor;

    }

    public String takeDataReserva(ArrayList<Reserva> dato, String characterSplitLv1, String characterSplitLv2, String character_split_lv4, String character_split_lv5) {

        String valor = "";

        for (Reserva reserva : dato) {
            valor += takeData(reserva, characterSplitLv2, character_split_lv4, character_split_lv5) + characterSplitLv1;
        }

    return valor;

    }


    public String takeData(Cliente dato, String characterSplit) {

        return dato.getID() + characterSplit + 
        dato.getNombre() + characterSplit + 
        dato.getApellidos() + characterSplit +  
        dato.getDNI() + characterSplit + 
        dato.getTelefono() + characterSplit + 
        dato.getMail();
    }

    public String takeData(Conserje dato, String characterSplit) {

        return dato.getID() + characterSplit + 
        dato.getNombre() + characterSplit + 
        dato.getApellidos() + characterSplit +  
        dato.getDNI() + characterSplit + 
        dato.getTelefono() + characterSplit + 
        dato.getMail();
    }

    public String takeData(Persona dato, String characterSplit) {

        return  dato.getNombre() + characterSplit + 
        dato.getApellidos() + characterSplit +  
        dato.getTelefono() + characterSplit + 
        dato.getMail();
    }

    // String EAN, String nombre, String descripcion, int cantidad, int cantidad_disponible

    public String takeData(Material dato, String characterSplit) {

        return dato.getEAN() + characterSplit + 
        dato.getNombre() + characterSplit + 
        dato.getDescripcion()  + characterSplit + 
        dato.getDescripcion() + characterSplit + 
        dato.getCantidad() + characterSplit + 
        dato.getCantidad_disponible();
    }

// String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas

    public String takeData(Sala sala, String characterSplitLv1, String characterSplitLv2, String characterSplitSplitLv3, String character_split_lv4, String character_split_lv5) {
        return sala.getNombre() + characterSplitLv1 +
        sala.getDescripcion() + characterSplitLv1 +
        sala.getCapacidad() + characterSplitLv1 +
        takeDataReserva(sala.getReservas(), characterSplitLv2, characterSplitSplitLv3, character_split_lv4, character_split_lv5);
    }



}
