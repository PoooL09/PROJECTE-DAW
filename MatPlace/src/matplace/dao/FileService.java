package matplace.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author pg_po
 */
public class FileService {

    private static FileService instance;

    private final File CARPETA_ARCHIVOS = new File(System.getProperty("user.home") + File.separator + "MatPlace");

    private final String CHARACTER_SPLIT_LV1 = "#";
    private final String CHARACTER_SPLIT_LV2 = "|";
    private final String CHARACTER_SPLIT_LV3 = "¬";
    private final String CHARACTER_SPLIT_LV4 = "ª";
    private final String CHARACTER_SPLIT_LV5 = "º";

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

    public boolean actualizar(File fichero0bjetivo, String lineaEliminarID, String lineaNuevaText) {
        String nombreF = "temp" + fichero0bjetivo.toString();
        File fileTemp = new File(nombreF);

        Scanner entrada = null;
        String linea;
        FileWriter fw = null;
        PrintWriter pw = null;

        int numeroDeLinea = 1;

        try {
            fw = new FileWriter(nombreF, true);
            pw = new PrintWriter(fw);
            entrada = new Scanner(fichero0bjetivo);

            while (entrada.hasNext()) {
                linea = entrada.nextLine().toLowerCase();
                String id = linea.split("#")[0];
                if (id.equals(lineaEliminarID)) {
                    String split[] = leerFichero(fichero0bjetivo).split("\n");
                    split[numeroDeLinea - 1] = lineaNuevaText;

                    try {
                        for (int i = 0; i < split.length; i++) {
                            pw.println(split[i]);
                        }
                        fichero0bjetivo.delete();
                        fileTemp.renameTo(fichero0bjetivo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (null != fw) {
                                fw.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    return true;
                }
                numeroDeLinea++;
            }

        } catch (IOException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void eliminar(File ficheroDestino, String lineaEliminarID) {
        String lineToRemove = "";
        File tempFile = new File("tempFile.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        try {
            writer = new BufferedWriter(new FileWriter(tempFile));
            reader = new BufferedReader(new FileReader(ficheroDestino));
            entrada = new Scanner(ficheroDestino);
            while (entrada.hasNext()) {
                linea = entrada.nextLine().toLowerCase();
                String id = linea.split("#")[0];
                if (id.equals(lineaEliminarID)) {
                    String split[] = leerFichero(ficheroDestino).split("\n");
                    lineToRemove = split[numeroDeLinea - 1];
                }
                numeroDeLinea++;
            }

            while ((linea = reader.readLine()) != null) {
                String trimmedLine = linea.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(linea + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            tempFile.renameTo(ficheroDestino);

        } catch (IOException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public File getCARPETA_ARCHIVOS() {
        return CARPETA_ARCHIVOS;
    }

    public String getCHARACTER_SPLIT_LV1() {
        return CHARACTER_SPLIT_LV1;
    }

    public String getCHARACTER_SPLIT_LV2() {
        return CHARACTER_SPLIT_LV2;
    }

    public String getCHARACTER_SPLIT_LV3() {
        return this.CHARACTER_SPLIT_LV3;
    }

    public String getCHARACTER_SPLIT_LV4() {
        return CHARACTER_SPLIT_LV4;
    }

    public String getCHARACTER_SPLIT_LV5() {
        return CHARACTER_SPLIT_LV5;
    }
}
