/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;

import matplace.model.Cliente;

/**
 *
 * @author pg_po
 */
public class ClienteDao implements Crud{


    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "cliente");

    // String nombre, String apellidos, String DNI, String telefono, String mail

    @Override
    public void create(Object object) {
        Cliente cliente = (Cliente) object;
        fileService.escribirFichero(archivoDestino, cliente.getID() + fileService.getCHARACTER_SPLIT() + cliente.getDNI() + fileService.getCHARACTER_SPLIT() + cliente.getTelefono() + fileService.getCHARACTER_SPLIT() + cliente.getMail());
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
