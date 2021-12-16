/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.model;

import matplace.dao.ServiceID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pg_po
 */
public class Reserva {

    private ArrayList<Persona> miembrosSala = new ArrayList<>();
    private Cliente responsable;
    private Conserje conserje;
    private Material material;
    private LocalDateTime dataInici;
    private LocalDateTime dataFinal;
    private int ID;
    private static int incrementoID=1;

    public Reserva() {
        this.ID = incrementoID;
        incrementoID++;
        new ServiceID().setIDFile();
    }

    public Reserva(int id, ArrayList<Persona> miembrosSala, Cliente responsable, Conserje conserje, Material material, LocalDateTime dataInici, LocalDateTime dataFinal) {
        this.miembrosSala = miembrosSala;
        this.responsable = responsable;
        this.conserje = conserje;
        this.material = material;
        this.dataInici = dataInici;
        this.dataFinal = dataFinal;
        this.ID = id;
    }

    public Reserva(ArrayList<Persona> miembrosSala, Cliente responsable, Conserje conserje, Material material, LocalDateTime dataInici, LocalDateTime dataFinal) {
        this.miembrosSala = miembrosSala;
        this.responsable = responsable;
        this.conserje = conserje;
        this.material = material;
        this.dataInici = dataInici;
        this.dataFinal = dataFinal;
        this.ID = incrementoID;
        incrementoID++;
        new ServiceID().setIDFile();
    }

    @Override
    public String toString() {
        return miembrosSala + "," + responsable + "," + conserje + "," + material + "," + dataInici + "," + dataFinal;
    }

    public ArrayList<Persona> getMiembrosSala() {
        return miembrosSala;
    }

    public void setMiembrosSala(ArrayList<Persona> miembrosSala) {
        this.miembrosSala = miembrosSala;
    }

    public Cliente getResponsable() {
        return responsable;
    }

    public void setResponsable(Cliente responsable) {
        this.responsable = responsable;
    }

    public Conserje getConserje() {
        return conserje;
    }

    public void setConserje(Conserje conserje) {
        this.conserje = conserje;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public LocalDateTime getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDateTime dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getIncrementoID() {
        return incrementoID;
    }

    public static void setIncrementoID(int incrementoID) {
        Reserva.incrementoID = incrementoID;
    }
}
