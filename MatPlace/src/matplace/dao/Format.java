package matplace.dao;

import java.util.ArrayList;

import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.model.Material;
import matplace.model.Reserva;
import matplace.model.Sala;
import matplace.model.Usuario;

public class Format {
    
    private FileService fileService = FileService.getInstance();

    // revisar spliters characters
    public String takeData(Reserva reserva, String characterSplit) {

        return takeData(reserva.getMiembrosSala(), characterSplit, fileService.getCHARACTER_SPLIT_ARRAY()) + characterSplit + 
        takeData(reserva.getResponsable(), fileService.getCHARACTER_SPLIT_ARRAY()) + characterSplit + 
        takeData(reserva.getConserje(), fileService.getCHARACTER_SPLIT_ARRAY()) + characterSplit + 
        takeData(reserva.getMaterial(), fileService.getCHARACTER_SPLIT_ARRAY()) + characterSplit + 
        reserva.getDataInici() + characterSplit + 
        reserva.getDataFinal();
    }


    public String takeData(ArrayList<Usuario> dato, String characterSplit, String characterSplitThis) {

        String valor = "";

        for (Usuario usuario : dato) {
            valor += takeData(usuario, characterSplit) + characterSplitThis;
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

    public String takeData(Usuario dato, String characterSplit) {

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

    public String takeData(Sala sala, String character_SPLIT) {
        return sala.getName() + character_SPLIT +
        "";
    }



}
