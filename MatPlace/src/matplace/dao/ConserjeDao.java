/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;
import matplace.model.Conserje;

/**
 *
 * @author pg_po
 */
public class ConserjeDao implements Crud {

    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "conserje");

    public void create(Conserje conserje) {
    }

    
        // String nombre, String apellidos, String DNI, String telefono, String mail

    @Override
    public void create(Object object) {
        Conserje conserje = (Conserje) object;
        fileService.escribirFichero(archivoDestino, conserje.getID() + fileService.getCHARACTER_SPLIT() + conserje.getDNI() + fileService.getCHARACTER_SPLIT() + conserje.getTelefono() + fileService.getCHARACTER_SPLIT() + conserje.getMail());
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
