/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.dao;

/**
 *
 * @author pg_po
 */
public interface Crud {
    
    public void create(Object object);
    public Object read(int id);
    public void update(Object object);
    public void delete(Object object);
    
}
