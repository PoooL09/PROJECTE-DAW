/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.utils;

import matplace.dao.ConserjeDao;
import matplace.model.Conserje;
import matplace.model.Sala;

import java.util.ArrayList;

/**
 *
 * @author pg_po
 */
public class SalaUtils {

    private static ArrayList<Sala> salas;
    private ConserjeDao dao;

    public void create(Object object) {
        Sala sala = (Sala) object;
        salas.add(sala);
        dao.create(object);
    }

    public Sala read(int id) {
        for (Sala c : salas) {
            if (c.getID() == id) {
                dao.read(id);
                return c;
            }
        }

        return null;

    }

    public void update(Object object) {
        Sala sala = (Sala) object;
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getID() == sala.getID()) {
                salas.set(i, sala);
                dao.update(object);
            }
        }
    }

    public void delete(Object object) {
        Sala sala = (Sala) object;
        salas.remove(sala);
        dao.delete(object);
    }

}
