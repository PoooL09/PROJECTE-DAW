package matplace.dao;

import java.io.File;

import matplace.model.Sala;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pg_po
 */
public class SalaDao implements Crud{

    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "sala");
    private Format format = new Format();

    @Override
    public void create(Object object) {
        // String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas
        Sala sala = (Sala) object;
        //fileService.escribirFichero(archivoDestino, format.takeData(sala, fileService.getCHARACTER_SPLIT()));
        /*sala.getNombre() + fileService.getCHARACTER_SPLIT() + 
        sala.getDescripcion() + fileService.getCHARACTER_SPLIT() + 
        sala.getCapacidad() + fileService.getCHARACTER_SPLIT() + 
        sala.getReservas());*/
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

    
       
}
