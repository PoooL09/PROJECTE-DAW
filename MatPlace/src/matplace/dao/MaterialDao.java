/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import java.io.File;
import java.util.ArrayList;

import matplace.model.Material;

/**
 *
 * @author pg_po
 */
public class MaterialDao implements Crud{

    private FileService fileService = FileService.getInstance();
    
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "material");
    
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
        fileService.actualizar(archivoDestino, String.valueOf(material.getEAN()), format.takeData(material, fileService.getCHARACTER_SPLIT_LV1()));
    }

    @Override
    public void delete(Object object) {
        Material material = (Material) object;
        fileService.eliminar(archivoDestino, String.valueOf(material.getEAN()));
    }


    public ArrayList<Material> cargar() {
        String dato = fileService.leerFichero(archivoDestino);
        
        if(dato==null || dato.equals("")){  
            return new ArrayList<>();   
        }
        
        return undo.yourMaterials(dato, fileService.getCHARACTER_SPLIT_LV1());
    }
}
