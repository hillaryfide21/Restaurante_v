/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.entity;


import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
/**
 *
 * @author Hillary
 */

@Entity
@Table(name="cupones")
public class Cupon implements Serializable{
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY)  
    
    private long id_cupon;
    private String nombre_cupon;
    private String detalle_cupon;
    private String tipo_cupon;

    public long getId_cupon() {
        return id_cupon;
    }

    public void setId_cupon(long id_cupon) {
        this.id_cupon = id_cupon;
    }

    public String getNombre_cupon() {
        return nombre_cupon;
    }

    public void setNombre_cupon(String nombre_cupon) {
        this.nombre_cupon = nombre_cupon;
    }

    public String getDetalle_cupon() {
        return detalle_cupon;
    }

    public void setDetalle_cupon(String detalle_cupon) {
        this.detalle_cupon = detalle_cupon;
    }

    public String getTipo_cupon() {
        return tipo_cupon;
    }

    public void setTipo_cupon(String tipo_cupon) {
        this.tipo_cupon = tipo_cupon;
    }
    
    
}





    


   