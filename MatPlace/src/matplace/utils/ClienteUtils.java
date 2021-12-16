/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.utils;

import matplace.dao.ClienteDao;
import matplace.model.Cliente;

import java.util.ArrayList;

/**
 *
 * @author pg_po
 */
public class ClienteUtils {

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private ClienteDao dao = new ClienteDao();

    public void create(Object object) {

        Cliente cliente = (Cliente) object;
        clientes.add(cliente);
        dao.create(object);

    }

    public Cliente read(int id) {

        for (Cliente c : clientes) {
            if (c.getID() == id) {
                dao.read(id);
                return c;
            }
        }

        return null;
    }

    public void update(Object object) {

        Cliente cliente = (Cliente) object;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getID() == cliente.getID()) {
                clientes.set(i, cliente);
                dao.update(object);
            }
        }

        /*for (Cliente c: clientes) {
            if (c.getID() == cliente.getID()) {
                c = cliente;
            }
        }*/
    }

    public void delete(Object object) {

        Cliente cliente = (Cliente) object;
        clientes.remove(cliente);
        dao.delete(object);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        ClienteUtils.clientes = clientes;
    }

}
