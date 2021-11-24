/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;
import java.util.ArrayList;

import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.model.Material;
import matplace.model.Persona;
import matplace.model.Reserva;

// PROBLEMA, NO DECLARAMOS LOS SEPARADORES ENTRE LOS DATOS Y NO VA A SABER LEERLO (EL ARRAY)
/**
 *
 * @author pg_po
 */

public class ReservaDao implements Crud{

    private FileService fileService = FileService.getInstance();
    private Format format = new Format();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "conserje");
    
    //ArrayList<Persona> miembrosSala,Cliente responsable, Conserje conserje, Material material, Date dataInici, Date dataFinal

    @Override
    public void create(Object object) {
        Reserva reserva = (Reserva) object;
        fileService.escribirFichero(archivoDestino, format.takeData(reserva, fileService.getCHARACTER_SPLIT()));
    }

    @Override
    public Object read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/*
    public String takeData(ArrayList<Usuario> dato) {

        String valor = "";

        for (Usuario usuario : dato) {
            valor = takeData(usuario);
        }

    return valor;

    }

    public String takeData(Cliente dato) {

        return dato.getID() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getNombre() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getApellidos() + fileService.getCHARACTER_SPLIT_ARRAY() +  
        dato.getDNI() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getTelefono() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getMail();
    }

    public String takeData(Conserje dato) {

        return dato.getID() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getNombre() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getApellidos() + fileService.getCHARACTER_SPLIT_ARRAY() +  
        dato.getDNI() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getTelefono() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getMail();
    }

    public String takeData(Usuario dato) {

        return  dato.getNombre() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getApellidos() + fileService.getCHARACTER_SPLIT_ARRAY() +  
        dato.getTelefono() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getMail();
    }

    // String EAN, String nombre, String descripcion, int cantidad, int cantidad_disponible

    public String takeData(Material dato) {

        return dato.getEAN() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getNombre() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getDescripcion()  + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getDescripcion() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getCantidad() + fileService.getCHARACTER_SPLIT_ARRAY() + 
        dato.getCantidad_disponible();
    }

*/

}
