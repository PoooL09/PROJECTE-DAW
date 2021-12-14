/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.model;

import matplace.utils.SalaUtils;

/**
 *
 * @author pg_po
 */
public class Material {
    
    int EAN; //identificador unico de cada producto.
    String nombre;
    String descripcion;
    int cantidad;
    int cantidad_disponible;



    public Material(int EAN, String nombre, String descripcion, int cantidad, int cantidad_disponible) {
        this.EAN = EAN;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.cantidad_disponible = cantidad_disponible;
    }

    @Override
    public String toString() {
        return  "EAN:" + EAN +
                " nombre:" + nombre +
                " cantidad:" + cantidad +
                " cantidad_disponible=" + cantidad_disponible;
    }

    public Material(String nombre) {
        this.nombre = nombre;
    }

    public Material() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEAN() {
        return EAN;
    }

    public void setEAN(int EAN) {
        this.EAN = EAN;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

   
    
    
    
}
