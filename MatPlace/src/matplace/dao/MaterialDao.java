/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;

import matplace.model.Material;

/**
 *
 * @author pg_po
 */
public class MaterialDao implements Crud{

    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "conserje");
    
    @Override
    public void create(Object object) {
        Material material = (Material) object;
        fileService.escribirFichero(archivoDestino, material.getEAN() + fileService.getCHARACTER_SPLIT() + material.getNombre() + fileService.getCHARACTER_SPLIT() + material.getDescripcion()  + fileService.getCHARACTER_SPLIT() + material.getDescripcion() + fileService.getCHARACTER_SPLIT() + material.getCantidad() + fileService.getCHARACTER_SPLIT() + material.getCantidad_disponible());
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
