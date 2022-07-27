package com.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu")

public class Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    private long id_producto;
    private String nombre_producto;
    private String detalle_producto;
    private String precio_producto;
    private String imagen_producto;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categorias id_categoria;

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDetalle_producto() {
        return detalle_producto;
    }

    public void setDetalle_producto(String detalle_producto) {
        this.detalle_producto = detalle_producto;
    }

    public String getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(String precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Categorias getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categorias id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImagen_producto() {
        return imagen_producto;
    }

    public void setImagen_producto(String imagen_producto) {
        this.imagen_producto = imagen_producto;
    }
    
    
        
}
