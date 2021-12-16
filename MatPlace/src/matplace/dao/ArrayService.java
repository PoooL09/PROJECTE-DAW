package matplace.dao;

import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.model.Material;
import matplace.model.Sala;
import matplace.utils.ClienteUtils;
import matplace.utils.ConserjeUtils;
import matplace.utils.MaterialUtils;
import matplace.utils.SalaUtils;

import java.util.ArrayList;

public class ArrayService {

    public void startAll() {
        startClientes();
        startConserjes();
        startMaterials();
        startSalas();
    }

    public void startClientes() {

        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Cliente> clientesFile = clienteDao.cargar();
        ClienteUtils.setClientes(clientesFile);

    }

    public void startConserjes() {

        ConserjeDao conserjeDao = new ConserjeDao();
        ArrayList<Conserje> clientesFile = conserjeDao.cargar();
        ConserjeUtils.setConserjes(clientesFile);

    }

    public void startMaterials() {

        MaterialDao materialDao = new MaterialDao();
        ArrayList<Material> materialsFile = materialDao.cargar();
        MaterialUtils.setMaterials(materialsFile);

    }

    public void startSalas() {

        SalaDao salaDao = new SalaDao();
        ArrayList<Sala> salasFile = salaDao.cargar();
        SalaUtils.setSalas(salasFile);

    }


}
