/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;

import matplace.model.Conserje;
import matplace.model.Material;

/**
 *
 * @author pg_po
 */
public class MaterialDao implements Crud{

    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "conserje");
    
    private Format format = new Format();
    private Undo undo = new Undo();


    @Override
    public void create(Object object) {
        Material material = (Material) object;
        fileService.escribirFichero(archivoDestino, format.takeData(material, fileService.getCHARACTER_SPLIT_LV1()));
        /*material.getEAN() + fileService.getCHARACTER_SPLIT() + 
        material.getNombre() + fileService.getCHARACTER_SPLIT() + 
        material.getDescripcion()  + fileService.getCHARACTER_SPLIT() + 
        material.getCantidad() + fileService.getCHARACTER_SPLIT() + 
        material.getCantidad_disponible());*/
    }

    // material no tiene id int sino k es ean String
    @Override
    public Object read(int id) {
        Material material = undo.yourMaterial(fileService.leerFichero(archivoDestino), id, fileService.getCHARACTER_SPLIT_LV1());
        return material;
    }

    @Override
    public void update(Object object) {
        Material material = (Material) object;
        // FileService.update(material, archivoDestino)
    }

    @Override
    public void delete(Object object) {
        Material material = (Material) object;
        // FileService.delete(material, archivoDestino)
    }
    
    

}
