package com.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")

public class Categorias implements Serializable{

    public Categorias() {
    }

    public Categorias(long id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    private long id_categoria;
    private String nombre_categoria;
    private String referencia_categoria;

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getReferencia_categoria() {
        return referencia_categoria;
    }

    public void setReferencia_categoria(String referencia_categoria) {
        this.referencia_categoria = referencia_categoria;
    }

    
   
}
