/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

import matplace.model.*;

import java.io.File;

/**
 *
 * @author PoooL
 */
public class ServiceID {

    FileService fileService = FileService.getInstance();
    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "ID");

    public void setIDFile() {

        int clienteId = Cliente.getIncrementoID();
        int conserjeId = Conserje.getIncrementoID();
        int reservaId = Reserva.getIncrementoID();
        int salaId = Sala.getIncrementoID();

        String dato = "0" + fileService.getCHARACTER_SPLIT_LV1() +
                clienteId + fileService.getCHARACTER_SPLIT_LV1() +
                conserjeId + fileService.getCHARACTER_SPLIT_LV1() +
                reservaId+ fileService.getCHARACTER_SPLIT_LV1() +
                salaId;

        fileService.actualizar(archivoDestino, "0", dato);
    }

    public void takeID() {
        String dato = fileService.leerFichero(archivoDestino);

        String[] datos = dato.split(fileService.getCHARACTER_SPLIT_LV1());

        Cliente.setIncrementoID(Integer.parseInt(datos[1]));
        Conserje.setIncrementoID(Integer.parseInt(datos[2]));
        Reserva.setIncrementoID(Integer.parseInt(datos[3]));
        Sala.setIncrementoID(Integer.parseInt(datos[4]));
    }




    
}
