package matplace.dao;

import java.io.File;

import matplace.model.Sala;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author pg_po
 */
public class SalaDao implements Crud {

    private FileService fileService = FileService.getInstance();

    private File archivoDestino = new File(fileService.getCARPETA_ARCHIVOS() + File.separator + "sala");
    private Format format = new Format();
    private Undo undo = new Undo();

    @Override
    public void create(Object object) {
        // String nombre, String descripcion, int capacidad, ArrayList<Reserva> reservas
        Sala sala = (Sala) object;
        fileService.escribirFichero(archivoDestino, format.takeData(sala, fileService.getCHARACTER_SPLIT_LV1(), fileService.getCHARACTER_SPLIT_LV2(), fileService.getCHARACTER_SPLIT_LV3(), fileService.getCHARACTER_SPLIT_LV4(), fileService.getCHARACTER_SPLIT_LV5()));
        /*sala.getNombre() + fileService.getCHARACTER_SPLIT() + 
        sala.getDescripcion() + fileService.getCHARACTER_SPLIT() + 
        sala.getCapacidad() + fileService.getCHARACTER_SPLIT() + 
        sala.getReservas());*/
    }

    @Override
    public Object read(int id) {
        Sala sala = undo.yourSala(fileService.leerFichero(archivoDestino), id,
                fileService.getCHARACTER_SPLIT_LV1(),
                fileService.getCHARACTER_SPLIT_LV2(),
                fileService.getCHARACTER_SPLIT_LV3(),
                fileService.getCHARACTER_SPLIT_LV4(),
                fileService.getCHARACTER_SPLIT_LV5());
        return sala;
    }

    @Override
    public void update(Object object) {
        Sala sala = (Sala) object;
        // FileService.update(sala, archivoDestino)
    }

    @Override
    public void delete(Object object) {
        Sala sala = (Sala) object;
        // FileService.delete(sala, archivoDestino)
    }


}
