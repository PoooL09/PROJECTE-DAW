package matplace.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pg_po
 */
public class FileService {

    private static FileService instance;

    private final File CARPETA_ARCHIVOS = new File(System.getProperty("user.home") + File.separator + "MatPlace");
    
    private final String CHARACTER_SPLIT = "#";

    /**
     * Constructor privado. Patrón singleton.
     */
    private FileService() {

    }

    /**
     * Devuelve la instancia LogsService. Si no existe la crea y la devuelve.
     *
     * @return La instancia LogsService.
     */
    public static FileService getInstance() {

        if (instance == null) {

            instance = new FileService();

        }

        return instance;

    }

    public void escribirFichero(File ficheroDestino, String textoGuardado) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            if (!ficheroDestino.exists()) {
                ficheroDestino.createNewFile();
            }
            fw = new FileWriter(ficheroDestino.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write("\n" + textoGuardado);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String leerFichero(File ficheroObjetivo) {
        Scanner entrada = null;
        String contenido = "";
        int numeroDeLinea = 1;
        try {
            entrada = new Scanner(ficheroObjetivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (entrada.hasNext()) {
            contenido += entrada.nextLine() + "\n";
            numeroDeLinea++;
        }

        return contenido;

    }

    public File getCARPETA_ARCHIVOS() {
        return CARPETA_ARCHIVOS;
    }

    public String getCHARACTER_SPLIT() {
        return CHARACTER_SPLIT;
    }
}
