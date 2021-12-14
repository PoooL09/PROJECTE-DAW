/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.utils;

import matplace.dao.ConserjeDao;
import matplace.model.Conserje;

import java.util.ArrayList;

/**
 *
 * @author pg_po
 */
public class ConserjeUtils {

    private static ArrayList<Conserje> conserjes;
    private ConserjeDao dao;

    public void create(Object object) {
        Conserje conserje = (Conserje) object;
        conserjes.add(conserje);
        dao.create(object);
    }

    public Conserje read(int id) {

        for (Conserje c : conserjes) {
            if (c.getID() == id) {
                dao.read(id);
                return c;
            }
        }

        return null;

    }

    public void update(Object object) {

        Conserje conserje = (Conserje) object;
        for (int i = 0; i < conserjes.size(); i++) {
            if (conserjes.get(i).getID() == conserje.getID()) {
                conserjes.set(i, conserje);
                dao.update(object);
            }
        }

    }

    public void delete(Object object) {
        Conserje conserje = (Conserje) object;
        conserjes.remove(conserje);
        dao.delete(object);
    }

    public static ArrayList<Conserje> getConserjes() {
        return conserjes;
    }

    public static void setConserjes(ArrayList<Conserje> conserjes) {
        ConserjeUtils.conserjes = conserjes;
    }
    
}
