/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package matplace.utils;

import matplace.model.Reserva;

import java.util.ArrayList;
import matplace.dao.ReservaDao;

/**
 *
 * @author pg_po
 */
/*
public class ReservaUtils {

    private static ArrayList<Reserva> reservas = new ArrayList<>();
    private ReservaDao dao = new ReservaDao();

    public void create(Object object) {
        Reserva reserva = (Reserva) object;
        reservas.add(reserva);
        dao.create(object);
    }

    public Reserva read(int id) {
        for (Reserva c : reservas) {
            if (c.getID() == id) {
                dao.read(id);
                return c;
            }
        }

        return null;

    }

    public void update(Object object) {
        Reserva reserva = (Reserva) object;
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getID() == reserva.getID()) {
                reservas.set(i, reserva);
                dao.update(object);
            }
        }
    }

    public void delete(Object object) {
        Reserva reserva = (Reserva) object;
        reservas.remove(reserva);
        dao.delete(object);
    }

}
*/