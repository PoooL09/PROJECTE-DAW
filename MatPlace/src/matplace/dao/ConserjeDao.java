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

/**
 *
 * @author pg_po
 */
public class ConserjeDao implements Crud {

    private FileService fileService = FileService.getInstance();

    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "conserje");
    private Format format = new Format();
    private Undo undo = new Undo();

    public void create(Conserje conserje) {
    }

    // String nombre, String apellidos, String DNI, String telefono, String mail
    @Override
    public void create(Object object) {
        Conserje conserje = (Conserje) object;
        fileService.escribirFichero(archivoDestino, format.takeData(conserje, fileService.getCHARACTER_SPLIT_LV1()));
        /*conserje.getID() + fileService.getCHARACTER_SPLIT() + 
        conserje.getDNI() + fileService.getCHARACTER_SPLIT() + 
        conserje.getTelefono() + fileService.getCHARACTER_SPLIT() + 
        conserje.getMail());*/
    }

    @Override
    public Object read(int id) {

        Conserje conserje = undo.yourConserje(fileService.leerFichero(archivoDestino), id, fileService.getCHARACTER_SPLIT_LV1());

        return conserje;
    }

    @Override
    public void update(Object object) {
        Conserje conserje = (Conserje) object;
        fileService.actualizar(archivoDestino, String.valueOf(conserje.getID()), format.takeData(conserje, fileService.getCHARACTER_SPLIT_LV1()));
    }

    @Override
    public void delete(Object object) {
        Conserje conserje = (Conserje) object;
        fileService.eliminar(archivoDestino, String.valueOf(conserje.getID()));
    }

    public ArrayList<Conserje> cargar() {
        String dato = fileService.leerFichero(archivoDestino);

        if (dato == null || dato.equals("")) {
            return new ArrayList<>();
        }

        return undo.yourConserjes(dato, fileService.getCHARACTER_SPLIT_LV1());
    }
}
