/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.utils;

import matplace.dao.ConserjeDao;
import matplace.model.Conserje;
import matplace.model.Material;

import java.util.ArrayList;

/**
 *
 * @author pg_po
 */
public class MaterialUtils {

    ArrayList<Material> materials;
    ConserjeDao dao;

    public void create(Object object) {
        Material material = (Material) object;
        materials.add(material);
        dao.create(object);
    }

    public Material read(int id) {
        for (Material c: materials) {
            if (c.getEAN() == id) {
                dao.read(id);
                return c;
            }
        }

        return null;

    }

    public void update(Object object) {
        Material material = (Material) object;
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getEAN() == material.getEAN()) {
                materials.set(i, material);
                dao.update(object);
            }
        }
    }

    public void delete(Object object) {
        Material material = (Material) object;
        materials.remove(material);
        dao.delete(object);
    }

}
