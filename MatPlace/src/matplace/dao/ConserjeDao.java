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

    private File archivoDestino = new File("conserje");

    public void create(Conserje conserje) {
        FileService fileService = FileService.getInstance();

        //fileService.escribirFichero(ficheroDestino, textoGuardado);
        String nombre;
        String apellidos;
        String DNI;

    }
    
    @Override
    public void create(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
