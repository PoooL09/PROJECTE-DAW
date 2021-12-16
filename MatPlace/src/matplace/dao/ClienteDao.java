/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;
import java.util.ArrayList;

import matplace.model.Cliente;

/**
 *
 * @author pg_po
 */
public class ClienteDao implements Crud{


    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "cliente");

    // String nombre, String apellidos, String DNI, String telefono, String mail

    private Format format = new Format();
    private Undo undo = new Undo();


    @Override
    public void create(Object object) {
        Cliente cliente = (Cliente) object;
        fileService.escribirFichero(archivoDestino, format.takeData(cliente, fileService.getCHARACTER_SPLIT_LV1()));
        /*cliente.getID() + fileService.getCHARACTER_SPLIT() + 
        cliente.getDNI() + fileService.getCHARACTER_SPLIT() + 
        cliente.getTelefono() + fileService.getCHARACTER_SPLIT() + 
        cliente.getMail());*/
    }

    @Override
    public Object read(int id) {

        Cliente cliente = undo.yourClient(fileService.leerFichero(archivoDestino), id, fileService.getCHARACTER_SPLIT_LV1());
        return cliente;
    }

    @Override
    public void update(Object object) {
        Cliente cliente = (Cliente) object;
        fileService.actualizar(archivoDestino, String.valueOf(cliente.getID()), format.takeData(cliente, fileService.getCHARACTER_SPLIT_LV1()));
    }

    @Override
    public void delete(Object object) { // se podria recibir un id y ya
        Cliente cliente = (Cliente) object;
        fileService.eliminar(archivoDestino, String.valueOf(cliente.getID()));
    }

    public ArrayList<Cliente> cargar () {
        String dato = fileService.leerFichero(archivoDestino);
        return undo.yourClientes(dato, fileService.getCHARACTER_SPLIT_LV1());
    }



    

}
